package controller;

import dao.PasajeroD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.PasajeroM;

@Named(value = "pasajeroC")
@SessionScoped
public class PasajeroC implements Serializable {

    // INSTANCIAR E INICIALIZAR
    PasajeroM pasajero = new PasajeroM();
    private List<PasajeroM> lstPasajero;
    private PasajeroM selectedPasajero;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        pasajero = new PasajeroM();
    }

    public void guardar() {
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            dao.guardar(pasajero);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
        }
    }

    public void listar() throws Exception {
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            lstPasajero = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(){
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            dao.modificar(selectedPasajero);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
        }
    }
    
    public void eliminar() {
        PasajeroD dao;
        try {
            dao = new PasajeroD();
            dao.eliminar(selectedPasajero);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
        }
    }

    public PasajeroM getPasajero() {
        return pasajero;
    }

    public void setPasajero(PasajeroM pasajero) {
        this.pasajero = pasajero;
    }

    public List<PasajeroM> getLstPasajero() {
        return lstPasajero;
    }

    public void setLstPasajero(List<PasajeroM> lstPasajero) {
        this.lstPasajero = lstPasajero;
    }

    public PasajeroM getSelectedPasajero() {
        return selectedPasajero;
    }

    public void setSelectedPasajero(PasajeroM selectedPasajero) {
        this.selectedPasajero = selectedPasajero;
    }
    
}
