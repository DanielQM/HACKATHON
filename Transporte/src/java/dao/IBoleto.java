
package dao;

import java.util.List;
import model.BoletoM;


public interface IBoleto {
    
    void guardar(BoletoM boleto) throws Exception;
    List<BoletoM> listar() throws Exception;
}
