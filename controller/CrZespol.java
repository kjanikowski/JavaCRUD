package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.StadionDb;
import application.ZespolDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Stadion;
import model.Zespol;

public class CrZespol implements Initializable{
	
	@FXML TextField nazwa;
	@FXML TextField miasto;
	@FXML TextField ulica;
	@FXML TextField numer;
	@FXML Button btn;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void create(ActionEvent a) {
		Zespol nowy = new Zespol(nazwa.getText(), miasto.getText(), ulica.getText(), numer.getText());
		ZespolDb x = new ZespolDb();
		x.insert(nowy);
		btn.setText("Dodano!");
	}
}
