package Database;

public interface ConnectionInterface {
    void conectar();
    void desconectar();
    void ejecutarConsulta(String consulta);
}
