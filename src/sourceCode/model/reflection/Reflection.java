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
     * @throws ClassNotFoundException - Exception when class is not found
     */
    public Reflection(String className, Position p) throws
            ClassNotFoundException {
        klass = Class.forName(className);
        this.p = p;
    }

    /**
     * Creates object from the class
     * @throws InstantiationException - Exception when class cant be instatiated
     */
    private void createObject() throws InstantiationException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        Constructor<?> con = klass.getConstructor(Position.class);
        newKlass = con.newInstance(p);
    }

    /**
     * Gets the current tile as an object
     * @return newKlass - the object
     * @throws InvocationTargetException - Exception when invocation goes wrong
     * @throws NoSuchMethodException - Exception when method call fails
     * @throws InstantiationException - Exception when instantiation fails
     * @throws IllegalAccessException - Exception when access is denied
     */
    public Object getTile() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        createObject();
        return newKlass;
    }
}
