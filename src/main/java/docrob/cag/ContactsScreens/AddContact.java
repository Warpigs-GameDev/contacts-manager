//package docrob.cag.ContactsScreens;
//
//import docrob.cag.Contacts.Contact;
//import docrob.cag.framework.screens.Screen;
//import docrob.cag.framework.screens.ScreenManager;
//import docrob.cag.framework.state.Game;
//
//public class AddContact extends Screen {
//
//
//
//
//    @Override
//    protected void handleInput() {
//        String firstName = Game.getInstance().getInput().getString("Enter contacts first name");
//        String lastName = Game.getInstance().getInput().getString("Enter last name");
//        long phoneNubmer = Long.parseLong(Game.getInstance().getInput().getString("Enter phone Number"));
//        Contact contact = new Contact(firstName, lastName, phoneNubmer);
//        Game.getInstance().addStateItem("contact", contact);
//
//
//        MainMenu screen = new MainMenu();
//        ScreenManager.addScreen(screen);
//        super.setReadyToExit();
//
//    }
//
//    @Override
//    protected void show() {
//        super.show();
//    }
//}
