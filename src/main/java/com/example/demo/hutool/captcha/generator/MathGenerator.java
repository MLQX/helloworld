package com.example.demo.hutool.captcha.generator;

import com.example.demo.hutool.core.util.CharUtil;
import com.example.demo.hutool.core.util.RandomUtil;
import com.example.demo.hutool.core.util.StrUtil;

/**
 * 数字计算验证码生成器
 * 
 * @author looly
 * @since 4.1.2
 */
public class MathGenerator implements CodeGenerator {
	private static final long serialVersionUID = -5514819971774091076L;

	private static final String operators = "+-*";

	/** 参与计算数字最大长度 */
	private int numberLength;

	/**
	 * 构造
	 */
	public MathGenerator() {
		this(2);
	}

	/**
	 * 构造
	 * 
	 * @param numberLength 参与计算最大数字位数
	 */
	public MathGenerator(int numberLength) {
		this.numberLength = numberLength;
	}

	@Override
	public String generate() {
		final int limit = getLimit();
		String number1 = Integer.toString(RandomUtil.randomInt(limit));
		String number2 = Integer.toString(RandomUtil.randomInt(limit));
		number1 = StrUtil.padAfter(number1, this.numberLength, CharUtil.SPACE);
		number2 = StrUtil.padAfter(number2, this.numberLength, CharUtil.SPACE);

		return StrUtil.builder()//
				.append(number1)//
				.append(RandomUtil.randomChar(operators))//
				.append(number2)//
				.append('=').toString();
	}

	@Override
	public boolean verify(String code, String userInputCode) {
		int result;
		try {
			result = Integer.parseInt(userInputCode);
		} catch (NumberFormatException e) {
			// 用户输入非数字
			return false;
		}

		final int a = Integer.parseInt(StrUtil.sub(code, 0, this.numberLength).trim());
		final char operator = code.charAt(this.numberLength);
		final int b = Integer.parseInt(StrUtil.sub(code, this.numberLength + 1, this.numberLength + 1 + this.numberLength).trim());

		switch (operator) {
		case '+':
			return (a + b) == result;
		case '-':
			return (a - b) == result;
		case '*':
			return (a * b) == result;
		default:
			return false;
		}
	}

	/**
	 * 获取长度验证码
	 * 
	 * @return 验证码长度
	 */
	public int getLength() {
		return this.numberLength * 2 + 2;
	}

	/**
	 * 根据长度获取参与计算数字最大值
	 * 
	 * @return 最大值
	 */
	private int getLimit() {
		return Integer.parseInt("1" + StrUtil.repeat('0', this.numberLength));
	}
}
