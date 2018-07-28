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
@Table(name = "materias")
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")
    , @NamedQuery(name = "Materias.findByIdmaterias", query = "SELECT m FROM Materias m WHERE m.idmaterias = :idmaterias")
    , @NamedQuery(name = "Materias.findByNombre", query = "SELECT m FROM Materias m WHERE m.nombre = :nombre")})
public class Materias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmaterias")
    private Integer idmaterias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiasIdmaterias")
    private List<HorarioDocente> horarioDocenteList;

    public Materias() {
    }

    public Materias(Integer idmaterias) {
        this.idmaterias = idmaterias;
    }

    public Materias(Integer idmaterias, String nombre) {
        this.idmaterias = idmaterias;
        this.nombre = nombre;
    }

    public Integer getIdmaterias() {
        return idmaterias;
    }

    public void setIdmaterias(Integer idmaterias) {
        this.idmaterias = idmaterias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idmaterias != null ? idmaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.idmaterias == null && other.idmaterias != null) || (this.idmaterias != null && !this.idmaterias.equals(other.idmaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.idmaterias + " " + this.nombre;
    }

}
