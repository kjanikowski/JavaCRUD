package model;

import javafx.beans.property.SimpleStringProperty;

public class Stadion {
	
	SimpleStringProperty id = new SimpleStringProperty();
	SimpleStringProperty nazwa = new SimpleStringProperty();
	SimpleStringProperty miasto = new SimpleStringProperty();
	SimpleStringProperty ulica = new SimpleStringProperty();
	SimpleStringProperty numer = new SimpleStringProperty();
	
	public Stadion(int id, String nazwa, String miasto, String ulica, String numer){
		this.id.set(Integer.toString(id));

		this.nazwa.set(nazwa);
		this.miasto.set(miasto);
		this.ulica.set(ulica);
		this.numer.set(numer);
		
}
	public Stadion( String nazwa, String miasto, String ulica, String numer){
	

		this.nazwa.set(nazwa);
		this.miasto.set(miasto);
		this.ulica.set(ulica);
		this.numer.set(numer);
		
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
	public String getMiasto() {
		return miasto.get();
	}
	public void setMiasto(String miasto) {
		this.miasto.set(miasto);
	}
		
	public SimpleStringProperty getMiastoProp() {
		return miasto;
	}
			
		
	
	public String getUlica() {
		return ulica.get();
	}
	public void setUlica(String ulica) {
		this.ulica.set(ulica);
	}
	
	public SimpleStringProperty getUlicaProp() {
		return ulica;
	}
	
	public String getNumer() {
		return numer.get();
	}
	public void setNumer(String numer) {
		this.numer.set(numer);
	}
	
	public SimpleStringProperty getNumerProp() {
		return numer;
	}
	

}
