package smartlibrary;

import java.time.LocalDate;

/**
 * Registro histórico e inmutable de una renovación (R11).
 * Es PARTE de Prestamo: solo Prestamo puede crearla (constructor de paquete).
 */
public class Renovacion {
    private final LocalDate fechaRenovacion;  // cuándo se realizó
    private final LocalDate fechaAnterior;    // fecha de devolución previa
    private final LocalDate nuevaFecha;       // nueva fecha de devolución

    Renovacion(LocalDate fechaRenovacion, LocalDate fechaAnterior, LocalDate nuevaFecha) {
        this.fechaRenovacion = fechaRenovacion;
        this.fechaAnterior = fechaAnterior;
        this.nuevaFecha = nuevaFecha;
    }

    public LocalDate getFechaRenovacion() { return fechaRenovacion; }
    public LocalDate getFechaAnterior()   { return fechaAnterior; }
    public LocalDate getNuevaFecha()      { return nuevaFecha; }

    @Override
    public String toString() {
        return "Renovacion[hecha el " + fechaRenovacion + ": " + fechaAnterior
                + " -> " + nuevaFecha + "]";
    }
}
