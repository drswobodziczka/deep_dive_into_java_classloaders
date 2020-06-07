// import jdk.internal.loader.ClassLoaders;

import java.util.Arrays;

public class ClassNotFoundDemo {

    public static void main(String[] args) {
        String fullQualifiedClassName = "I'm not here";

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        loadClass(systemClassLoader, fullQualifiedClassName);
        loadClass(platformClassLoader, fullQualifiedClassName);
//        loadClass(ClassLoaders.appClassLoader(), fullQualifiedClassName);
//        loadClass(ClassLoaders.platformClassLoader(), fullQualifiedClassName);

    }

    private static void loadClass(ClassLoader classLoader, String fullQualifiedClassName) {
        try {
            System.out.println("name: " + classLoader.getName());
            System.out.println("parent: " + classLoader.getParent());
            System.out.println("defined packages: " + Arrays.toString(classLoader.getDefinedPackages()));
            System.out.println("isRegisteredAsParallelCapable:" + classLoader.isRegisteredAsParallelCapable());
            System.out.println("classLoader loaded classLoader: " + classLoader.getClass().getClassLoader());

            classLoader.loadClass(fullQualifiedClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

