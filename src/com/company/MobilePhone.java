package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    Scanner scanner = new Scanner(System.in);

    private ArrayList<Contact> contactList = new ArrayList<>();

    MobilePhone(){

        runMenu();
    }



    MobilePhone(String name, String phoneNumber){
        contactList.add(new Contact(name, phoneNumber));
    }

    private void runMenu() {

        boolean quit = false;
        int menuOpt;

        while(!quit){
            System.out.println("Enter an option");
            System.out.println("1 - print list of contacts");
            System.out.println("2 - add new contact");
            System.out.println("3 - update existing contact");
            System.out.println("4 - remove contact");
            System.out.println("5 - search for contact");
            System.out.println("6 - quit");

            menuOpt = scanner.nextInt();

            switch (menuOpt){
                case 1:
                    printContactList();
                    break;
                case 2:
                    getNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                        runMenu();
            }

        }

    }
    private boolean contactExists(String contactToFind) {
        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getName().equals(contactToFind)){
            return true;
            }
        }
        return false;
    }

    private void searchForContact() {
        String contactToFind;

        scanner.nextLine();
        System.out.println("Enter name of contact you want to find");
        contactToFind = scanner.nextLine();

        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getName().equals(contactToFind)){
                System.out.println(contactList.get(i).getName()
                        + " found at position: " + (i + 1)
                        + " this phone number is: "
                        + contactList.get(i).getPhoneNumber());
            }
        }

    }

    private void removeContact() {

        String contactToRemove;

        scanner.nextLine();
        System.out.println("Enter name of contact you want to remove");
        contactToRemove = scanner.nextLine();

        for (int i = 0; i < contactList.size() ; i++) {
            if(contactList.get(i).getName().equals(contactToRemove)){
                contactList.remove(i);
                break;
            }
        }

    }

    private void updateContact() {
        Contact newContact = new Contact();
        String existingContactName;

        scanner.nextLine();
        System.out.println("Enter name of contact you want to update");
        existingContactName = scanner.nextLine();

        System.out.println("Enter name of new contact");
        newContact.setName(scanner.nextLine());

        System.out.println("Enter phone of new contact");
        newContact.setPhoneNumber(scanner.nextLine());

        for (int i = 0; i < contactList.size(); i++) {
          if(existingContactName.equals(contactList.get(i).getName())){
             contactList.set(i, newContact);
             break;
          }
        }
    }

    private void getNewContact() {
        Contact newContact = new Contact();

        scanner.nextLine();
        System.out.println("Enter the name of new contact");
        newContact.setName(scanner.nextLine());
        System.out.println("Enter the phone number");
        newContact.setPhoneNumber(scanner.nextLine());
        if(!contactExists(newContact.getName())) {
            addContact(newContact);
        }else {
            System.out.println("Contact already exists. No changes made");
        }
    }

    private void printContactList() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i+1) +": name = " + contactList.get(i).getName()
                    +", phone = " + contactList.get(i).getPhoneNumber());
        }
    }

    public void addContact(Contact contact){
        addContact(contact.getName(), contact.getPhoneNumber());
    }

    public void addContact(String name, String phoneNumber){
        contactList.add(new Contact(name, phoneNumber));
    }


}
