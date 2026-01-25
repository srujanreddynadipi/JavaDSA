package com.prepInsta.java.Composition;

public class University {
    private String Name;
    private College college;

    public University(String name, College college) {
        Name = name;
        this.college = college;
    }

    public String getName() {
        return Name;
    }

    public College getCollege() {
        return college;
    }
}
