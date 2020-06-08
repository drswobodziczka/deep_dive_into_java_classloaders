package com.gmail.rwawrzkowicz.classloaders;

import com.google.common.base.CharMatcher;

public class ExternalLibClassLoaderExample {

    public static void main(String[] args) {
        CharMatcher any = CharMatcher.any();
        String name = any.getClass().getClassLoader().getName();
        System.out.println(name);
    }
}
