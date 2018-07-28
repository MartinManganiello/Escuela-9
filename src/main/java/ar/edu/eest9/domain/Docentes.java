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
@Table(name = "docentes")
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d")
    , @NamedQuery(name = "Docentes.findById", query = "SELECT d FROM Docentes d WHERE d.id = :id")
    , @NamedQuery(name = "Docentes.findByNombre", query = "SELECT d FROM Docentes d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Docentes.findByApellido", query = "SELECT d FROM Docentes d WHERE d.apellido = :apellido")
    , @NamedQuery(name = "Docentes.findByDni", query = "SELECT d FROM Docentes d WHERE d.dni = :dni")})
public class Docentes implements Serializable {

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
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dni")
    private String dni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docentesId")
    private List<HorarioDocente> horarioDocenteList;

    public Docentes() {
    }

    public Docentes(Integer id) {
        this.id = id;
    }

    public Docentes(Integer id, String nombre, String apellido, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<HorarioDocente> getHorarioDocenteList() {
        return horarioDocenteList;
    }

    public void setHorarioDocenteList(List<HorarioDocente> horarioDocenteList) {
        this.horarioDocenteList = horarioDocenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + this.nombre + " " + this.apellido +" "+this.dni;
    }

}
