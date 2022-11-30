package dad.micv.conocimientos;

import dad.micv.MiCV;
import dad.micv.model.Conocimiento;
import dad.micv.model.Nivel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ConocimientosView {

    private Parent root;

    @FXML
    TableView<Conocimiento> conocTable;

    @FXML
    TableColumn<Conocimiento, String> denomColumn;

    @FXML
    TableColumn<Conocimiento, Nivel> levelColumn;

    @FXML
    Button addConButton;

    @FXML
    Button addLanButton;

    @FXML
    Button removeButton;

    public ConocimientosView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("Conocimientos.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        denomColumn.setCellValueFactory(conocimiento -> conocimiento.getValue().denominacionProperty());
        levelColumn.setCellValueFactory(conocimiento -> conocimiento.getValue().nivelProperty());
    }

    public Button getAddConButton() {
        return addConButton;
    }

    public Button getAddLanButton() {
        return addLanButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public TableView<Conocimiento> getConocTable() {
        return conocTable;
    }

    public Parent getRoot() {
        return root;
    }

}
