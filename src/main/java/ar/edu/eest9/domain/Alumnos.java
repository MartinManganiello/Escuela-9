package ar.edu.eest9.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumnos")
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a")
    , @NamedQuery(name = "Alumnos.findById", query = "SELECT a FROM Alumnos a WHERE a.id = :id")
    , @NamedQuery(name = "Alumnos.findByNombre", query = "SELECT a FROM Alumnos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumnos.findByApellido", query = "SELECT a FROM Alumnos a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Alumnos.findByLegajo", query = "SELECT a FROM Alumnos a WHERE a.legajo = :legajo")
    , @NamedQuery(name = "Alumnos.findByDni", query = "SELECT a FROM Alumnos a WHERE a.dni = :dni")
    , @NamedQuery(name = "Alumnos.findByFechaNacimiento", query = "SELECT a FROM Alumnos a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Alumnos.findByTelefono1", query = "SELECT a FROM Alumnos a WHERE a.telefono1 = :telefono1")
    , @NamedQuery(name = "Alumnos.findByTelefono2", query = "SELECT a FROM Alumnos a WHERE a.telefono2 = :telefono2")
    , @NamedQuery(name = "Alumnos.findByDomicilio", query = "SELECT a FROM Alumnos a WHERE a.domicilio = :domicilio")
    , @NamedQuery(name = "Alumnos.findByLocalidad", query = "SELECT a FROM Alumnos a WHERE a.localidad = :localidad")
    , @NamedQuery(name = "Alumnos.findByProcedencia", query = "SELECT a FROM Alumnos a WHERE a.procedencia = :procedencia")
    , @NamedQuery(name = "Alumnos.findByObservaciones", query = "SELECT a FROM Alumnos a WHERE a.observaciones = :observaciones")})
public class Alumnos implements Serializable {

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
    @Column(name = "legajo")
    private String legajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "telefono1")
    private String telefono1;
    @Size(max = 45)
    @Column(name = "telefono2")
    private String telefono2;
    @Size(max = 45)
    @Column(name = "domicilio")
    private String domicilio;
    @Size(max = 45)
    @Column(name = "localidad")
    private String localidad;
    @Size(max = 45)
    @Column(name = "procedencia")
    private String procedencia;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinTable(name = "alumnos_has_autorizados", joinColumns = {
        @JoinColumn(name = "alumnos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "autorizados_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Autorizados> autorizadosList;
    @JoinTable(name = "documentacion_has_alumnos", joinColumns = {
        @JoinColumn(name = "alumnos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "documentacion_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Documentaciones> documentacionesList;
    @JoinTable(name = "padres_has_alumnos", joinColumns = {
        @JoinColumn(name = "alumnos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "padres_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Padres> padresList;
    @JoinColumn(name = "cursos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cursos cursosId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnosId")
    private List<Documentaciones> documentacionesList1;

    public Alumnos() {
    }

    public Alumnos(Integer id) {
        this.id = id;
    }

    public Alumnos(Integer id, String nombre, String apellido, String legajo, String dni, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
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

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Autorizados> getAutorizadosList() {
        return autorizadosList;
    }

    public void setAutorizadosList(List<Autorizados> autorizadosList) {
        this.autorizadosList = autorizadosList;
    }

    public List<Documentaciones> getDocumentacionesList() {
        return documentacionesList;
    }

    public void setDocumentacionesList(List<Documentaciones> documentacionesList) {
        this.documentacionesList = documentacionesList;
    }

    public List<Padres> getPadresList() {
        return padresList;
    }

    public void setPadresList(List<Padres> padresList) {
        this.padresList = padresList;
    }

    public Cursos getCursosId() {
        return cursosId;
    }

    public void setCursosId(Cursos cursosId) {
        this.cursosId = cursosId;
    }

    public List<Documentaciones> getDocumentacionesList1() {
        return documentacionesList1;
    }

    public void setDocumentacionesList1(List<Documentaciones> documentacionesList1) {
        this.documentacionesList1 = documentacionesList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id+" " + this.apellido + " " +this.nombre+ " "+ this.legajo;
    }

}
