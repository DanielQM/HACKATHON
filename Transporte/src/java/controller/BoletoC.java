
package controller;

import dao.BoletoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.BoletoM;


@Named(value = "boletoC")
@SessionScoped
public class BoletoC implements Serializable {

    BoletoM boleto = new BoletoM();
    List<BoletoM> lstBoleto;
    
    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }
    
    public void limpiar() {
        boleto = new BoletoM();
    }
    
    public void guardar() {
        BoletoD dao;
        try {
            dao = new BoletoD();
            dao.guardar(boleto);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"AGREGADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"BOLETO EXISTE", null));
        }
    }
    
    public void listar() throws Exception {
        BoletoD dao;
        try {
            dao = new BoletoD();
            lstBoleto = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public BoletoM getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoM boleto) {
        this.boleto = boleto;
    }

    public List<BoletoM> getLstBoleto() {
        return lstBoleto;
    }

    public void setLstBoleto(List<BoletoM> lstBoleto) {
        this.lstBoleto = lstBoleto;
    }
}
