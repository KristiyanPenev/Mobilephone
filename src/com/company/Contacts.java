package com.company;


import java.util.ArrayList;

public class Contacts {

    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacts createContacts(String name, String phoneNumber) {
        return new Contacts(name,phoneNumber);
    }

    private ArrayList<String> contactList = new ArrayList<>();

    public ArrayList<String> getContactList() {
        return contactList;
    }

    public void storeContacts(String name) {
        contactList.add(name);
    }

    public void printContactList() {
        System.out.println("You have " + contactList.size() + " contacts in your list.");

    }
}
