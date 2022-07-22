package de.exxcellent.challenge.challenges;

import de.exxcellent.challenge.calculations.ColumnOperations;
import de.exxcellent.challenge.reader.CSVReader;


import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

/**
 * The class Weather describes the relevant data from the table from the file weather.csv
 */
public class Weather {
    private final List<Integer> days;
    private final List<Integer> maxTemp;
    private final List<Integer> minTemp;

    /**
     * The constructor adds the data from the relevant columns to list interfaces
     */
    public Weather(CSVReader reader) throws IllegalArgumentException, FileNotFoundException {
        this.days = reader.returnIntegerColumnAsList(0);
        this.maxTemp = reader.returnIntegerColumnAsList(5);
        this.minTemp = reader.returnIntegerColumnAsList(6);
    }

    /**
     * getMaxDay returns a String of the day with the maximum temperature spread
     * (The spread itself is calculated in a helper class)
     */
    public String getMaxDay() {
        List<Integer> spread = ColumnOperations.getSpreadOfTwoColumns(this.maxTemp, this.minTemp);
        int maxIndex = spread.indexOf(Collections.max(spread));
        return String.valueOf(this.days.get(maxIndex));
    }


}
