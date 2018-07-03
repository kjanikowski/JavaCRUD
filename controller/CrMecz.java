package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.MeczDb;
import application.StadionDb;
import application.ZawodnikDb;
import application.ZespolDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Mecz;
import model.Stadion;
import model.Zawodnik;
import model.Zespol;

public class CrMecz implements Initializable{
	
	@FXML TextField nazwa;
	@FXML Button btn;
	@FXML ChoiceBox<String> box;
	@FXML ChoiceBox<String> box2;
	@FXML ChoiceBox<String> boxS;

	
	ArrayList<Zespol> lista = new ArrayList<Zespol>();
	ZespolDb stad;
	
	ArrayList<Stadion> listaStad = new ArrayList<Stadion>();
	StadionDb stadStad;



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
		
		stadStad = new StadionDb();
		ArrayList<String> pomStad = new ArrayList<String>();
		
		listaStad = stadStad.selectAll();
		
		for(int i = 0; i < stadStad.selectAll().size(); i++) {
			pomStad.add(listaStad.get(i).getNazwa() + " ( "+ listaStad.get(i).getMiasto() + " ), z " + listaStad.get(i).getUlica() + ",status: " + listaStad.get(i).getNumer());	
		}
		
		
		
		
		box.getItems().setAll(pom);
		box2.getItems().setAll(pom);
		boxS.getItems().setAll(pomStad);
	}
	
	
	public void create(ActionEvent a) {
		
		Zespol wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		Zespol wybrany2 = lista.get(box2.getSelectionModel().getSelectedIndex());
		Stadion nowyS = listaStad.get(boxS.getSelectionModel().getSelectedIndex());

		
		Mecz nowy = new Mecz(nazwa.getText(), nowyS.getId(), wybrany.getId(), wybrany2.getId());
		MeczDb x = new MeczDb();
		
		x.insert(nowy);
		
		btn.setText("Dodano!");
	}
}
