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
@Table(name = "padres")
@NamedQueries({
    @NamedQuery(name = "Padres.findAll", query = "SELECT p FROM Padres p")
    , @NamedQuery(name = "Padres.findById", query = "SELECT p FROM Padres p WHERE p.id = :id")
    , @NamedQuery(name = "Padres.findByApellido", query = "SELECT p FROM Padres p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Padres.findByNombre", query = "SELECT p FROM Padres p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Padres.findByDni", query = "SELECT p FROM Padres p WHERE p.dni = :dni")
    , @NamedQuery(name = "Padres.findByNacionalidad", query = "SELECT p FROM Padres p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Padres.findByOcupacion", query = "SELECT p FROM Padres p WHERE p.ocupacion = :ocupacion")
    , @NamedQuery(name = "Padres.findByDomicilio", query = "SELECT p FROM Padres p WHERE p.domicilio = :domicilio")
    , @NamedQuery(name = "Padres.findByLocalidad", query = "SELECT p FROM Padres p WHERE p.localidad = :localidad")})
public class Padres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Size(max = 45)
    @Column(name = "ocupacion")
    private String ocupacion;
    @Size(max = 80)
    @Column(name = "domicilio")
    private String domicilio;
    @Size(max = 45)
    @Column(name = "localidad")
    private String localidad;
    @ManyToMany(mappedBy = "padresList")
    private List<Alumnos> alumnosList;

    public Padres() {
    }

    public Padres(Integer id) {
        this.id = id;
    }

    public Padres(Integer id, String apellido, String nombre, String dni, String nacionalidad) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
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
        if (!(object instanceof Padres)) {
            return false;
        }
        Padres other = (Padres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + " " + this.apellido + " " + this.nombre + " "+ this.dni;
    }

}
