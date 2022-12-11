package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
//       Field field = r.getClass().getDeclaredField("uuid");
        field.setAccessible(true);
        System.out.println(field.getName());
        field.get(r);
        field.set(r, "new_uuid");
        System.out.println(r);

        Class<? extends Resume> aClass = r.getClass();

        Method method = aClass.getMethod("toString");
        Object str = method.invoke(r).toString();
        System.out.println(str);

    }
}
