package dad.micv.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma extends Conocimiento {

    private StringProperty certificacion;

    public Idioma() {
        this.certificacion = new SimpleStringProperty();
    }

    public String getCertificacion() {
        return certificacion.get();
    }

    public StringProperty certificacionProperty() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion.set(certificacion);
    }

}
