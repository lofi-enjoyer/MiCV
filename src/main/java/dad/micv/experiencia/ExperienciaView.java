package dad.micv.experiencia;

import dad.micv.MiCV;
import dad.micv.model.Experiencia;
import dad.micv.model.Titulo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class ExperienciaView {

    private Parent root;

    @FXML
    TableView<Experiencia> experTable;

    @FXML
    TableColumn<Experiencia, LocalDate> sinceColumn;

    @FXML
    TableColumn<Experiencia, LocalDate> untilColumn;

    @FXML
    TableColumn<Experiencia, String> denomColumn;

    @FXML
    TableColumn<Experiencia, String> empleColumn;

    @FXML
    Button addButton;

    @FXML
    Button removeButton;

    public ExperienciaView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("Experiencia.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sinceColumn.setCellValueFactory(experiencia -> experiencia.getValue().desdeProperty());
        untilColumn.setCellValueFactory(experiencia -> experiencia.getValue().hastaProperty());
        denomColumn.setCellValueFactory(experiencia -> experiencia.getValue().denominacionProperty());
        empleColumn.setCellValueFactory(experiencia -> experiencia.getValue().empleadorProperty());
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public TableView<Experiencia> getExperTable() {
        return experTable;
    }

    public Parent getRoot() {
        return root;
    }

}
