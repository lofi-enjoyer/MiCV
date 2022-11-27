package dad.micv.formacion;

import dad.micv.CV;

public class FormacionController {

    private FormacionView view;

    public FormacionController() {
        this.view = new FormacionView();
    }

    public void loadCV(CV cv) {
        view.getFormacionTable().setItems(cv.getFormacion());
    }

    public void unloadCV() {
        view.getFormacionTable().setItems(null);
    }

    public FormacionView getView() {
        return view;
    }

}
