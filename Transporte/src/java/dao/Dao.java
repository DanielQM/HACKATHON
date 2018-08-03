
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dao {
    
    private Connection cn;
    
    public void conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.8.128:1433;database=BD_Transporte", "sa", "vallegrande2018");
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void cerrar() throws SQLException {
        try {
            if(cn != null){
                if(cn.isClosed() == false){
                    cn.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        try {
            Dao dao = new Dao();
            dao.conectar();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
}
