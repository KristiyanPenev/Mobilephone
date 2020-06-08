package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contacts> contactList;

    public MobilePhone() {
        this.contactList = new ArrayList<>();
    }

    public boolean addNewContact(Contacts contact) {
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already in the list.");
        }
        contactList.add(contact);
        return true;
    }
    public boolean updateContact(Contacts oldContact , Contacts newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName() + " , was not found");
            return false;
        }

        contactList.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }


    public boolean removeContact(Contacts contacts) {
        int findPosition = findContact(contacts);
        if(findPosition < 0) {
            System.out.println(contacts.getName() + ", was found!");
            return false;
        }
        contactList.remove(findPosition);
        System.out.println(contacts.getName() + ", was deleted successfully!");
        return true;
    }

    private int findContact(Contacts contact) {
        return contactList.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(int i = 0; i < contactList.size();i++) {
            Contacts contact = contactList.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String searchContact(Contacts contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contacts searchContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return contactList.get(position);
        }
        return  null;
    }

    public void printContacts() {
        System.out.println("Contact list: ");
        for(int i = 0; i < contactList.size();i++) {
            System.out.println((i+1) + " ." + contactList.get(i).getName() + ", telephone number: " +
                            contactList.get(i).getPhoneNumber());
        }
    }
}
