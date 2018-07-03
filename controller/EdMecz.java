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

public class EdMecz implements Initializable {
	
	@FXML ChoiceBox<String> box; /// mecz
	@FXML ChoiceBox<String> wyb;
	@FXML ChoiceBox<String> wyb1;
	@FXML ChoiceBox<String> stadion;

	@FXML TextField Nazwa;

	@FXML Button Edytuj;
	
	MeczDb stad;
	ArrayList<Mecz> lista = new ArrayList<Mecz>();
	
	ArrayList<Zespol> listaZ = new ArrayList<Zespol>();
	ZespolDb zesp;
	
	ArrayList<Zespol> listaZ2 = new ArrayList<Zespol>();
	ZespolDb zesp2;
	
	ArrayList<Stadion> stadionik = new ArrayList<Stadion>();
	StadionDb stadionikdb;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stad = new MeczDb();
		ArrayList<String> pom = new ArrayList<String>();

		lista = stad.selectAll();
		
		for(int i = 0; i < stad.selectAll().size(); i++) {
			pom.add(lista.get(i).getData() + " "+ lista.get(i).getStadion_nazwa() + ", nr: " + lista.get(i).getDr_nazwa() + "vs " + lista.get(i).getDr2_nazwa());	
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
		wyb1.getItems().setAll(listapom);
		
		stadionikdb = new StadionDb();
		ArrayList<String> listapoms = new ArrayList<String>();

		stadionik = stadionikdb.selectAll();
		
		for(int i = 0; i < stadionikdb.selectAll().size(); i++) {
			listapoms.add(stadionik.get(i).getNazwa() + " ( "+ stadionik.get(i).getMiasto() + " ), z " + stadionik.get(i).getUlica() + ",status: " + stadionik.get(i).getNumer());	
		}
		
		stadion.getItems().setAll(listapoms);

	}
	
	public void edytuj(ActionEvent a) {
		
		Mecz wybrany = lista.get(box.getSelectionModel().getSelectedIndex());
		
		Zespol wybranyZ = listaZ.get(wyb.getSelectionModel().getSelectedIndex());
		
		Zespol wybranyZ2 = listaZ.get(wyb1.getSelectionModel().getSelectedIndex());

		Stadion nowyS = stadionik.get(stadion.getSelectionModel().getSelectedIndex());
		
		Mecz nowy = new Mecz(Nazwa.getText(), nowyS.getId(), wybranyZ.getId(), wybranyZ2.getId());
		
		stad.edit(wybrany, nowy);
		
	}
}
