/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversordivisaapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Diurno
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label lTitulo;
    @FXML
    private TextField tfImporte;
    @FXML
    private ComboBox<String> cbDivisaOrigen;
    @FXML
    private Button bConvertir;
    
    ObservableList<String> divisas = FXCollections.observableArrayList("Dólares", "divisa2", "divisa3");
    @FXML
    private ComboBox<String> cbDivisaDestino;
    String divisaOrigen;
    String divisaDestino;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbDivisaOrigen.setItems(divisas);
        cbDivisaOrigen.getSelectionModel().selectFirst();
    }    
    
    @FXML
    public void getDivisaOrigen(ActionEvent evento) {
        divisaOrigen = (String) cbDivisaOrigen.getValue();
    }
    
    @FXML
    public void getDivisaDestino(ActionEvent evento){
        divisaDestino = (String) cbDivisaDestino.getValue();
    }
}
