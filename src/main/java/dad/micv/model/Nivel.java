package dad.micv.model;

public enum Nivel {

    BASICO(0), MEDIO(1), AVANZADO(2);

    private final int nivel;

    Nivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

}
