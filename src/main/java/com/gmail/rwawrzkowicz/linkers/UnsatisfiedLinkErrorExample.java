package com.gmail.rwawrzkowicz.linkers;

public class UnsatisfiedLinkErrorExample {

    // Define a method that is defined externally.
    native void CFunction();

    // Load an external library, called "clibrary".
    static {
        System.loadLibrary("clibrary");
    }

    public static void main(String[] argv) {
        UnsatisfiedLinkErrorExample example = new UnsatisfiedLinkErrorExample();
        example.CFunction ();
    }
}

