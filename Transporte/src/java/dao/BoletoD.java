
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BoletoM;

public class BoletoD extends Dao implements IBoleto{

    @Override
    public void guardar(BoletoM boleto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO BOLETO(FEC_BOL,NUM_ASIE,COD_PASJ,COD_RUTA,COD_BUS) VALUES(?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, boleto.getFecha());
            ps.setString(2, boleto.getNumeroAsiento());
            ps.setString(3, boleto.getCodPasajero());
            ps.setString(4, boleto.getCodRuta());
            ps.setString(5, boleto.getCodBus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(BoletoM boleto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE FROM BOLETO SET FEC_BOL=?,NUM_ASIE=?,COD_PASJ=?,COD_RUTA=?,COD_BUS=? WHERE COD_BOL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, boleto.getFecha());
            ps.setString(2, boleto.getNumeroAsiento());
            ps.setString(3, boleto.getCodPasajero());
            ps.setString(4, boleto.getCodRuta());
            ps.setString(5, boleto.getCodBus());
            ps.setString(6, boleto.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(BoletoM boleto) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM BOLETO WHERE COD_BOL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, boleto.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<BoletoM> listar() throws Exception {
        List<BoletoM> listaBoleta;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "EXEC SP_ListBoleto";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaBoleta = new ArrayList();
            BoletoM boleto;
            while(rs.next()){
                boleto = new BoletoM();
                boleto.setCodBus(rs.getString("COD_BUS"));
                boleto.setFecha(rs.getString("FEC_BOL"));
                boleto.setNumeroAsiento(rs.getString("NUM_ASIE"));
                boleto.setCodPasajero(rs.getString("COD_PASJ"));
                boleto.setNom_pasj(rs.getString("NOM_PASJ"));
                boleto.setCodRuta(rs.getString("COD_RUTA"));
                boleto.setRuta(rs.getString("RUTA"));
                boleto.setCosto(rs.getString("COS_RUTA"));
                boleto.setCodBus(rs.getString("COD_BUS"));
                boleto.setPlaca_bus(rs.getString("PLACA_BUS"));
                listaBoleta.add(boleto);
            }
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return listaBoleta;
    }
    
}
