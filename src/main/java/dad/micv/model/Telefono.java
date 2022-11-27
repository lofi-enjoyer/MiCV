package dad.micv.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefono {

    private StringProperty numero;
    private ObjectProperty<TipoTelefono> tipo;

    public Telefono(String numero) {
        this.numero = new SimpleStringProperty(numero);
        this.tipo = new SimpleObjectProperty<>(TipoTelefono.DOMICILIO);
    }

    public Telefono() {
        this("");
    }

    public String getNumero() {
        return numero.get();
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public TipoTelefono getTipo() {
        return tipo.get();
    }

    public ObjectProperty<TipoTelefono> tipoProperty() {
        return tipo;
    }

    public void setTipo(TipoTelefono tipo) {
        this.tipo.set(tipo);
    }

}
