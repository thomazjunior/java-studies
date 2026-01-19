package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MiniDIExample {

    /* =======================
       1. ANNOTATION
       ======================= */

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Inject {
    }

    /* =======================
       2. SERVICES
       ======================= */

    static class Database {
        public void connect() {
            System.out.println("Database connected");
        }
    }

    static class UserService {

        @Inject
        private Database database;

        public void process() {
            database.connect();
            System.out.println("User processed");
        }
    }

    /* =======================
       3. CONTENEUR DI
       ======================= */

    static class Container {

        private final Map<Class<?>, Object> instances = new HashMap<>();

       public synchronized <T> T get(Class<T> type) {
           Object existing = instances.get(type);
           if (existing != null){
               return type.cast(existing);
           }

           Object created = create(type);
           instances.put(type, created);
           return type.cast(created);
       }

        private Object create(Class<?> type) {
            try {
                // 1. Créer l’instance (constructeur vide)
                Constructor<?> constructor = type.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object instance = constructor.newInstance();

                // 2. Injecter les champs annotés
                for (Field field : type.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        field.setAccessible(true);
                        Object dependency = get(field.getType());
                        field.set(instance, dependency);
                    }
                }
                return instance;

            } catch (Exception e) {
                throw new RuntimeException("Cannot create " + type.getName(), e);
            }
        }
    }

    /* =======================
       4. MAIN
       ======================= */

    public static void main(String[] args) {

        Container container = new Container();

        UserService service = container.get(UserService.class);
        service.process();
    }
}
