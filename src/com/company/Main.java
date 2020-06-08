package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quitContacts = false;
        int choice = 0;
        printInstruction();
        while(!quitContacts) {
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quitContacts = true;
                    break;


        }

        }

    }

    public static void printInstruction() {
        System.out.println("\nPress: ");
        System.out.println("\t 0  - To print choice options ");
        System.out.println("\t 1 - To print contact list");
        System.out.println("\t 2 - To add new contact in the list.");
        System.out.println("\t 3 - To update an existing contact. ");
        System.out.println("\t 4 - To remove an existing contact. ");
        System.out.println("\t 5 - To search an existing contact. ");
        System.out.println("\t 6 - To quit application. ");
        System.out.println("\t 7 - Choose instruction: ");
    }

    public static void addNewContact() {
        System.out.println("Enter contact name: ");
        String name = input.nextLine();
        System.out.println("Enter contact phone number: ");
        String phoneNumber = input.nextLine();
        Contacts newContact = Contacts.createContacts(name,phoneNumber);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", and phone = " + phoneNumber);
        } else {
            System.out.println("Can not add, " + name + " already on list.");
        }
    }

    public static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = input.nextLine();
        Contacts exContact = mobilePhone.searchContact(name);
        if(exContact == null) {
            System.out.println("Cannot find contact!");

        }
        System.out.println("Enter new contact name: ");
        String newName = input.nextLine();
        System.out.println("Enter new phone number: ");
        String newPhoneNumber = input.nextLine();

        Contacts newContact = Contacts.createContacts(newName,newPhoneNumber);
        if(mobilePhone.updateContact(exContact,newContact)) {
            System.out.println("Successfully updated!");
        } else {
            System.out.println("Error updating contact!");
        }
    }

    public static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = input.nextLine();
        Contacts exContacts = mobilePhone.searchContact(name);
        if(exContacts == null) {
            System.out.println("Cannot find contact! ");
        }
        if (mobilePhone.removeContact(exContacts)){
            System.out.println("Successfully Deleted!");
        } else {
            System.out.println("Cannot delete!");
        }
    }

    public static void searchContact() {
        System.out.println("Search contact: ");
        String searchContact = input.nextLine();
        if(mobilePhone.searchContact(searchContact)!=null) {
            System.out.println("Found " + searchContact + " in our contact list!");
        } else {
            System.out.println(searchContact + " is not in the contact list!");
        }
    }
}
