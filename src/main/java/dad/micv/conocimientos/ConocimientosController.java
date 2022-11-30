package dad.micv.conocimientos;

import dad.micv.CV;
import dad.micv.model.Conocimiento;
import dad.micv.model.Idioma;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ConocimientosController {

    private ConocimientosView view;

    private CV cv;

    public ConocimientosController() {
        this.view = new ConocimientosView();

        view.getAddConButton().setOnAction(this::onAddConocimiento);
        view.getAddLanButton().setOnAction(this::onAddIdioma);
        view.getRemoveButton().setOnAction(this::removeConocimiento);
    }

    private void onAddConocimiento(ActionEvent event) {
        AddConocimientoDialog addConocimientoDialog = new AddConocimientoDialog();
        Optional<Conocimiento> result = addConocimientoDialog.showAndWait();

        result.ifPresent(conocimiento -> {
            cv.getHabilidades().add(conocimiento);
        });
    }

    private void onAddIdioma(ActionEvent event) {
        AddIdiomaDialog addIdiomaDialog = new AddIdiomaDialog();
        Optional<Idioma> result = addIdiomaDialog.showAndWait();

        result.ifPresent(idioma -> {
            cv.getHabilidades().add(idioma);
        });
    }

    private void removeConocimiento(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Eliminar?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int index = view.getConocTable().getSelectionModel().getSelectedIndex();
            if (index != -1)
                cv.getHabilidades().remove(index);
        }
    }

    public void loadCV(CV cv) {
        this.cv = cv;

        view.getConocTable().setItems(cv.getHabilidades());
    }

    public void unloadCV() {
        view.getConocTable().setItems(null);
    }

    public ConocimientosView getView() {
        return view;
    }

}
