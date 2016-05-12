package com.infinitechnic.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public final class StringUtil {
	private static final String EMPTY_STRING = "";

	public static final boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	/**
	 * This function returns the string by default calling toString() function
	 * If the input object is null, it returns empty string instead of null
	 * @param obj Input Object
	 * @return String
     */
	public static final String toString(Object obj) {
		if (obj == null) {
			return EMPTY_STRING;
		}
		return obj.toString();
	}

	/**
	 * This concatenate function treats null object as empty string
	 * @param objects Input Object
	 * @return String
	 */
	public static final String concat(Object... objects) {
		if (objects == null) {
			return EMPTY_STRING;
		}
		
		StringBuilder sb = new StringBuilder();
		for (Object object : objects) {
			if (object != null) {
				sb.append(object);
			}
		}
		return sb.toString();
	}

	/**
	 * This concatenate function treats null object as empty string
	 * It appends a delimiter between two objects
	 * @param objects Input Object
	 * @param delimiter Delimiter
     * @return String
     */
	public static final String concatWithDelimiter(Collection<?> objects, String delimiter) {
		StringBuilder sb = new StringBuilder();
		objects.stream().forEach(o -> {
			if (sb.length() != 0) {
				sb.append(delimiter);
			}
			sb.append(toString(o));
		});
		return sb.toString();
	}

	public static final int countMatches(String str, String find) {
		return (str == null || find == null || find.length() == 0 || str.length() < find.length()) ? 0 : str.length() - str.replace(find, "").length() / find.length();
	}
}
