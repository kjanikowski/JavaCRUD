package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.StadionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import model.Mecz;
import model.Stadion;

public class DelStadion implements Initializable  {
	
	@FXML ChoiceBox<String> box;
	@FXML Button Usun;
	
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
	}
	
	int i=0;
	public void usun(ActionEvent a) {
		
		Stadion wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		Usun.setText("Potwierdz usuniecie");
		
		if(i>0)
			stad.delete(wybrany);
		
		i++;
		
	}
}
