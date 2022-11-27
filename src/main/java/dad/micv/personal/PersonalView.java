package dad.micv.personal;

import dad.micv.MiCV;
import dad.micv.model.Pais;
import dad.micv.model.Nacionalidad;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

public class PersonalView {

    private Parent root;

    @FXML
    TextField idTextField;

    @FXML
    TextField nameTextField;

    @FXML
    TextField surnamesTextField;

    @FXML
    DatePicker birthdateDatePicker;

    @FXML
    TextArea addressTextArea;

    @FXML
    TextField codPostalTextField;

    @FXML
    TextField localidadTextField;

    @FXML
    ComboBox<String> countryComboBox;

    @FXML
    ListView<Nacionalidad> nationsListView;

    @FXML
    Button addNationButton;

    @FXML
    Button removeNationButton;

    public PersonalView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("Personal.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getRoot() {
        return root;
    }

    public TextField getIdTextField() {
        return idTextField;
    }

    public TextField getNameTextField() {
        return nameTextField;
    }

    public TextField getSurnamesTextField() {
        return surnamesTextField;
    }

    public DatePicker getBirthdateDatePicker() {
        return birthdateDatePicker;
    }

    public TextArea getAddressTextArea() {
        return addressTextArea;
    }

    public TextField getCodPostalTextField() {
        return codPostalTextField;
    }

    public TextField getLocalidadTextField() {
        return localidadTextField;
    }

    public ComboBox<String> getCountryComboBox() {
        return countryComboBox;
    }

    public ListView<Nacionalidad> getNationsListView() {
        return nationsListView;
    }

    public Button getAddNationButton() {
        return addNationButton;
    }

    public Button getRemoveNationButton() {
        return removeNationButton;
    }

}
