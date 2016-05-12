package com.infinitechnic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public static final String format(Date date, String format, TimeZone timeZone) {
        if (date == null) {
            return null;
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                if (timeZone != null) {
                    sdf.setTimeZone(timeZone);
                }
                return sdf.format(date);
            } catch (Exception e) {
                //logger.error("[DateUtil.format] Format exception - date: " + date);
                return null;
            }
        }
    }
}
