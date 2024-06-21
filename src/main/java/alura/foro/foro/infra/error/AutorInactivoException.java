package alura.foro.foro.infra.error;

public class AutorInactivoException extends RuntimeException{
    public AutorInactivoException(String mensaje) {
        super(mensaje);
    }
}
