package dad.micv.experiencia;

import dad.micv.CV;

public class ExperienciaController {

    private ExperienciaView view;

    public ExperienciaController() {
        this.view = new ExperienciaView();
    }

    public void loadCV(CV cv) {
        view.getExperTable().setItems(cv.getExperiencias());
    }

    public void unloadCV() {
        view.getExperTable().setItems(null);
    }

    public ExperienciaView getView() {
        return view;
    }

}
