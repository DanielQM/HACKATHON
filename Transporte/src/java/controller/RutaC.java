package controller;

import dao.RutaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.RutaM;

@Named(value = "rutaC")
@SessionScoped
public class RutaC implements Serializable {

    RutaM ruta = new RutaM();
    private List<RutaM> lstRuta;
    private RutaM selectedRuta;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        ruta = new RutaM();
    }

    public void guardar() {
        RutaD dao;
        try {
            dao = new RutaD();
            if (ruta.getOrigen().equals(ruta.getDestino())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Origen y Destino no pueden ser iguales", null));
            } else {
                dao.guardar(ruta);
                listar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente", null));
                limpiar();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al Guardar", null));
        }
    }

    public void listar() throws Exception {
        RutaD dao;
        try {
            dao = new RutaD();
            lstRuta = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() {
        RutaD dao;
        try {
            dao = new RutaD();
            dao.modificar(selectedRuta);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado Correctamente", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al Modificar", null));
        }
    }
    
    public void eliminar() {
        RutaD dao;
        try {
            dao = new RutaD();
            dao.eliminar(selectedRuta);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado Correctamente", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al Eliminar", null));
        }
    }

    public RutaM getRuta() {
        return ruta;
    }

    public void setRuta(RutaM ruta) {
        this.ruta = ruta;
    }

    public List<RutaM> getLstRuta() {
        return lstRuta;
    }

    public void setLstRuta(List<RutaM> lstRuta) {
        this.lstRuta = lstRuta;
    }

    public RutaM getSelectedRuta() {
        return selectedRuta;
    }

    public void setSelectedRuta(RutaM selectedRuta) {
        this.selectedRuta = selectedRuta;
    }
}
