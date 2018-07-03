package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.MeczDb;
import application.StadionDb;
import application.Szt_drDb;
import application.SztabDb;
import application.ZawodnikDb;
import application.ZespolDb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Mecz;
import model.Stadion;
import model.Szt_dr;
import model.Sztab;
import model.Zawodnik;
import model.Zespol;

public class Big implements Initializable{

	@FXML private Button dodaj;
	@FXML private Button edytuj;
	@FXML private Button usun;
	@FXML private TableView<Mecz> table;
	@FXML private TableColumn<Mecz, String> data;
	@FXML private TableColumn<Mecz, String> stadion;
	@FXML private TableColumn<Mecz, String> dr1;
	@FXML private TableColumn<Mecz, String> dr2;
	
	@FXML private Button dodajS;
	@FXML private Button edytujS;
	@FXML private Button usunS;
	@FXML private TableView<Stadion> tableS;
	@FXML private TableColumn<Stadion, String> nazwaS;
	@FXML private TableColumn<Stadion, String> miastoS;
	@FXML private TableColumn<Stadion, String> ulicaS;
	@FXML private TableColumn<Stadion, String> numerS;
	
	@FXML private Button dodajZe;
	@FXML private Button edytujZe;
	@FXML private Button usunZe;
	@FXML private TableView<Zespol> tableZe;
	@FXML private TableColumn<Zespol, String> nazwaZe;
	@FXML private TableColumn<Zespol, String> nazwa_potZe;
	@FXML private TableColumn<Zespol, String> miastoZe;
	@FXML private TableColumn<Zespol, String> statusZe;
	
	@FXML private Button dodajSz;
	@FXML private Button edytujSz;
	@FXML private Button usunSz;
	@FXML private TableView<Sztab> tableSz;
	@FXML private TableColumn<Sztab, String> imieSz;
	@FXML private TableColumn<Sztab, String> nazwiskoSz;
	@FXML private TableColumn<Sztab, String> funkcjaSz;
	@FXML private TableColumn<Sztab, String> pensjaSz;
	
	@FXML private Button dodajZa;
	@FXML private Button edytujZa;
	@FXML private Button usunZa;
	@FXML private TableView<Zawodnik> tableZa;
	@FXML private TableColumn<Zawodnik, String> imieZa;
	@FXML private TableColumn<Zawodnik, String> nazwiskoZa;
	@FXML private TableColumn<Zawodnik, String> numerZa;
	@FXML private TableColumn<Zawodnik, String> statusZa;
	@FXML private TableColumn<Zawodnik, String> zespolZa;
	
	@FXML private Button dodajSd;
	@FXML private Button edytujSd;
	@FXML private Button usunSd;
	@FXML private TableView<Szt_dr> tableSd;
	@FXML private TableColumn<Szt_dr, String> imieSd;
	@FXML private TableColumn<Szt_dr, String> nazwiskoSd;

	


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		load();
		
	}
	
	
	public void load() {
		///// Stadiony
		
		tableS.getItems().clear();
		
		nazwaS.setCellValueFactory((TableColumn.CellDataFeatures<Stadion, String> cellData) -> cellData.getValue().getNazwaProp());
		
		miastoS.setCellValueFactory((TableColumn.CellDataFeatures<Stadion, String> cellData) -> cellData.getValue().getMiastoProp());
		
		ulicaS.setCellValueFactory((TableColumn.CellDataFeatures<Stadion, String> cellData) -> cellData.getValue().getUlicaProp());
		
		numerS.setCellValueFactory((TableColumn.CellDataFeatures<Stadion, String> cellData) -> cellData.getValue().getNumerProp());
		
		tableS.getColumns().clear();
		
		tableS.getColumns().addAll(nazwaS, miastoS, ulicaS, numerS );
		
		StadionDb stad = new StadionDb();
		
		tableS.getItems().addAll(stad.selectAll());
		
		/////
		
		//// Zespoly
		
		tableZe.getItems().clear();
		
		nazwaZe.setCellValueFactory((TableColumn.CellDataFeatures<Zespol, String> cellData) -> cellData.getValue().getNazwaProp());
		
		miastoZe.setCellValueFactory((TableColumn.CellDataFeatures<Zespol, String> cellData) -> cellData.getValue().getMiastoProp());
		
		nazwa_potZe.setCellValueFactory((TableColumn.CellDataFeatures<Zespol, String> cellData) -> cellData.getValue().getnazwaPot());
		
		statusZe.setCellValueFactory((TableColumn.CellDataFeatures<Zespol, String> cellData) -> cellData.getValue().getStatusProp());
		
		tableZe.getColumns().clear();
		
		tableZe.getColumns().addAll(nazwaZe, nazwa_potZe , miastoZe, statusZe );
		
		ZespolDb zesp = new ZespolDb();
		
		tableZe.getItems().addAll(zesp.selectAll());
		
		////////
		//// Sztab
		
		tableSz.getItems().clear();
		
		imieSz.setCellValueFactory((TableColumn.CellDataFeatures<Sztab, String> cellData) -> cellData.getValue().getImieProp());
		
		nazwiskoSz.setCellValueFactory((TableColumn.CellDataFeatures<Sztab, String> cellData) -> cellData.getValue().getNazwiskoProp());
		
		funkcjaSz.setCellValueFactory((TableColumn.CellDataFeatures<Sztab, String> cellData) -> cellData.getValue().getFunkcjaProp());
		
		pensjaSz.setCellValueFactory((TableColumn.CellDataFeatures<Sztab, String> cellData) -> cellData.getValue().getPensjaProp());
		
		tableSz.getColumns().clear();
		
		tableSz.getColumns().addAll(imieSz, nazwiskoSz , funkcjaSz, pensjaSz );
		
		SztabDb sztab = new SztabDb();
		
		tableSz.getItems().addAll(sztab.selectAll());
		
		//////
		// Zawodnicy
		
		tableZa.getItems().clear();
		
		imieZa.setCellValueFactory((TableColumn.CellDataFeatures<Zawodnik, String> cellData) -> cellData.getValue().getNazwaProp());
		
		nazwiskoZa.setCellValueFactory((TableColumn.CellDataFeatures<Zawodnik, String> cellData) -> cellData.getValue().getMiastoProp());
		
		numerZa.setCellValueFactory((TableColumn.CellDataFeatures<Zawodnik, String> cellData) -> cellData.getValue().getUlicaProp());
		
		statusZa.setCellValueFactory((TableColumn.CellDataFeatures<Zawodnik, String> cellData) -> cellData.getValue().getNumerProp());
		
		zespolZa.setCellValueFactory((TableColumn.CellDataFeatures<Zawodnik, String> cellData) -> cellData.getValue().getNazwaZespProp());

		
		tableZa.getColumns().clear();
		
		tableZa.getColumns().addAll(imieZa, nazwiskoZa , numerZa, statusZa, zespolZa );
		
		ZawodnikDb zaw = new ZawodnikDb();
		
		tableZa.getItems().addAll(zaw.selectAll());
		
		
		////
		//mecz
		
		
		table.getItems().clear();
		
		data.setCellValueFactory((TableColumn.CellDataFeatures<Mecz, String> cellData) -> cellData.getValue().getDataProp());
		
		stadion.setCellValueFactory((TableColumn.CellDataFeatures<Mecz, String> cellData) -> cellData.getValue().getStadion_nazwaProp());
		
		dr1.setCellValueFactory((TableColumn.CellDataFeatures<Mecz, String> cellData) -> cellData.getValue().getDr_nazwaProp());
		
		dr2.setCellValueFactory((TableColumn.CellDataFeatures<Mecz, String> cellData) -> cellData.getValue().getDr2_nazwaProp());
		
		table.getColumns().clear();
		
		table.getColumns().addAll(data, stadion , dr1, dr2 );
		
		MeczDb mecz = new MeczDb();
		
		table.getItems().addAll(mecz.selectAll());
		
		///
		//Sd
		
		tableSd.getItems().clear();
		
		imieSd.setCellValueFactory((TableColumn.CellDataFeatures<Szt_dr, String> cellData) -> cellData.getValue().getNazwaNProp());
		
		nazwiskoSd.setCellValueFactory((TableColumn.CellDataFeatures<Szt_dr, String> cellData) -> cellData.getValue().getMiastoNProp());
		
		tableSd.getColumns().clear();
		
		tableSd.getColumns().addAll(imieSd, nazwiskoSd );
		
		Szt_drDb sztDr = new Szt_drDb();
		
		tableSd.getItems().addAll(sztDr.selectAll());
		
	}
	
	public void create(ActionEvent a) {

		        Parent root;
		        try {
		            root = FXMLLoader.load(getClass().getResource("CrStadion.fxml"));
		            Stage stage = new Stage();
		            stage.setTitle("Dodaj Stadion");
		            stage.setScene(new Scene(root, 450, 450));
		            stage.show();
		            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		            	public void handle(WindowEvent we) {
		            		load();
		            	}
		            });
		            
		            

		        }
		        catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		        	load();
		        }
		    }
	
	
	public void edit(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("EdStadion.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj Stadion");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void delete(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DelStadion.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Usun Stadion");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void createZe(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("CrZespol.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj Zespol");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void editZe(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("EdZespol.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edytuj Zespol");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
		
	public void delZe(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DelZespol.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Usun Zespol");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	///////
	
	public void createSz(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("CrSztab.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj Sztab");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void editSz(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("EdSztab.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edytuj Sztab");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void delSz(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DelSztab.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Usun Sztab");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	
	/////////
	
	
	public void createZaw(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("CrZawodnik.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj Stadion");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void editZaw(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("EdZawodnik.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edytuj Zawodnika");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void delZaw(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DelZawodnik.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Usun Zawodnika");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	
	public void createMecz(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("CrMecz.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj Mecz");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void editMecz(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("EdMecz.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edytuj Mecz");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void deleteMecz(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DelMecz.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Usun Stadion");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void createSzt_dr(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("CrSzt_dr.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj Szt-dr");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	public void editSzt_dr(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("EdSzt_dr.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edytuj Szt_dr");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	
	public void deleteSzt_dr(ActionEvent a) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("DelSzt_dr.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Usun Szt_dr");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            	public void handle(WindowEvent we) {
            		load();
            	}
            });
            
            

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        	load();
        }
    }
	
	}
	

