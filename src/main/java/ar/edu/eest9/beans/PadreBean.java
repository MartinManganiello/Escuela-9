package ar.edu.eest9.beans;

import ar.edu.eest9.domain.Padres;
import ar.edu.eest9.service.padre.PadreService;
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
public class PadreBean implements Serializable {

    @Inject
    private PadreService padreService;
    private Padres selected;
    private List<Padres> items = null;

    public PadreBean() {
    }

    public Padres prepareCreate() {
        selected = new Padres();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PadresCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Si todo fue bien, se nullea la lista.
        }
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PadresDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Borra la selección
            items = null;    // Nullea la lista.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PadresUpdated"));
    }

    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    this.getPadreService().edit(selected);
                } else {
                    this.getPadreService().remove(selected);
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

    public PadreService getPadreService() {
        return padreService;
    }

    public void setPadreService(PadreService padreService) {
        this.padreService = padreService;
    }

    public Padres getSelected() {
        return selected;
    }

    public void setSelected(Padres selected) {
        this.selected = selected;
    }

    public List<Padres> getItems() {
        if (items == null) { //Si la lista esta vacía la carga.
            items = this.getPadreService().findAll();
        }
        return items;
    }

    public void setItems(List<Padres> items) {
        this.items = items;
    }
    
     public List<Padres> getItemsAvailableSelectMany() {
        return this.getPadreService().findAll();
    }

    public List<Padres> getItemsAvailableSelectOne() {
        return this.getPadreService().findAll();
    }
    
    public Padres getPadres(java.lang.Integer id) {
        return this.getPadreService().find(id);
    }
    
    @FacesConverter(forClass = Padres.class)
    public static class CursoBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PadreBean controller = (PadreBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "padreBean");
            return controller.getPadres(getKey(value));
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
            if (object instanceof Padres) {
                Padres o = (Padres) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Padres.class.getName()});
                return null;
            }
        }

    }

}
