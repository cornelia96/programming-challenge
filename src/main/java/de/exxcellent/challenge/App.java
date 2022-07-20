package de.exxcellent.challenge;

import java.io. *;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws FileNotFoundException {

        String path = "C:\\Users\\chipp\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";
        System.out.printf("Day with smallest temperature spread : %s%n", getMaxDay(path));
    }

    public static Scanner readCsvFile(String path) throws FileNotFoundException {
        try {
            return new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Unter dem angegeben Pfad konnte keine Datei gefunden werden");
        }
    }

    public static List<Integer> getColumn(Scanner sc, int index) {
        List<Integer> column = new ArrayList<>();
        sc.useDelimiter("\n");
        sc.next();
        while (sc.hasNext()) {
            int value = Integer.parseInt(sc.next().split(",")[index]);
            column.add(value);
        }
        return column;
    }

    public static List<Integer> substractColumnsAminusB(List<Integer> columnA, List<Integer> columnB) {
        List<Integer> ranges = new ArrayList<>();
        for (int i=0; i<columnA.size(); i++) {
            ranges.add(columnA.get(i) - columnB.get(i));
        }
        return ranges;
    }

    public static int getMaxIndex(List<Integer> column) {
        int maxRange = Collections.max(column);
        return column.indexOf(maxRange);
    }

    public static Scanner resetScanner(Scanner sc) {
        Scanner newSc = sc.reset();
        sc.close();
        return newSc;
    }

    public static int getMaxDay(String path) throws FileNotFoundException {
        Scanner sc = readCsvFile(path);
        List<Integer> dayNumbers = getColumn(sc, 0);
        sc = readCsvFile(path);
        List<Integer> maxColumn = getColumn(sc, 1);
        sc = readCsvFile(path);
        List<Integer> minColumn = getColumn(sc, 2);
        sc.close();
        List<Integer> ranges = substractColumnsAminusB(maxColumn, minColumn);
        int maxDay = getMaxIndex(ranges);
        return dayNumbers.get(maxDay);
    }

}
