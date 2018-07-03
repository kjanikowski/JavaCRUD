package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.ZawodnikDb;
import application.ZespolDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import model.Mecz;
import model.Zawodnik;
import model.Zespol;

public class DelZawodnik  implements Initializable  {
	
	@FXML ChoiceBox<String> box;
	@FXML Button Usun;
	
	ZawodnikDb stad;
	ArrayList<Zawodnik> lista = new ArrayList<Zawodnik>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new ZawodnikDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getImie() + " "+ lista.get(i).getNazwisko() + ", nr: " + lista.get(i).getNumer_karty() + ",status: " + lista.get(i).getZawodowiec());	
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		box.getItems().setAll(pom);
		}
	}
	
	int i=0;
	public void usun(ActionEvent a) {
		
		Zawodnik wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		Usun.setText("Potwierdz usuniecie");
		
		if(i>0)
			stad.delete(wybrany);
		
		i++;
		
	}
}
