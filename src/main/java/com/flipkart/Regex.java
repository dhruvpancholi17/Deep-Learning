package com.flipkart;

import org.apache.commons.lang.StringUtils;

/**
 * Created by dhruv.pancholi on 19/04/16.
 */
public class Regex {

    public static String textApproxPatternReplace(String query) {
        query = query.replaceAll("ee", "i");
        query = query.replaceAll("th", "t");
        query = query.replaceAll("sh", "s");
        query = query.replaceAll("([A-Za-z])\\1", "$1");
        return query;
    }

    public static String getSherlockSynonym(String token) {
        return token;
    }

    public static String textApprox(String query) {
        String[] tokens = query.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            String approx = textApproxPatternReplace(token);
            approx = getSherlockSynonym(approx);
            if (!approx.equals(token)) {
                tokens[i] = "(" + token + " OR " + approx + ")";
            }
        }
        return StringUtils.join(tokens, " ");
    }

    public static void main(String[] args) {
        System.out.println(textApprox("shaver"));
    }
}
