package org.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        FuzzyListGenerator generator = new FuzzyListGenerator(1000); // generates ~7000 fuzzies
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

        System.out.println("Let me search for the golden fuzzy...\n");

        //Linear Search on Sorted List
        long startTime1 = System.nanoTime();
        int testOne = finder.linearSearch(sortedFuzzies);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        System.out.println("Linear Search (Sorted List): index " + testOne);
        System.out.println("Time taken (ns): " + duration1);
        System.out.println("Worst-case comparisons: " + sortedFuzzies.size());
        System.out.println("Time Complexity: O(n)\n");

        //Binary Search on Sorted List
        long startTime2 = System.nanoTime();
        int testTwo = finder.binarySearch(sortedFuzzies);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        System.out.println("Binary Search (Sorted List): index " + testTwo);
        System.out.println("Time taken (ns): " + duration2);
        System.out.println("Time Complexity: O(log n)\n");

        //Linear Search on Randomized List 
        long startTime3 = System.nanoTime();
        int testThree = finder.linearSearch(randomFuzzies);
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;

        System.out.println("Linear Search (Random List): index " + testThree);
        System.out.println("Time taken (ns): " + duration3);
        System.out.println("Worst-case comparisons: " + randomFuzzies.size());
        System.out.println("Time Complexity: O(n)\n");

        // Binary Search on Randomized List
        long startTime4 = System.nanoTime();
        int testFour = finder.binarySearch(randomFuzzies);
        long endTime4 = System.nanoTime();
        long duration4 = endTime4 - startTime4;

        System.out.println("Binary Search (Random List): index " + testFour + " (may be incorrect!)");
        System.out.println("Time taken (ns): " + duration4);
        System.out.println("Time Complexity: O(log n) but only valid for sorted lists\n");

        // Theoretical Analysis of Linear Search
        System.out.println("Worst-Case Linear Search Analysis ");
        System.out.println("Algorithm: Linear Search");
        System.out.println("Input: Randomized list of fuzzies (n = " + randomFuzzies.size() + ")");
        System.out.println("Operation: Compare each fuzzy's color to \"gold\" sequentially");
        System.out.println("Worst-case scenario: Golden fuzzy is at the end or absent");
        System.out.println("Number of comparisons in worst-case: C(n) = n = " + randomFuzzies.size());
        System.out.println("Worst-case time complexity: T(n) = O(n)");
        System.out.println("Linear search works on unsorted data but runtime grows linearly with list size.\n");

        System.out.println("Complited analysis!");
    }
}
