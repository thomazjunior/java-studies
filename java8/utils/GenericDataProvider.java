package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * A generic data provider that generates a list of random instances of a
 * specified type.
 * 
 * @param <T> the type of objects that this provider generates, must extend
 *            RandomPopulatable
 */
public class GenericDataProvider<T extends RandomPopulatable> implements DataProvider<T> {
    private final Supplier<T> supplier;

    /**
     * Constructs a GenericDataProvider with a given supplier for the objects.
     * 
     * @param supplier a Supplier that generates instances of type T
     */
    public GenericDataProvider(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * Generates a list of random instances of type T
     * 
     * @param numberOfInstances the number of instances to generate
     * @return a list of randomly populated instances
     */
    @Override
    public List<T> generate(int numberOfInstances) {
        List<T> instances = new ArrayList<>();
        for (int i = 0; i < numberOfInstances; i++) {
            T instance = supplier.get();
            instance.populateRandomValues();
            instances.add(instance);
        }
        return instances;
    }
}
