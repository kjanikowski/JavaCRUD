package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.MeczDb;
import application.StadionDb;
import application.Szt_drDb;
import application.SztabDb;
import application.ZespolDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Mecz;
import model.Stadion;
import model.Szt_dr;
import model.Sztab;
import model.Zespol;

public class CrSzt_dr implements Initializable{
	

	@FXML Button btn;
	@FXML ChoiceBox<String> box;
	@FXML ChoiceBox<String> box2;


	
	ArrayList<Zespol> lista = new ArrayList<Zespol>();
	ZespolDb stad;
	
	ArrayList<Sztab> listaStad = new ArrayList<Sztab>();
	SztabDb stadStad;



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
		
		stadStad = new SztabDb();
		ArrayList<String> pomStad = new ArrayList<String>();
		
		listaStad = stadStad.selectAll();
		
		for(int i = 0; i < stadStad.selectAll().size(); i++) {
			pomStad.add(listaStad.get(i).getImie() + " ( "+ listaStad.get(i).getNazwisko() + " ), z " + listaStad.get(i).getFunkcja());	
		}
		
		
		
		
		box.getItems().setAll(pom);
		box2.getItems().setAll(pomStad);

	}
	
	
	public void create(ActionEvent a) {
		
		Zespol wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		Sztab wybrany2 = listaStad.get(box2.getSelectionModel().getSelectedIndex());
		//Stadion nowyS = listaStad.get(boxS.getSelectionModel().getSelectedIndex());

		
		Szt_dr nowy = new Szt_dr(null, wybrany.getId(), wybrany2.getId());
		Szt_drDb x = new Szt_drDb();
		x.insert(nowy);
		btn.setText("Dodano!");
	}
}
