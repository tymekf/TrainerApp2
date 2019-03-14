package com.trainerapp;

class tescik2 {
    public static String makeTitle(String s) {

        StringBuilder sb = new StringBuilder(s);
        s = s.toLowerCase();

        char cha = ' ';

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
               sb.append(Character.toUpperCase(i+1));

            }

        }
        return sb.toString().trim();




    }
}