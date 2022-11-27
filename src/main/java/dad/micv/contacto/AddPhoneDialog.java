package dad.micv.contacto;

import dad.micv.MiCV;
import dad.micv.model.Telefono;
import dad.micv.model.TipoTelefono;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

public class AddPhoneDialog extends Dialog<Telefono> {

    private Parent root;

    @FXML
    TextField phoneTextField;

    @FXML
    ComboBox<TipoTelefono> typeComboBox;

    private StringProperty phoneProperty = new SimpleStringProperty();
    private ObjectProperty<TipoTelefono> typeProperty = new SimpleObjectProperty<>(TipoTelefono.DOMICILIO);

    public AddPhoneDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("AddPhone.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ButtonType addButtonType = new ButtonType("Añadir", ButtonBar.ButtonData.OK_DONE);

        setTitle("Nuevo teléfono");
        setHeaderText("Introduzca el nuevo número de teléfono.");
        getDialogPane().setContent(root);
        getDialogPane().getButtonTypes().setAll(addButtonType, ButtonType.CANCEL);

        setResultConverter(this::getConverter);

        typeComboBox.getItems().setAll(TipoTelefono.values());

        phoneProperty.bind(phoneTextField.textProperty());
        typeProperty.bind(typeComboBox.getSelectionModel().selectedItemProperty());

        Button addButton = (Button) getDialogPane().lookupButton(addButtonType);
        addButton.disableProperty().bind(phoneProperty.isEmpty().or(typeProperty.isNull()));
    }

    private Telefono getConverter(ButtonType buttonType) {
        if (buttonType.getButtonData() != ButtonBar.ButtonData.OK_DONE)
            return null;

        Telefono telefono = new Telefono();
        telefono.setNumero(phoneProperty.get());
        telefono.setTipo(typeProperty.get());
        return telefono;
    }

}
