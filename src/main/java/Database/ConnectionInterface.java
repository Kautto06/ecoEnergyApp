package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConnectionInterface {
    void conectar();
    void desconectar();
    void ejecutarConsulta(String consulta);

    ResultSet ejecutarConsultaRetorno(String consulta) throws SQLException;
}
