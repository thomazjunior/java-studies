package utils;

import java.util.List;

@FunctionalInterface
public interface DataProvider<T> {
    List<T> generate(int numberOfInstances);
}