package com.infinitechnic.util;

import com.google.common.primitives.Primitives;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
    public static final List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        // Extract base class fields
        if (clazz != null && clazz.getSuperclass() != null) {
            fields.addAll(getAllFields(clazz.getSuperclass()));
        }
        return fields;
    }

    public static final <T> T newInstance(Class<T> clazz, Object value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (clazz.isPrimitive()) {
            clazz = Primitives.wrap(clazz);
        }
        if (value == null) {
            Constructor<?> constructor = clazz.getConstructor();
            return (T) constructor.newInstance();
        } else if (value.getClass().equals(clazz)) {
            return (T)value;
        } else {
            Constructor<?> constructor = clazz.getConstructor(value.getClass());
            return (T) constructor.newInstance(value);
        }
    }

    //TODO: how to List
    //TODO: use @NotNull on instance & field
    public static final void setValue(Object instance, Field field, Object value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (instance != null && field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                field.set(instance, newInstance(field.getType(), value));
                field.setAccessible(false);
            } else {
                field.set(instance, newInstance(field.getType(), value));
            }
        } else {
            throw new NullPointerException("Instance or Field is null!");
        }
    }
}
