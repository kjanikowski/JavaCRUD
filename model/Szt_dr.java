package model;

import javafx.beans.property.SimpleStringProperty;

public class Szt_dr {
	
	SimpleStringProperty id = new SimpleStringProperty();
	SimpleStringProperty nazwa = new SimpleStringProperty();
	SimpleStringProperty nazwaN = new SimpleStringProperty();
	
	
	SimpleStringProperty miasto = new SimpleStringProperty();
	SimpleStringProperty miastoN = new SimpleStringProperty();

	
	
	public Szt_dr(String s, String s1, String s2){
		id.set(s);
		nazwa.set(s1);
		miasto.set(s2);
	}
	
	public SimpleStringProperty getIdProp() {
		return id;
	}
	public void setId(String id) {
		this.id.set(id);
	}
	
	public String getId() {
		return id.get();
	}	
	
	public SimpleStringProperty getNazwaProp() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa.set(nazwa);
	}
	public String getNazwa() {
		return nazwa.get();
	}	
	
	public SimpleStringProperty getNazwaNProp() {
		return nazwaN;
	}
	public void setNazwaN(String nazwa) {
		this.nazwaN.set(nazwa);
	}
	public String getNazwaN() {
		return nazwaN.get();
	}	
	
	
	
	public SimpleStringProperty getMiastoProp() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto.set(miasto);
	}
	public String getMiasto() {
		return miasto.get();
	}	
	
	public SimpleStringProperty getMiastoNProp() {
		return miastoN;
	}
	public void setMiastoN(String miasto) {
		this.miastoN.set(miasto);
	}
	public String getMiastoN() {
		return miastoN.get();
	}	

}
