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
    
    ObservableList<String> divisas = FXCollections.observableArrayList("Euro", "Peso mexicano", "Libra esterlina", "Zloty polaco", "Dólar");
    @FXML
    private ComboBox<String> cbDivisaDestino;

    @FXML
    private Label resultLb;
    
    int divisaOrigen;
    int divisaDestino;
    
    
    
    double[][] conversion;
    
    
    final double EURO_TO_DOLLAR = 1.0626;
    final double PESO_TO_DOLLAR = 0.0509;
    final double POUND_TO_DOLLAR = 1.2366;
    final double ZLOTY_TO_DOLLAR = 0.2268;
    
    public double calcula(double importe, String divisaOrigen, String divisaDestino){
        if (divisaOrigen.equals("Euro")){
            importe *= EURO_TO_DOLLAR;
        } else if (divisaOrigen.equals("Peso mexicano")){
            importe *= PESO_TO_DOLLAR;
        } else if (divisaOrigen.equals("Libra esterlina")){
            importe *= POUND_TO_DOLLAR;
        } else if (divisaOrigen.equals("Zloty polaco")){
            importe *= ZLOTY_TO_DOLLAR;
        }
        
        if (divisaDestino.equals("Euro")){
            importe /= EURO_TO_DOLLAR;
        } else if (divisaDestino.equals("Peso mexicano")){
            importe /= PESO_TO_DOLLAR;
        } else if (divisaDestino.equals("Libra esterlina")){
            importe /= POUND_TO_DOLLAR;
        } else if (divisaDestino.equals("Zloty polaco")){
            importe /= ZLOTY_TO_DOLLAR;
        }
        
        return importe;
    }
    
    public double calcula(double importe, int divisaOrigen, int divisaDestino){
        return importe * conversion[divisaOrigen][divisaDestino];
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbDivisaOrigen.setItems(divisas);
        cbDivisaDestino.setItems(divisas);
        conversion = new double[][]{
        {1,      21,      0.87,    4.68,   1.06},
        {1/21,   1,       0.042,   0.22,   0.051},
        {1/0.87, 1/0.042, 1,       5.37,   1.22},
        {1/4.68, 1/0.22,  1/5.37,  1,      0.23},
        {1/1.06, 1/0.051, 1/1.22,  1/0.23, 1},
        };
        int i = 1;
        int j = 0;
        
    }    
    
    @FXML
    public void getDivisaOrigen(ActionEvent evento) {
        divisaOrigen = cbDivisaOrigen.getSelectionModel().getSelectedIndex();
    }
    
    @FXML
    public void getDivisaDestino(ActionEvent evento){
        divisaDestino = cbDivisaDestino.getSelectionModel().getSelectedIndex();
    }
    
    

    @FXML
    private void bConvertirClick(ActionEvent event) {
        
        
        double importe = calcula(Double.parseDouble(tfImporte.getText()),divisaOrigen ,divisaDestino);
        
        resultLb.setText(String.format("%s %s = %.02f %s",tfImporte.getText(), 
                cbDivisaOrigen.getValue(), importe, cbDivisaDestino.getValue()));
    }
    

}
