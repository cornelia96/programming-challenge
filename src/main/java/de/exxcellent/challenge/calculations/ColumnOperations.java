package de.exxcellent.challenge.calculations;

import java.util.ArrayList;
import java.util.List;

/**
 * The class ColumnOperations contains a method to get the spread between two
 * columns/lists. It may be expanded upon to contain different math operations
 * which can be performed with two or more columns.
 */

public class ColumnOperations {

    public static List<Integer> getSpreadOfTwoColumns(List<Integer> columnA, List<Integer> columnB) throws IndexOutOfBoundsException {
        List<Integer> spread = new ArrayList<>();
        try {
            for (int i=0; i<columnA.size(); i++) {
                spread.add(Math.abs(columnA.get(i) - columnB.get(i)));
            }
        } catch (IndexOutOfBoundsException ignored) {}

        return spread;
    }
}
