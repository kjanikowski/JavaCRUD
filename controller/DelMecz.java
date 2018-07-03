package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.MeczDb;
import application.ZawodnikDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import model.Mecz;
import model.Zawodnik;

public class DelMecz  implements Initializable  {
	
	@FXML ChoiceBox<String> box;
	@FXML Button Usun;
	
	MeczDb stad;
	ArrayList<Mecz> lista = new ArrayList<Mecz>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new MeczDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getData() + " "+ lista.get(i).getStadion_nazwa() + ", nr: " + lista.get(i).getDr_nazwa() + "vs " + lista.get(i).getDr2_nazwa());	
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		box.getItems().setAll(pom);
		}
	}
	int i=0;
	public void usun(ActionEvent a) {
		
		Mecz wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		Usun.setText("Potwierdz usuniecie");
		
		if(i>0)
			stad.delete(wybrany);
		
		i++;
		
	}

}
