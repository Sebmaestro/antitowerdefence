package sourceCode.model.reflection;

import sourceCode.model.Position;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author: Sebastian Arledal c17sal / Simon Lundkvist c17slt
 */
public class Reflection {
    private Class<?> klass;
    private Object newKlass;
    Position p;

    public Reflection(String className, Position p) {
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        this.p = p;
    }

    private void createObject() {
        try {
            Constructor<?> con = klass.getConstructor(Position.class);
            newKlass = con.newInstance(p);
            //newKlass = klass.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getTile() {
        createObject();
        return newKlass;
    }
}
