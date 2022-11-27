package dad.micv;

import javafx.application.Application;
import javafx.stage.Stage;

public class MiCV extends Application {

    @Override
    public void start(Stage stage) {
        new RootController(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}