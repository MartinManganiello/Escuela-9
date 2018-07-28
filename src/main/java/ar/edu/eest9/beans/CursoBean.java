package ar.edu.eest9.beans;

import ar.edu.eest9.domain.Cursos;
import ar.edu.eest9.service.curso.impl.CursoService;
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
public class CursoBean implements Serializable {

    /*Este ManagedBean es el encargado de comunicarse con los EJB para interactuar con la BD*/
    @Inject
    private CursoService cursoService;
    private Cursos selected;
    private List<Cursos> items = null;

    public CursoBean() {
    }

    public Cursos prepareCreate() {
        selected = new Cursos();
        initializeEmbeddableKey();
        return selected;
    }

//    @PostConstruct
//    public void init() {
//        cursos = cursoService.findAll();
//    }
    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CursosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Si todo fue bien, se nullea la lista.
        }
//        Message.showMessage("Alta de cursos", "Se dio de alta al curso " + selected.getId() + " " + selected.getNombre());
//        this.selected = new Cursos();
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CursosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Borra la selección
            items = null;    // Nullea la lista.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CursosUpdated"));
    }

    protected void initializeEmbeddableKey() {
    }

    protected void setEmbeddableKeys() {
    }

    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    this.getCursoService().edit(selected);
                } else {
                    this.getCursoService().remove(selected);
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

    public CursoService getCursoService() {
        return cursoService;
    }

    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public Cursos getSelected() {
        return selected;
    }

    public void setSelected(Cursos selected) {
        this.selected = selected;
    }

    public List<Cursos> getItems() {
        if (items == null) { //Si la lista esta vacía la carga.
            items = this.getCursoService().findAll();
        }
        return items;
    }

    public void setItems(List<Cursos> items) {
        this.items = items;
    }

    public List<Cursos> getItemsAvailableSelectMany() {
        return this.getCursoService().findAll();
    }

    public List<Cursos> getItemsAvailableSelectOne() {
        return this.getCursoService().findAll();
    }
    
    public Cursos getCursos(java.lang.Integer id) {
        return this.getCursoService().find(id);
    }
    
    @FacesConverter(forClass = Cursos.class)
    public static class CursoBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CursoBean controller = (CursoBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cursoBean");
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
            if (object instanceof Cursos) {
                Cursos o = (Cursos) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cursos.class.getName()});
                return null;
            }
        }

    }

}
