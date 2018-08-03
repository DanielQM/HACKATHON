
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RutaM;


public class RutaD extends Dao implements IRuta{

    @Override
    public void guardar(RutaM ruta) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO RUTAS VALUES(?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setString(3, ruta.getCosto());
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
            String sql = "UPDATE RUTAS SET ORI_RUTA=?, DES_RUTA=?, COS_RUTA=? WHERE COD_RUTA=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setString(3, ruta.getCosto());
            ps.setString(4, ruta.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(RutaM ruta) throws Exception {
        try {
            this.conectar();
            String sql="DELETE FROM RUTAS WHERE COD_RUTA=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, ruta.getCodigo());
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<RutaM> listar() throws Exception {
        List<RutaM> listaRuta;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM RUTAS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaRuta = new ArrayList();
            RutaM ruta;
            while(rs.next()){
                ruta = new RutaM();
                ruta.setCodigo(rs.getString("COD_RUTA"));
                ruta.setOrigen(rs.getString("ORI_RUTA"));
                ruta.setDestino(rs.getString("DES_RUTA"));
                ruta.setCosto(rs.getString("COS_RUTA"));
                listaRuta.add(ruta);
            }
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return listaRuta;
    }
    
}
