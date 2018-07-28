package ar.edu.eest9.beans;

import ar.edu.eest9.domain.Autorizados;
import ar.edu.eest9.service.autorizado.AutorizadoService;
import ar.edu.eest9.utils.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AutorizadoBean implements Serializable {

    @Inject
    private AutorizadoService autorizadoService;
    private Autorizados selected;
    private List<Autorizados> items = null;

    public AutorizadoBean() {
    }

    public Autorizados prepareCreate() {
        selected = new Autorizados();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AutorizadosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Si todo fue bien, se nullea la lista.
        }
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AutorizadosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Borra la selección
            items = null;    // Nullea la lista.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AutorizadosUpdated"));
    }

    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    this.getAutorizadoService().edit(selected);
                } else {
                    this.getAutorizadoService().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    protected void initializeEmbeddableKey() {
    }

    protected void setEmbeddableKeys() {
    }

    public AutorizadoService getAutorizadoService() {
        return autorizadoService;
    }

    public void setAutorizadoService(AutorizadoService autorizadoService) {
        this.autorizadoService = autorizadoService;
    }

    public Autorizados getSelected() {
        return selected;
    }

    public void setSelected(Autorizados selected) {
        this.selected = selected;
    }

    public List<Autorizados> getItems() {
        if (items == null) { //Si la lista esta vacía la carga.
            items = this.getAutorizadoService().findAll();
        }
        return items;
    }

    public void setItems(List<Autorizados> items) {
        this.items = items;
    }
    
     public List<Autorizados> getItemsAvailableSelectMany() {
        return this.getAutorizadoService().findAll();
    }

    public List<Autorizados> getItemsAvailableSelectOne() {
        return this.getAutorizadoService().findAll();
    }
    
    public Autorizados getCursos(java.lang.Integer id) {
        return this.getAutorizadoService().find(id);
    }
    
    @FacesConverter(forClass = Autorizados.class)
    public static class CursoBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CursoBean controller = (CursoBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "autorizadoBean");
            return controller.getCursos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Autorizados) {
                Autorizados o = (Autorizados) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Autorizados.class.getName()});
                return null;
            }
        }

    }

}
