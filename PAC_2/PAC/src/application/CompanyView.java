
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

public class CompanyView implements Initializable {

	@FXML
	private TableView <Company> CustomerView ;
	@FXML
	private TableColumn <Company, Integer> Customer_ID ;
	@FXML
	private TableColumn <Company, String> C_Name;
	@FXML
	private TableColumn <Company, String> Address;
	@FXML
	private TableColumn <Company, Integer> Phone;
	@FXML
	private Button Back;


	ObservableList<Company> CompanyList = FXCollections.observableArrayList();
	public static ArrayList<Company> Company = new ArrayList<Company>();
	ResultSet rs;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {

			rs = DB_Connection.select("select * from Company");
			Company.clear();

			while (rs.next()) {

				Company.add(new Company(Integer.parseInt(rs.getString(1)),rs.getString(2)));

			}
			System.out.println(Company);
		                
			for (int i = 0; i < Company.size(); i++)
				CompanyList.add(Company.get(i));
			
			Customer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
			C_Name.setCellValueFactory(new PropertyValueFactory<>("C_Name"));
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
			
			CustomerView.setItems(CompanyList);
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

