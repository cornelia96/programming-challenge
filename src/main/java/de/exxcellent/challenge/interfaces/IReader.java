package de.exxcellent.challenge.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

public interface IReader {
    /**
     * ReturnIntegerColumnAsAList returns the column of a table/data sheet as a
     * List interface of the object type Integer (provided the column contains Integers)
     */
    List<Integer> returnIntegerColumnAsList(int index) throws FileNotFoundException;

    /**
     * ReturnStringColumnAsAList returns the column of a table/data sheet as a
     * List interface of the object type String
     */
    List<String> returnStringColumnAsList(int index) throws FileNotFoundException;
}
