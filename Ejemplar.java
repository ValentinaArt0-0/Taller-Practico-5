package smartlibrary;

/**
 * Copia física de un libro (R10). Constructor visible solo en el paquete
 * para que únicamente Libro pueda crearlo (refleja la composición).
 */
public class Ejemplar {
    private final String codigoInventario;
    private final Libro libro;   // cada ejemplar corresponde a un único libro

    Ejemplar(String codigoInventario, Libro libro) {
        this.codigoInventario = codigoInventario;
        this.libro = libro;
    }

    public String getCodigoInventario() { return codigoInventario; }
    public Libro getLibro()             { return libro; }

    @Override
    public String toString() {
        return "Ejemplar[" + codigoInventario + " de '" + libro.getTitulo() + "']";
    }
}
