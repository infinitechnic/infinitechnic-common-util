package com.infinitechnic.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtil {
    /**
     * This function extracts fields in the class and based class regardless the type of Access Modifiers (private, protected, defaulf, public)
     * @param clazz class
     * @return A list of Field objects
     * @see java.lang.reflect.Field
     */
    public static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        // Extract base class fields
        if (clazz != null && clazz.getSuperclass() != null) {
            fields.addAll(getAllFields(clazz.getSuperclass()));
        }
        return fields;
    }

}
