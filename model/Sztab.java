package model;

import javafx.beans.property.SimpleStringProperty;

public class Sztab {
	SimpleStringProperty id = new SimpleStringProperty();
	SimpleStringProperty imie = new SimpleStringProperty();
	SimpleStringProperty nazwisko = new SimpleStringProperty();
	SimpleStringProperty funkcja = new SimpleStringProperty();
	SimpleStringProperty pensja = new SimpleStringProperty();
	
	public Sztab(String nazwa, String miasto, String ulica, String numer){
		this.imie.set(nazwa);
		this.nazwisko.set(miasto);
		this.funkcja.set(ulica);
		this.pensja.set(numer);
		
}
	
	public Sztab(String id, String nazwa, String miasto, String ulica, String numer){
		this.id.set(id);
		this.imie.set(nazwa);
		this.nazwisko.set(miasto);
		this.funkcja.set(ulica);
		this.pensja.set(numer);
		
}
	
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public String getImie() {
		return imie.get();
	}
	
	public SimpleStringProperty getImieProp() {
		return imie;
	}
	
	public void setImie(String nazwa) {
		this.imie.set(nazwa);
	}
	public String getNazwisko() {
		return nazwisko.get();
	}
	public void setNazwisko(String miasto) {
		this.nazwisko.set(miasto);
	}
		
	public SimpleStringProperty getNazwiskoProp() {
		return nazwisko;
	}
			
		
	
	public String getFunkcja() {
		return funkcja.get();
	}
	public void setFunkcja(String ulica) {
		this.funkcja.set(ulica);
	}
	
	public SimpleStringProperty getFunkcjaProp() {
		return funkcja;
	}
	
	public String getPensja() {
		return pensja.get();
	}
	public void setPensja(String numer) {
		this.pensja.set(numer);
	}
	
	public SimpleStringProperty getPensjaProp() {
		return pensja;
	}
}
