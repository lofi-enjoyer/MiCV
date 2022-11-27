package dad.micv.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacto {

    private ObservableList<Telefono> telefonos;
    private ObservableList<Email> emails;
    private ObservableList<Web> webs;

    public Contacto() {
        this.telefonos = FXCollections.observableArrayList();
        this.emails = FXCollections.observableArrayList();
        this.webs = FXCollections.observableArrayList();
    }

    public ObservableList<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ObservableList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public ObservableList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ObservableList<Email> emails) {
        this.emails = emails;
    }

    public ObservableList<Web> getWebs() {
        return webs;
    }

    public void setWebs(ObservableList<Web> webs) {
        this.webs = webs;
    }

}
