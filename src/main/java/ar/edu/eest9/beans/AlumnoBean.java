package ar.edu.eest9.beans;

import ar.edu.eest9.domain.Alumnos;
import ar.edu.eest9.domain.Documentaciones;
import ar.edu.eest9.service.alumno.AlumnoService;
import ar.edu.eest9.utils.JsfUtil;
import ar.edu.eest9.utils.JsfUtil.PersistAction;
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
public class AlumnoBean implements Serializable {

    @Inject
    private AlumnoService alumnoService;
    private Alumnos selected;
    private List<Alumnos> items = null;
    private List<Documentaciones> listDocu;

    public AlumnoBean() {
    }

    public Alumnos prepareCreate() {
        selected = new Alumnos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AlumnosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AlumnosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AlumnosUpdated"));
    }

    public AlumnoService getAlumnoService() {
        return alumnoService;
    }

    public void setAlumnoService(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    public Alumnos getSelected() {
        return selected;
    }

    public void setSelected(Alumnos selected) {
        this.selected = selected;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    this.getAlumnoService().edit(selected);
                } else {
                    this.getAlumnoService().remove(selected);
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

    public List<Alumnos> getItems() {
        if (items == null) {
            items = this.getAlumnoService().findAll();
        }
        return items;
    }

    public void setItems(List<Alumnos> items) {
        this.items = items;
    }

    public List<Documentaciones> getListDocu() {
        return listDocu;
    }

    public void setListDocu(List<Documentaciones> listDocu) {
        this.listDocu = listDocu;
    }

    public List<Alumnos> getItemsAvailableSelectMany() {
        return this.getAlumnoService().findAll();
    }

    public List<Alumnos> getItemsAvailableSelectOne() {
        return this.getAlumnoService().findAll();
    }

    public Alumnos getAlumnos(java.lang.Integer id) {
        return this.getAlumnoService().find(id);
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

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    @FacesConverter(forClass = Alumnos.class)
    public static class AlumnoMBConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlumnoBean controller = (AlumnoBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "alumnoBean");
            return controller.getAlumnos(getKey(value));
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
            if (object instanceof Alumnos) {
                Alumnos o = (Alumnos) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Alumnos.class.getName()});
                return null;
            }
        }

    }
}
