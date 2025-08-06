# SuperCoolBankManager

SuperCoolBankManager is a Java-based desktop application for managing bank accounts, transactions, savings, and more. It features a user-friendly graphical interface and supports day-to-day banking operations, recipient payments, and account validation.

## Features

- User authentication and login management
- View and manage day-to-day and savings accounts
- Make payments to recipients
- View transaction history
- In-app messaging system
- Card validation functionality
- Intuitive GUI built with Java Swing
- Data storage using Microsoft Access database (`Main.accdb`)

## Project Structure

```
SuperCoolBankManager/
├── src/supercoolbankmanager/         # Java source files and GUI forms
├── build/                           # Compiled classes and build artifacts
├── Main.accdb                       # Access database file
├── build.xml                        # Ant build script
├── manifest.mf                      # JAR manifest
├── README.md                        # Project documentation
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Ant (for building the project)
- Microsoft Access (or compatible driver for database access)

### Build Instructions

1. Clone or download this repository.
2. Open a terminal in the project root directory.
3. Run the following command to build the project:
   ```
   ant
   ```
   This will compile the source files and generate the necessary class files in the `build/classes` directory.

### Running the Application

1. After building, run the application using the following command:

   ```
   java -cp build/classes;Main.accdb supercoolbankmanager.SuperCoolBankManager
   ```

   (Adjust the classpath separator `;` if running on a non-Windows OS.)

2. Alternatively, you can package the application as a JAR and run it:
   ```
   ant jar
   java -jar dist/SuperCoolBankManager.jar
   ```

## Database Setup

- The application uses `Main.accdb` (Microsoft Access) as its database.
- Ensure you have the appropriate JDBC-ODBC bridge or driver installed to allow Java to connect to Access databases.
- The database file should be located in the project root directory.

## Main Classes

- `SuperCoolBankManager.java`: Main entry point
- `LoginScreenGUI.java`: Login interface
- `BankManagerGUI.java`: Main banking dashboard
- `DayToDayGUI.java`, `SavingsGUI.java`: Account management GUIs
- `PayRecipientGUI.java`: Payment interface
- `TransactionsGUI.java`: Transaction history
- `MessagesGUI.java`: Messaging system
- `ValidateCardGUI.java`: Card validation
- `DBManager.java`: Database connection and queries

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is for educational purposes.
