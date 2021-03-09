package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private TextArea txtExecution;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doInsert(ActionEvent event) {

		if (!txtParola.getText().equals("")) {
			long in = System.nanoTime();
			elenco.addParola(txtParola.getText());
			long fin = System.nanoTime();
			txtParola.clear();
			elenco.getElenco();
			txtResult.setText(elenco.toString());
			long diff = fin - in;
			txtExecution.setText(Long.toString( diff ));
		} 
		else {
			txtResult.setText("Devi inserire una parola");
		}

	}

	@FXML
	void doReset(ActionEvent event) {
		elenco.reset();
		txtResult.clear();
		txtParola.clear();
		txtExecution.clear();
	}

	@FXML
	void doCancel(ActionEvent event) {
		long in = System.nanoTime();
		elenco.cancel(txtResult.getSelectedText());
		long fin = System.nanoTime();
		txtParola.clear();
		elenco.getElenco();
		txtResult.setText(elenco.toString());
		long diff = fin - in;
		txtExecution.setText(Long.toString( diff ));
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtExecution != null : "fx:id=\"txtExecution\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
	}
}
