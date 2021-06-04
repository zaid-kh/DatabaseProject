package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CustomerController implements Initializable {
	@FXML
	private GridPane PersonGrid;
	@FXML
	private TextField NameTxtF;
	@FXML
	private TextField CIDtxtF;
	@FXML
	private TextField IDtxtF;
	@FXML
	private TextField AgetxtF;
	@FXML
	private Button Search;
	@FXML
	private Button View;
	@FXML
	private GridPane CustomerTypeGrid;
	@FXML
	private RadioButton RBPerson;
	@FXML
	private RadioButton RBcompany;
	@FXML
	private Button Back;
	@FXML
	private GridPane CompanyGrid;
	@FXML
	private TextField companytxtF;
	@FXML
	private TextField cidtxtF;
	@FXML
	private Button Search1;
	@FXML
	private Button View1;
	@FXML
	private TextField AddresstxtF;
	@FXML
	private ToggleGroup customerGroup;

	@FXML
	void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SalesmanController.fxml"));
			Scene scene = new Scene(root, 600, 400);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {

		}
	}

	public static String S, SQL = null;
	public ResultSet rs;
	static Pattern numberin = Pattern.compile("[^0-9]");
	static Pattern Input = Pattern.compile("[^ a-zA-Z0-9]");

	@FXML
	void search(ActionEvent event) throws ClassNotFoundException, SQLException {
		// String type = RBPerson.getSelectionModel().getSelectedItem().toString();
		if (RBPerson.isSelected()) { // If The Radio button is selected as Person, the user should enter data to find
										// it then the program will matche it from data base
			// S = "Person"; // And show it on the table view
			// if(Input.matcher(NameTxtF.getText()).find() ||
			// Input.matcher(NameTxtF.getText()).find()||
			// numberin.matcher(CIDtxtF.getText()).find() ||
			// numberin.matcher(IDtxtF.getText()).find() )
			// {}
			// else
			SQL = "select * from Person P where p.p_name like ";
			if (NameTxtF.getText().isEmpty())
				SQL = SQL + "p.p_name And ";
			else
				SQL = SQL + ("'%" + NameTxtF.getText() + "%'") + " and";

			if (CIDtxtF.getText().isEmpty())
				SQL = SQL + " p.customer_id = p.customer_id and";
			else
				SQL = SQL + " p.customer_id =" + Integer.parseInt(CIDtxtF.getText()) + " and";

			if (IDtxtF.getText().isEmpty())
				SQL = SQL + " p.id = p.id and";
			else
				SQL = SQL + " p.id =" + Integer.parseInt(IDtxtF.getText()) + " and";
			if (AgetxtF.getText().isEmpty())
				SQL = SQL + " p.DOB = p.DOB ";
			else
				SQL = SQL + " p.DOB =" + ("'" + AgetxtF.getText() + "'");

			// + "AND P.customer_id "+ (CIDtxtF.getText().isEmpty() ? "=" : (
			// Integer.parseInt(CIDtxtF.getText())));;
			System.out.println(SQL);
			try {
				Parent root = FXMLLoader.load(getClass().getResource("TableView.fxml"));
				Scene scene = new Scene(root);
				Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
				st.setScene(scene);
				st.show();

			} catch (Exception e) {
			}
		}

		else if (RBcompany.isSelected()) {

			SQL = "select * from Person P where  p.p_name " + (NameTxtF.getText().isEmpty() ? "like"
					: ("'%" + NameTxtF.getText() + "%'") + "AND  P.customer_id = "
							+ (CIDtxtF.getText().isEmpty() ? "=" : (CIDtxtF.getText())));

			/*
			 * select * from Person P where P.customer_id = "+ String here +"; select * from
			 * Person P where P.id = "+ String here +"; select * from Person P where
			 * P.p_name = " + String here + "; # name is exact select * from Person P where
			 * P.p_name like '%" + String here + "%'; # part of name is enough
			 */

			try {

				Parent root = FXMLLoader.load(getClass().getResource("CompanyView.fxml"));
				Scene scene = new Scene(root);
				Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
				st.setScene(scene);
				st.show();

			} catch (Exception e) {
			}
		} else if (!RBcompany.isSelected() && !RBPerson.isSelected()) {

			SQL = "select * from Customer ";
			// System.out.println(">>>>>>>");

			try {

				Parent root = FXMLLoader.load(getClass().getResource("AllCustomers.fxml"));
				Scene scene = new Scene(root);
				Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
				st.setScene(scene);
				st.show();

			} catch (Exception e) {
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
