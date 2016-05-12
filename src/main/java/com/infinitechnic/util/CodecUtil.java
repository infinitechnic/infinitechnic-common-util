package com.infinitechnic.util;

import org.apache.commons.codec.binary.Base64;

public class CodecUtil {
    public static String encodeBase64(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
        str = new String(bytesEncoded);
        return str == null ? null : str.replaceAll("=", "");
    }
}
