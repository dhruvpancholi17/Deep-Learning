package com.flipkart.helpers;

/**
 * Created by dhruv.pancholi on 15/04/16.
 */
public class Correction {

    private String incorrect;
    private String correct;

    public String getCorrect() {
        return correct;
    }

    public String getIncorrect() {
        return incorrect;
    }

    public Correction(String s) {
        if (s == null) throw new RuntimeException("Correction object cannot be instantiated with null String");
        if (!s.contains(",")) throw new RuntimeException("Line is not comma separated");
        String[] splits = s.split(",");
        correct = splits[0];
        incorrect = splits[1];
    }

    @Override
    public String toString() {
        return "Incorrect: " + incorrect + " Correct: " + correct;
    }
}
