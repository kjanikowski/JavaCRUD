package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.StadionDb;
import application.ZespolDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Stadion;
import model.Zespol;

public class EdZespol implements Initializable {
	
	@FXML ChoiceBox<String> box;
	@FXML TextField Nazwa;
	@FXML TextField Miasto;
	@FXML TextField Ulica;
	@FXML TextField Numer;
	@FXML Button Edytuj;
	
	ZespolDb stad;
	ArrayList<Zespol> lista = new ArrayList<Zespol>();

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
		
		
		
		//box = new ChoiceBox<Stadion>(FXCollections.observableArrayList(stad.selectAll()));
	}
	
	public void edytuj(ActionEvent a) {
		
		Zespol wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		
		Zespol nowy = new Zespol(Nazwa.getText(), Miasto.getText(), Ulica.getText(), Numer.getText());
		
		stad.edit(wybrany, nowy);
		
	}
}
