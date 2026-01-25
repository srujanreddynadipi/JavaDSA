package com.prepInsta.java.Composition;

public class Library {
    private String Name;
    private String YearOfBuild;
    private int NoofBooks;
    private Floor floor;

    public Library(String name, String yearOfBuild, int noofBooks, Floor floor) {
        Name = name;
        YearOfBuild = yearOfBuild;
        NoofBooks = noofBooks;
        this.floor = floor;
    }

    public String getName() {
        return Name;
    }

    public String getYearOfBuild() {
        return YearOfBuild;
    }

    public int getNoofBooks() {
        return NoofBooks;
    }

    public Floor getFloor() {
        return floor;
    }

    public void SearchaBook(){
        System.out.println("Searching for Book");
    }
}
