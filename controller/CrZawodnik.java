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

public class CrZawodnik implements Initializable{
	
	@FXML TextField nazwa;
	@FXML TextField miasto;
	@FXML TextField ulica;
	@FXML TextField numer;
	@FXML Button btn;
	@FXML ChoiceBox<String> box;

	
	ArrayList<Zespol> lista = new ArrayList<Zespol>();
	ZespolDb stad;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new ZespolDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getNazwa() + " ( "+ lista.get(i).getNazwaPot() + " ), z " + lista.get(i).getMiasto() + ",status: " + lista.get(i).getStatus());	
		}
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		box.getItems().setAll(pom);
	}
	
	
	public void create(ActionEvent a) {
		
		Zespol wybrany = lista.get(box.getSelectionModel().getSelectedIndex());

		
		Zawodnik nowy = new Zawodnik(nazwa.getText(), miasto.getText(), ulica.getText(), numer.getText(), wybrany.getId());
		ZawodnikDb x = new ZawodnikDb();
		x.insert(nowy);
		btn.setText("Dodano!");
	}
}
