package controller;

import personel.Personel;
import application.Main;
import dataStructure.BagliListe;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ekleController {
	@FXML
	private Button onaylaButon;
	@FXML
	private TextField isimTextField;
	@FXML
	private TextField soyisimTextField;
	@FXML
	private TextField maasTextField;
	@FXML
	private ChoiceBox<String> pozisyonChoiceBox;
	@FXML
	private TextField yasTextField;
	
	@FXML
    public void initialize() {
        // ChoiceBox öğelerini doldurma
        pozisyonChoiceBox.setItems(FXCollections.observableArrayList("Stajyer","Junier", "Mid Level", "Senior","Team Lead","Software Architect",""
        		+ "Freelancer","CTO"));
        pozisyonChoiceBox.getSelectionModel().selectFirst(); // Varsayılan olarak ilk öğe seçilir
    }
	
	@FXML
	public void onaylaButonKod() {
		// TextField'dan alınan değerleri uygun türlere dönüştür
	    long maas = Long.parseLong(maasTextField.getText());
	    String isim = isimTextField.getText().toUpperCase();
	    String soyisim = soyisimTextField.getText().toUpperCase();
	    String pozisyon = pozisyonChoiceBox.getValue();
	    int yas = Integer.parseInt(yasTextField.getText());
	    
	    
	    
	    // Personel nesnesi oluşturuluyor
	    Personel yeniPersonel = new Personel(isim, soyisim, pozisyon, yas,maas);
	    yeniPersonel.getTerfiListesi().add(yeniPersonel.getPozisyon());
	    
	    yeniPersonel.getTerfiListesi().add(yeniPersonel.getTerfiBilgileri());
	    // observable liste yenii personeli ekle
	    Controller.personelList.add(yeniPersonel);
	    
	    
	    Main.bL.Ekle(yeniPersonel);
	    Main.bL.listeYazdir();
		// onaylaButon'un bulunduğu stage'i kapat
		Stage kapastage = (Stage) onaylaButon.getScene().getWindow(); // onaylaButon'un bulunduğu stage'i bir nesneye atama
		kapastage.close(); // alınan stage'i kapatma
		
		
	}
	
    
	
}
