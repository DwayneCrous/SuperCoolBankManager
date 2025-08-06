package supercoolbankmanager;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dwayn
 */
public class DBManager {
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String url = "jdbc:ucanaccess://Main.accdb";
    
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    /**
     * This is a method to load the driver for jdbc and connect to the database
     */
    public DBManager()
    {
        //load driver
        try
        {
            Class.forName(driver);
            System.out.println("Driver Successfully Found...");
        } catch (ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Error: Database driver not found");
        }
        
        //connect to database
        try
        {
            connection = DriverManager.getConnection(url);
            System.out.println("DB Connection Successful!");
        } catch (SQLException e)
        {
            System.out.println("Unable to connect to database!");
        }
    }
    
    /**
     *
     * @param stmt The SQL statement / query you want to use
     * @return
     * @throws SQLException
     */
    public ResultSet queryDB(String stmt) throws SQLException 
    {
        //Generic query to execute a SELECT statement
        statement = connection.prepareStatement(stmt);
        
        resultSet = statement.executeQuery();
        
        return resultSet;
    }
    
    //INSERT, UPDATE, DELETING - Update method can do all three

    /**
     *
     * @param update The update query you want to use (insert, update, delete)
     * @throws SQLException
     */
    public void update(String update) throws SQLException
    {
        statement = connection.prepareStatement(update);
        statement.executeUpdate();
        statement.close();
    }
}
