package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FuzzyFinderTest {

    @Test
    public void testLinearSearchFindsGold() {
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        fuzzies.add(new Fuzzy("red"));
        fuzzies.add(new Fuzzy("gold"));
        fuzzies.add(new Fuzzy("blue"));

        FuzzyFinder finder = new FuzzyFinder();
        int index = finder.linearSearch(fuzzies);

        assertEquals(1, index);
    }

    @Test
    public void testBinarySearchFindsGoldInSortedList() {
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        fuzzies.add(new Fuzzy("blue"));
        fuzzies.add(new Fuzzy("gold"));
        fuzzies.add(new Fuzzy("red"));

        // Sort alphabetically (blue, gold, red)
        fuzzies.sort((f1, f2) -> f1.color.compareTo(f2.color));

        FuzzyFinder finder = new FuzzyFinder();
        int index = finder.binarySearch(fuzzies);

        assertTrue(index >= 0);
        assertEquals("gold", fuzzies.get(index).color);
    }

    @Test
    public void testLinearSearchWithNoGold() {
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        fuzzies.add(new Fuzzy("red"));
        fuzzies.add(new Fuzzy("blue"));

        FuzzyFinder finder = new FuzzyFinder();
        int index = finder.linearSearch(fuzzies);

        assertEquals(-1, index, "Linear search should return -1 if no gold is found");
    }

    @Test
    public void testBinarySearchWithNoGold() {
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        fuzzies.add(new Fuzzy("blue"));
        fuzzies.add(new Fuzzy("red"));
        fuzzies.sort((f1, f2) -> f1.color.compareTo(f2.color));

        FuzzyFinder finder = new FuzzyFinder();
        int index = finder.binarySearch(fuzzies);

        assertEquals(-1, index, "Binary search should return -1 if gold is not present");
    }

    @Test
    public void testSearchOnEmptyList() {
        ArrayList<Fuzzy> fuzzies = new ArrayList<>();
        FuzzyFinder finder = new FuzzyFinder();

        assertEquals(-1, finder.linearSearch(fuzzies));
        assertEquals(-1, finder.binarySearch(fuzzies));
    }

    @Test
    public void testPerformanceComparison() {
        // Test speed difference roughly (no strict assert, just demonstration)
        FuzzyListGenerator generator = new FuzzyListGenerator(1000); // large enough for timing
        ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
        FuzzyFinder finder = new FuzzyFinder();

        long startLinear = System.nanoTime();
        finder.linearSearch(fuzzies);
        long endLinear = System.nanoTime();

        long startBinary = System.nanoTime();
        finder.binarySearch(fuzzies);
        long endBinary = System.nanoTime();

        System.out.println("Linear Search Time: " + (endLinear - startLinear) + " ns");
        System.out.println("Binary Search Time: " + (endBinary - startBinary) + " ns");
    }
}
