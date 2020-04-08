package com.example.demo.hutool.setting;

import com.example.demo.hutool.core.io.FileUtil;
import com.example.demo.hutool.core.io.resource.NoResourceException;
import com.example.demo.hutool.core.util.StrUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Setting工具类<br>
 * 提供静态方法获取配置文件
 *
 * @author looly
 */
public class SettingUtil {
	/**
	 * 配置文件缓存
	 */
	private static Map<String, Setting> settingMap = new ConcurrentHashMap<>();
	private static final Object lock = new Object();

	/**
	 * 获取当前环境下的配置文件<br>
	 * name可以为不包括扩展名的文件名（默认.setting为结尾），也可以是文件名全称
	 *
	 * @param name 文件名，如果没有扩展名，默认为.setting
	 * @return 当前环境下配置文件
	 */
	public static Setting get(String name) {
		Setting setting = settingMap.get(name);
		if (null == setting) {
			synchronized (lock) {
				setting = settingMap.get(name);
				if (null == setting) {
					String filePath = name;
					String extName = FileUtil.extName(filePath);
					if (StrUtil.isEmpty(extName)) {
						filePath = filePath + "." + Setting.EXT_NAME;
					}
					setting = new Setting(filePath, true);
					settingMap.put(name, setting);
				}
			}
		}
		return setting;
	}

	/**
	 * 获取给定路径找到的第一个配置文件<br>
	 * * name可以为不包括扩展名的文件名（默认.setting为结尾），也可以是文件名全称
	 *
	 * @param names 文件名，如果没有扩展名，默认为.setting
	 *
	 * @return 当前环境下配置文件
	 * @since 5.1.3
	 */
	public static Setting getFirstFound(String... names) {
		Setting setting;
		for (String name : names) {
			try {
				return get(name);
			} catch (NoResourceException e) {
				//ignore
			}
		}
		return null;
	}
}
