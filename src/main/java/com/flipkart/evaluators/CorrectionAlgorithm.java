package com.flipkart.evaluators;

import com.flipkart.helpers.Correction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhruv.pancholi on 15/04/16.
 */
public abstract class CorrectionAlgorithm {

    static List<Correction> correctionList;

    private static String CORRECTION_FILE_LOCATION = "/Users/dhruv.pancholi/flipkart/log-analysis/data/Queries/test_data.txt";

    public static void loadTestCorrections() throws FileNotFoundException {
        correctionList = new ArrayList<Correction>();

        BufferedReader br = new BufferedReader(new FileReader(CORRECTION_FILE_LOCATION));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                correctionList.add(new Correction(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of corrections loaded: " + correctionList.size());
    }

    public static String getRoot(String query) {

        if (query == null || query.isEmpty() || query.length() == 1) {
            return query;
        }

        char sChar = query.charAt(0);

        StringBuilder sb = new StringBuilder();
        sb.append(sChar);

        for (int i = 1; i < query.length(); i++) {
            if (query.charAt(i) != sChar) {
                sb.append(query.charAt(i));
            }
            sChar = query.charAt(i);
        }

        return sb.toString();
    }

    public static void loadModel() {

    }


    public static void main(String[] args) throws FileNotFoundException {
        loadTestCorrections();
        loadModel();
    }
}
