package com.example.testdatabase;

import java.util.Objects;

public class Directory {
    public String idx; // 목록 번호
    public String division; // 분류
    public String word; // 단어
    public String meaning; // 단어의 뜻
    public String clear;
    public String star;
    public int directoryCheck=0;
    Directory(){}
    Directory(String word){
        this.word = word;
    }

    public int getDirectoryCheck() {
        return directoryCheck;
    }

    public void setDirectoryCheck(int directoryCheck) {
        this.directoryCheck = directoryCheck;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getIdx() {
        return idx;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(word, directory.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "Database{" +
                "idx='" + idx + '\'' +
                ", division='" + division + '\'' +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
