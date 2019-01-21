package sourceCode.model.reflection;

import sourceCode.model.Position;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author: Sebastian Arledal c17sal / Simon Lundkvist c17slt
 * 2019-01-21
 *
 * Class to handle the reflection
 */
public class Reflection {
    private Class<?> klass;
    private Object newKlass;
    private Position p;

    /**
     * Constructor: Creates a new class with reflection
     * @param className - Name of class to create
     * @param p - position
     */
    public Reflection(String className, Position p) {
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        this.p = p;
    }

    /**
     * Creates object from the class
     */
    private void createObject() {
        try {
            Constructor<?> con = klass.getConstructor(Position.class);
            newKlass = con.newInstance(p);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the current tile as an object
     * @return newKlass - the object
     */
    public Object getTile() {
        createObject();
        return newKlass;
    }
}
