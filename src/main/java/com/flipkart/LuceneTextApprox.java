package com.flipkart;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by dhruv.pancholi on 26/04/16.
 */
public class LuceneTextApprox {

    public static String textApproxPatternReplace(String query) {
        query = query.replaceAll("ee", "i");
        query = query.replaceAll("th", "t");
        query = query.replaceAll("sh", "s");
        query = query.replaceAll("([A-Za-z])\\1", "$1");
        return query;
    }

    /**
     * @param lQ The original lucene query, in which terms are going to be rooted
     * @return The lucene query with the rooted terms in the root
     */
    public static String getRootedLuceneQuery(String lQ, Set<String> negativeSet, Map<String, String> corrections) {
        int s = -1, e = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lQ.length(); i++) {
            if (Character.isLetter(lQ.charAt(i))) {
                if (s < 0) {
                    s = i;
                }
                e = i;
            } else {
                if (s > -1 && e >= s) {
                    String word = lQ.substring(s, e + 1);
                    String root = textApproxPatternReplace(word);
                    if (!word.equals(root) && !negativeSet.contains(word) && !corrections.containsKey(word)) {
                        sb.append("(" + word + " OR " + textApproxPatternReplace(word) + ")");
                    } else {
                        sb.append(word);
                    }
                }
                sb.append(lQ.charAt(i));
                s = -1;
                e = -1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(getRootedLuceneQuery("((shaver OR saver) OR search results)", new HashSet<String>(), new HashMap<String, String>()));
    }
}
