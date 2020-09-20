package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Contacts myNumber = new Contacts("My Number", "972-974-6999");
    private static MobilePhone phone = new MobilePhone(myNumber);

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        while (!quit) {
            phone.mainMenu();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    phone.printContacts();
                    break;
                case 2:
                    phone.addContact();
                    break;
                case 3:
                    phone.modifyContact();
                    break;
                case 4:
                    phone.removeContact();
                    break;
                case 5:
                    phone.searchContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void removeContact() {

    }

    private static void searchContact() {

    }
}
