
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
    List<SucursalM> lstSucursal;
    
    @PostConstruct
    public void iniciar(){
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Agregado Correctamente", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Agregar", null));
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
}
