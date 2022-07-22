package de.exxcellent.challenge.challenges;

import de.exxcellent.challenge.calculations.ColumnOperations;
import de.exxcellent.challenge.interfaces.IReader;
import de.exxcellent.challenge.interfaces.ITable;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

/**
 * The class Football describes the relevant data from the table from the file football.csv
 */
public class Football implements ITable {
    private final List<String> teams;
    private final List<Integer> goals;
    private final List<Integer> goalsAllowed;

    /**
     * The constructor adds the data from the relevant columns to list interfaces
     */
    public Football(IReader reader) throws IllegalArgumentException, FileNotFoundException {
        this.teams = reader.returnStringColumnAsList(0);
        this.goals = reader.returnIntegerColumnAsList(5);
        this.goalsAllowed = reader.returnIntegerColumnAsList(6);
    }

    /**
     * getMaxDay returns a String of the day with the maximum temperature spread
     * (The spread itself is calculated in a helper class)
     */
    @Override
    public String getMin() {
        List<Integer> spread = ColumnOperations.getSpreadOfTwoColumns(this.goals, this.goalsAllowed);
        int minIndex = spread.indexOf(Collections.min(spread));
        return this.teams.get(minIndex);
    }

    @Override
    public String getMax() {
        return null;
    }
}

