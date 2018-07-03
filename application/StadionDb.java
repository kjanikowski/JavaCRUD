package application;

import java.io.IOException;
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

public class StadionDb {
	
	Conn c;
	
//	StadionDb(String nazwa, String miasto, String ulica, String numer){
//		
//	
//}
	
	public void insert(Stadion s) {
		c = new Conn();
		c.connect();
		PreparedStatement stat;
		try {
			stat = c.connect().prepareStatement("INSERT INTO stadion(nazwa, miasto, ulica, ulica_numer) VALUES(?,?,?,?)");  
			stat.setString(1, s.getNazwa());
			stat.setString(2, s.getMiasto());
			stat.setString(3, s.getUlica());
			stat.setString(4, s.getNumer());
			stat.execute();
			c.connect().close();

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Stadion> selectAll(){
		
		c = new Conn();
		c.connect();
		
	    ArrayList<Stadion> itemsList = new ArrayList<Stadion>();
	    try
	    {
	        String query = "SELECT nazwa, miasto, ulica, ulica_numer, id_stadion FROM stadion;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            String nazwa = rs.getString(1);
	            String miasto = rs.getString(2);
	            String ulica = rs.getString(3);
	            String numer = rs.getString(4);
	            int id = rs.getInt(5);
	            Stadion item = new Stadion(id, nazwa, miasto, ulica, numer);
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
	        String query = "SELECT nazwa, miasto, ulica, ulica_numer FROM stadion;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            String nazwa = rs.getString(1);
	            String miasto = rs.getString(2);
	            String ulica = rs.getString(3);
	            String numer = rs.getString(4);
	            String item = new String(nazwa + " w " + miasto +", " + ulica + " " + numer);
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


public void edit(Stadion s, Stadion nowy) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;
	try {
		stat = c.connect().prepareStatement("UPDATE stadion SET nazwa = ?, miasto = ?, ulica = ?, ulica_numer = ? WHERE nazwa = ?;");  
		stat.setString(1, nowy.getNazwa());
		stat.setString(2, nowy.getMiasto());
		stat.setString(3, nowy.getUlica());
		stat.setString(4, nowy.getNumer());
		stat.setString(5,  s.getNazwa());
		stat.execute();
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}
}

public void delete(Stadion s) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;

	try {
		stat = c.connect().prepareStatement("DELETE FROM stadion WHERE nazwa = ?;");  
		stat.setString(1, s.getNazwa());
		
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
