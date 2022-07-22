package de.exxcellent.challenge;

import de.exxcellent.challenge.challenges.Football;
import de.exxcellent.challenge.challenges.Weather;
import de.exxcellent.challenge.reader.CSVReader;

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

        Scanner sc = new Scanner(new File(weatherPath));

        Weather weather = new Weather(new CSVReader(weatherPath));
        Football football = new Football(new CSVReader(footballPath));

        String dayWithSmallestTempSpread = weather.getMaxDay();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = football.getMinTeam(); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }

}
