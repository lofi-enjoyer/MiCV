package dad.micv.experiencia;

import dad.micv.MiCV;
import dad.micv.model.Experiencia;
import dad.micv.model.Titulo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class AddExperienciaDialog extends Dialog<Experiencia> {

    private Parent root;

    @FXML
    TextField denomTextField;

    @FXML
    TextField empleTextField;

    @FXML
    DatePicker sinceDatePicker;

    @FXML
    DatePicker untilDatePicker;

    private StringProperty denomProperty = new SimpleStringProperty();
    private StringProperty empleProperty = new SimpleStringProperty();
    private ObjectProperty<LocalDate> sinceProperty = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> untilProperty = new SimpleObjectProperty<>();

    public AddExperienciaDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(MiCV.class.getResource("NuevaExperiencia.fxml"));
            loader.setController(this);
            this.root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ButtonType addButtonType = new ButtonType("Añadir", ButtonBar.ButtonData.OK_DONE);

        setTitle("Añadir experiencia");
        getDialogPane().setContent(root);
        getDialogPane().getButtonTypes().setAll(addButtonType, ButtonType.CANCEL);

        setResultConverter(this::getConverter);

        denomProperty.bind(denomTextField.textProperty());
        empleProperty.bind(empleTextField.textProperty());
        sinceProperty.bind(sinceDatePicker.valueProperty());
        untilProperty.bind(untilDatePicker.valueProperty());
    }

    private Experiencia getConverter(ButtonType button) {
        if (button.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            Experiencia experiencia = new Experiencia();
            experiencia.setDenominacion(denomProperty.get());
            experiencia.setDesde(sinceProperty.get());
            experiencia.setHasta(untilProperty.get());
            experiencia.setEmpleador(empleProperty.get());
            return experiencia;
        }
        return null;
    }

}
