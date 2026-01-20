package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionFactoryExample {

    /**
     * 1. Classe métier
     */
    static class Calculator {
        private final int base;

        public Calculator(int base) {
            this.base = base;
        }

        public int add(int value) {
            return base + value;
        }

        private int secretMultiply(int value) {
            return base * value;
        }
    }

    /**
     * 2. Fabrique Générique
     */
    static class ObjectFactory {
        public static <T> T create(
                Class<T> type,
                Class<?>[] paramTypes,
                Object[] args
        ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            Constructor<?> ctor = type.getDeclaredConstructor(paramTypes);
            ctor.setAccessible(true);

            Object raw = ctor.newInstance(args);
            return type.cast(raw);
        }
    }

    /**
     * 3. Invocation Dynamique
     */
    static Object invoke(
            Object target,
            String methodName,
            Class<?>[] paramTypes,
            Object[] args
    ) {

            Class<?> clazz = target.getClass();
            Method method;


            try {
                method = clazz.getDeclaredMethod(methodName, paramTypes);
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException(
                        "La méthode '" + methodName + "' avec les paramètres " +
                                java.util.Arrays.toString(paramTypes) +
                                " n'existe pas dans la classe " + clazz.getName(), e
                );
            }


        try {
            method.setAccessible(true);
            return method.invoke(target, args);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(
                    "Impossible d'accéder à la méthode '" + methodName +
                            "' de la classe " + clazz.getName(), e
            );
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            throw new RuntimeException(
                    "La méthode '" + methodName +
                            "' a levé une exception : " + cause, cause
            );
        }

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Calculator calc = ObjectFactory.create(
                Calculator.class,
                new Class<?>[]{int.class},
                new Object[]{10}
        );

        Object result1 = invoke(
                calc,
                "add",
                new Class<?>[]{int.class},
                new Object[]{5}
        );
    }

}
