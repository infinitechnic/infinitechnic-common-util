package com.infinitechnic.util;

import org.apache.commons.lang3.StringUtils;

public final class StringUtil {
	private static final String EMPTY_STRING = "";

	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}
	
	public static String toString(Object obj) {
		if (obj == null) {
			return null;
		}
		return obj.toString();
	}

	public static int countMatches(String str, String find) {
		return (str == null || find == null || find.length() == 0 || str.length() < find.length()) ? 0 : str.length() - str.replace(find, "").length() / find.length();
	}

	/**
	 * This concatenate function treats null object as empty string
	 * @param objects
	 * @return String
	 */
	public static String concat(Object... objects) {
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
}
