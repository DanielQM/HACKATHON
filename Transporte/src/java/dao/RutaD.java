
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.RutaM;


public class RutaD extends Dao implements IRuta{

    @Override
    public void guardar(RutaM ruta) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO RUTAS VALUES(?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setDouble(3, ruta.getCosto());
            ps.setString(4, ruta.getCodSucursal());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(RutaM ruta) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE INTO RUTAS SET ORI_RUTA=?, DES_RUTA=?, COS_TUTA=?, ";
        } catch (Exception e) {
        }
    }

    @Override
    public void eliminar(RutaM ruta) throws Exception {
        
    }

    @Override
    public List<RutaM> listar() throws Exception {
        
    }
    
}
