package ar.edu.eest9.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cursos")
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")
    , @NamedQuery(name = "Cursos.findById", query = "SELECT c FROM Cursos c WHERE c.id = :id")
    , @NamedQuery(name = "Cursos.findByNombre", query = "SELECT c FROM Cursos c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cursos.findByTurno", query = "SELECT c FROM Cursos c WHERE c.turno = :turno")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "turno")
    private String turno;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosId")
//    private List<HorarioDocente> horarioDocenteList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosId")
//    private List<Alumnos> alumnosList;

    public Cursos() {
    }

    public Cursos(Integer id) {
        this.id = id;
    }

    public Cursos(Integer id, String nombre, String turno) {
        this.id = id;
        this.nombre = nombre;
        this.turno = turno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

//    public List<HorarioDocente> getHorarioDocenteList() {
//        return horarioDocenteList;
//    }
//
//    public void setHorarioDocenteList(List<HorarioDocente> horarioDocenteList) {
//        this.horarioDocenteList = horarioDocenteList;
//    }
//
//    public List<Alumnos> getAlumnosList() {
//        return alumnosList;
//    }
//
//    public void setAlumnosList(List<Alumnos> alumnosList) {
//        this.alumnosList = alumnosList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + " " + this.nombre + " " + this.turno;
    }

}
