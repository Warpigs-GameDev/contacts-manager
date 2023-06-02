package docrob.cag.ContactsScreens;


import java.util.ArrayList;
import java.util.Arrays;

public class ContactList {
    public static ArrayList<Contact> findAll() {
        return new ArrayList<>(Arrays.asList(
                new Contact("C1", "xxx"),
                new Contact("C2", "xxx"),
                new Contact("C3", "xxx"),
                new Contact("C4", "xxx"),
                new Contact("C5", "xxx")));
    }
}
