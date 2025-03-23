package java9.compactString;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class CompactStringExample {
    public static void main(String[] args) {
        System.out.println("🚀 Comparaison Compact Strings : Java 8 vs Java 9+");

        // Test avec String ASCII (Compact Strings activé en Java 9+)
        System.out.println("\n🔹 Test avec ASCII Strings (Compact Strings ON en Java 9+)");
        long beforeAscii = getUsedMemory();
        List<String> asciiStrings = generateStrings("Hello Java 9!", 1_000_000);
        long afterAscii = getUsedMemory();
        System.out.println("📊 Mémoire utilisée (ASCII) : " + (afterAscii - beforeAscii) + " KB");

        // Test avec String Unicode (Compact Strings désactivé)
        System.out.println("\n🔹 Test avec Unicode Strings (Compact Strings OFF)");
        long beforeUnicode = getUsedMemory();
        List<String> unicodeStrings = generateStrings("Привет, мир! 🌍", 1_000_000);
        long afterUnicode = getUsedMemory();
        System.out.println("📊 Mémoire utilisée (Unicode) : " + (afterUnicode - beforeUnicode) + " KB");

        // Empêcher le GC
        System.out.println("\n📌 Nombre total de chaînes stockées : " + (asciiStrings.size() + unicodeStrings.size()));
    }

    private static List<String> generateStrings(String text, int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(text);
        }
        return list;
    }

    private static long getUsedMemory() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / 1024;
    }
}

