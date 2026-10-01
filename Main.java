package smartlibrary;

import java.time.LocalDate;

/** Prueba mínima: una renovación válida y una inválida. */
public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("1085", "Ana Torres",
                "ana.torres@udenar.edu.co", "EST-2024-017", "Ingeniería de Sistemas");
        Bibliotecario bibliotecario = new Bibliotecario("2090", "Luis Mora",
                "luis.mora@smartlibrary.edu", "EMP-005", "Mañana");

        Libro libro = new Libro("978-0132350884", "Clean Code", "Robert C. Martin");
        Ejemplar ejemplar = libro.agregarEjemplar("EJ-001");
        libro.agregarEjemplar("EJ-002");

        Prestamo prestamo = new Prestamo(estudiante, ejemplar,
                LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 8));

        System.out.println("=== Datos iniciales ===");
        System.out.println(estudiante + " | " + bibliotecario);
        System.out.println(libro.getTitulo() + " tiene " + libro.getEjemplares().size() + " ejemplares");
        System.out.println("Fecha prevista inicial: " + prestamo.getFechaPrevistaDevolucion());

        // ---- PRUEBA 1: renovación válida ----
        System.out.println("\n=== Prueba 1: renovación válida ===");
        prestamo.renovar(LocalDate.of(2026, 10, 15), LocalDate.of(2026, 10, 7));
        estudiante.notificar("Su préstamo fue renovado.");
        System.out.println("Nueva fecha prevista: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());
        prestamo.getRenovaciones().forEach(System.out::println);

        // ---- PRUEBA 2: renovación inválida ----
        System.out.println("\n=== Prueba 2: renovación inválida (fecha igual a la vigente) ===");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 15), LocalDate.of(2026, 10, 14));
            System.out.println("ERROR: debió rechazarse.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Rechazada correctamente -> " + ex.getMessage());
        }

        System.out.println("\n=== Prueba 2b: renovación inválida (fecha anterior) ===");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 10), LocalDate.of(2026, 10, 14));
            System.out.println("ERROR: debió rechazarse.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Rechazada correctamente -> " + ex.getMessage());
        }

        System.out.println("\nEstado final (sin cambios por las inválidas):");
        System.out.println("Fecha prevista: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());

        // ---- Polimorfismo por contrato ----
        System.out.println("\n=== Polimorfismo mediante Notificable ===");
        Notificable[] destinatarios = { estudiante, bibliotecario };
        for (Notificable n : destinatarios) {
            n.notificar("Recordatorio general del sistema.");
        }
    }
}
