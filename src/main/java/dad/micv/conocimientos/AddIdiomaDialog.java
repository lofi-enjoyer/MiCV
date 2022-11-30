package dad.micv.conocimientos;

import dad.micv.MiCV;
import dad.micv.model.Conocimiento;
import dad.micv.model.Idioma;
import dad.micv.model.Nivel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

public class AddIdiomaDialog extends Dialog<Idioma> {

    private Parent root;

    @FXML
    TextField denomTextField;

    @FXML
    ComboBox<Nivel> levelComboBox;

    @FXML
    TextField certiTextField;

    private StringProperty denomProperty = new SimpleStringProperty();
    private ObjectProperty<Nivel> levelProperty = new SimpleObjectProperty<>();
    private StringProperty certiProperty = new SimpleStringProperty();

    public AddIdiomaDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(MiCV.class.getResource("NuevoIdioma.fxml"));
            loader.setController(this);
            this.root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ButtonType addButtonType = new ButtonType("Añadir", ButtonBar.ButtonData.OK_DONE);

        setTitle("Añadir idioma");
        getDialogPane().setContent(root);
        getDialogPane().getButtonTypes().setAll(addButtonType, ButtonType.CANCEL);

        setResultConverter(this::getConverter);

        denomProperty.bind(denomTextField.textProperty());
        levelProperty.bind(levelComboBox.valueProperty());
        certiProperty.bind(certiTextField.textProperty());

        ObservableList<Nivel> levelList = FXCollections.observableArrayList();
        levelList.addAll(Nivel.values());
        levelComboBox.setItems(levelList);
    }

    private Idioma getConverter(ButtonType button) {
        if (button.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            Idioma idioma = new Idioma();
            idioma.setDenominacion(denomProperty.get());
            idioma.setNivel(levelProperty.get());
            idioma.setCertificacion(certiProperty.get());
            return idioma;
        }
        return null;
    }

}
