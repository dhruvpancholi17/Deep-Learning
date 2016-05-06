package com.flipkart;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.embeddings.wordvectors.WordVectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Collection;

/**
 * Created by dhruv.pancholi on 23/03/16.
 */
public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        File gModel = new File("/Users/dhruv.pancholi/flipkart/word2vec.bin");
        WordVectors vec = WordVectorSerializer.loadGoogleModel(gModel, true);
        double sim = vec.similarity("chollis","cholis");
        System.out.println(vec.similarity("studds","studs"));
    }
}

