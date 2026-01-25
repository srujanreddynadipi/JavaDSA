package com.prepInsta.java.Composition;

public class Sessions {
    private String SessionName;
    private Student student;

    public Sessions(String sessionName, Student student) {
        SessionName = sessionName;
        this.student = student;
    }

    public String getSessionName() {
        return SessionName;
    }

    public Student getStudent() {
        return student;
    }
}
