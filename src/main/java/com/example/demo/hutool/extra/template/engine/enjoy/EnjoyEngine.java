package com.example.demo.hutool.extra.template.engine.enjoy;

import com.example.demo.hutool.core.io.FileUtil;
import com.example.demo.hutool.core.util.IdUtil;
import com.example.demo.hutool.core.util.ObjectUtil;
import com.example.demo.hutool.extra.template.Template;
import com.example.demo.hutool.extra.template.TemplateConfig;
import com.example.demo.hutool.extra.template.TemplateConfig.ResourceMode;
import com.example.demo.hutool.extra.template.TemplateEngine;
import com.jfinal.template.source.FileSourceFactory;
import org.beetl.core.GroupTemplate;

/**
 * Enjoy库的引擎包装
 *
 * @author looly
 * @since 4.1.10
 */
public class EnjoyEngine implements TemplateEngine {

	private com.jfinal.template.Engine engine;
	private ResourceMode resourceMode;

	// --------------------------------------------------------------------------------- Constructor start

	/**
	 * 默认构造
	 */
	public EnjoyEngine() {}

	/**
	 * 构造
	 *
	 * @param config 模板配置
	 */
	public EnjoyEngine(TemplateConfig config) {
		init(config);
	}

	/**
	 * 构造
	 *
	 * @param engine {@link com.jfinal.template.Engine}
	 */
	public EnjoyEngine(com.jfinal.template.Engine engine) {
		init(engine);
	}
	// --------------------------------------------------------------------------------- Constructor end

	@Override
	public TemplateEngine init(TemplateConfig config) {
		if(null == config){
			config = TemplateConfig.DEFAULT;
		}
		this.resourceMode = config.getResourceMode();
		init(createEngine(config));
		return this;
	}

	/**
	 * 初始化引擎
	 * @param engine 引擎
	 */
	private void init(com.jfinal.template.Engine engine){
		this.engine = engine;
	}

	@Override
	public Template getTemplate(String resource) {
		if(null == this.engine){
			init(TemplateConfig.DEFAULT);
		}
		if (ObjectUtil.equal(ResourceMode.STRING, this.resourceMode)) {
			return EnjoyTemplate.wrap(this.engine.getTemplateByString(resource));
		}
		return EnjoyTemplate.wrap(this.engine.getTemplate(resource));
	}

	/**
	 * 创建引擎
	 *
	 * @param config 模板配置
	 * @return {@link GroupTemplate}
	 */
	private static com.jfinal.template.Engine createEngine(TemplateConfig config) {
		final com.jfinal.template.Engine engine = com.jfinal.template.Engine.create("Hutool-Enjoy-Engine-" + IdUtil.fastSimpleUUID());
		engine.setEncoding(config.getCharsetStr());

		switch (config.getResourceMode()) {
			case STRING:
				// 默认字符串类型资源:
				break;
			case CLASSPATH:
				engine.setToClassPathSourceFactory();
				engine.setBaseTemplatePath(config.getPath());
				break;
			case FILE:
				engine.setSourceFactory(new FileSourceFactory());
				engine.setBaseTemplatePath(config.getPath());
				break;
			case WEB_ROOT:
				engine.setSourceFactory(new FileSourceFactory());
				engine.setBaseTemplatePath(FileUtil.getAbsolutePath(FileUtil.getWebRoot()));
				break;
			default:
				break;
		}

		return engine;
	}
}
