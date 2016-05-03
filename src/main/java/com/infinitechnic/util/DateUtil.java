package com.infinitechnic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final Date parseDate(String val, String format) throws ParseException {
        if (StringUtil.isEmpty(val)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(val.trim());
        } catch (ParseException pe) {
            throw pe;
        } catch (Exception e) {
            throw new ParseException("Invalid format: " + format, 0);
        }
    }

    public static final boolean isDate(String val, String format) {
        try {
            if (parseDate(val, format) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
