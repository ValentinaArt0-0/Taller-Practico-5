package smartlibrary;

/**
 * Contrato de capacidad: cualquier objeto que lo cumpla puede recibir
 * un mensaje del sistema.
 *
 * Garantiza: existe una operación notificar(String) que puede invocarse.
 * NO especifica: el canal (consola, correo, SMS), el formato, la
 * persistencia ni qué ocurre si la entrega falla.
 */
public interface Notificable {
    void notificar(String mensaje);
}
