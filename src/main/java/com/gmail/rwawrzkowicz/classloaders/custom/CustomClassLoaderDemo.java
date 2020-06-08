package com.gmail.rwawrzkowicz.classloaders.custom;

import com.gmail.rwawrzkowicz.classloaders.A;

public class CustomClassLoaderDemo {

    public static void main(String[] args) {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader(ClassLoader.getSystemClassLoader());
            customClassLoader.loadClass(Dummy.class.getName());
            customClassLoader.loadClass(A.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
