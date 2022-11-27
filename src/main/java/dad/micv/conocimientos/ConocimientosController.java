package dad.micv.conocimientos;

import dad.micv.CV;

public class ConocimientosController {

    private ConocimientosView view;

    public ConocimientosController() {
        this.view = new ConocimientosView();
    }

    public void loadCV(CV cv) {
        view.getConocTable().setItems(cv.getHabilidades());
    }

    public void unloadCV() {
        view.getConocTable().setItems(null);
    }

    public ConocimientosView getView() {
        return view;
    }

}
