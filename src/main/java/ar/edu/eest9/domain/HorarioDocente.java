package ar.edu.eest9.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "horario_docente")
@NamedQueries({
    @NamedQuery(name = "HorarioDocente.findAll", query = "SELECT h FROM HorarioDocente h")
    , @NamedQuery(name = "HorarioDocente.findByIdHorario", query = "SELECT h FROM HorarioDocente h WHERE h.idHorario = :idHorario")
    , @NamedQuery(name = "HorarioDocente.findByDia", query = "SELECT h FROM HorarioDocente h WHERE h.dia = :dia")
    , @NamedQuery(name = "HorarioDocente.findByHoraInicio", query = "SELECT h FROM HorarioDocente h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "HorarioDocente.findByHoraFin", query = "SELECT h FROM HorarioDocente h WHERE h.horaFin = :horaFin")})
public class HorarioDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario")
    private Integer idHorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumn(name = "cursos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cursos cursosId;
    @JoinColumn(name = "docentes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Docentes docentesId;
    @JoinColumn(name = "materias_idmaterias", referencedColumnName = "idmaterias")
    @ManyToOne(optional = false)
    private Materias materiasIdmaterias;

    public HorarioDocente() {
    }

    public HorarioDocente(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public HorarioDocente(Integer idHorario, String dia, Date horaInicio, Date horaFin) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Cursos getCursosId() {
        return cursosId;
    }

    public void setCursosId(Cursos cursosId) {
        this.cursosId = cursosId;
    }

    public Docentes getDocentesId() {
        return docentesId;
    }

    public void setDocentesId(Docentes docentesId) {
        this.docentesId = docentesId;
    }

    public Materias getMateriasIdmaterias() {
        return materiasIdmaterias;
    }

    public void setMateriasIdmaterias(Materias materiasIdmaterias) {
        this.materiasIdmaterias = materiasIdmaterias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof HorarioDocente)) {
            return false;
        }
        HorarioDocente other = (HorarioDocente) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.idHorario + " " + this.cursosId.getNombre() + " " +this.dia +" " + this.horaInicio + "/"+ this.horaFin + " " + this.docentesId.getNombre() + " " + this.docentesId.getApellido();
    }

}
