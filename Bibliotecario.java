package smartlibrary;

/**
 * Usuario que administra la biblioteca.
 * Decisión: implementa Notificable porque recibe avisos operativos
 * (p. ej. ejemplares vencidos o reservas pendientes). Supuesto documentado.
 */
public class Bibliotecario extends Usuario implements Notificable {
    private final String codigoEmpleado;
    private final String turno;

    public Bibliotecario(String identificacion, String nombre, String correo,
                         String codigoEmpleado, String turno) {
        super(identificacion, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public String getTurno()          { return turno; }

    @Override
    public void notificar(String mensaje) {
        System.out.println("[NOTIFICACIÓN -> Bibliotecario " + getNombre()
                + " (turno " + turno + ")] " + mensaje);
    }
}
