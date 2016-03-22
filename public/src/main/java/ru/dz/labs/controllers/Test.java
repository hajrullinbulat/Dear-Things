package ru.dz.labs.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Булат on 17.03.2016.
 */
public class Test {
    public static void main(String[] args) {
        String s = "1,2,3,4,55,4,";
        System.out.println(s);
        String[] s1 = s.split(",");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, s1);

        Long integer = 4L;

        for (int i = 0; i < s1.length; i++) {
            if (i == integer - 1) {
                list.remove(i);
            }
        }

        String ans = "";
        for (String s2 : list) {
            ans = ans + s2 + ",";
        }

        System.out.println(ans);


    }
}
