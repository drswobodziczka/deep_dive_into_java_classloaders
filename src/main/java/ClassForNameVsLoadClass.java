import java.lang.reflect.InvocationTargetException;

public class ClassForNameVsLoadClass {

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("A");
            Class<?> d = ClassLoader.getSystemClassLoader().loadClass("A");
            d.getConstructor().newInstance();
            System.out.println(c.equals(d));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
