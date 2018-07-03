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

public class EdSzt_dr implements Initializable {
	
	@FXML ChoiceBox<String> box; /// mecz
	@FXML ChoiceBox<String> wyb;
	@FXML ChoiceBox<String> wyb1;


	@FXML Button Edytuj;
	
	Szt_drDb stad;
	ArrayList<Szt_dr> lista = new ArrayList<Szt_dr>();
	
	ArrayList<Zespol> listaZ = new ArrayList<Zespol>();
	ZespolDb zesp;
	
	ArrayList<Sztab> listaZ2 = new ArrayList<Sztab>();
	SztabDb zesp2;
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new Szt_drDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getNazwaN() + " "+ lista.get(i).getMiastoN());	
		}
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		box.getItems().setAll(pom);
		
		
		
		zesp = new ZespolDb();
		ArrayList<String> listapom = new ArrayList<String>();

		listaZ = zesp.selectAll();
		
		for(int i = 0; i < zesp.selectAll().size(); i++) {
			listapom.add(listaZ.get(i).getNazwa() + " ( "+ listaZ.get(i).getNazwaPot() + " ), z " + listaZ.get(i).getMiasto() + ",status: " + listaZ.get(i).getStatus());	
		}
		
		//box.setItems(FXCollections.observableArrayList(stad.selectAll()));
		
		wyb.getItems().setAll(listapom);
		
		
		zesp2 = new SztabDb();
		ArrayList<String> listapoms = new ArrayList<String>();

		listaZ2 = zesp2.selectAll();
		
		for(int i = 0; i < zesp2.selectAll().size(); i++) {
			listapoms.add(listaZ2.get(i).getImie() + " ( "+ listaZ2.get(i).getNazwisko() + " ), z " + listaZ2.get(i).getFunkcja());	
		}
		
		wyb1.getItems().setAll(listapoms);
	}
	
	public void edytuj(ActionEvent a) {
		
		Szt_dr wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		
		Zespol wybranyZ = listaZ.get(wyb.getSelectionModel().getSelectedIndex());
		
		Sztab wybranyZ2 = listaZ2.get(wyb1.getSelectionModel().getSelectedIndex());

		
		Szt_dr nowy = new Szt_dr(null, wybranyZ.getId(), wybranyZ2.getId());
		
		stad.edit(wybrany, nowy);
		
	}
}
