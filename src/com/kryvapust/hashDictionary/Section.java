package com.kryvapust.hashDictionary;

import java.util.LinkedList;

public class Section {

    private final LinkedList<Combination> linkedList = new LinkedList<>();


    public void addTranslation(Combination combination) {
        linkedList.add(combination);
    }

    public void deleteTranslation(String word) {
        linkedList.remove(new Combination(word, null));
    }

    public String getTranslation(String key) {
        for (Combination entry : linkedList) {
            if (entry.getWord().equals(key)) {
                return entry.getTranslation();
            }
        }
        return String.format("Translation word \"%s\" was not found", key);
    }
}

