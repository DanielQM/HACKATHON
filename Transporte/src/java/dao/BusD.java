
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BusM;

public class BusD extends Dao implements IBus{

    @Override
    public void guardar(BusM bus) throws Exception {
        try {
            this.conectar();
            String sql = " EXEC SP_INSERTBUS @PLACA=?,@ASIENTOS=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, bus.getPlaca());
            ps.setString(2, bus.getAsientos());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(BusM bus) throws Exception {
        try {
            this.conectar();
            String sql = "EXEC SP_UPDATEBUS @PLACA=?, @ASIENTOS=?, @CODIGO=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, bus.getPlaca());
            ps.setString(2, bus.getAsientos());
            ps.setString(3, bus.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(BusM bus) throws Exception {
        try {
            this.conectar();
            String sql = "EXEC SP_DELETEBUS ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, bus.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<BusM> listar() throws Exception {
        List<BusM> listaBus;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM VW_BUS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaBus = new ArrayList();
            BusM bus;
            while(rs.next()){
                bus = new BusM();
                bus.setCodigo(rs.getString("COD_BUS"));
                bus.setPlaca(rs.getString("PLACA_BUS"));
                bus.setAsientos(rs.getString("NASIENTO"));
                listaBus.add(bus);
            }
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return listaBus;
    }
    
}
