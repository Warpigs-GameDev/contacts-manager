package docrob.cag.ContactsScreens;

import docrob.cag.framework.menu.Menu;
import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.utils.Input;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static docrob.cag.ContactsScreens.ContactList.findAll;

public class ShowContacts extends Screen {

    private static ArrayList<Contact> contacts;

    @Override
    public void setup() {
        super.setup();
        menu.addItem("Go back to the main menu", goBack);
    }

    @Override
    protected void show() {
        super.show();

        System.out.println("This is the Contacts Screen");
        System.out.println("What would you like to do?");
    }

    private MenuItemMethod goBack = () -> {
        ShowContacts screen = new ShowContacts();
        ScreenManager.addScreen(screen);
        super.setReadyToExit();
    };

    public static List<Contact> clist = findAll();

    public static void main(String[] args) {

        clist = loadContacts();
        System.out.println(clist);

        Input in = new Input();
        int choice = -1;
        while(choice !=0){
            System.out.println("0 - Close your phone");
            System.out.println("1 - View all Contacts");
            System.out.println("2 - Add new Contact");
            System.out.println("3 - Delete Contact");

            choice = in.getInt(0, 6);

            doChoice(choice);
        }
    }

    private static List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            Path dataFile = Paths.get("contacts.txt");

            contacts = getContactsFromFile(dataFile);

        } catch (IOException e) {
            System.out.println("Hey man your data file does not exist!");
            System.exit(0);
        }

        return contacts;

    }

    private static List<Contact> getContactsFromFile(Path dataFile) throws IOException {
        List<String> contactStrings = Files.readAllLines(dataFile);
        List<Contact> contacts = new ArrayList<>();

        // iterate over the strings
        for (String contactString : contactStrings) {
            // make a new fighter object from each string
            Contact contact = Contact.createFromCSVString(contactString);

            // add the fighter objects to the fighters list
            contacts.add(contact);
        }

        return contacts;
    }

    private static void doChoice(int choice){
        switch (choice){
            case 1:
                for(Contact pContact : clist){
                    System.out.println(pContact.getName() + " | " + pContact.getNumber());
                }
                break;
            case 2:
                Input in = new Input();
                System.out.println("Enter contact name");
                String name = in.getString();
                System.out.println("Enter contact number");
                String number = in.getString();
                Contact nContact = new Contact(name, number);
                addContact(nContact);

                for(Contact pContact : clist){
                    System.out.println(pContact.getName() + " | " + pContact.getNumber());
                }
                break;
            case 3:
                Input bye = new Input();
                System.out.println("Enter contact place you wish to delete");
                String byeName = bye.getString();
                for (int i = 0; i < clist.size(); i++) {
                    if (clist.get(i).getName().equalsIgnoreCase(byeName)) {
                        clist.remove(i);
                    }
                }
        }
    }

    public static void addContact(Contact contact){
         clist.add(contact);
    }
}
