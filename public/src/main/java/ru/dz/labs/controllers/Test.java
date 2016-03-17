package ru.dz.labs.controllers;

import java.util.Arrays;

/**
 * Created by Булат on 17.03.2016.
 */
public class Test {
    public static void main(String[] args) {
        String letters = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] symbols = new char[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            symbols[i] = letters.charAt((int) (Math.random() * letters.length()));
        }

        System.out.println(String.valueOf(symbols));

    }
}
