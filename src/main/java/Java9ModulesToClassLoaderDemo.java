import static java.util.Objects.isNull;

public class Java9ModulesToClassLoaderDemo {
    public static void main(String[] args) {
        ModuleLayer layer = ModuleLayer.boot();
        layer.modules()
                .stream()
                .map(module -> {
                    ClassLoader classLoader = module.getClassLoader();
                    String classLoaderName = isNull(classLoader) ? "bootstrap" : classLoader.getName();
                    return classLoaderName + ": " + module.getName();
                })
                .sorted()
                .forEach(System.out::println);
    }
}
