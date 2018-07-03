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
import model.Zespol;

public class ZespolDb {

	Conn c;
	
//	StadionDb(String nazwa, String miasto, String ulica, String numer){
//		
//	
//}
	
	private void spoj(){
		c = new Conn();
		c.connect();
		PreparedStatement stat;
		ZespolDb test = new ZespolDb();
		for(int i = 0; i < test.selectAll().size(); i++) {
			
		}
	}
	
	public void insert(Zespol s) {
		c = new Conn();
		c.connect();
		PreparedStatement stat;
		try {
			stat = c.connect().prepareStatement("INSERT INTO zespol(nazwa, nazwa_potoczna, miasto, status) VALUES(?,?,?,?)");  
			stat.setString(1, s.getNazwa());
			stat.setString(2, s.getNazwaPot());
			stat.setString(3, s.getMiasto());
			stat.setString(4, s.getStatus());
			stat.execute();
			c.connect().close();

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Zespol> selectAll(){
		
		c = new Conn();
		c.connect();
		
	    ArrayList<Zespol> itemsList = new ArrayList<Zespol>();
	    try
	    {
	        String query = "SELECT nazwa, nazwa_potoczna, miasto, status, id_zespol FROM zespol;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            String nazwa = rs.getString(1);
	            String miasto = rs.getString(2);
	            String ulica = rs.getString(3);
	            String numer = rs.getString(4);
	            int id = rs.getInt(5);
	            Zespol item = new Zespol(Integer.toString(id), nazwa, miasto, ulica, numer);
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
	        String query = "SELECT nazwa, nazwa_potoczna, miasto, status FROM zespol;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            String nazwa = rs.getString(1);
	            String miasto = rs.getString(2);
	            String ulica = rs.getString(3);
	            String numer = rs.getString(4);
	            String item = new String(nazwa + " ( " + miasto +" ), z " + ulica + ", status: " + numer);
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


public void edit(Zespol s, Zespol nowy) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;
	try {
		stat = c.connect().prepareStatement("UPDATE zespol SET id_zespol=?, nazwa = ?, nazwa_potoczna = ?, miasto = ?, status = ? WHERE nazwa = ?;");  
		stat.setString(1, s.getId());
		stat.setString(2, nowy.getNazwa());
		stat.setString(3, nowy.getNazwaPot());
		stat.setString(4, nowy.getMiasto());
		stat.setString(5, nowy.getStatus());
		stat.setString(6,  s.getNazwa());
		stat.execute();	
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}
	
	
    
//    try {
//    
//    stat = c.connect().prepareStatement("SELECT id_zespol FROM zespol WHERE nazwa=? AND miasto=?;");
//	stat.setString(1, nowy.getNazwa());
//	stat.setString(2, nowy.getMiasto());
//	ResultSet nazwaZ = stat.executeQuery();
//	String naaaa = null;
//    while(nazwaZ.next()) {
//
//	naaaa = nazwaZ.getString(1);
//    }
//    nowy.setId(naaaa);
//    
//    }catch(Exception e) {
//    	e.printStackTrace();
//    }
	
    
	
	
}

public void delete(Zespol s) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;

	try {
		stat = c.connect().prepareStatement("DELETE FROM zespol WHERE nazwa = ?;");  
		stat.setString(1, s.getNazwa());
		
		stat.execute();
		c.connect().close();

	}  catch (SQLIntegrityConstraintViolationException e) {
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
	} catch (Exception e) {
		e.printStackTrace();
	} 



}
	
	
}
