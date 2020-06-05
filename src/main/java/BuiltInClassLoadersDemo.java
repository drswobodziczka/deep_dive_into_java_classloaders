import java.sql.Date;

/*
* Code source => https://medium.com/javarevisited/java-virtual-machine-internals-class-loader-eea706eb37d9
* */
public class BuiltInClassLoadersDemo {

    public static void main(String[] args) {
        // new classes are loaded by application class loader
        BuiltInClassLoadersDemo demoObject = new BuiltInClassLoadersDemo();
        ClassLoader applicationClassLoader = demoObject.getClass().getClassLoader();
        printClassLoaderDetails(applicationClassLoader);

        // java.sql classes are loaded by platform classloader
        java.sql.Date now = new Date(System.currentTimeMillis());
        ClassLoader platformClassLoder = now.getClass().getClassLoader();
        printClassLoaderDetails(platformClassLoder);

        // java.lang classes are loaded by bootstrap classloader
        ClassLoader bootstrapClassLoder = args.getClass().getClassLoader();
        printClassLoaderDetails(bootstrapClassLoder);
    }

    private static void printClassLoaderDetails(ClassLoader classLoader) {
        // bootstrap classloader is represented by null in JVM
        if (classLoader != null) {
            System.out.println("ClassLoader name : " + classLoader.getName());
            System.out.println("ClassLoader class : " + classLoader.getClass().getName());
        } else {
            System.out.println("Bootstrap classloader");
        }
    }
}

