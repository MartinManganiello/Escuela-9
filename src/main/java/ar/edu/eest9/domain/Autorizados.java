package ar.edu.eest9.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "autorizados")
@NamedQueries({
    @NamedQuery(name = "Autorizados.findAll", query = "SELECT a FROM Autorizados a")
    , @NamedQuery(name = "Autorizados.findById", query = "SELECT a FROM Autorizados a WHERE a.id = :id")
    , @NamedQuery(name = "Autorizados.findByNombreApellido", query = "SELECT a FROM Autorizados a WHERE a.nombreApellido = :nombreApellido")
    , @NamedQuery(name = "Autorizados.findByParentesco", query = "SELECT a FROM Autorizados a WHERE a.parentesco = :parentesco")
    , @NamedQuery(name = "Autorizados.findByDni", query = "SELECT a FROM Autorizados a WHERE a.dni = :dni")})
public class Autorizados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreApellido")
    private String nombreApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "parentesco")
    private String parentesco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dni")
    private String dni;
    @ManyToMany(mappedBy = "autorizadosList")
    private List<Alumnos> alumnosList;

    public Autorizados() {
    }

    public Autorizados(Integer id) {
        this.id = id;
    }

    public Autorizados(Integer id, String nombreApellido, String parentesco, String dni) {
        this.id = id;
        this.nombreApellido = nombreApellido;
        this.parentesco = parentesco;
        this.dni = dni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Alumnos> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumnos> alumnosList) {
        this.alumnosList = alumnosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Autorizados)) {
            return false;
        }
        Autorizados other = (Autorizados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id +" " +  this.nombreApellido+ " " + this.parentesco  ;
    }

}
