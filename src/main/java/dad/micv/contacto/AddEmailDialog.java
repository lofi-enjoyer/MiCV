package dad.micv.contacto;

import dad.micv.MiCV;
import dad.micv.model.Email;
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

public class AddEmailDialog extends Dialog<Email> {

    private Parent root;

    @FXML
    TextField emailTextField;

    private StringProperty emailProperty = new SimpleStringProperty();

    public AddEmailDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("AddEmail.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ButtonType addButtonType = new ButtonType("Añadir", ButtonBar.ButtonData.OK_DONE);

        setTitle("Añadir email");
        getDialogPane().setContent(root);
        getDialogPane().getButtonTypes().setAll(addButtonType, ButtonType.CANCEL);

        setResultConverter(this::getConverter);

        emailProperty.bind(emailTextField.textProperty());
    }

    private Email getConverter(ButtonType buttonType) {
        if (buttonType.getButtonData() != ButtonBar.ButtonData.OK_DONE)
            return null;

        Email email = new Email();
        email.setDireccion(emailProperty.get());
        return email;
    }

}
