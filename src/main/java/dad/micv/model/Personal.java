package dad.micv.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Personal {

    private StringProperty identificacion;
    private StringProperty nombre;
    private StringProperty apellidos;
    private ObjectProperty<LocalDate> fechaNacimiento;
    private StringProperty direccion;
    private StringProperty codigoPostal;
    private StringProperty localidad;
    private StringProperty pais;
    private ObservableList<Nacionalidad> nacionalidades;

    public Personal() {
        this.identificacion = new SimpleStringProperty();
        this.nombre = new SimpleStringProperty();
        this.apellidos = new SimpleStringProperty();
        this.fechaNacimiento = new SimpleObjectProperty<>();
        this.direccion = new SimpleStringProperty();
        this.codigoPostal = new SimpleStringProperty();
        this.localidad = new SimpleStringProperty();
        this.pais = new SimpleStringProperty();
        this.nacionalidades = FXCollections.observableArrayList();
    }

    public String getIdentificacion() {
        return identificacion.get();
    }

    public StringProperty identificacionProperty() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion.set(identificacion);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public ObjectProperty<LocalDate> fechaNacimientoProperty() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getCodigoPostal() {
        return codigoPostal.get();
    }

    public StringProperty codigoPostalProperty() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal.set(codigoPostal);
    }

    public String getLocalidad() {
        return localidad.get();
    }

    public StringProperty localidadProperty() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad.set(localidad);
    }

    public String getPais() {
        return pais.get();
    }

    public StringProperty paisProperty() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais.set(pais);
    }

    public ObservableList<Nacionalidad> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(ObservableList<Nacionalidad> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }

}
