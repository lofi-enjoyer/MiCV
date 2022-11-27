package dad.micv.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {

    private StringProperty denominacion;
    private ObjectProperty<Nivel> nivel;

    public Conocimiento() {
        this.denominacion = new SimpleStringProperty();
        this.nivel = new SimpleObjectProperty<>();
    }

    public String getDenominacion() {
        return denominacion.get();
    }

    public StringProperty denominacionProperty() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion.set(denominacion);
    }

    public Nivel getNivel() {
        return nivel.get();
    }

    public ObjectProperty<Nivel> nivelProperty() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel.set(nivel);
    }

}
