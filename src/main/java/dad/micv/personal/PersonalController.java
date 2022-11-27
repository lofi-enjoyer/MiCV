package dad.micv.personal;

import dad.micv.CV;
import dad.micv.RootController;
import dad.micv.model.Nacionalidad;
import dad.micv.model.Personal;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceDialog;

import java.util.Optional;

public class PersonalController {

    private RootController rootController;

    private final PersonalView view;
    private CV cv;

    public PersonalController(RootController rootController) {
        this.rootController = rootController;

        this.view = new PersonalView();

        view.getAddNationButton().setOnAction(this::addNation);
        view.getRemoveNationButton().setOnAction(this::removeNation);

        view.getCountryComboBox().setItems(rootController.getPaisList());
    }

    private void addNation(ActionEvent event) {
        ChoiceDialog<Nacionalidad> dialog = new ChoiceDialog<>(rootController.getNacionalidadList().get(0), rootController.getNacionalidadList());
        dialog.setTitle("Nueva nacionalidad");
        dialog.setHeaderText("Añadir nacionalidad");
        dialog.setContentText("Seleccione una nacionalidad:");
        Optional<Nacionalidad> result = dialog.showAndWait();

        result.ifPresent(nation -> {
            cv.getPersonal().getNacionalidades().add(nation);
        });
    }

    private void removeNation(ActionEvent event) {
        int index = view.getNationsListView().getSelectionModel().getSelectedIndex();
        if (index != -1)
            cv.getPersonal().getNacionalidades().remove(index);
    }

    public void loadCV(CV cv) {
        this.cv = cv;

        Personal personal = cv.getPersonal();

        view.getIdTextField().textProperty().bindBidirectional(personal.identificacionProperty());
        view.getNameTextField().textProperty().bindBidirectional(personal.nombreProperty());
        view.getSurnamesTextField().textProperty().bindBidirectional(personal.apellidosProperty());
        view.getAddressTextArea().textProperty().bindBidirectional(personal.direccionProperty());
        view.getCodPostalTextField().textProperty().bindBidirectional(personal.codigoPostalProperty());
        view.getLocalidadTextField().textProperty().bindBidirectional(personal.localidadProperty());
        view.getBirthdateDatePicker().valueProperty().bindBidirectional(personal.fechaNacimientoProperty());
        view.getCountryComboBox().valueProperty().bindBidirectional(personal.paisProperty());
        view.getNationsListView().itemsProperty().bind(new SimpleObjectProperty<>(personal.getNacionalidades()));
    }

    public void unloadCV() {
        view.getIdTextField().textProperty().unbind();
        view.getNameTextField().textProperty().unbind();
        view.getSurnamesTextField().textProperty().unbind();
        view.getAddressTextArea().textProperty().unbind();
        view.getCodPostalTextField().textProperty().unbind();
        view.getLocalidadTextField().textProperty().unbind();
        view.getBirthdateDatePicker().valueProperty().unbind();
        view.getCountryComboBox().valueProperty().unbind();
        view.getNationsListView().itemsProperty().unbind();
    }

    public PersonalView getView() {
        return view;
    }

}
