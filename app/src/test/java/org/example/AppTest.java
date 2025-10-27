package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class AppTest {

    @Test
    public void testAppFindsGoldInSortedList() {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        int index = finder.linearSearch(sortedFuzzies);

        // Gold must exist in the sorted list
        assertTrue(index >= 0, "Linear search should find gold in sorted list");
        assertEquals("gold", sortedFuzzies.get(index).color);
    }

    @Test
    public void testAppFindsGoldInRandomList() {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
        int index = finder.linearSearch(randomFuzzies);

        // Gold must exist even in randomized order
        assertTrue(index >= 0, "Linear search should find gold in random list");
        assertEquals("gold", randomFuzzies.get(index).color);
    }

    @Test
    public void testAppBinarySearchOnSortedList() {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        int index = finder.binarySearch(sortedFuzzies);

        // Binary search should find gold in a sorted list
        assertTrue(index >= 0, "Binary search should find gold in sorted list");
        assertEquals("gold", sortedFuzzies.get(index).color);
    }

    @Test
    public void testAppBinarySearchOnRandomList() {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
        int index = finder.binarySearch(randomFuzzies);

        System.out.println("Binary search (random list) returned index: " + index);

        // It may fail — we only check that it doesn't crash
        assertTrue(index >= -1, "Binary search on random list should not crash");
    }
}
