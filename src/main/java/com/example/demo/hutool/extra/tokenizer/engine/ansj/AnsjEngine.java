package com.example.demo.hutool.extra.tokenizer.engine.ansj;

import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import com.example.demo.hutool.core.util.StrUtil;
import com.example.demo.hutool.extra.tokenizer.Result;
import com.example.demo.hutool.extra.tokenizer.TokenizerEngine;

/**
 * Ansj分词引擎实现<br>
 * 项目地址：https://github.com/NLPchina/ansj_seg
 * 
 * @author looly
 *
 */
public class AnsjEngine implements TokenizerEngine {

	private final Analysis analysis;
	
	/**
	 * 构造
	 */
	public AnsjEngine() {
		this(new ToAnalysis());
	}
	
	/**
	 * 构造
	 * 
	 * @param analysis {@link Analysis}
	 */
	public AnsjEngine(Analysis analysis) {
		this.analysis = analysis;
	}

	@Override
	public Result parse(CharSequence text) {
		return new AnsjResult(analysis.parseStr(StrUtil.str(text)));
	}
	
}
