package com.example.demo.hutool.core.convert.impl;

import com.example.demo.hutool.core.convert.AbstractConverter;

/**
 * 字符串转换器
 * @author Looly
 *
 */
public class StringConverter extends AbstractConverter<String>{
	private static final long serialVersionUID = 1L;

	@Override
	protected String convertInternal(Object value) {
		return convertToStr(value);
	}

}
