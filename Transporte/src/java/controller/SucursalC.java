package controller;

import dao.SucursalD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.SucursalM;

@Named(value = "sucursalC")
@SessionScoped
public class SucursalC implements Serializable {

    SucursalM sucursal = new SucursalM();
    private List<SucursalM> lstSucursal;
    private SucursalM selectedSucursal;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        sucursal = new SucursalM();
    }

    public void guardar() {
        SucursalD dao;
        try {
            dao = new SucursalD();
            dao.guardar(sucursal);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "SUCURSAL YA EXISTE", null));
        }
    }

    public void listar() throws Exception {
        SucursalD dao;
        try {
            dao = new SucursalD();
            lstSucursal = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() {
        SucursalD dao;
        try {
            dao = new SucursalD();
            dao.modificar(selectedSucursal);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", null));
        }
    }

    public void eliminar() {
        SucursalD dao;
        try {
            dao = new SucursalD();
            dao.eliminar(selectedSucursal);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", null));
        }
    }

    public SucursalM getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalM sucursal) {
        this.sucursal = sucursal;
    }

    public List<SucursalM> getLstSucursal() {
        return lstSucursal;
    }

    public void setLstSucursal(List<SucursalM> lstSucursal) {
        this.lstSucursal = lstSucursal;
    }

    public SucursalM getSelectedSucursal() {
        return selectedSucursal;
    }

    public void setSelectedSucursal(SucursalM selectedSucursal) {
        this.selectedSucursal = selectedSucursal;
    }
}
