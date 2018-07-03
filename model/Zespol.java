package model;

import javafx.beans.property.SimpleStringProperty;

public class Zespol {
	SimpleStringProperty id = new SimpleStringProperty();
	SimpleStringProperty nazwa = new SimpleStringProperty();
	SimpleStringProperty nazwaPot = new SimpleStringProperty();
	SimpleStringProperty miasto = new SimpleStringProperty();
	SimpleStringProperty status = new SimpleStringProperty();
	
	public Zespol(String nazwa, String miasto, String ulica, String numer){
		this.nazwa.set(nazwa);
		this.nazwaPot.set(miasto);
		this.miasto.set(ulica);
		this.status.set(numer);
		
}
	
	public Zespol(String id, String nazwa, String miasto, String ulica, String numer){
		this.nazwa.set(nazwa);
		this.nazwaPot.set(miasto);
		this.miasto.set(ulica);
		this.status.set(numer);
		this.id.set(id);
		
}
	
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public String getNazwa() {
		return nazwa.get();
	}
	
	public SimpleStringProperty getNazwaProp() {
		return nazwa;
	}
	
	public void setNazwa(String nazwa) {
		this.nazwa.set(nazwa);
	}
	public String getNazwaPot() {
		return nazwaPot.get();
	}
	public void setnazwaPot(String miasto) {
		this.nazwaPot.set(miasto);
	}
		
	public SimpleStringProperty getnazwaPot() {
		return nazwaPot;
	}
			
		
	
	public String getMiasto() {
		return miasto.get();
	}
	public void setMiasto(String ulica) {
		this.miasto.set(ulica);
	}
	
	public SimpleStringProperty getMiastoProp() {
		return miasto;
	}
	
	public String getStatus() {
		return status.get();
	}
	public void setStatus(String numer) {
		this.status.set(numer);
	}
	
	public SimpleStringProperty getStatusProp() {
		return status;
	}
}
