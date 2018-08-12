
package controller;

import dao.BusD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.BusM;


@Named(value = "busC")
@SessionScoped
public class BusC implements Serializable {

    BusM bus = new BusM();
    private List<BusM> lstBus;
    private BusM selectedBus;
    
    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }
    
    public void limpiar() {
        bus = new BusM();
    }

    public void guardar() {
        BusD dao;
        try {
            dao = new BusD();
            dao.guardar(bus);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "BUS YA AGREGADO", null));
        }
    }
    
    public void listar() throws Exception {
        BusD dao;
        try {
            dao = new BusD();
            lstBus = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(){
        BusD dao;
        try {
            dao = new BusD();
            dao.modificar(selectedBus);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
        }
    }
    
    public void eliminar() {
        BusD dao;
        try {
            dao = new BusD();
            dao.eliminar(selectedBus);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
        }
    }

    public BusM getBus() {
        return bus;
    }

    public void setBus(BusM bus) {
        this.bus = bus;
    }

    public List<BusM> getLstBus() {
        return lstBus;
    }

    public void setLstBus(List<BusM> lstBus) {
        this.lstBus = lstBus;
    }

    public BusM getSelectedBus() {
        return selectedBus;
    }

    public void setSelectedBus(BusM selectedBus) {
        this.selectedBus = selectedBus;
    }
    
}
