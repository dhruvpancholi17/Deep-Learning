package com.flipkart.iterators;

import com.flipkart.helpers.Correction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by dhruv.pancholi on 15/04/16.
 */
public class CorrectionsLoader implements Iterator<Correction> {
    BufferedReader br;
    String line;

    public CorrectionsLoader(String filePath) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filePath));
    }

    public boolean hasNext() {
        try {
            line = br.readLine();
        } catch (IOException e) {
            return false;
        }
        return line != null;
    }

    public Correction next() {
        return new Correction(line);
    }

    public void remove() {

    }
}
