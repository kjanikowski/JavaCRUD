package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

	private Connection connection;
	
    public Connection connect() {

        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            
        }

        System.out.println("MySQL JDBC Driver Registered!");
        

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mecz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","java", "java");


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            
        }
        return connection;
	
}
}
