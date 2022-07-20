package de.exxcellent.challenge;

import java.io. *;
import java.util.*;

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

        String weatherPath = "C:\\Users\\chipp\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";
        String footballPath = "C:\\Users\\chipp\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv";


        String dayWithSmallestTempSpread = getMaxDay(weatherPath);     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = getMinGoalTeam(footballPath); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }

    /** readCsvFile opens and reads a .csv-file at "path" and returns a scanner object */
     public static Scanner readCsvFile(String path) throws FileNotFoundException {
        try {
            return new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Unter dem angegeben Pfad konnte keine Datei gefunden werden");
        }
    }

    /** getColumn returns an arraylist of the type String
     * The contents of the array is the column with the specified index
     * BUG: The scanner cannot be reset, so it has to be re-initialized
     * with readCsvFile each time before getColumn is used
     */
    public static List<String> getColumn(Scanner sc, int index) {
        List<String> column = new ArrayList<>();
        Scanner scanner = sc.useDelimiter("\n");
        scanner.next();
        while (scanner.hasNext()) {
            String value = scanner.next().split(",")[index];
            column.add(value);
        }
        scanner.close();
        return column;
    }

    /** getMaxIndex returns the index of the biggest value in an integer array list
     */
    public static int getMaxIndex(List<Integer> column) {
        int maxRange = Collections.max(column);
        return column.indexOf(maxRange);
    }

    /** getMinIndex returns the index of the smallest value in an integer array list
     */
    public static int getMinIndex(List<Integer> column) {
        int minRange = Collections.min(column);
        return column.indexOf(minRange);
    }

    /** getSpreadOfTwoColumns calculates the spread between the two columns with the
     * provided indices, returning an array list of type int
     */
    public static List<Integer> getSpreadOfTwoColumns(String path, int indexA, int indexB) throws FileNotFoundException {
        Scanner sc = readCsvFile(path);
        List<String> columnA = getColumn(sc, indexA);
        sc = readCsvFile(path);
        List<String> columnB = getColumn(sc, indexB);
        sc.close();
        List<Integer> ranges = new ArrayList<>();
        List<Integer> integerA = new ArrayList<>();
        List<Integer> integerB = new ArrayList<>();
        try {
            for (String s : columnA) {
                integerA.add(Integer.parseInt(s));
            }for (String s : columnB) {
                integerB.add(Integer.parseInt(s));
            }
            for (int i=0; i<integerA.size(); i++) {
                ranges.add(integerA.get(i) - integerB.get(i));
            }
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
        }
        List<Integer> absRanges = new ArrayList<>();
        for (int value : ranges) {
            absRanges.add(Math.abs(value));
        }
        return absRanges;
    }

    /** getMaxDay returns the day with the largest temperature spread
     */
    public static String getMaxDay(String path) throws FileNotFoundException {
        Scanner sc = readCsvFile(path);
        List<String> infoColumn = getColumn(sc, 0);
        sc.close();
        int maxDay = getMaxIndex(getSpreadOfTwoColumns(path, 1, 2));
        return infoColumn.get(maxDay);
    }

    /** getMaxDay returns the day with the largest temperature spread
     */
    public static String getMinGoalTeam(String path) throws FileNotFoundException {
        Scanner sc = readCsvFile(path);
        List<String> infoColumn = getColumn(sc, 0);
        sc.close();
        int minTeam = getMinIndex(getSpreadOfTwoColumns(path, 5,6));
        return infoColumn.get(minTeam);
    }

}
