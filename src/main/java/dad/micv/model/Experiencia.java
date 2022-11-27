package dad.micv.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Experiencia {

    private ObjectProperty<LocalDate> desde;
    private ObjectProperty<LocalDate> hasta;
    private StringProperty denominacion;
    private StringProperty empleador;

    public Experiencia() {
        this.desde = new SimpleObjectProperty<>();
        this.hasta = new SimpleObjectProperty<>();
        this.denominacion = new SimpleStringProperty();
        this.empleador = new SimpleStringProperty();
    }

    public LocalDate getDesde() {
        return desde.get();
    }

    public ObjectProperty<LocalDate> desdeProperty() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde.set(desde);
    }

    public LocalDate getHasta() {
        return hasta.get();
    }

    public ObjectProperty<LocalDate> hastaProperty() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta.set(hasta);
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

    public String getEmpleador() {
        return empleador.get();
    }

    public StringProperty empleadorProperty() {
        return empleador;
    }

    public void setEmpleador(String empleador) {
        this.empleador.set(empleador);
    }

}
