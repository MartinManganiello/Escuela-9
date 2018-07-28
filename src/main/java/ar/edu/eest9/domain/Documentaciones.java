package ar.edu.eest9.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "documentaciones")
@NamedQueries({
    @NamedQuery(name = "Documentaciones.findAll", query = "SELECT d FROM Documentaciones d")
    , @NamedQuery(name = "Documentaciones.findById", query = "SELECT d FROM Documentaciones d WHERE d.id = :id")
    , @NamedQuery(name = "Documentaciones.findByTitulo", query = "SELECT d FROM Documentaciones d WHERE d.titulo = :titulo")})
public class Documentaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @ManyToMany(mappedBy = "documentacionesList")
    private List<Alumnos> alumnosList;
    @JoinColumn(name = "alumnos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Alumnos alumnosId;

    public Documentaciones() {
    }

    public Documentaciones(Integer id) {
        this.id = id;
    }

    public Documentaciones(Integer id, String titulo, byte[] foto) {
        this.id = id;
        this.titulo = titulo;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<Alumnos> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumnos> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public Alumnos getAlumnosId() {
        return alumnosId;
    }

    public void setAlumnosId(Alumnos alumnosId) {
        this.alumnosId = alumnosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Documentaciones)) {
            return false;
        }
        Documentaciones other = (Documentaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + " " + this.titulo;
    }

}
