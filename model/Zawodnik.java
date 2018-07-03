package model;

import javafx.beans.property.SimpleStringProperty;

public class Zawodnik {
	SimpleStringProperty id = new SimpleStringProperty();
	SimpleStringProperty imie = new SimpleStringProperty();
	SimpleStringProperty nazwisko = new SimpleStringProperty();
	SimpleStringProperty numer_karty = new SimpleStringProperty();
	SimpleStringProperty zawodowiec = new SimpleStringProperty();
	SimpleStringProperty id_zespol = new SimpleStringProperty();
	SimpleStringProperty nazwa_zespol = new SimpleStringProperty();

	
	public Zawodnik(String nazwa, String miasto, String ulica, String numer, String id_zespol){
		this.imie.set(nazwa);
		this.nazwisko.set(miasto);
		this.numer_karty.set(ulica);
		this.zawodowiec.set(numer);
		this.id_zespol.set(id_zespol);
		//this.nazwa_zespol.set(nazwa_zespol);
		
}
	public String getIdZesp() {
		return id_zespol.get();
	}
	
	public String getNazwaZesp() {
		return nazwa_zespol.get();
	}
	
	public SimpleStringProperty getIdZespProp() {
		return id_zespol;
	}
	
	public SimpleStringProperty getNazwaZespProp() {
		return nazwa_zespol;
	}
	
	public void setIdZesp(String z) {
		id_zespol.set(z);
	}
	
	public void setNazwaZesp(String z) {
		nazwa_zespol.set(z);
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
	
	public SimpleStringProperty getNazwaProp() {
		return imie;
	}
	
	public void setNazwa(String nazwa) {
		this.imie.set(nazwa);
	}
	public String getNazwisko() {
		return nazwisko.get();
	}
	public void setMiasto(String miasto) {
		this.nazwisko.set(miasto);
	}
		
	public SimpleStringProperty getMiastoProp() {
		return nazwisko;
	}
			
		
	
	public String getNumer_karty() {
		return numer_karty.get();
	}
	public void setUlica(String ulica) {
		this.numer_karty.set(ulica);
	}
	
	public SimpleStringProperty getUlicaProp() {
		return numer_karty;
	}
	
	public String getZawodowiec() {
		return zawodowiec.get();
	}
	public void setNumer(String numer) {
		this.zawodowiec.set(numer);
	}
	
	public SimpleStringProperty getNumerProp() {
		return zawodowiec;
	}
}
