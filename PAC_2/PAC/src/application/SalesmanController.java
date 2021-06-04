package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;

public class SalesmanController {
	@FXML
	Button customerSB = new Button();
	
	public void sceneChange(ActionEvent ac) throws IOException {
		Main m = new Main();
		m.changeScene("Customer.fxml");

	}

}
