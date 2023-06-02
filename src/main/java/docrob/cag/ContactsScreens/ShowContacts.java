package docrob.cag.ContactsScreens;

import docrob.cag.framework.menu.Menu;
import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.utils.Input;

import java.util.ArrayList;
import java.util.Arrays;

import static docrob.cag.ContactsScreens.ContactList.findAll;

public class ShowContacts extends Screen {

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

    public static ArrayList<Contact> clist = findAll();

    public static void main(String[] args) {
        Input in = new Input();
        int choice = -1;
        while(choice !=0){
            System.out.println("0 - Return to the main menu");
            System.out.println("1 - View all Contacts");
            System.out.println("2 - Add new Contact");
            System.out.println("3 - Delete Contact");

            choice = in.getInt(0, 6);

            doChoice(choice);
        }
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
