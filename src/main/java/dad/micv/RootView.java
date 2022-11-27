package dad.micv;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RootView {

    Parent root;

    @FXML
    Tab personalTab;

    @FXML
    Tab contactoTab;

    @FXML
    Tab formacionTab;

    @FXML
    Tab experienciaTab;

    @FXML
    Tab conocimientosTab;

    @FXML
    MenuItem newMenuItem;

    @FXML
    MenuItem openMenuItem;

    @FXML
    MenuItem saveMenuItem;

    @FXML
    MenuItem saveAsMenuItem;

    @FXML
    MenuItem exitMenuItem;

    public RootView(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MiCV.class.getResource("Main.fxml"));
            fxmlLoader.setController(this);
            this.root = fxmlLoader.load();
            Scene scene = new Scene(root, 640, 480);
            stage.setTitle("Mi CV");
            stage.setScene(scene);
            stage.getIcons().add(new Image(MiCV.class.getResourceAsStream("cv64x64.png")));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getRoot() {
        return root;
    }

    public Tab getPersonalTab() {
        return personalTab;
    }

    public Tab getContactoTab() {
        return contactoTab;
    }

    public Tab getFormacionTab() {
        return formacionTab;
    }

    public Tab getExperienciaTab() {
        return experienciaTab;
    }

    public Tab getConocimientosTab() {
        return conocimientosTab;
    }

    public MenuItem getNewMenuItem() {
        return newMenuItem;
    }

    public MenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public MenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public MenuItem getSaveAsMenuItem() {
        return saveAsMenuItem;
    }

    public MenuItem getExitMenuItem() {
        return exitMenuItem;
    }

}
