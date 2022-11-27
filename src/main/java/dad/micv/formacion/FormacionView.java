package dad.micv.formacion;

import dad.micv.CV;
import dad.micv.MiCV;
import dad.micv.model.Titulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.time.LocalDate;

public class FormacionView {

    private Parent root;

    @FXML
    TableView<Titulo> formacionTable;

    @FXML
    TableColumn<Titulo, LocalDate> sinceColumn;

    @FXML
    TableColumn<Titulo, LocalDate> untilColumn;

    @FXML
    TableColumn<Titulo, String> denomColumn;

    @FXML
    TableColumn<Titulo, String> organColumn;

    public FormacionView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("Formacion.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sinceColumn.setCellValueFactory(formacion -> formacion.getValue().desdeProperty());
        untilColumn.setCellValueFactory(formacion -> formacion.getValue().hastaProperty());
        denomColumn.setCellValueFactory(formacion -> formacion.getValue().denominacionProperty());
        organColumn.setCellValueFactory(formacion -> formacion.getValue().organizadorProperty());
    }

    public TableView<Titulo> getFormacionTable() {
        return formacionTable;
    }

    public Parent getRoot() {
        return root;
    }

}
