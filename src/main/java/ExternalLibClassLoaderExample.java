public class ExternalLibClassLoaderExample {

    public static void main(String[] args) {
        String name = Extenssion.class.getClassLoader().getName();
        System.out.println(name);
    }
}
