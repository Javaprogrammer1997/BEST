package com.hillel.hw19;

import java.util.*;

public class TextUtils {

    public  String text = "Say your prayers little one\n" +
            "don't forget my son\n" +
            "to include everyone\n" +
            "Tuck you in warm within\n" +
            "keep you free from sin\n" +
            "till the sandman he comes\n" +
            "Sleep with one eye open\n" +
            "gripping your pillow tight";


    public List<String> splitTextToWords(String text) {
        return new ArrayList<>(Arrays.asList(text.split("\\W+")));
    }

    public Map<String, Integer> toMap(List<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }
}
