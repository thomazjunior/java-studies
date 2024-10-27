package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// Utility class to provide mock data for examples
public class DataUtil {
    public static List<String> getMockFruitsArrayList() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        return fruits;
    }

    public static List<String> getMockFruitsLinkedList() {
        List<String> fruits = new LinkedList<>();
        fruits.add("Eggplant");
        fruits.add("Fig");
        fruits.add("Grapes");
        return fruits;
    }

    public static List<String> getMockFruitsVector() {
        List<String> fruits = new Vector<>();
        fruits.add("Honeydew");
        fruits.add("Kiwi");
        fruits.add("Lemon");
        return fruits;
    }
}