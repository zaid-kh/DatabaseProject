package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SalesmenStatsController implements Initializable {
	@FXML
	private TextField numOfSalesmen;
	@FXML
	private TextField citySalesmenTF;
	@FXML
	private TextField mostSalesTF;
	@FXML
	private TableView salesmenTable;
	@FXML
	private TableColumn job_idCol;
	@FXML
	private TableColumn nameCol;
	@FXML
	private TableColumn idCol;
	@FXML
	private TableColumn phoneCol;
	@FXML
	private TableColumn addressCol;
	@FXML
	private Button backB;
	ResultSet rs;

	public void backToStatMain(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("StatsMain.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int sum;
		try {
			// most expensive
			rs = DB_Connection.select("select count(*) from Salesmen s;");
			if (rs.next())
				numOfSalesmen.setText(rs.getString(1));
			else
				numOfSalesmen.setText("-");
//			// num of cars in brand
//			rs = DB_Connection.select("select count(*) from car e where e.C_Brand = \"" + getBrandName() + "\" ;");
//			if (rs.next())
//				numOfBrandsTF.setText(rs.getString(1));
//			else
//				numOfBrandsTF.setText("-");
			// total profit since the beginning of year
//			rs = DB_Connection.select("SELECT MAX(c.count) , c.Address  FROM (SELECT E.Address, COUNT(E.Job_ID) AS count FROM Salesmen E GROUP BY E.Address ORDER BY 2 DESC) c;");
//			if (rs.next())
//                                mostSalesTF.setText(rs.getString(2));
//			else
//				mostSalesTF.setText("-");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
