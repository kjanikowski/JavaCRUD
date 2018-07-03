package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.StadionDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Stadion;

public class CrStadion implements Initializable{
	
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
		Stadion nowy = new Stadion(nazwa.getText(), miasto.getText(), ulica.getText(), numer.getText());
		StadionDb x = new StadionDb();
		x.insert(nowy);
		btn.setText("Dodano!");
	}

}
