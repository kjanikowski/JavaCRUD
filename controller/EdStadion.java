package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.StadionDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Stadion;

public class EdStadion implements Initializable {
	
	@FXML ChoiceBox<String> box;
	@FXML TextField Nazwa;
	@FXML TextField Miasto;
	@FXML TextField Ulica;
	@FXML TextField Numer;
	@FXML Button Edytuj;
	
	StadionDb stad;
	ArrayList<Stadion> lista = new ArrayList<Stadion>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new StadionDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getNazwa() + " w "+ lista.get(i).getMiasto() + ", " + lista.get(i).getUlica() + " " + lista.get(i).getNumer());	
		}
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		box.getItems().setAll(pom);
		
		
		
		//box = new ChoiceBox<Stadion>(FXCollections.observableArrayList(stad.selectAll()));
	}
	
	public void edytuj(ActionEvent a) {
		
		Stadion wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		
		Stadion nowy = new Stadion(Nazwa.getText(), Miasto.getText(), Ulica.getText(), Numer.getText());
		
		stad.edit(wybrany, nowy);
		
	}

}
