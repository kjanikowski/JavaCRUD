package application;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConn {
	
	static Connection connection = null;

    public static void main(String[] argv) {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        
        
        try {
        	connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","java", "java");
        	Statement s = connection.createStatement();
        	int Result = s.executeUpdate("CREATE DATABASE IF NOT EXISTS mecz");
        	
        	
        	
        	
        }catch (SQLException e) {
            System.out.println("Create DB Failed! Check output console");
            e.printStackTrace();
            return;
        }
        
        
        
        
        
        

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mecz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","java", "java");


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        
        
        try {
			Statement stat = connection.createStatement();
			String[] create = new String[12];
			
			create[0] = "CREATE TABLE IF NOT EXISTS mecz (\r\n" + 
					"    id_mecz              INTEGER NOT NULL AUTO_INCREMENT,\r\n" + 
					"    data                 DATETIME NOT NULL,\r\n" + 
					"    stadion_id_stadion   INTEGER NOT NULL,\r\n" + 
					"    zespol_id_zespol     INTEGER NOT NULL,\r\n" + 
					"    zespol_id_zespol1    INTEGER NOT NULL,\r\n" + 
					"    PRIMARY KEY ( id_mecz )\r\n" + 
					");\r\n" + 
					"";		
			create[1] = "CREATE TABLE IF NOT EXISTS stadion (\r\n" + 
					"    id_stadion    INTEGER NOT NULL AUTO_INCREMENT,\r\n" + 
					"    nazwa         VARCHAR(30) NOT NULL,\r\n" + 
					"    miasto        VARCHAR(30) NOT NULL,\r\n" + 
					"    ulica         VARCHAR(30) NOT NULL,\r\n" + 
					"    ulica_numer   VARCHAR(4) NOT NULL,\r\n" + 
					"    PRIMARY KEY ( id_stadion )\r\n" + 
					");";
			
			create[2] = "CREATE TABLE IF NOT EXISTS sztab (\r\n" + 
					"    id_sztab           INTEGER NOT NULL AUTO_INCREMENT,\r\n" + 
					"    imie               VARCHAR(20) NOT NULL,\r\n" + 
					"    nazwisko           VARCHAR(30) NOT NULL,\r\n" + 
					"    funkcja            VARCHAR(20) NOT NULL,\r\n" + 
					"    pensja             DOUBLE NOT NULL,\r\n" + 
					"    PRIMARY KEY ( id_sztab )\r\n" + 
					");";
			
			create[3] = "CREATE TABLE IF NOT EXISTS zawodnik (\r\n" + 
					"    id_zawodnik        INTEGER NOT NULL AUTO_INCREMENT,\r\n" + 
					"    imie               VARCHAR(20) NOT NULL,\r\n" + 
					"    nazwisko           VARCHAR(30) NOT NULL,\r\n" + 
					"    numer_karty        VARCHAR(15) NOT NULL,\r\n" + 
					"    zawodowiec         VARCHAR(10) NOT NULL,\r\n" + 
					"    zespol_id_zespol   INTEGER NOT NULL,\r\n" + 
					"    PRIMARY KEY ( id_zawodnik )\r\n" + 
					");";
			
			create[4] = "CREATE TABLE IF NOT EXISTS zespol (\r\n" + 
					"    id_zespol        INTEGER NOT NULL AUTO_INCREMENT,\r\n" + 
					"    nazwa            VARCHAR(30) NOT NULL,\r\n" + 
					"    nazwa_potoczna   VARCHAR(30) NOT NULL,\r\n" + 
					"    miasto           VARCHAR(30) NOT NULL,\r\n" + 
					"    status           VARCHAR(20) NOT NULL,\r\n" + 
					"    PRIMARY KEY ( id_zespol )\r\n" + 
					");";
			
			create[5] = "CREATE TABLE IF NOT EXISTS sztab_druzyna (\r\n" + 
					"    id_sztab_druzyna           INTEGER NOT NULL AUTO_INCREMENT,\r\n" + 
					"    zespol_id_zespol   INTEGER NOT NULL,\r\n" + 
					"    sztab_id_sztab   INTEGER NOT NULL,\r\n" + 
					"    PRIMARY KEY ( id_sztab_druzyna )\r\n" + 
					");";
			
			create[6] = "ALTER TABLE mecz\r\n" + 
					"    ADD CONSTRAINT mecz_stadion_fk FOREIGN KEY ( stadion_id_stadion )\r\n" + 
					"        REFERENCES stadion ( id_stadion );\r\n";
			
			create[7] = "ALTER TABLE mecz\r\n" + 
					"    ADD CONSTRAINT mecz_zespol_fk FOREIGN KEY ( zespol_id_zespol )\r\n" + 
					"        REFERENCES zespol ( id_zespol );";
			
			create[8] = "ALTER TABLE mecz\r\n" + 
					"    ADD CONSTRAINT mecz_zespol_fkv2 FOREIGN KEY ( zespol_id_zespol1 )\r\n" + 
					"        REFERENCES zespol ( id_zespol );";
			

			
			create[9] = "\r\n" + 
					"ALTER TABLE zawodnik\r\n" + 
					"    ADD CONSTRAINT zawodnik_zespol_fk FOREIGN KEY ( zespol_id_zespol )\r\n" + 
					"        REFERENCES zespol ( id_zespol );";
			
			create[10] = "ALTER TABLE sztab_druzyna\r\n" + 
					"    ADD CONSTRAINT sztab_druzyna_sztab_fk FOREIGN KEY ( sztab_id_sztab )\r\n" + 
					"        REFERENCES sztab ( id_sztab );";
			
			create[11] = "ALTER TABLE sztab_druzyna\r\n" + 
					"    ADD CONSTRAINT sztab_druzyna_zespol_fk FOREIGN KEY ( zespol_id_zespol )\r\n" + 
					"        REFERENCES zespol ( id_zespol );";
					

			
			for(int i = 0; i < create.length; i++) {
			stat.execute(create[i]);
			}

			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
        
        
        
        
        
        
        

       // System.out.println("You made it, take control your database now!");
    }



}
