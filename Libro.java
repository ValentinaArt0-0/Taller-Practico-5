package smartlibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Título del catálogo. Es el TODO en la composición Libro ◆— Ejemplar:
 * es el único que crea sus ejemplares (R10).
 */
public class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final List<Ejemplar> ejemplares = new ArrayList<>();

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    /** Crea un ejemplar que nace ligado a este libro y no existe fuera de él. */
    public Ejemplar agregarEjemplar(String codigoInventario) {
        Ejemplar e = new Ejemplar(codigoInventario, this);
        ejemplares.add(e);
        return e;
    }

    public String getIsbn()   { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor()  { return autor; }

    public List<Ejemplar> getEjemplares() {
        return Collections.unmodifiableList(ejemplares);
    }
}
