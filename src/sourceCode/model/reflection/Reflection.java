package sourceCode.model.reflection;

public class Reflection {
    private Class<?> klass;

    public Reflection(String s) {
        try {
            klass = Class.forName(s);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }

    public Class<?> getTile() {
        return klass;
    }
}
