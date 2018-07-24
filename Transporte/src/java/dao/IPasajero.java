
package dao;

import java.util.List;
import model.PasajeroM;


public interface IPasajero {
    
    void guardar(PasajeroM pasajero) throws Exception;
    void modificar(PasajeroM pasajero) throws Exception;
    void eliminar(PasajeroM pasajero) throws Exception;
    List<PasajeroM> listar() throws Exception;
}
