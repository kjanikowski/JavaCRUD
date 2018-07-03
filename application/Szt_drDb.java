package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Mecz;
import model.Szt_dr;

public class Szt_drDb {
	
	Conn c;

	//StadionDb(String nazwa, String miasto, String ulica, String numer){
	//	
	//
	//}
	

	
	

	public void insert(Szt_dr s) {
		c = new Conn();
		c.connect();
		PreparedStatement stat;
		try {
			stat = c.connect().prepareStatement("INSERT INTO sztab_druzyna(zespol_id_zespol,sztab_id_sztab) VALUES(?,?)");  
			
			
			
			stat.setInt(1, Integer.parseInt(s.getNazwa()));
			stat.setInt(2, Integer.parseInt(s.getMiasto()));

			stat.execute();
		} catch (Exception e){
			e.printStackTrace();
		}
	}


	public ArrayList<Szt_dr> selectAll(){
		
		c = new Conn();
		c.connect();
		Szt_dr item = null;
		
	    ArrayList<Szt_dr> itemsList = new ArrayList<Szt_dr>();
	    try
	    {
	        String query = "SELECT zespol_id_zespol,sztab_id_sztab,id_sztab_druzyna FROM sztab_druzyna;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	        	
	            int nazwa = rs.getInt(1);
	            int miasto = rs.getInt(2);
	            int id = rs.getInt(3);




	            item = new Szt_dr(Integer.toString(id),Integer.toString(nazwa), Integer.toString(miasto));
	            itemsList.add(item);
	            
		        if(item!=null) {
			        
			        PreparedStatement stat;
		    
			        query = "SELECT nazwa FROM zespol WHERE id_zespol=?;";
			        
			        stat = c.connect().prepareStatement(query);
			    	stat.setString(1, item.getNazwa());
			    	ResultSet nazwaZ = stat.executeQuery();
			    	String naaaa = null;
			        while(nazwaZ.next()) {

			    	naaaa = nazwaZ.getString(1);
			        }
			    	item.setNazwaN(naaaa);
			    	
			    	
			    	//////
			    	
			        PreparedStatement stat1;
			        
			        query = "SELECT imie,nazwisko FROM sztab WHERE id_sztab=?;";
			        
			        stat1 = c.connect().prepareStatement(query);
			    	stat1.setString(1, item.getMiasto());
			    	ResultSet nazwaZ1 = stat1.executeQuery();
			    	String naaaa1 = null;
			    	String naaaa2 = null;
			        while(nazwaZ1.next()) {

			    	naaaa1 = nazwaZ1.getString(1);
			    	naaaa2 = nazwaZ1.getString(2);
			        }
			    	item.setMiastoN(naaaa1+" "+naaaa2);
			        }
	            
	            
	            
	            
	            
	            
	            
	        }
	        

			
			c.connect().close();

	    }
	    	
	    	
	    	


	        ////
	        
	       
	    	
	        

	        
	    
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
        
        String dr1 = null;
        String dr2 = null;
		
	    ArrayList<String> itemsList = new ArrayList<String>();
	    try
	    {
	        String query = "SELECT zespol_id_zespol,sztab_id_sztab FROM sztab_druzyna;";
	        PreparedStatement ps = c.connect().prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	            
	            dr1 = rs.getString(1);
	            dr2 = rs.getString(2);
	            
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
		        
		        query = "SELECT imie,nazwisko FROM sztab WHERE id_sztab=?;";
		        
		        Conn conn = new Conn();
		        stat2 = conn.connect().prepareStatement(query);
		    	stat2.setString(1, dr2);
		    	ResultSet nazwaZ2 = stat2.executeQuery();
		    	String naaaa2 = null;
		    	String naaaa3 = null;
		        while(nazwaZ2.next()) {

		    	naaaa2 = nazwaZ2.getString(1);
		    	naaaa3 = nazwaZ2.getString(2);

		        }
		    	
		    	item = naaaa1 + " vs " + naaaa2 + " " + naaaa3;
		        
				

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


	public void edit(Szt_dr s, Szt_dr nowy) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;
	try {
		stat = c.connect().prepareStatement("UPDATE sztab_druzyna SET id_sztab_druzyna = ?, zespol_id_zespol = ?, sztab_id_sztab = ? WHERE id_sztab_druzyna = ?;");  
		
		stat.setString(1, s.getId());
		stat.setString(2, nowy.getNazwa());
		stat.setString(3, nowy.getMiasto());
		

		stat.setInt(4, Integer.parseInt(s.getId()));
		
		
		
		stat.execute();
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}
	}

	public void delete(Szt_dr s) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;

	try {
		stat = c.connect().prepareStatement("DELETE FROM sztab_druzyna WHERE id_sztab_druzyna = ?;");  
		stat.setString(1, s.getId());
		
		stat.execute();
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}


	}

}

