package dad.micv;

import dad.micv.model.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

public class CV {

    private final ObjectProperty<Personal> personal;
    private final ObjectProperty<Contacto> contacto;
    private final ObservableList<Titulo> formacion;
    private final ObservableList<Experiencia> experiencias;
    private final ObservableList<Conocimiento> habilidades;

    public CV() {
        this.personal = new SimpleObjectProperty<>(new Personal());
        this.contacto = new SimpleObjectProperty<>(new Contacto());
        this.formacion = new SimpleListProperty<>();
        this.experiencias = new SimpleListProperty<>();
        this.habilidades = new SimpleListProperty<>();
    }

    public Personal getPersonal() {
        return personal.get();
    }

    public Contacto getContacto() {
        return contacto.get();
    }

    public ObjectProperty<Personal> personalProperty() {
        return personal;
    }

    public ObservableList<Titulo> getFormacion() {
        return formacion;
    }

    public ObservableList<Experiencia> getExperiencias() {
        return experiencias;
    }

    public ObservableList<Conocimiento> getHabilidades() {
        return habilidades;
    }

}
