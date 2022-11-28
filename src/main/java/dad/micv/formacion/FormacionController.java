package dad.micv.formacion;

import dad.micv.CV;
import dad.micv.model.Titulo;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class FormacionController {

    private FormacionView view;

    private CV cv;

    public FormacionController() {
        this.view = new FormacionView();

        view.getAddButton().setOnAction(this::onAddFormacion);
        view.getRemoveButton().setOnAction(this::removeFormacion);
    }

    private void onAddFormacion(ActionEvent event) {
        AddFormacionDialog addFormacionDialog = new AddFormacionDialog();
        Optional<Titulo> result = addFormacionDialog.showAndWait();

        result.ifPresent(titulo -> {
            cv.getFormacion().add(titulo);
        });
    }

    private void removeFormacion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Eliminar?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int index = view.getFormacionTable().getSelectionModel().getSelectedIndex();
            if (index != -1)
                cv.getFormacion().remove(index);
        }
    }

    public void loadCV(CV cv) {
        this.cv = cv;

        view.getFormacionTable().setItems(cv.getFormacion());
    }

    public void unloadCV() {
        view.getFormacionTable().setItems(null);
    }

    public FormacionView getView() {
        return view;
    }

}
