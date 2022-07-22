package de.exxcellent.challenge.challenges;

import de.exxcellent.challenge.calculations.ColumnOperations;
import de.exxcellent.challenge.interfaces.IReader;
import de.exxcellent.challenge.interfaces.ITable;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

/**
 * The class Weather describes the relevant data from the table from the file weather.csv
 */
public class Weather implements ITable {
    private final List<Integer> days;
    private final List<Integer> maxTemp;
    private final List<Integer> minTemp;

    /**
     * The constructor adds the data from the relevant columns to list interfaces
     */
    public Weather(IReader reader) throws IllegalArgumentException, FileNotFoundException {
        this.days = reader.returnIntegerColumnAsList(0);
        this.maxTemp = reader.returnIntegerColumnAsList(1);
        this.minTemp = reader.returnIntegerColumnAsList(2);
    }

    @Override
    public String getMin() {
        return null;
    }

    /**
     * getMaxDay returns a String of the day with the maximum temperature spread
     * (The spread itself is calculated in a helper class)
     */
    @Override
    public String getMax() {
        List<Integer> spread = ColumnOperations.getSpreadOfTwoColumns(this.maxTemp, this.minTemp);
        int maxIndex = spread.indexOf(Collections.max(spread));
        return String.valueOf(this.days.get(maxIndex));
    }


}
