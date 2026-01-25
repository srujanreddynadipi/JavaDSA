package com.prepInsta.java.Composition;

public class Branch {
    private String BranchName;
    private Sessions session;

    public Branch(String branchName, Sessions session) {
        BranchName = branchName;
        this.session = session;
    }

    public String getBranchName() {
        return BranchName;
    }

    public Sessions getSession() {
        return session;
    }
}
