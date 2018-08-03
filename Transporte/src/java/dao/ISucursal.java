
package dao;

import java.util.List;
import model.SucursalM;


public interface ISucursal {
    
    void guardar(SucursalM sucursal) throws Exception;
    void modificar(SucursalM sucursal) throws Exception;
    void eliminar(SucursalM sucursal) throws Exception;
    List<SucursalM> listar() throws Exception;
}
