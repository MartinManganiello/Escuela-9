package ar.edu.eest9.beans;

import ar.edu.eest9.domain.Cursos;
import ar.edu.eest9.service.curso.impl.CursoService;
import ar.edu.eest9.utils.Message;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@RequestScoped
@Named
public class CursoBean {

    /*Este ManagedBean es el encargado de comunicarse con los EJB para interactuar con la BD*/
    @Inject
    private CursoService cursoService;
    private Cursos curso;
    private List<Cursos> cursos;
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public CursoBean() {
        this.curso = new Cursos();
    }

    @PostConstruct
    public void init() {
        cursos = cursoService.findAll();
    }

    public void editListener(RowEditEvent event) {
        this.curso = (Cursos) event.getObject();
        cursoService.edit(curso);
    }

    public List<Cursos> getCursos() {
        return this.cursos;
    }

    public void save() {
        cursoService.create(curso);
        Message.showMessage("Alta de cursos", "Se dio de alta al curso " + curso.getId() + " " + curso.getNombre());
        this.curso = new Cursos();
    }

    public void cargar() {
        curso = cursoService.find(param);
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

}
