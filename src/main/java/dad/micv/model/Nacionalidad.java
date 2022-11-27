package dad.micv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {

    private StringProperty denominacion;

    public Nacionalidad() {
        this.denominacion = new SimpleStringProperty();
    }

    public Nacionalidad(String denominacion) {
        this.denominacion = new SimpleStringProperty(denominacion);
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

    @Override
    public String toString() {
        return denominacion.get();
    }
}
