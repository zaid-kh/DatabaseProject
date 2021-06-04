package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class PersonView implements Initializable {
	@FXML
	private TableView<Person> PersonView;
	@FXML
	private TableColumn<Person, Integer> Id;
	@FXML
	private TableColumn<Person, String> P_Name;
	@FXML
	private TableColumn<Person, String> Age;
	@FXML
	private TableColumn<Person, Integer> Customer_ID;
	@FXML
	private Button Back;

	ObservableList<Person> personList = FXCollections.observableArrayList();
	public static ArrayList<Person> person = new ArrayList<Person>();
	ResultSet rs;
	public static String S;

	void search(ActionEvent event) throws ClassNotFoundException, SQLException {
		//	String type = RBPerson.getSelectionModel().getSelectedItem().toString();
		//	if (CustomerController.RBPerson.isSelected()) { // If The Radio button is selected as Person, the user should enter data to find it then the program will matche it from data base
		//	 S = "select p.P_Name from  Person p  where p.P_name = \"ALi mostafa";"; 				// And  show it on the table view
			 
			 //if(CustomerController.Input.matcher(CustomerController.NameTxtF.getText()).find() || CustomerController.Input.matcher(CustomerController.NameTxtF.getText()).find()||  CustomerController.numberin.matcher(CustomerController.CIDtxtF.getText()).find() ||CustomerController.numberin.matcher(CustomerController.IDtxtF.getText()).find());
			}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {

			rs = DB_Connection.select(CustomerController.SQL);
			System.out.println(rs);
			person.clear();

			while (rs.next()) {

				person.add(new Person(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),rs.getDate(3),
						rs.getString(4)));

			}
			System.out.println(person);

			for (int i = 0; i < person.size(); i++)
				personList.add(person.get(i));

			Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
			P_Name.setCellValueFactory(new PropertyValueFactory<>("P_Name"));
			Age.setCellValueFactory(new PropertyValueFactory<>("DOB"));
			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));

			PersonView.setItems(personList);
		} catch (Exception e) {

		} finally {
			try {
				DB_Connection.con.close();

			} catch (SQLException e) {
			}
		}
	}

	@FXML
	void back(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
			Scene scene = new Scene(root, 600, 400);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene);
			st.show();

		} catch (Exception e) {

		}
	}

}
