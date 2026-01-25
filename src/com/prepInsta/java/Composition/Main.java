package com.prepInsta.java.Composition;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Srujan" , "7439");
        Sessions FinalYear = new Sessions("2026" , student1);
        Floor floor = new Floor(5 , 120);
        Branch csg = new Branch("csg" , new Sessions("third year ",student1));
        Library APJ = new Library("BestLibrary","2019",10000,floor);
        College TKREC = new College("TKR",APJ,csg);
        University TKR = new University("TKR",TKREC );

        TKR.getCollege().getCollegeName();
        TKR.getCollege().getLibrary().SearchaBook();
        TKR.getCollege().getLibrary().getFloor().Cleanthefloor();


    }
}
