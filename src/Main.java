import view.first_screen.LoginScreen;


public class Main {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
//                Custommer_menu = new Custommer_menu();
//                SignUpScreen signUpScreen = new SignUpScreen();
            }
        });
    }
}