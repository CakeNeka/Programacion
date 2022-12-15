/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Diurno
 */
public class FXMLDocumentController implements Initializable {

    String operador1;
    String operador2;
    String operacion;

    @FXML
    private TextField TFPantalla;
    @FXML
    private Button bSiete;
    @FXML
    private Button bOcho;
    @FXML
    private Button bNueve;
    @FXML
    private Button batras;
    @FXML
    private Button bCE;
    @FXML
    private Button bDivide;
    @FXML
    private Button bMultiplica;
    @FXML
    private Button bCuatro;
    @FXML
    private Button bCinco;
    @FXML
    private Button bSeis;
    @FXML
    private Button bMenos;
    @FXML
    private Button bUno;
    @FXML
    private Button bDos;
    @FXML
    private Button bTres;
    @FXML
    private Button bMas;
    @FXML
    private Button bMasMenos;
    @FXML
    private Button bCero;
    @FXML
    private Button bComa;
    @FXML
    private Button bIgual;
    @FXML
    private Button BC;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void bAtrasClick(ActionEvent event) {
        TFPantalla.setText(TFPantalla.getText().substring(0, TFPantalla.getText().length() - 1));
    }

    @FXML
    private void bCEClick(ActionEvent event) {
        TFPantalla.setText("0");
    }

    @FXML
    private void bDivideClick(ActionEvent event) {
    }

    @FXML
    private void bSieteClick(ActionEvent event) {
        addText("7");
    }

    @FXML
    private void bOchoClick(ActionEvent event) {
        addText("8");
    }

    @FXML
    private void bNueveClick(ActionEvent event) {
        addText("9");
    }

    @FXML
    private void bMultiplicaClick(ActionEvent event) {
        operador1 = TFPantalla.getText();
        TFPantalla.setText("");
        operacion = "*";   
    }

    @FXML
    private void bCuatroClick(ActionEvent event) {
        addText("4");
    }

    @FXML
    private void bCincoClick(ActionEvent event) {
        addText("5");
    }

    @FXML
    private void bSeisClick(ActionEvent event) {
        addText("0");
    }

    @FXML
    private void bMenosClick(ActionEvent event) {
        operador1 = TFPantalla.getText();
        TFPantalla.setText("");
        operacion = "-";
    }

    @FXML
    private void bUnoClick(ActionEvent event) {
        addText("1");
    }

    @FXML
    private void bDosClick(ActionEvent event) {
        addText("2");
    }

    @FXML
    private void bTresClick(ActionEvent event) {
        addText("3");
    }

    @FXML
    private void bMasClick(ActionEvent event) {
        operador1 = TFPantalla.getText();
        TFPantalla.setText("");
        operacion = "+";
    }

    @FXML
    private void bMasMenosClick(ActionEvent event) {
        
        if (TFPantalla.getText().charAt(0) != '-')
            TFPantalla.setText("-" + TFPantalla.getText());
        else
            TFPantalla.setText(TFPantalla.getText(1, TFPantalla.getText().length()));
    }

    @FXML
    private void bCeroClick(ActionEvent event) {
        addText("0");
    }

    @FXML
    private void bComaClick(ActionEvent event) {
        addText(".");
    }

    @FXML
    private void bIgualClick(ActionEvent event) {
        operador2 = TFPantalla.getText();
        double o1 = Double.parseDouble(operador1);
        double o2 = Double.parseDouble(operador2);
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = o1 + o2;
                break;
            case "-":
                resultado = o1 - o2;
                break;
            case "*":
                resultado = o1 * o2;
                break;
            case "/":
                resultado = o1 / o2;
                break;

        }
        if (!operacion.equals(""))
            TFPantalla.setText(resultado + "");
        
        operacion = "";
    }

    private void addText(String num) {
        if (!TFPantalla.getText().equals("0")) {
            TFPantalla.setText(TFPantalla.getText() + num);
        } else {
            TFPantalla.setText(num);
        }
    }

    @FXML
    private void BCclick(ActionEvent event) {
        TFPantalla.setText("0");
        operador1 = "0";
        operacion = "0";
    }
}
