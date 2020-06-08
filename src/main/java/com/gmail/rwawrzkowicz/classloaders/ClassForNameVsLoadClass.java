package com.gmail.rwawrzkowicz.classloaders;

import java.lang.reflect.InvocationTargetException;

public class ClassForNameVsLoadClass {

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("com.gmail.rwawrzkowicz.classloaders.A");
            Class<?> d = ClassLoader.getSystemClassLoader().loadClass("com.gmail.rwawrzkowicz.classloaders.A");
            d.getConstructor().newInstance();
            System.out.println(c.equals(d));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
