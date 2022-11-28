package dad.micv.formacion;

import dad.micv.MiCV;
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

public class AddFormacionDialog extends Dialog<Titulo> {

    private Parent root;

    @FXML
    TextField denomTextField;

    @FXML
    TextField organTextField;

    @FXML
    DatePicker sinceDatePicker;

    @FXML
    DatePicker untilDatePicker;

    private StringProperty denomProperty = new SimpleStringProperty();
    private StringProperty organProperty = new SimpleStringProperty();
    private ObjectProperty<LocalDate> sinceProperty = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> untilProperty = new SimpleObjectProperty<>();

    public AddFormacionDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(MiCV.class.getResource("NuevaFormacion.fxml"));
            loader.setController(this);
            this.root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ButtonType addButtonType = new ButtonType("Añadir", ButtonBar.ButtonData.OK_DONE);

        setTitle("Añadir formación");
        getDialogPane().setContent(root);
        getDialogPane().getButtonTypes().setAll(addButtonType, ButtonType.CANCEL);

        setResultConverter(this::getConverter);

        denomProperty.bind(denomTextField.textProperty());
        organProperty.bind(organTextField.textProperty());
        sinceProperty.bind(sinceDatePicker.valueProperty());
        untilProperty.bind(untilDatePicker.valueProperty());
    }

    private Titulo getConverter(ButtonType button) {
        if (button.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            Titulo titulo = new Titulo();
            titulo.setDenominacion(denomProperty.get());
            titulo.setDesde(sinceProperty.get());
            titulo.setHasta(untilProperty.get());
            titulo.setOrganizador(organProperty.get());
            return titulo;
        }
        return null;
    }

}
