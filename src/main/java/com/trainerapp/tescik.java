package com.trainerapp;

import java.util.*;


public class tescik {
    public static String[] isFourLetters(String[] s) {
        ArrayList<String> list = new ArrayList();

        for(String i : s){
            if(i.length() == 4){
                list.add(i);
            }
        }

        String[] result = list.toArray(new String[list.size()]);
        return result;
    }
}