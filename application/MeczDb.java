package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Mecz;
import model.Zawodnik;

public class MeczDb {
	
	Conn c;

	//StadionDb(String nazwa, String miasto, String ulica, String numer){
	//	
	//
	//}
	

	
	

	public void insert(Mecz s) {
		c = new Conn();
		c.connect();
		PreparedStatement stat;
		try {
			stat = c.connect().prepareStatement("INSERT INTO mecz(data, stadion_id_stadion, zespol_id_zespol, zespol_id_zespol1) VALUES(?,?,?,?)");  
			
			
			
			stat.setDate(1, s.toDate(s.getData()));
			stat.setString(2, s.getStadion_id());
			stat.setString(3, s.getDr_id());
			stat.setString(4, s.getDr2_id());
			stat.execute();
			c.connect().close();
		} catch (Exception e){
			e.printStackTrace();
			
		}
	}


	public ArrayList<Mecz> selectAll(){
		
		c = new Conn();
		c.connect();
		Mecz item = null;
		
	    ArrayList<Mecz> itemsList = new ArrayList<Mecz>();
	    try
	    {
	        String query = "SELECT data, stadion_id_stadion, zespol_id_zespol, zespol_id_zespol1 FROM mecz;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            java.sql.Date nazwa = rs.getDate(1);
	            int miasto = rs.getInt(2);
	            int ulica = rs.getInt(3);
	            int numer = rs.getInt(4);


	            item = new Mecz(nazwa.toString(), Integer.toString(miasto), Integer.toString(ulica), Integer.toString(numer));
	            itemsList.add(item);
	            
	            
	            
		        if(item!=null) {
			        
			        PreparedStatement stat;
		    
			        query = "SELECT nazwa FROM zespol WHERE id_zespol=?;";
			        
			        stat = c.connect().prepareStatement(query);
			    	stat.setString(1, item.getDr_id());
			    	ResultSet nazwaZ = stat.executeQuery();
			    	String naaaa = null;
			        while(nazwaZ.next()) {

			    	naaaa = nazwaZ.getString(1);
			        }
			    	item.setDr_nazwa(naaaa);
			    	
			    	
			    	//////
			    	
			        PreparedStatement stat1;
			        
			        query = "SELECT nazwa FROM zespol WHERE id_zespol=?;";
			        
			        stat1 = c.connect().prepareStatement(query);
			    	stat1.setString(1, item.getDr2_id());
			    	ResultSet nazwaZ1 = stat1.executeQuery();
			    	String naaaa1 = null;
			        while(nazwaZ1.next()) {

			    	naaaa1 = nazwaZ1.getString(1);
			        }
			    	item.setDr2_nazwa(naaaa1);
			    	
			    	
			    	
			    	 PreparedStatement stat2;
				        
				        query = "SELECT nazwa FROM stadion WHERE id_stadion=?;";
				        
				        stat2 = c.connect().prepareStatement(query);
				    	stat2.setString(1, item.getStadion_id());
				    	ResultSet nazwaZ2 = stat2.executeQuery();
				    	String naaaa3 = null;
				        while(nazwaZ2.next()) {

				    	naaaa3 = nazwaZ2.getString(1);
				        }
				    	item.setStadion_nazwa(naaaa3);
			    	
			        }
	            
	            
	            
	        }
	        


	        ////
	        
	       
	    	
	        
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
		String item = null;
        String data = null;
        String dr1 = null;
        String dr2 = null;
		
	    ArrayList<String> itemsList = new ArrayList<String>();
	    try
	    {
	        String query = "SELECT data, stadion_id_stadion, zespol_id_zespol, zespol_id_zespol1 FROM mecz;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            data = rs.getString(1);
	            dr1 = rs.getString(3);
	            dr2 = rs.getString(4);
	            
		        PreparedStatement stat1;
		        
		        query = "SELECT nazwa FROM zespol WHERE id_zespol=?;";
		        
		        Conn con = new Conn();
		        stat1 = con.connect().prepareStatement(query);
		    	stat1.setString(1, dr1);
		    	ResultSet nazwaZ1 = stat1.executeQuery();
		    	String naaaa1 = null;
		        while(nazwaZ1.next()) {

		    	naaaa1 = nazwaZ1.getString(1);
		        }
		        
		        PreparedStatement stat2;
		        
		        query = "SELECT nazwa FROM zespol WHERE id_zespol=?;";
		        
		        Conn conn = new Conn();
		        stat2 = conn.connect().prepareStatement(query);
		    	stat2.setString(1, dr2);
		    	ResultSet nazwaZ2 = stat2.executeQuery();
		    	String naaaa2 = null;
		        while(nazwaZ2.next()) {

		    	naaaa2 = nazwaZ2.getString(1);
		        }
		    	
		    	item = naaaa1 + " vs " + naaaa2 + " " + data;
		        
	            
	        }
	        
			

	        
			c.connect().close();

	        itemsList.add(item);
	    }
	    
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return itemsList;
		
	}


	public void edit(Mecz s, Mecz nowy) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;
	try {
		stat = c.connect().prepareStatement("UPDATE mecz SET data = ?, stadion_id_stadion = ?, zespol_id_zespol = ?, zespol_id_zespol1 = ? WHERE data = ?;");  
		stat.setDate(1, nowy.toDate(nowy.getData()));
		stat.setString(2, nowy.getStadion_id());
		stat.setString(3, nowy.getDr_id());
		stat.setString(4, nowy.getDr2_id());

		stat.setDate(5,  s.toDateJ(s.getData()));
		
		
		
		stat.execute();
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}
	}

	public void delete(Mecz s) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;

	try {
		stat = c.connect().prepareStatement("DELETE FROM mecz WHERE data = ?;");  
		stat.setDate(1, s.toDateJ(s.getData()));
		
		stat.execute();
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}


	}

}
