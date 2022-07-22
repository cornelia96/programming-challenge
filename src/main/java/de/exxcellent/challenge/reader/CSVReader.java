package de.exxcellent.challenge.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private final String path;
    private Scanner sc;

    /**
     * The class CSVReader reads data from a .csv-file and returns
     * columns as lists of Integer or String objects.
     * May be expanded upon by returning columns of different object types
     * or returning rows instead of columns, as needed.
     */
    public CSVReader(String path) throws FileNotFoundException {
        this.path = path;
        this.sc = new Scanner(new File(path));
    }

    public List<Integer> returnIntegerColumnAsList(int index) throws FileNotFoundException {
        this.sc = new Scanner(new File(path));
        this.sc.useDelimiter("\n");
        this.sc.next();
        List<Integer> values = new ArrayList<>();
        while (this.sc.hasNext()) {
            try {
                values.add(Integer.valueOf(this.sc.next().split(",")[index]));
            } catch (IllegalArgumentException ignored){}
        }
        this.sc.close();
        return values;
    }

    public List<String> returnStringColumnAsList(int index) {
        this.sc.useDelimiter("\n");
        this.sc.next();
        List<String> values = new ArrayList<>();
        while (this.sc.hasNext()) {
            try {
                values.add(this.sc.next().split(",")[index]);
            } catch (IllegalArgumentException ignored){}
        }
        this.sc.close();
        return values;
    }
}