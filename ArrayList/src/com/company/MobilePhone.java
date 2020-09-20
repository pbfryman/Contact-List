package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Contacts> myContacts;

    public MobilePhone(Contacts myNumber) {
        this.myContacts = new ArrayList<Contacts>();
        myContacts.add(myNumber);

    }

    public void mainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("-------------------");
        System.out.println("\t 1 - Print contact list.");
        System.out.println("\t 2 - Add new contact.");
        System.out.println("\t 3 - Update existing contact.");
        System.out.println("\t 4 - Delete contact.");
        System.out.println("\t 5 - Find existing contact.");
        System.out.println("\t 6 - Power off.\n");
    }

    public void printContacts() {
        System.out.println("You have " + myContacts.size() + " contacts.");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(i+1 + ". " + myContacts.get(i).getName() + ", " +
                     myContacts.get(i).getNumber());
        }
    }

    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number: ");
        String number = scanner.nextLine();

        Contacts contact = new Contacts(name, number);

        if (findContact(contact) >= 0 || findNumber(number) == true) {
            System.out.println("Contact already exists.");
        } else {
            myContacts.add(contact);
            System.out.println("Added Contact: \n" + contact.getName() + "\n"
                    + contact.getNumber() + "\n");
        }
    }

    public void modifyContact() {
        modifyMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("\nEnter existing name: ");
                Contacts contact = findContact(scanner.nextLine());
                if (contact != null) {
                    System.out.print("\nEnter new name: ");
                    contact.setName(scanner.nextLine());
                } else {
                    System.out.println("\nContact not found.\n");
                }
                break;
            case 2:
                System.out.print("\nEnter existing name: ");
                contact = findContact(scanner.nextLine());
                if (contact != null) {
                    System.out.print("\nEnter new number: ");
                    contact.setNumber(scanner.nextLine());
                } else {
                    System.out.println("\nContact not found.\n");
                }
                break;
            case 3:
                System.out.print("\nEnter existing name: ");
                contact = findContact(scanner.nextLine());
                if (contact != null) {
                    System.out.print("\nEnter new name: ");
                    contact.setName(scanner.nextLine());
                    System.out.print("\nEnter new number: ");
                    contact.setNumber(scanner.nextLine());
                } else {
                    System.out.println("\nContact not found.\n");
                }
                break;
            case 4:

        }
    }

    public void removeContact() {
        System.out.print("\nEnter contact name: ");
        Contacts contact = findContact(scanner.nextLine());
        if (contact != null) {
            myContacts.remove(findContact(contact));
        } else {
            System.out.println("\nContact not found.\n");
        }
    }

    public void searchContact() {
        System.out.print("\nEnter contact name: ");
        Contacts contact = findContact(scanner.nextLine());
        if (contact != null) {
            System.out.println("Name: " + contact.getName() + "\nNumber: " +
                    contact.getNumber());
        } else {
            System.out.println("\nContact not found.\n");
        }
    }

    private int findContact(Contacts contact) {
        return myContacts.indexOf(contact);
    }

    private Contacts findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contacts contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }

    private boolean findNumber(String number) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contacts contact = this.myContacts.get(i);
            if (contact.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    private void modifyMenu() {
        System.out.println("\nUpdate Contact Menu:");
        System.out.println("\t 1 - Update name.");
        System.out.println("\t 2 - Update phone.");
        System.out.println("\t 3 - Update name and phone.");
        System.out.println("\t 4 - Main menu.");
    }
}
