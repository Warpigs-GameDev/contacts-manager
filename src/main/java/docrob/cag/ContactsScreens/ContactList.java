package docrob.cag.ContactsScreens;


import java.util.ArrayList;
import java.util.Arrays;

public class ContactList {
    public static ArrayList<Contact> findAll() {
        return new ArrayList<>(Arrays.asList(
                new Contact("John Doe", "xxx"),
                new Contact("Jack Brown", "xxx"),
                new Contact("Reese Witherfork", "xxx")));
    }
}
