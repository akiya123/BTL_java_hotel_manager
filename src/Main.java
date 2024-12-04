import database.UserDAO;
import view.LoginScreen;
import view.SignUpScreen;

import javax.swing.*;


public class Main {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
//                SignUpScreen signUpScreen = new SignUpScreen();
            }
        });
    }
}