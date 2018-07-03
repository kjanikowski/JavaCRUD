package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Zawodnik;
import model.Zespol;

public class ZawodnikDb{
	
 Conn c;

//StadionDb(String nazwa, String miasto, String ulica, String numer){
//	
//
//}

public void insert(Zawodnik s) {
	c = new Conn();
	c.connect();
	PreparedStatement stat;
	try {
		stat = c.connect().prepareStatement("INSERT INTO zawodnik(imie, nazwisko, numer_karty, zawodowiec, zespol_id_zespol) VALUES(?,?,?,?,?)");  
		stat.setString(1, s.getImie());
		stat.setString(2, s.getNazwisko());
		stat.setString(3, s.getNumer_karty());
		stat.setString(4, s.getZawodowiec());
		stat.setInt(5, Integer.parseInt(s.getIdZesp()));
		stat.execute();
		c.connect().close();

	} catch (Exception e){
		e.printStackTrace();
	}
}


public ArrayList<Zawodnik> selectAll(){
	
	c = new Conn();
	c.connect();
	Zawodnik item = null;
	
    ArrayList<Zawodnik> itemsList = new ArrayList<Zawodnik>();
    try
    {
        String query = "SELECT imie, nazwisko, numer_karty, zawodowiec, zespol_id_zespol FROM zawodnik;";
        PreparedStatement ps = c.connect().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            String nazwa = rs.getString(1);
            String miasto = rs.getString(2);
            String ulica = rs.getString(3);
            String numer = rs.getString(4);
            int id_zesp = rs.getInt(5);

            item = new Zawodnik(nazwa, miasto, ulica, numer, Integer.toString(id_zesp));
            itemsList.add(item);
        }
        
        if(item!=null) {
        
        PreparedStatement stat;

        
        
        query = "SELECT nazwa FROM zespol WHERE id_zespol=?;";
        
        stat = c.connect().prepareStatement(query);
    	stat.setString(1, item.getIdZesp());
    	ResultSet nazwaZ = stat.executeQuery();
    	String naaaa = null;
        while(nazwaZ.next()) {

    	naaaa = nazwaZ.getString(1);
        }
    	item.setNazwaZesp(naaaa);
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
	String item = null;
	
    ArrayList<String> itemsList = new ArrayList<String>();
    try
    {
        String query = "SELECT imie, nazwisko, numer_karty, zawodowiec, zespol_id_zespol FROM zawodnik;";
        PreparedStatement ps = c.connect().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            String nazwa = rs.getString(1);
            String miasto = rs.getString(2);
            String ulica = rs.getString(3);
            String numer = rs.getString(4);
            int id_zesp = rs.getInt(5);
            
            String q2 = "SELECT nazwa FROM zespol WHERE id_zespol=?;";
            PreparedStatement ps2 = c.connect().prepareStatement(q2);
            ps2.setInt(1, id_zesp);
            ResultSet rs2 = ps2.executeQuery();
            String zesp = rs2.getString(1);

            
            
            item = new String(nazwa + " " + miasto +", nr " + ulica + ", status: " + numer + ", zespol" +zesp);
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


public void edit(Zawodnik s, Zawodnik nowy) {
c = new Conn();
c.connect();
PreparedStatement stat;
try {
	stat = c.connect().prepareStatement("UPDATE zawodnik SET imie = ?, nazwisko = ?, numer_karty = ?, zawodowiec = ?, zespol_id_zespol=?  WHERE imie = ?;");  
	stat.setString(1, nowy.getImie());
	stat.setString(2, nowy.getNazwisko());
	stat.setString(3, nowy.getNumer_karty());
	stat.setString(4, nowy.getZawodowiec());
	stat.setString(5, nowy.getIdZesp());

	stat.setString(6,  s.getImie());
	stat.execute();
	c.connect().close();

} catch (Exception e){
	e.printStackTrace();
}
}

public void delete(Zawodnik s) {
c = new Conn();
c.connect();
PreparedStatement stat;

try {
	stat = c.connect().prepareStatement("DELETE FROM zawodnik WHERE imie = ?;");  
	stat.setString(1, s.getImie());
	
	stat.execute();
	c.connect().close();

} catch (Exception e){
	e.printStackTrace();
}


}


}
