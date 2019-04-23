package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class MainController {
	@FXML
	private TableView<Person> tableView;

	@FXML
	private TableColumn<Person, String> name;

	@FXML
	private TableColumn<Person, String> age;

	@FXML
	private TableColumn<Person, String> email;

	@FXML
	private TableColumn<Person, String> gender;

	@FXML
	private JFXButton addButton;

	private Group group;

	private final ObservableList<Person> data = FXCollections
			.observableArrayList(new Person("Name", "Age", "Email", "Male"));

	@FXML
	public void initialize() {
		/*MenuBar menuBar = new MenuBar();
		
		if (System.getProperty("os.name", "UNKNOWN").equals("Mac OS X")) {
			menuBar.setUseSystemMenuBar(true);
		}*/
		
		group = new Group();
		group.addPerson(data.get(0));

		// Set the column of table
		name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> param) {
				return param.getValue().getName();
			}
		});
		age.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> param) {
				return param.getValue().getAge();
			}
		});
		email.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> param) {
						return param.getValue().getEmail();
					}
				});
		gender.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> param) {
						return param.getValue().getGender();
					}
				});

		// Set editable cells
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
			public void handle(javafx.scene.control.TableColumn.CellEditEvent<Person, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
			}
		});
		age.setCellFactory(TextFieldTableCell.forTableColumn());
		age.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
			public void handle(javafx.scene.control.TableColumn.CellEditEvent<Person, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setAge(event.getNewValue());
			}
		});
		email.setCellFactory(TextFieldTableCell.forTableColumn());
		email.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
			public void handle(javafx.scene.control.TableColumn.CellEditEvent<Person, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setEmail(event.getNewValue());
			}
		});

		// Gender Combo Box
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("Male");
		list.add("Female");

		gender.setCellFactory(ComboBoxTableCell.forTableColumn(list));

		tableView.setEditable(true);
		tableView.setItems(data);
	}

	public void addButtonClicked() {
		Person person = new Person("Name", "Age", "Email", "Male");
		tableView.getItems().add(person);
		group.addPerson(person);
	}

	public void deleteButtonClicked() {
		Person selectedItem = tableView.getSelectionModel().getSelectedItem();
		tableView.getItems().remove(selectedItem);
	}

	public void addGroupButtonClicked() {
		Group group = new Group();
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GroupPopUp.fxml"));
		//Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		
		stage.setTitle("Group");
	}

	public void deleteGroupButtonClicked() {
		Person person = new Person("Blank", "Blank", "Blank", "Male");
		tableView.getItems().add(person);
	}
}
