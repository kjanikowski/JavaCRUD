package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.SztabDb;
import application.ZawodnikDb;
import application.ZespolDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Sztab;
import model.Zawodnik;
import model.Zespol;

public class EdZawodnik implements Initializable {
	
	@FXML ChoiceBox<String> box;
	@FXML ChoiceBox<String> wyb;

	@FXML TextField Nazwa;
	@FXML TextField Miasto;
	@FXML TextField Ulica;
	@FXML TextField Numer;
	@FXML Button Edytuj;
	
	ZawodnikDb stad;
	ArrayList<Zawodnik> lista = new ArrayList<Zawodnik>();
	
	ArrayList<Zespol> listaZ = new ArrayList<Zespol>();
	ZespolDb zesp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new ZawodnikDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getImie() + " "+ lista.get(i).getNazwisko() + ", nr: " + lista.get(i).getNumer_karty() + ",status: " + lista.get(i).getZawodowiec());	
		}
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		box.getItems().setAll(pom);
		
		
		
		zesp = new ZespolDb();
		ArrayList<String> listapom = new ArrayList<String>();

		listaZ = zesp.selectAll();
		
		for(int i = 0; i < zesp.selectAll().size(); i++) {
			listapom.add(listaZ.get(i).getNazwa() + " ( "+ listaZ.get(i).getNazwaPot() + " ), z " + listaZ.get(i).getMiasto() + ",status: " + listaZ.get(i).getStatus());	
		}
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		wyb.getItems().setAll(listapom);
	}
	
	public void edytuj(ActionEvent a) {
		
		Zawodnik wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		
		Zespol wybranyZ = listaZ.get(wyb.getSelectionModel().getSelectedIndex());

		
		Zawodnik nowy = new Zawodnik(Nazwa.getText(), Miasto.getText(), Ulica.getText(), Numer.getText(), wybranyZ.getId());
		
		stad.edit(wybrany, nowy);
		
	}
}
