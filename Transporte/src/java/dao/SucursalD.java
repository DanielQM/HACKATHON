
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SucursalM;


public class SucursalD extends Dao implements ISucursal {

    @Override
    public void guardar(SucursalM sucursal) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO SUCURSALES VALUES(?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, sucursal.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(SucursalM sucursal) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE SUCURSALES SET NOM_SUC=? WHERE COD_SUC=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, sucursal.getNombre());
            ps.setString(2, sucursal.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(SucursalM sucursal) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM SUCURSALES WHERE COD_SUC=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, sucursal.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<SucursalM> listar() throws Exception {
        List<SucursalM> listaSuc;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM SUCURSALES";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaSuc = new ArrayList();
            SucursalM sucursal;
            while (rs.next()) {                
                sucursal = new SucursalM();
                sucursal.setCodigo(rs.getString("COD_SUC"));
                sucursal.setNombre(rs.getString("NOM_SUC"));
                listaSuc.add(sucursal);
            }
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return listaSuc;
    }
    
}
