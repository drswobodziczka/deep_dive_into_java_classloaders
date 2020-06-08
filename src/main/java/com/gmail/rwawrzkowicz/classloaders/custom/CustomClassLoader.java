package com.gmail.rwawrzkowicz.classloaders.custom;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class CustomClassLoader extends ClassLoader {

    private static final String CUSTOM_CLASSES_PACKAGE_PREFIX = "com.gmail.rwawrzkowicz.classloaders.custom";

    /**
     * This constructor is used to set the parent ClassLoader
     */
    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class '" + name + "'");
        if (name.startsWith(CUSTOM_CLASSES_PACKAGE_PREFIX)) {
            System.out.println("Loading Class using CustomClassLoader");
            return loadFromClassFile(name);
        }
        return super.loadClass(name);
    }

    private Class loadFromClassFile(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b = null;
        try {

            b = loadClassFileData(file);
            // defineClass is inherited from the ClassLoader class that converts byte array into a Class.
            // defineClass is Final so we cannot override it
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(
                name);
        int size = Objects.requireNonNull(stream).available();
        byte[] buff = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }
}
