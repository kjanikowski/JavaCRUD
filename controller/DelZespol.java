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
import model.Mecz;
import model.Stadion;
import model.Zespol;

public class DelZespol implements Initializable  {
	
	@FXML ChoiceBox<String> box;
	@FXML Button Usun;
	
	ZespolDb stad;
	ArrayList<Zespol> lista = new ArrayList<Zespol>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new ZespolDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getNazwa() + " ( "+ lista.get(i).getNazwaPot() + " ), z " + lista.get(i).getMiasto() + ",status: " + lista.get(i).getStatus());		}
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		box.getItems().setAll(pom);
	}
	
	int i=0;
	public void usun(ActionEvent a) {
		
		Zespol wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		Usun.setText("Potwierdz usuniecie");
		
		if(i>0)
			stad.delete(wybrany);
		
		i++;
		
	}
}
