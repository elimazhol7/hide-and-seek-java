package org.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        FuzzyListGenerator generator = new FuzzyListGenerator(1000); // generates ~7000 fuzzies
        FuzzyFinder finder = new FuzzyFinder();

        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

        System.out.println("Let me search for the golden fuzzy...");

        int testOne = finder.linearSearch(sortedFuzzies);
        System.out.println("Linear Search (Sorted List): index " + testOne);

        int testTwo = finder.binarySearch(sortedFuzzies);
        System.out.println("Binary Search (Sorted List): index " + testTwo);

        int testThree = finder.linearSearch(randomFuzzies);
        System.out.println("Linear Search (Random List): index " + testThree);

        int testFour = finder.binarySearch(randomFuzzies);
        System.out.println("Binary Search (Random List): index " + testFour + " (incorrect??)");

        System.out.println("\nI'm done with testing all four searches!");
    }
}
