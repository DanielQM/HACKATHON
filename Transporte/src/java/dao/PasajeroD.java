
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PasajeroM;


public class PasajeroD extends Dao implements IPasajero{

    @Override
    public void guardar(PasajeroM pasajero) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PASAJERO(NOM_PASJ, DNI_PASJ, FECNAC_PASJ) VALUES(?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getDni());
            ps.setString(3, pasajero.getNacimiento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(PasajeroM pasajero) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PASAJERO SET NOM_PASJ=?, DNI_PASJ=?, FECNAC_PASJ=? WHERE COD_PASJ=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getDni());
            ps.setString(3, pasajero.getNacimiento());
            ps.setString(4, pasajero.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
 
    }

    @Override
    public void eliminar(PasajeroM pasajero) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM PASAJERO WHERE COD_PASJ=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pasajero.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<PasajeroM> listar() throws Exception {
        List<PasajeroM> listaPasajero;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM PASAJERO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaPasajero = new ArrayList();
            PasajeroM pasajero;
            while(rs.next()){
                pasajero = new PasajeroM();
                pasajero.setCodigo(rs.getString("COD_PASJ"));
                pasajero.setNombre(rs.getString("NOM_PASJ"));
                pasajero.setDni(rs.getString("DNI_PASJ"));
                pasajero.setNacimiento(rs.getString("FECNAC_PASJ"));
                listaPasajero.add(pasajero);
            }
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return listaPasajero;
    }
    
    
}
