
package dao;

import java.util.List;
import model.BusM;



public interface IBus {
    
    void guardar(BusM bus) throws Exception;
    void modificar(BusM bus) throws Exception;
    void eliminar(BusM bus) throws Exception;
    List<BusM> listar() throws Exception;
    
}
