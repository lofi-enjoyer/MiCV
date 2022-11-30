package dad.micv.experiencia;

import dad.micv.CV;
import dad.micv.formacion.AddFormacionDialog;
import dad.micv.model.Experiencia;
import dad.micv.model.Titulo;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ExperienciaController {

    private ExperienciaView view;

    private CV cv;

    public ExperienciaController() {
        this.view = new ExperienciaView();

        view.getAddButton().setOnAction(this::onAddExperiencia);
        view.getRemoveButton().setOnAction(this::removeExperiencia);
    }

    private void onAddExperiencia(ActionEvent event) {
        AddExperienciaDialog addExperienciaDialog = new AddExperienciaDialog();
        Optional<Experiencia> result = addExperienciaDialog.showAndWait();

        result.ifPresent(experiencia -> {
            cv.getExperiencias().add(experiencia);
        });
    }

    private void removeExperiencia(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Eliminar?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int index = view.getExperTable().getSelectionModel().getSelectedIndex();
            if (index != -1)
                cv.getExperiencias().remove(index);
        }
    }

    public void loadCV(CV cv) {
        this.cv = cv;

        view.getExperTable().setItems(cv.getExperiencias());
    }

    public void unloadCV() {
        view.getExperTable().setItems(null);
    }

    public ExperienciaView getView() {
        return view;
    }

}
