package dad.micv.contacto;

import dad.micv.MiCV;
import dad.micv.model.Email;
import dad.micv.model.Web;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

public class AddWebDialog extends Dialog<Web> {

    private Parent root;

    @FXML
    TextField urlTextField;

    private StringProperty urlProperty = new SimpleStringProperty();

    public AddWebDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("AddWeb.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ButtonType addButtonType = new ButtonType("Añadir", ButtonBar.ButtonData.OK_DONE);

        setTitle("Añadir web");
        getDialogPane().setContent(root);
        getDialogPane().getButtonTypes().setAll(addButtonType, ButtonType.CANCEL);

        setResultConverter(this::getConverter);

        urlProperty.bind(urlTextField.textProperty());
    }

    private Web getConverter(ButtonType buttonType) {
        if (buttonType.getButtonData() != ButtonBar.ButtonData.OK_DONE)
            return null;

        Web web = new Web();
        web.setUrl(urlProperty.get());
        return web;
    }

}
