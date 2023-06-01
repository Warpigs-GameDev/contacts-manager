package docrob.cag.ContactsScreen;

import docrob.cag.framework.screens.Screen;
import docrob.cag.framework.screens.ScreenManager;
import docrob.cag.framework.state.Game;

public class ContactsWelcome {

    public static void main(String[] args) {

        Screen ContactWelcome = new Screen() {

            @Override
            protected void show() {
                System.out.println("WELCOME!");
            }
            @Override
            protected void handleInput() {
                Game.getInstance().getInput().getString("Press Enter to Continue");
                Screen MainMenu = new MainMenu();
                  ScreenManager.addScreen(MainMenu);



            };

        };

    }

}
