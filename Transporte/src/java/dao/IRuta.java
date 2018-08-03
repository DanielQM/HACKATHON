
package dao;

import java.util.List;
import model.RutaM;


public interface IRuta {
    void guardar(RutaM ruta) throws Exception;
    void modificar(RutaM ruta) throws Exception;
    void eliminar(RutaM ruta) throws Exception;
    List<RutaM> listar() throws Exception;
}
