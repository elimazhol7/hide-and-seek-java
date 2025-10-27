package org.example;

import java.util.ArrayList;

public class FuzzyFinder {

    /**
     * Performs a linear search to find the golden fuzzy.
     * Works for any list order.
     */
    public int linearSearch(ArrayList<Fuzzy> fuzzies) {
        for (int i = 0; i < fuzzies.size(); i++) {
            if (fuzzies.get(i).color.equalsIgnoreCase("gold")) {
                return i;
            }
        }
        return -1; // not found
    }

    /**
     * Performs a binary search to find the golden fuzzy.
     * Only guaranteed to work correctly on sorted lists.
     */
    public int binarySearch(ArrayList<Fuzzy> fuzzies) {
        int low = 0;
        int high = fuzzies.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midColor = fuzzies.get(mid).color;

            int compare = midColor.compareToIgnoreCase("gold");

            if (compare == 0) {
                return mid; // found!
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // not found
    }
}
