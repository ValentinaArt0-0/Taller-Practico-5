package smartlibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Préstamo de un ejemplar a un estudiante.
 * - Asociación con Estudiante y con Ejemplar (existen por sí mismos).
 * - Composición con Renovacion (el historial pertenece al préstamo).
 */
public class Prestamo {
    private final Estudiante estudiante;
    private final Ejemplar ejemplar;
    private final LocalDate fechaPrestamo;
    private LocalDate fechaPrevistaDevolucion;
    private final List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar,
                    LocalDate fechaPrestamo, LocalDate fechaPrevistaDevolucion) {
        if (estudiante == null || ejemplar == null) {
            throw new IllegalArgumentException("Estudiante y ejemplar son obligatorios.");
        }
        if (!fechaPrevistaDevolucion.isAfter(fechaPrestamo)) {
            throw new IllegalArgumentException(
                    "La fecha prevista debe ser posterior a la fecha del préstamo.");
        }
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    /** Regla protegida: la nueva fecha debe ser estrictamente posterior a la vigente. */
    public void renovar(LocalDate nuevaFecha) {
        renovar(nuevaFecha, LocalDate.now());
    }

    /** Variante con fecha de renovación explícita (útil para pruebas reproducibles). */
    public void renovar(LocalDate nuevaFecha, LocalDate fechaRenovacion) {
        if (nuevaFecha == null) {
            throw new IllegalArgumentException("La nueva fecha es obligatoria.");
        }
        // 1. validar
        if (!nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException("Renovación inválida: la nueva fecha ("
                    + nuevaFecha + ") debe ser posterior a la fecha prevista vigente ("
                    + fechaPrevistaDevolucion + ").");
        }
        // 2. crear  3. almacenar
        renovaciones.add(new Renovacion(fechaRenovacion, fechaPrevistaDevolucion, nuevaFecha));
        // 4. actualizar
        fechaPrevistaDevolucion = nuevaFecha;
    }

    public Estudiante getEstudiante()               { return estudiante; }
    public Ejemplar getEjemplar()                   { return ejemplar; }
    public LocalDate getFechaPrestamo()             { return fechaPrestamo; }
    public LocalDate getFechaPrevistaDevolucion()   { return fechaPrevistaDevolucion; }
    public int getCantidadRenovaciones()            { return renovaciones.size(); }

    /** Vista de solo lectura: nadie externo puede alterar el historial. */
    public List<Renovacion> getRenovaciones() {
        return Collections.unmodifiableList(renovaciones);
    }
}
