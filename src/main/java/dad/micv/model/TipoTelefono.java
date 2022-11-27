package dad.micv.model;

public enum TipoTelefono {

    DOMICILIO(0), MOVIL(1);

    private final int value;

    TipoTelefono(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
