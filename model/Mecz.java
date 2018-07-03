package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mecz {

	private StringProperty id = new SimpleStringProperty();
	private StringProperty data = new SimpleStringProperty();
	private StringProperty stadion_id = new SimpleStringProperty();
	private StringProperty stadion_nazwa = new SimpleStringProperty();
	private StringProperty dr_id = new SimpleStringProperty();
	private StringProperty dr_nazwa = new SimpleStringProperty();
	
	

	private StringProperty dr2_id = new SimpleStringProperty();
	private StringProperty dr2_nazwa = new SimpleStringProperty();
	
	
	public Mecz(String data, String stad, String dr1, String dr2) {
		// TODO Auto-generated constructor stub
		this.data.set(data);
		stadion_id.set(stad);
		dr_id.set(dr1);
		dr2_id.set(dr2);
	}

	public java.sql.Date toDate(String s) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date data=new Date();
		java.sql.Date sqlDate = null;
		try {
			data = format.parse(s);
			sqlDate = new java.sql.Date(data.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}
	
	public java.sql.Date toDateJ(String s) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date data=new Date();
		java.sql.Date sqlDate = null;
		try {
			data = format.parse(s);
			Calendar c = Calendar.getInstance();
			c.setTime(data);
			c.add(Calendar.DATE, 1);
			Date jutro = c.getTime();
			sqlDate = new java.sql.Date(jutro.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}
	
	public java.sql.Date toString(String d) {

		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
		
		String sqlDate=null;
		try {
			sqlDate = format2.format(format1.parse(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date finalna = toDate(sqlDate);
		

		return finalna;
		
	}

	
	public StringProperty getIdProp() {
		return id;
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public String getId() {
		return id.get();
	}
	
	public StringProperty getDataProp() {
		return data;
	}
	public void setData(String data) {
		this.data.set(data);
	}
	public String getData() {
		return data.get();
	}
	

	public StringProperty getStadion_idProp() {
		return stadion_id;
	}
	public void setStadion_id(String stadion_id) {
		this.stadion_id.set(stadion_id);
	}
	public String getStadion_id() {
		return stadion_id.get();
	}
	
	public StringProperty getStadion_nazwaProp() {
		return stadion_nazwa;
	}
	public void setStadion_nazwa(String stadion_id) {
		this.stadion_nazwa.set(stadion_id);
	}
	public String getStadion_nazwa() {
		return stadion_nazwa.get();
	}
	
	
	public StringProperty getDr_idProp() {
		return dr_id;
	}
	public void setDr_id(String dr_id) {
		this.dr_id.set(dr_id);
	}
	public String getDr_id() {
		return dr_id.get();
	}
	
	
	public StringProperty getDr_nazwaProp() {
		return dr_nazwa;
	}
	public void setDr_nazwa(String dr_id) {
		this.dr_nazwa.set(dr_id);
	}
	public String getDr_nazwa() {
		return dr_nazwa.get();
	}
	
	
	public StringProperty getDr2_idProp() {
		return dr2_id;
	}
	public void setDr2_id(String dr2_id) {
		this.dr2_id.set(dr2_id);
	}
	public String getDr2_id() {
		return dr2_id.get();
	}
	
	
	public StringProperty getDr2_nazwaProp() {
		return dr2_nazwa;
	}
	public void setDr2_nazwa(String dr_id) {
		this.dr2_nazwa.set(dr_id);
	}
	public String getDr2_nazwa() {
		return dr2_nazwa.get();
	}
	
}
