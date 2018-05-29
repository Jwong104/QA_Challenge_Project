package com.company.SortMatches;

import com.company.Recipient;

import java.util.*;

import static java.util.Arrays.asList;

public class SortMatches {
    public static ArrayList<Recipient> sortMatches(List<Recipient> matches){

        Object[] matched = matches.toArray();
        Arrays.sort(matched);
        //Arrays.sort(matched, Collections.reverseOrder());
        Recipient[] sorted = Arrays.asList(matched).toArray(new Recipient[matched.length]);
        ArrayList<Recipient> sortedMatches = new ArrayList<Recipient>(Arrays.asList(sorted));
        return sortedMatches;
    }
}