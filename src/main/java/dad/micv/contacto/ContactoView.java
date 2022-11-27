package dad.micv.contacto;

import dad.micv.CV;
import dad.micv.MiCV;
import dad.micv.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

public class ContactoView {

    private Parent root;

    @FXML
    TableView<Telefono> phoneTable;

    @FXML
    TableColumn<Telefono, String> phoneNumberColumn;

    @FXML
    TableColumn<Telefono, TipoTelefono> phoneTypeColumn;

    @FXML
    Button addPhoneButton;

    @FXML
    Button removePhoneButton;

    @FXML
    TableView<Email> emailTable;

    @FXML
    TableColumn<Email, String> emailColumn;

    @FXML
    Button addEmailButton;

    @FXML
    Button removeEmailButton;

    @FXML
    TableView<Web> urlTable;

    @FXML
    TableColumn<Web, String> urlColumn;

    @FXML
    Button addUrlButton;

    @FXML
    Button removeUrlButton;

    public ContactoView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("Contacto.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        phoneNumberColumn.setCellValueFactory(telefono -> telefono.getValue().numeroProperty());
        phoneTypeColumn.setCellValueFactory(telefono -> telefono.getValue().tipoProperty());
        emailColumn.setCellValueFactory(email -> email.getValue().direccionProperty());
        urlColumn.setCellValueFactory(web -> web.getValue().urlProperty());
    }

    public TableView<Telefono> getPhoneTable() {
        return phoneTable;
    }

    public TableView<Email> getEmailTable() {
        return emailTable;
    }

    public TableView<Web> getUrlTable() {
        return urlTable;
    }

    public Button getAddPhoneButton() {
        return addPhoneButton;
    }

    public Button getRemovePhoneButton() {
        return removePhoneButton;
    }

    public Button getAddEmailButton() {
        return addEmailButton;
    }

    public Button getRemoveEmailButton() {
        return removeEmailButton;
    }

    public Button getAddUrlButton() {
        return addUrlButton;
    }

    public Button getRemoveUrlButton() {
        return removeUrlButton;
    }

    public Parent getRoot() {
        return root;
    }

}
