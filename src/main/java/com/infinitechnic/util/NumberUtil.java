package com.infinitechnic.util;


public final class NumberUtil {
	private final static String NUMBER_PATTERN = "^[-]{0,1}[0-9]{1,3}(,[0-9]{3})*(\\.[0-9]+){0,1}$|^[-]{0,1}[0-9]+(\\.[0-9]+){0,1}$";
	private final static String DECIMAL_SYMBOL = ".";
	private final static String THOUSAND_SEPARATOR = ",";


	/**
	 * This function checks whether the string is a valid number.
	 *
	 * @param value input string
	 * @return boolean
	 */
	public static final boolean isNumber(String value) {
		if (StringUtil.isEmpty(value)) {
			return false;
		}
		return value.trim().matches(NUMBER_PATTERN);
	}

	/**
	 * This function checks whether the string is a valid integer
	 *
	 * @param value input string
	 * @return boolean
	 */
	public static final boolean isInteger(String value) {
		return isNumber(value) && !value.contains(DECIMAL_SYMBOL);
	}

	/**
	 * This function checks whether the string is a valid floating number
	 *
	 * @param value input string
	 * @return boolean
	 */
	public static final boolean isFloat(String value) {
		return isNumber(value) && value.contains(DECIMAL_SYMBOL);
	}

	/**
	 * This function parse the string value to integer, if invalid integer format, it returns null
	 * @param value Input value
	 * @return Integer
     */
	public static final Integer parseInteger(String value) {
		if (isInteger(value)) {
			if (value.contains(THOUSAND_SEPARATOR)) {
				value = value.replace(THOUSAND_SEPARATOR, "");
			}
			return Integer.parseInt(value);
		}
		return null;
	}
}
