package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class AllCustomersController implements Initializable {
	@FXML
	private Button Back;
	@FXML
	private TableView <Customer> AllView;
	@FXML
	private TableColumn<Person, String> P_Name;
	@FXML
	private TableColumn<Person, String> Id;
	@FXML
	private TableColumn<Person, String> DOB;
	@FXML
	private TableColumn<Customer, Integer> Customer_ID;
	@FXML
	private TableColumn<Customer, String> Phone;
	@FXML
	private TableColumn<Customer, String> Bankst;
	@FXML
	private TableColumn<Customer, String> incomeproof;
	@FXML
	private TableColumn<Customer, String> Address;

	ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
	public static ArrayList<Customer> AllCustomer = new ArrayList<Customer>();

	ObservableList<Person> personList = FXCollections.observableArrayList();
	public static ArrayList<Person> person = new ArrayList<Person>();
	ResultSet rs;

	public static String S;

	public void initialize(URL location, ResourceBundle resources) {

		try {

			rs = DB_Connection.select(CustomerController.SQL);
			System.out.println(">>>>>>>");

			//System.out.println(rs);

			AllCustomer.clear();

			while (rs.next()) {
				AllCustomer.add(new Customer(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3) , rs.getString(4) , rs.getString(5), rs.getString(6)));

			}
			System.out.println(AllCustomer);

			for (int i = 0; i < AllCustomer.size(); i++)
				CustomerList.add(AllCustomer.get(i));
		
			P_Name.setCellValueFactory(new PropertyValueFactory<>("C_name"));
			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
			Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			Bankst.setCellValueFactory(new PropertyValueFactory<>("Bank_Statement"));
			incomeproof.setCellValueFactory(new PropertyValueFactory<>("Income_Proof")); 
			AllView.setItems(CustomerList );

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


