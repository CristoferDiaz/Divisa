package dad.cambiodivisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisaApp extends Application {
	Divisa euro = new Divisa("Euro", 1.0);
	Divisa libra = new Divisa("Libra", 0.8873);
	Divisa dolar = new Divisa("Dolar", 1.2007);
	Divisa yen = new Divisa("Yen", 133.59);
	Divisa origen = yen;
	Divisa destino = dolar;
	Double cantidad;
	private TextField nombreText, nombreTextB;
	private Button saludarButton;
	private Label saludoLablel;
	private ComboBox<String> authModesCombo, authModesComboB;

	@Override
	public void start(Stage primaryStage) throws Exception {

		nombreText = new TextField();
		nombreText.setPromptText("");
		nombreText.setMaxWidth(150);

		nombreTextB = new TextField();
		nombreTextB.setPromptText("");
		nombreTextB.setMaxWidth(150);
		nombreTextB.cancelEdit();

		saludoLablel = new Label();

		saludarButton = new Button("Cambiar");
		saludarButton.setDefaultButton(true);
		saludarButton.setOnAction(e -> cambiarButtonAction(e));

		authModesCombo = new ComboBox<String>();
		authModesCombo.getItems().addAll("Euro", "Libra", "Dolar", "yen");
		authModesCombo.setPromptText("Cambiar de:");

		authModesComboB = new ComboBox<String>();
		authModesComboB.getItems().addAll("Euro", "Libra", "Dolar", "yen");
		authModesComboB.setPromptText("Cambiar a:");

		HBox primero = new HBox();
		primero.setSpacing(5);
		primero.setAlignment(Pos.CENTER);
		primero.getChildren().addAll(nombreText, authModesCombo);

		HBox segundo = new HBox();
		segundo.setSpacing(5);
		segundo.setAlignment(Pos.CENTER);
		segundo.getChildren().addAll(nombreTextB, authModesComboB);

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(primero, segundo, saludarButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Cambio divisa");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void cambiarButtonAction(ActionEvent e) {
		Double moneda = Double.parseDouble(nombreText.getText());
		String auth = authModesCombo.getSelectionModel().getSelectedItem();
		String authB = authModesComboB.getSelectionModel().getSelectedItem();
		switch (auth) {
		case "Euro":
			switch (authB) {
			case "Euro":
				origen=euro;
				destino=euro;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Libra":
				origen=euro;
				destino=libra;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Dolar":
				origen=euro;
				destino=dolar;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "yen":
				origen=euro;
				destino=yen;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			}
			break;
		case "Libra":
			switch (authB) {
			case "Euro":
				origen=libra;
				destino=euro;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Libra":
				origen=libra;
				destino=libra;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Dolar":
				origen=libra;
				destino=dolar;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "yen":
				origen=libra;
				destino=yen;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			}
			break;
		case "Dolar":
			switch (authB) {
			case "Euro":
				origen=dolar;
				destino=euro;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Libra":
				origen=dolar;
				destino=libra;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Dolar":
				origen=dolar;
				destino=dolar;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "yen":
				origen=dolar;
				destino=yen;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			}

			break;
		case "yen":
			switch (authB) {
			case "Euro":
				origen=yen;
				destino=euro;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Libra":
				origen=yen;
				destino=libra;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "Dolar":
				origen=yen;
				destino=dolar;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			case "yen":
				origen=yen;
				destino=yen;
				nombreTextB.setText(""+moneda*((destino.getTasa()/origen.getTasa())));
				break;
			}

			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
