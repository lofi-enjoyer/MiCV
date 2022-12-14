package dad.micv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dad.micv.conocimientos.ConocimientosController;
import dad.micv.contacto.ContactoController;
import dad.micv.experiencia.ExperienciaController;
import dad.micv.formacion.FormacionController;
import dad.micv.model.Nacionalidad;
import dad.micv.model.Pais;
import dad.micv.personal.PersonalController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hildan.fxgson.FxGson;
import org.hildan.fxgson.FxGsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RootController {

    private final Stage stage;

    private final RootView view;

    private final PersonalController personalController;
    private final ContactoController contactoController;
    private final FormacionController formacionController;
    private final ExperienciaController experienciaController;
    private final ConocimientosController conocimientosController;

    private final List<Nacionalidad> nacionalidadList;
    private final ObservableList<String> paisList;

    private CV cv;

    public RootController(Stage stage) {
        this.stage = stage;

        this.nacionalidadList = new ArrayList<>();
        BufferedReader nacionalidadReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("nacionalidades.csv")));
        nacionalidadReader.lines().forEach(line -> {
            nacionalidadList.add(new Nacionalidad(line));
        });

        this.paisList = FXCollections.observableArrayList();
        BufferedReader paisReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("paises.csv")));
        paisReader.lines().forEach(line -> {
            paisList.add(line);
        });

        try {
            nacionalidadReader.close();
            paisReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.view = new RootView(stage);

        this.personalController = new PersonalController(this);
        this.contactoController = new ContactoController();
        this.formacionController = new FormacionController();
        this.experienciaController = new ExperienciaController();
        this.conocimientosController = new ConocimientosController();

        view.getPersonalTab().setContent(personalController.getView().getRoot());
        view.getContactoTab().setContent(contactoController.getView().getRoot());
        view.getFormacionTab().setContent(formacionController.getView().getRoot());
        view.getExperienciaTab().setContent(experienciaController.getView().getRoot());
        view.getConocimientosTab().setContent(conocimientosController.getView().getRoot());

        view.getNewMenuItem().setOnAction(event -> loadCV(new CV()));
        view.getOpenMenuItem().setOnAction(event -> loadCVFromFile());

        this.cv = new CV();
        loadCV(cv);
    }

    public void loadCVFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir");
        fileChooser.setInitialDirectory(new File("."));

        File file = fileChooser.showOpenDialog(stage);
        if (file == null)
            return;

        Gson gson = FxGson.fullBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        try {
            unloadCV();
            this.cv = gson.fromJson(new FileReader(file), CV.class);
            loadCV(cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCVToFile(String file) {
        Gson gson = FxGson.fullBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        String json = gson.toJson(cv, CV.class);
        try {
            Files.writeString(new File(file).toPath(), json, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCV(CV cv) {
        personalController.loadCV(cv);
        contactoController.loadCV(cv);
        formacionController.loadCV(cv);
        experienciaController.loadCV(cv);
        conocimientosController.loadCV(cv);
    }

    public void unloadCV() {
        personalController.unloadCV();
        contactoController.unloadCV();
        formacionController.unloadCV();
        experienciaController.unloadCV();
        conocimientosController.unloadCV();
    }

    public List<Nacionalidad> getNacionalidadList() {
        return nacionalidadList;
    }

    public ObservableList<String> getPaisList() {
        return paisList;
    }

}