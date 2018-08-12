
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
            String sql = "EXEC SP_INSERTBOLETO @FEC_BOL=?,@NUM_ASIE=?,@EST_BOL=?,@COD_PASJ=?,@COD_RUTA=?,@COD_BUS=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, boleto.getFecha());
            ps.setString(2, boleto.getNumeroAsiento());
            ps.setString(3, "A");
            ps.setString(4, boleto.getCodPasajero());
            ps.setString(5, boleto.getCodRuta());
            ps.setString(6, boleto.getCodBus());
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
