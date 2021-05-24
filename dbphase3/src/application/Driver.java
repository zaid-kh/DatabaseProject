package application;

import static javafx.stage.Modality.NONE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.IntegerStringConverter;

/**
 * A JavaFX ConnectDB Application
 */
public class Driver extends Application {

	private ArrayList<Salesmen> data;
	private ObservableList<Salesmen> dataList;

	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "zaid333";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "PAC";
	private Connection con;

	public static void main(String[] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		data = new ArrayList<>();

		try {

			getData();

			// convert data from arraylist to observable arraylist
			dataList = FXCollections.observableArrayList(data);

			// really bad method
			tableView(stage);
			stage.show();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")

	private void tableView(Stage stage) {

		TableView<Salesmen> myDataTable = new TableView<Salesmen>();

		Scene scene = new Scene(new Group());
		stage.setTitle("PAC Table");
		stage.setWidth(550);
		stage.setHeight(500);

		Label label = new Label("PAC Table");
		label.setFont(new Font("Times New Roman", 20));
		label.setTextFill(Color.ROSYBROWN);

		myDataTable.setEditable(true);
		myDataTable.setMaxHeight(200);
		myDataTable.setMaxWidth(450);

		// name of column for display
		TableColumn<Salesmen, Integer> Job_IDCol = new TableColumn<Salesmen, Integer>("Job_ID");
		Job_IDCol.setMinWidth(50);

		// to get the data from specific column
		Job_IDCol.setCellValueFactory(new PropertyValueFactory<Salesmen, Integer>("Job_ID"));

		TableColumn<Salesmen, String> snameCol = new TableColumn<Salesmen, String>("Sname");
		snameCol.setMinWidth(100);
		snameCol.setCellValueFactory(new PropertyValueFactory<Salesmen, String>("Sname"));

		/*
		 * & snameCol .setCellFactory(TextFieldTableCell.<Salesmen>forTableColumn());
		 * snameCol .setOnEditCommit( (CellEditEvent<Salesmen, String> t) -> {
		 * ((Salesmen) t.getTableView().getItems().get( t.getTablePosition().getRow())
		 * ).setsname(t.getNewValue()); //display only updateName(
		 * t.getRowValue().getJob_ID(),t.getNewValue()); });
		 * 
		 */

		TableColumn<Salesmen, Integer> S_IDCol = new TableColumn<Salesmen, Integer>("S_ID");
		S_IDCol.setMinWidth(50);
		S_IDCol.setCellValueFactory(new PropertyValueFactory<Salesmen, Integer>("S_ID"));

		/*
		 * S_IDCol.setCellFactory(TextFieldTableCell.<PPhase3,Integer>
		 * forTableColumn(new IntegerStringConverter()));
		 * 
		 * S_IDCol.setOnEditCommit( (CellEditEvent<PPhase3, Integer> t) -> { ((PPhase3)
		 * t.getTableView().getItems().get( t.getTablePosition().getRow())
		 * ).setAge(t.getNewValue()); updateAge(
		 * t.getRowValue().getJob_ID(),t.getNewValue()); });
		 */

		TableColumn<Salesmen, String> AddressCol = new TableColumn<Salesmen, String>("Address");
		AddressCol.setMinWidth(100);
		AddressCol.setCellValueFactory(new PropertyValueFactory<Salesmen, String>("Address"));

		/*
		 * AddressCol.setCellFactory(TextFieldTableCell.<PPhase3>forTableColumn());
		 * AddressCol.setOnEditCommit( (CellEditEvent<PPhase3, String> t) -> {
		 * ((PPhase3) t.getTableView().getItems().get( t.getTablePosition().getRow())
		 * ).setMajor(t.getNewValue()); updateMajor(
		 * t.getRowValue().getJob_ID(),t.getNewValue()); });
		 */

		TableColumn<Salesmen, String> PhoneCol = new TableColumn<Salesmen, String>("Phone");
		PhoneCol.setMinWidth(100);
		PhoneCol.setCellValueFactory(new PropertyValueFactory<Salesmen, String>("Phone"));

		/*
		 * PhoneCol.setCellFactory(TextFieldTableCell.<PPhase3>forTableColumn());
		 * PhoneCol.setOnEditCommit( (CellEditEvent<PPhase3, String> t) -> { ((PPhase3)
		 * t.getTableView().getItems().get( t.getTablePosition().getRow())
		 * ).setMajor(t.getNewValue()); updateLevel(
		 * t.getRowValue().getJob_ID(),t.getNewValue()); });
		 */

		myDataTable.setItems(dataList);

		myDataTable.getColumns().addAll(Job_IDCol, snameCol, S_IDCol, AddressCol, PhoneCol);

		final TextField addJob_ID = new TextField();
		addJob_ID.setPromptText("Job_ID");
		addJob_ID.setMaxWidth(Job_IDCol.getPrefWidth());

		final TextField addsname = new TextField();
		addsname.setMaxWidth(snameCol.getPrefWidth());
		addsname.setPromptText("sname");

		final TextField addS_ID = new TextField();
		addS_ID.setMaxWidth(S_IDCol.getPrefWidth());
		addS_ID.setPromptText("S_ID");

		final TextField addAddress = new TextField();
		addAddress.setMaxWidth(AddressCol.getPrefWidth());
		addAddress.setPromptText("Address");

		final TextField addPhone = new TextField();
		addPhone.setMaxWidth(AddressCol.getPrefWidth());
		addPhone.setPromptText("Phone");

		final Button addButton = new Button("Add");
		addButton.setOnAction((ActionEvent e) -> {
			Salesmen rc;
			rc = new Salesmen(Integer.valueOf(addJob_ID.getText()), addsname.getText(),
					Integer.valueOf(addS_ID.getText()), addAddress.getText(), Integer.valueOf(addPhone.getText()));
			dataList.add(rc);
			insertData(rc);
			addJob_ID.clear();
			addsname.clear();
			addS_ID.clear();
			addAddress.clear();
			addPhone.clear();
		});

		final HBox hb = new HBox();

		final Button deleteButton = new Button("Delete");
		deleteButton.setOnAction((ActionEvent e) -> {
			ObservableList<Salesmen> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
			ArrayList<Salesmen> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				myDataTable.getItems().remove(row);
				deleteRow(row);
				myDataTable.refresh();
			});
		});

		hb.getChildren().addAll(addJob_ID, addsname, addS_ID, addAddress, addPhone, addButton, deleteButton);
		hb.setSpacing(3);

		final Button refreshButton = new Button("Refresh");
		refreshButton.setOnAction((ActionEvent e) -> {
			myDataTable.refresh();
		});

//		Button ownedNoneButton = new Button("Owned None");
//		ownedNoneButton.setOnAction(c -> );

		final Button clearButton = new Button("Clear All");
		clearButton.setOnAction((ActionEvent e) -> {
			showDialog(stage, NONE, myDataTable);

		});

		final HBox hb2 = new HBox();
		hb2.getChildren().addAll(clearButton, refreshButton);
		hb2.setAlignment(Pos.CENTER_RIGHT);
		hb2.setSpacing(3);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(label, myDataTable, hb, hb2);

		((Group) scene.getRoot()).getChildren().addAll(vbox);
		stage.setScene(scene);
	}

	/** MODIFY/USE WITH OTHERS **/
	private void insertData(Salesmen rc) {

		try {
			System.out.println("Insert into salesmen (Job_ID,sname,Address, S_ID, Phone) values(" + rc.getJob_ID()
					+ ",'" + rc.getSname() + "','" + rc.getAddress() + "'," + rc.getS_ID() + ", '" + rc.getPhone()
					+ "')");

			System.out.println("----------" + rc.getJob_ID() + ",'" + rc.getSname() + "','" + rc.getAddress() + "',"
					+ rc.getS_ID() + ", '" + rc.getPhone() + "')");

			connectDB();
			ExecuteStatement("Insert into salesmen (Job_ID,sname,Address, S_ID, Phone) values(" + rc.getJob_ID() + ",'"
					+ rc.getSname() + "','" + rc.getAddress() + "'," + rc.getS_ID() + ", '" + rc.getPhone() + "')");

			con.close();
			System.out.println("Connection closed" + data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/** MODIFY/USE WITH OTHERS **/
	private void getData() throws SQLException, ClassNotFoundException {

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select Job_ID,sname,S_ID, Address, Phone from salesmen order by Job_ID";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		System.out.println("###############################3");

		while (rs.next())
			data.add(new Salesmen(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)),
					rs.getString(4), Integer.parseInt(rs.getString(5))));

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());

	}

	/** keep this **/
	private void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	/** keep this **/
	public void ExecuteStatement(String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");

		}

	}

	public void updateName(int Job_ID, String sname) {

		try {
			System.out.println("update  salesmen set sname = '" + sname + "' where Job_ID = " + Job_ID);
			connectDB();
			ExecuteStatement("update  salesmen set sname = '" + sname + "' where Job_ID = " + Job_ID + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateAge(int Job_ID, int S_ID) {

		try {
			System.out.println("update  salesmen set S_ID = " + S_ID + " where Job_ID = " + Job_ID);
			connectDB();
			ExecuteStatement("update  salesmen set S_ID = " + S_ID + " where Job_ID = " + Job_ID + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateMajor(int Job_ID, String Address) {

		try {
			System.out.println("update  salesmen set Address = '" + Address + "' where Job_ID = " + Job_ID);
			connectDB();
			ExecuteStatement("update  salesmen set Address = '" + Address + "' where Job_ID = " + Job_ID + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateLevel(int Job_ID, String Phone) {

		try {
			System.out.println("update  salesmen set Phone = '" + Phone + "' where Job_ID = " + Job_ID);
			connectDB();
			ExecuteStatement("update  salesmen set Phone = '" + Phone + "' where Job_ID = " + Job_ID + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteRow(Salesmen row) {
		// TODO Auto-generated method stub

		try {
			System.out.println("delete from  salesmen where Job_ID=" + row.getJob_ID() + ";");
			connectDB();
			ExecuteStatement("delete from  salesmen where Job_ID=" + row.getJob_ID() + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void showDialog(Window owner, Modality modality, TableView<Salesmen> table) {
		// Create a Stage with specified owner and modality
		Stage stage = new Stage();
		stage.initOwner(owner);
		stage.initModality(modality);
		// Label modalityLabel = new Label(modality.toString());

		Button yesButton = new Button("Confirm");
		yesButton.setOnAction(e -> {
			for (Salesmen row : dataList) {
				deleteRow(row);
				table.refresh();
			}
			table.getItems().removeAll(dataList);
			stage.close();

		});

		Button noButton = new Button("Cancel");
		noButton.setOnAction(e -> stage.close());

		HBox root = new HBox();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);

		root.getChildren().addAll(yesButton, noButton);
		Scene scene = new Scene(root, 200, 100);
		stage.setScene(scene);
		stage.setTitle("Confirm Delete?");
		stage.show();
	}
}