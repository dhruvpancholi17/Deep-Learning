package com.flipkart;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by dhruv.pancholi on 06/04/16.
 */
public class CsvWord2Vec {
    private static Logger log = LoggerFactory.getLogger(CsvWord2Vec.class);

    public static void main(String[] args) throws Exception {
        File gModel = new File("/Users/dhruv.pancholi/flipkart/word2vec.bin");
        WordVectors vec = WordVectorSerializer.loadGoogleModel(gModel, true);
        BufferedReader br = new BufferedReader(new FileReader("/Users/dhruv.pancholi/Desktop/golden/golden_train.csv"));
        FileOutputStream fos = new FileOutputStream("/Users/dhruv.pancholi/Desktop/golden/word2vec.txt", true);
        OutputStreamWriter w = new OutputStreamWriter(fos, "UTF-8");
        String line = br.readLine();
        String incorrect, correct;
        String[] liner;
        double sim;
        while ((line = br.readLine()) != null) {
            liner = line.split(",");

            incorrect = liner[0];
            correct = liner[1];
            System.out.println(vec.similarity(incorrect, correct));
        }
        w.flush();
        w.close();
    }
}
