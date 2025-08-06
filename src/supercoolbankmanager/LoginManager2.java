package supercoolbankmanager;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dwayn
 */
public class LoginManager2 {

    static DBManager db = new DBManager();
    private String loggedInUser = "";

    /**
     *
     */
    public LoginManager2() {
        System.out.println("\n");
    }

    /**
     *
     * @return login details from database
     */
    public String displayLoginDetails() {
        String temp = "";

        try {
            ResultSet rs = db.queryDB("SELECT * FROM LoginDetails");
            int i = 1;

            while (rs.next()) {
                String userName = rs.getString("UserName");
                String password = rs.getString("Password");

                temp += "User " + i + ": " + userName + "\nPassword: " + password;
                System.out.println("\n");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
        }

        return temp;
    }

    /**
     *
     * @return all usernames from database
     */
    public String returnUserName() {
        String temp = "";

        try {
            ResultSet rs = db.queryDB("SELECT UserName FROM LoginDetails");
            int i = 1;

            while (rs.next()) {
                String userName = rs.getString("UserName");

                temp += userName;
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot execute query!");
        }

        return temp;
    }

    /**
     *
     * @return all passwords from database
     */
    public String returnPassword() {
        String temp = "";

        try {
            ResultSet rs = db.queryDB("SELECT Password FROM LoginDetails");
            int i = 1;

            while (rs.next()) {
                String password = rs.getString("Password");

                temp += password;
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot execute query!");
        }

        return temp;
    }

    /**
     *
     * @param UserName gets username from the create account input field
     * @param Password gets password from the create account input field
     * @param confirmPassword gets confirm password from the create account input field
     */
    public void writeUserDetailsToDB(String UserName, String Password, String confirmPassword) {
    
        try {
            if (Password.equals(confirmPassword)) {
                MainManager mm = new MainManager();
                
                /*inserts the new account username and password, creates default values for the user 
                and creates a welcome message for the next time the user logs in*/
                db.update("INSERT INTO LoginDetails (UserName, Password) VALUES ('" + UserName + "', '" + Password + "')");
                mm.insertTransaction("DayToDayTransactions", UserName, 0, 0);
                mm.insertTransaction("SavingsTransactions", UserName, 0, 0);
                mm.insertRecipientTransaction(UserName, 0);
                mm.insertMessage(UserName, "Account created successfully, welcome to  the app " + UserName + "!");
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully!"); 

            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot update Record!");
        }

    }

    /**
     *
     * @param UserName gets the username from the existing user login field
     * @param Password gets the password from the existing user login field
     * @return return true or false whether the login details match an existing account
     */
    public boolean loginDetailsCheck(String UserName, String Password) {
        try {
            ResultSet rs = db.queryDB("SELECT * FROM LoginDetails");

            while (rs.next()) {
                String userName = rs.getString("UserName");
                String password = rs.getString("Password");

                if (userName.equals(UserName) && password.equals(Password)) {
                    loggedInUser = userName;
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
        }

        return false;
    }

    /**
     *
     * @return the logged in user
     */
    public String getLoggedInUser() {
        return loggedInUser;
    }
}
