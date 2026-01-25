package com.prepInsta.java.Composition;

public class Student {
    private String  name ;
    private String RollNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public Student(String name, String rollNo) {
        this.name = name;
        RollNo = rollNo;
    }


}
