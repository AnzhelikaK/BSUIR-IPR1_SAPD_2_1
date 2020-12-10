package com.kryvapust.hashDictionary;

import java.util.Objects;

public class Combination {
    private final String word;
    private final String translation;

    public Combination(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
