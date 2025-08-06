package supercoolbankmanager;

import java.sql.*;
import java.text.SimpleDateFormat;

public class MainManager {
    static DBManager db = new DBManager();

    public MainManager() {
        System.out.println("\n");
    }
    
    //DayToDay Feature Methods
    //display deposits from the day to day account
    public double[] displayDayToDayDeposits(String user) {
        int count = 0;

        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM DayToDayTransactions WHERE UserName = '" + user + "'");

            if(countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }
        
        double[] depositsArr = new double[count];
        int index = 0;

        try {
            ResultSet rs = db.queryDB("SELECT Deposits FROM DayToDayTransactions WHERE UserName = '" + user + "'");

            while (rs.next()) {
                depositsArr[index] = rs.getDouble("Deposits");
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }

        return depositsArr;
    }
    
    //display the withdrawals from the day to day account
    public double[] getDayToDayWithdrawels(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM DayToDayTransactions WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot count withdrawals!");
            return new double[0];
        }
    
        double[] withdrawelsArr = new double[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT Withdrawels FROM DayToDayTransactions WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                withdrawelsArr[index] = rs.getDouble("Withdrawels");
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot fetch withdrawals!");
            return new double[0];
        }
    
        return withdrawelsArr;
    }
    
    //display the available balance of the day to day account
    public double[] displayDayToDayAvailableBal(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM DayToDayTransactions WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }
    
        double[] balanceArr = new double[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT [Available Balance] FROM DayToDayTransactions WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                balanceArr[index] = rs.getDouble("Available Balance");
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }
    
        return balanceArr;
    }
    
    //display the transaction dates of the day to day account
    public String[] displayDayToDayDates(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM DayToDayTransactions WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        String[] datesArr = new String[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT Date FROM DayToDayTransactions WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("Date");
                datesArr[index] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        return datesArr;
    }
    
    //Savings Feature Methods
    //display the deposits from the savings account
    public double[] displaySavingsDeposits(String user) {
        int count = 0;

        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM SavingsTransactions WHERE UserName = '" + user + "'");

            if(countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }
        
        double[] depositsArr = new double[count];
        int index = 0;

        try {
            ResultSet rs = db.queryDB("SELECT Deposits FROM SavingsTransactions WHERE UserName = '" + user + "'");

            while (rs.next()) {
                depositsArr[index] = rs.getDouble("Deposits");
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }

        return depositsArr;
    }
    
    //display the withdrawals from the savings account
    public double[] getSavingsWithdrawals(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM SavingsTransactions WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot count withdrawals!");
            return new double[0];
        }
    
        double[] withdrawelsArr = new double[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT Withdrawels FROM SavingsTransactions WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                withdrawelsArr[index] = rs.getDouble("Withdrawels");
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot fetch withdrawals!");
            return new double[0];
        }
    
        return withdrawelsArr;
    }
    
    //display the available balance from the savings account
    public double[] displaySavingsAvailableBal(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM SavingsTransactions WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }
    
        double[] balanceArr = new double[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT [Available Balance] FROM SavingsTransactions WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                balanceArr[index] = rs.getDouble("Available Balance");
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }
    
        return balanceArr;
    }
    
    //display the transaction dates from the savings account
    public String[] displaySavingsDates(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM SavingsTransactions WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        String[] datesArr = new String[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT Date FROM SavingsTransactions WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("Date");
                datesArr[index] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        return datesArr;
    }
    
    //Pay Recipient Feature Methods
    //display the payments made from the pay recipient feature
    public double[] displayPayRecipientPayments(String user) {
        int count = 0;

        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM RecipientTransactions WHERE UserName = '" + user + "'");

            if(countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }
        
        double[] paymentsArr = new double[count];
        int index = 0;

        try {
            ResultSet rs = db.queryDB("SELECT Payments FROM RecipientTransactions WHERE UserName = '" + user + "'");

            while (rs.next()) {
                paymentsArr[index] = rs.getDouble("Payments");
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new double[0];
        }

        return paymentsArr;
    }
        
    //display the transaction dates from the pay recipient feature
    public String[] displayPayRecipientDates(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM RecipientTransactions WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        String[] datesArr = new String[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT Date FROM RecipientTransactions WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("Date");
                datesArr[index] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        return datesArr;
    }
    
    //Message feature methods
    //display all of the messages from the database
    public String[] displayMessages(String user) {
        int count = 0;

            try {
                ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM Messages WHERE UserName = '" + user + "'");

                if (countRs.next()) {
                    count = countRs.getInt("total");
                }
            } catch (SQLException e) {
                System.out.println("Error: Cannot Execute Query!");
                return new String[0];
            }

            String[] messagesArr = new String[count];
            int index = 0;

            try {
                ResultSet rs = db.queryDB("SELECT Message FROM Messages WHERE UserName = '" + user + "'");

                while (rs.next()) {
                    messagesArr[index] = rs.getString("Message");
                    index++;
                }
            } catch (SQLException e) {
                System.out.println("Error: Cannot Execute Query!");
                return new String[0];
            }

        return messagesArr;
    }
    
    //display the dates that the messages were sent
    public String[] displayMessageDate(String user) {
        int count = 0;
    
        try {
            ResultSet countRs = db.queryDB("SELECT COUNT(*) AS total FROM Messages WHERE UserName = '" + user + "'");
            if (countRs.next()) {
                count = countRs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        String[] datesArr = new String[count];
        int index = 0;
    
        try {
            ResultSet rs = db.queryDB("SELECT Date FROM Messages WHERE UserName = '" + user + "'");
    
            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("Date");
                datesArr[index] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error: Cannot Execute Query!");
            return new String[0];
        }
    
        return datesArr;
    }
    
    //Inserting Transactions into specified tables
    //insert a transaction into a specified table
    public void insertTransaction(String table, String user, double deposit, double withdrawel) {
        double latestBalance = 0;
        
        try{
            ResultSet rs = db.queryDB("SELECT TOP 1 [Available Balance] FROM " + table + " WHERE UserName = '" + user + "' ORDER BY Date DESC");
            if (rs.next()) {
                latestBalance = rs.getDouble("Available Balance");
            }
        } catch (SQLException e) {
            System.out.println("Error getting the last balance");
        }
        
        double newBalance = latestBalance + deposit - withdrawel;
        
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
             db.update("INSERT INTO " + table + " ([Available Balance], Deposits, Withdrawels, Date, UserName) " +
                       "VALUES ('" + newBalance + "', '" + deposit + "', '" + withdrawel + "', '" + timestamp + "', '" + user + "')");
        } catch (SQLException e) {
            System.out.println("Error inserting transaction: " + e);
        }
    }
    
    //insert a transaction into the RecipientTransactions table
    public void insertRecipientTransaction(String user, double payments) {
        double latestBalance = 0;
        
        try {
            ResultSet rs = db.queryDB("SELECT TOP 1 Payments FROM RecipientTransactions WHERE UserName = '" + user + "' ORDER BY Date DESC");
            if (rs.next()) {
                latestBalance = rs.getDouble("Payments");
            }
        } catch (SQLException e) {
            System.out.println("Error getting the last balance");
        }
        
        double newBalance = latestBalance + payments;
        
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            db.update("INSERT INTO RecipientTransactions (Payments, Date, UserName) " 
                    + "VALUES ('" + newBalance + "', '" + timestamp +"', '" + user + "')");
        } catch (SQLException e) {
            System.out.println("Error inserting transaction: " + e);
        }
    }
    
    //insert a message into the Messages table
    public void insertMessage(String user, String message) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            db.update("INSERT INTO Messages (Message, UserName, Date) "
                    + "VALUES ('" + message + "', '" + user + "', '" + timestamp + "')");
        } catch (SQLException e) {
            System.out.println("Error inserting message: " + e);
    }
}
    
    
}
