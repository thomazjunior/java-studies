package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflexionValidationExample {

    /**
     * 1. Annotation
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface NotNull {
    }

    /**
     * 2. Objet Métier
     */
    static class User {

        @NotNull
        private String userName;
        @NotNull
        private String email;
        private int age;

        public User(String userName, String email, int age) {
            this.userName = userName;
            this.email = email;
            this.age = age;
        }
    }

    /**
     * 3. Validateur Générique
     */
    static class Validator {
        public static List<String> validate(Object target) {
            List<String> errors = new ArrayList<>();
            Class<?> clazz = target.getClass();

            for (Field field : clazz.getDeclaredFields()) {
                if (!field.isAnnotationPresent(NotNull.class)) {
                    continue;
                }

                field.setAccessible(true);

                try {
                    Object value = field.get(target);

                    if (value == null) {
                        errors.add(
                                "Field '" + field.getName() + "' must not be null"
                        );
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return errors;
        }
    }

    /**
     * 4. Main : Utilisation
     */
    public static void main (String[] args) throws Exception {
        // Instanciation vi réflexion
        Constructor<User> constructor = User.class.getDeclaredConstructor(String.class, String.class, int.class);
        constructor.setAccessible(true);

        User user = constructor.newInstance("Alice", null, 25);

        List<String> errors = Validator.validate(user);
        errors.forEach(System.out::println);
    }


}
