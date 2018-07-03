package application;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Stadion;
import model.Sztab;

public class SztabDb {

Conn c;
	
//	StadionDb(String nazwa, String miasto, String ulica, String numer){
//		
//	
//}
	
	public void insert(Sztab s) {
		c = new Conn();
		c.connect();
		PreparedStatement stat;
		try {
			stat = c.connect().prepareStatement("INSERT INTO sztab(imie, nazwisko, funkcja, pensja) VALUES(?,?,?,?)");  
			stat.setString(1, s.getImie());
			stat.setString(2, s.getNazwisko());
			stat.setString(3, s.getFunkcja());
			BigDecimal dec = new BigDecimal(s.getPensja());
			stat.setBigDecimal(4, dec);
			stat.execute();
			c.connect().close();

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Sztab> selectAll(){
		
		c = new Conn();
		c.connect();
		
	    ArrayList<Sztab> itemsList = new ArrayList<Sztab>();
	    try
	    {
	        String query = "SELECT imie, nazwisko, funkcja, pensja,id_sztab FROM sztab;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            String nazwa = rs.getString(1);
	            String miasto = rs.getString(2);
	            String ulica = rs.getString(3);
	            BigDecimal numer = rs.getBigDecimal(4);
	            String id = Integer.toString(rs.getInt(5));
	            String dec = numer.toString();
	            Sztab item = new Sztab(id,nazwa, miasto, ulica, dec);
	            itemsList.add(item);
	        }
			c.connect().close();

	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return itemsList;
		
	}
	
	
public ArrayList<String> selectAllString(){
		
		c = new Conn();
		c.connect();
		
	    ArrayList<String> itemsList = new ArrayList<String>();
	    try
	    {
	        String query = "SELECT imie, nazwisko, funkcja, pensja FROM sztab;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            String nazwa = rs.getString(1);
	            String miasto = rs.getString(2);
	            String ulica = rs.getString(3);
	            BigDecimal numer = rs.getBigDecimal(4);
	            String dec = numer.toString();
	            String item = new String(nazwa + " " + miasto +", " + ulica + ",pensja: " + dec);
	            itemsList.add(item);
	        }
			c.connect().close();

	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return itemsList;
		
	}


public void edit(Sztab s, Sztab nowy) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;
	try {
		stat = c.connect().prepareStatement("UPDATE sztab SET imie = ?, nazwisko = ?, funkcja = ?, pensja = ?, id = ? WHERE imie = ?;");  
		stat.setString(1, nowy.getImie());
		stat.setString(2, nowy.getNazwisko());
		stat.setString(3, nowy.getFunkcja());
		stat.setString(4, nowy.getPensja());
		stat.setString(5,  s.getId());

		stat.setString(6,  s.getImie());
		stat.execute();
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}
}

public void delete(Sztab s) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;

	try {
		stat = c.connect().prepareStatement("DELETE FROM sztab WHERE imie = ?;");  
		stat.setString(1, s.getImie());
		
		stat.execute();
		c.connect().close();

	} 
	catch (SQLIntegrityConstraintViolationException e) {
		Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/controller/Blad.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Blad");
            stage.setScene(new Scene(root, 400, 200));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		
            	}
            });
            
            

        }
        catch (IOException f) {
            f.printStackTrace();
        }
	}
	
	catch (Exception e){
		e.printStackTrace();
	}


}
	
}
