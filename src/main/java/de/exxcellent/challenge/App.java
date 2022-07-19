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
    public static void main(String... args) {

        String path = "C:\\Users\\chipp\\IdeaProjects\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";

        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> dayNumbers = new ArrayList<>();
        List<Integer> ranges = new ArrayList<>();

        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            List<Integer> day = new ArrayList<>();



            for (String s : sc.next().split(",")) {
                try {
                    day.add(Integer.parseInt(s));
                    int range = day.get(1) - day.get(2);
                    ranges.add(range);
                    dayNumbers.add(day.get(0));
                } catch (IllegalArgumentException | IndexOutOfBoundsException ignored) {
                }
            }
        }

        int maxRange = Collections.max(ranges);
        int maxId = ranges.indexOf(maxRange);

        int maxDay = dayNumbers.get(maxId);

    // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", maxDay);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }

}
