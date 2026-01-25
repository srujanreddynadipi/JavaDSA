package com.prepInsta.java.collections.comparator;

public class PhoneDirectory implements Comparable<PhoneDirectory> {
    private String contactName;
    private String contactNumber;

    public PhoneDirectory(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }


    @Override
    public int compareTo(PhoneDirectory o) {
        if (this.contactName.compareTo(o.contactName) == 0) {
            return 0;
        } else if (this.contactName.compareTo(o.contactName) > 0) {
            return 1;
        } else
            return -1;
    }


    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

}
