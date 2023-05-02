package com.example.interceptor2.entities;

public class Month {

    private Integer monthNumber;

    private String englishName;

    private String italianName;

    private String germanName;

    public Month(){

    }
    public Month(int monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getGernamName() {
        return germanName;
    }

    public void setGernamName(String gernamName) {
        this.germanName = gernamName;
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthNumber=" + monthNumber +
                ", englishName='" + englishName + '\'' +
                ", italianName='" + italianName + '\'' +
                ", gernamName='" + germanName + '\'' +
                '}';
    }
}
