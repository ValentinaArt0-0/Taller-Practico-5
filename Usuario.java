package smartlibrary;

/**
 * Abstracción de toda persona registrada en SmartLibrary (R12).
 * Es abstracta: en el sistema no existe un "usuario genérico",
 * siempre es un estudiante o un bibliotecario.
 */
public abstract class Usuario {
    private final String identificacion;
    private final String nombre;
    private final String correo;

    protected Usuario(String identificacion, String nombre, String correo) {
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("La identificación es obligatoria.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo no es válido.");
        }
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getIdentificacion() { return identificacion; }
    public String getNombre()         { return nombre; }
    public String getCorreo()         { return correo; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + identificacion + " - " + nombre + "]";
    }
}
