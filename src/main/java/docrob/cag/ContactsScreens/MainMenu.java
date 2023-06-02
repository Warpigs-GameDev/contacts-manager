package docrob.cag.ContactsScreens;

import docrob.cag.framework.menu.Menu;
import docrob.cag.framework.menu.MenuItemMethod;
import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;

public class MainMenu extends Screen {
    @Override
    public void setup() {
        super.setup();
        menu.addItem("Exit Application", exitProgram);
//        menu.addItem("Hi", sayHello);
        menu.addItem("Show list of contacts", showContacts);
//        menu.addItem("Add a new contact", addContact);
        menu.addItem("Search by contact name", searchContact);
        menu.addItem("Delete an existing contact", deleteContact);
//        menu.addItem("Do something else", doSomethingElse, true);
    }
    @Override
    public void show (){
        System.out.println("This is the Main Menu");
        super.show();
    }

    private MenuItemMethod exitProgram = ()->{
        System.out.println("Exiting Main Screen");
        super.setReadyToExit();
    };

    private MenuItemMethod sayHello = () -> {
        System.out.println("Hi");
    };

    private MenuItemMethod doSomethingElse = () -> {
        System.out.println("Gotcha");
    };

    private MenuItemMethod showContacts = () -> {
        System.out.println("Here is a list of all your contacts");
    };

//    private MenuItemMethod addContact = () -> {
//        System.out.println("You may enter your new contact information");
//        AddContact screen = new AddContact();
//        ScreenManager.addScreen(screen);
//        super.setReadyToExit();
//    };

    private MenuItemMethod searchContact = () -> {
        System.out.println("Please enter the name of the person you wish to look up");
    };

    private MenuItemMethod deleteContact = () -> {
        System.out.println("You may pick a contact to delete");
    };

}