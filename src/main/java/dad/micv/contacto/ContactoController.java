package dad.micv.contacto;

import dad.micv.CV;
import dad.micv.model.Telefono;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ContactoController {

    private final ContactoView view;

    private CV cv;

    public ContactoController() {
        this.view = new ContactoView();

        view.getAddPhoneButton().setOnAction(this::addPhone);
        view.getRemovePhoneButton().setOnAction(this::removePhone);

        view.getAddEmailButton().setOnAction(this::addEmail);
        view.getRemoveEmailButton().setOnAction(this::removeEmail);

        view.getAddUrlButton().setOnAction(this::addWeb);
        view.getRemoveUrlButton().setOnAction(this::removeWeb);
    }

    private void addPhone(ActionEvent event) {
        AddPhoneDialog addPhoneDialog = new AddPhoneDialog();
        Optional<Telefono> result = addPhoneDialog.showAndWait();

        result.ifPresent(telefono -> {
            cv.getContacto().getTelefonos().add(telefono);
        });
    }

    private void removePhone(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Eliminar?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int index = view.getPhoneTable().getSelectionModel().getSelectedIndex();
            if (index != -1)
                cv.getContacto().getTelefonos().remove(index);
        }
    }

    private void addEmail(ActionEvent event) {

    }

    private void removeEmail(ActionEvent event) {

    }

    private void addWeb(ActionEvent event) {

    }

    private void removeWeb(ActionEvent event) {

    }

    public void loadCV(CV cv) {
        this.cv = cv;

        view.getPhoneTable().setItems(cv.getContacto().getTelefonos());
        view.getEmailTable().setItems(cv.getContacto().getEmails());
        view.getUrlTable().setItems(cv.getContacto().getWebs());
    }

    public void unloadCV() {
        this.cv = null;

        view.getPhoneTable().setItems(null);
        view.getEmailTable().setItems(null);
        view.getUrlTable().setItems(null);
    }

    public ContactoView getView() {
        return view;
    }

}
