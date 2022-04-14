package com.example.testdatabase;

public class BenPick {
    private String eng;
    private String japan;

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getJapan() {
        return japan;
    }

    public void setJapan(String japan) {
        this.japan = japan;
    }

    @Override
    public String toString() {
        return "BenPick{" +
                "eng='" + eng + '\'' +
                ", japan='" + japan + '\'' +
                '}';
    }
}
