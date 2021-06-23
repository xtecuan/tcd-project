package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the docente_aplicacion database table.
 * 
 */
@Entity
@Table(name="docente_aplicacion")
@NamedQuery(name="DocenteAplicacion.findAll", query="SELECT d FROM DocenteAplicacion d")
public class DocenteAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nip_docente")
	private String nipDocente;

	@Column(name="aplicacion_cerrada")
	private String aplicacionCerrada;

	@Column(name="direccion_docente")
	private String direccionDocente;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_aplicacion")
	private Date fechaAplicacion;

	@Column(name="id_motivo_traslado")
	private BigDecimal idMotivoTraslado;

	@Column(name="telefono_fijo_docente")
	private BigDecimal telefonoFijoDocente;

	@Column(name="telefono_movil_docente")
	private BigDecimal telefonoMovilDocente;

	//bi-directional many-to-one association to AplicacionDocentePlaza
	@OneToMany(mappedBy="docenteAplicacion")
	private List<AplicacionDocentePlaza> aplicacionDocentePlazas;

	//bi-directional many-to-one association to ArchivosAplicacion
	@OneToMany(mappedBy="docenteAplicacion")
	private List<ArchivosAplicacion> archivosAplicacions;

	//bi-directional one-to-one association to Docente
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nip_docente")
	private Docente docente;

	//bi-directional many-to-one association to Municipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_munic_docente")
	private Municipio municipio;

	//bi-directional many-to-one association to DocenteDiscapacidad
	@OneToMany(mappedBy="docenteAplicacion")
	private List<DocenteDiscapacidad> docenteDiscapacidads;

	//bi-directional many-to-one association to DocenteEspecialidad
	@OneToMany(mappedBy="docenteAplicacion")
	private List<DocenteEspecialidad> docenteEspecialidads;

	public DocenteAplicacion() {
	}

	public String getNipDocente() {
		return this.nipDocente;
	}

	public void setNipDocente(String nipDocente) {
		this.nipDocente = nipDocente;
	}

	public String getAplicacionCerrada() {
		return this.aplicacionCerrada;
	}

	public void setAplicacionCerrada(String aplicacionCerrada) {
		this.aplicacionCerrada = aplicacionCerrada;
	}

	public String getDireccionDocente() {
		return this.direccionDocente;
	}

	public void setDireccionDocente(String direccionDocente) {
		this.direccionDocente = direccionDocente;
	}

	public Date getFechaAplicacion() {
		return this.fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public BigDecimal getIdMotivoTraslado() {
		return this.idMotivoTraslado;
	}

	public void setIdMotivoTraslado(BigDecimal idMotivoTraslado) {
		this.idMotivoTraslado = idMotivoTraslado;
	}

	public BigDecimal getTelefonoFijoDocente() {
		return this.telefonoFijoDocente;
	}

	public void setTelefonoFijoDocente(BigDecimal telefonoFijoDocente) {
		this.telefonoFijoDocente = telefonoFijoDocente;
	}

	public BigDecimal getTelefonoMovilDocente() {
		return this.telefonoMovilDocente;
	}

	public void setTelefonoMovilDocente(BigDecimal telefonoMovilDocente) {
		this.telefonoMovilDocente = telefonoMovilDocente;
	}

	public List<AplicacionDocentePlaza> getAplicacionDocentePlazas() {
		return this.aplicacionDocentePlazas;
	}

	public void setAplicacionDocentePlazas(List<AplicacionDocentePlaza> aplicacionDocentePlazas) {
		this.aplicacionDocentePlazas = aplicacionDocentePlazas;
	}

	public AplicacionDocentePlaza addAplicacionDocentePlaza(AplicacionDocentePlaza aplicacionDocentePlaza) {
		getAplicacionDocentePlazas().add(aplicacionDocentePlaza);
		aplicacionDocentePlaza.setDocenteAplicacion(this);

		return aplicacionDocentePlaza;
	}

	public AplicacionDocentePlaza removeAplicacionDocentePlaza(AplicacionDocentePlaza aplicacionDocentePlaza) {
		getAplicacionDocentePlazas().remove(aplicacionDocentePlaza);
		aplicacionDocentePlaza.setDocenteAplicacion(null);

		return aplicacionDocentePlaza;
	}

	public List<ArchivosAplicacion> getArchivosAplicacions() {
		return this.archivosAplicacions;
	}

	public void setArchivosAplicacions(List<ArchivosAplicacion> archivosAplicacions) {
		this.archivosAplicacions = archivosAplicacions;
	}

	public ArchivosAplicacion addArchivosAplicacion(ArchivosAplicacion archivosAplicacion) {
		getArchivosAplicacions().add(archivosAplicacion);
		archivosAplicacion.setDocenteAplicacion(this);

		return archivosAplicacion;
	}

	public ArchivosAplicacion removeArchivosAplicacion(ArchivosAplicacion archivosAplicacion) {
		getArchivosAplicacions().remove(archivosAplicacion);
		archivosAplicacion.setDocenteAplicacion(null);

		return archivosAplicacion;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<DocenteDiscapacidad> getDocenteDiscapacidads() {
		return this.docenteDiscapacidads;
	}

	public void setDocenteDiscapacidads(List<DocenteDiscapacidad> docenteDiscapacidads) {
		this.docenteDiscapacidads = docenteDiscapacidads;
	}

	public DocenteDiscapacidad addDocenteDiscapacidad(DocenteDiscapacidad docenteDiscapacidad) {
		getDocenteDiscapacidads().add(docenteDiscapacidad);
		docenteDiscapacidad.setDocenteAplicacion(this);

		return docenteDiscapacidad;
	}

	public DocenteDiscapacidad removeDocenteDiscapacidad(DocenteDiscapacidad docenteDiscapacidad) {
		getDocenteDiscapacidads().remove(docenteDiscapacidad);
		docenteDiscapacidad.setDocenteAplicacion(null);

		return docenteDiscapacidad;
	}

	public List<DocenteEspecialidad> getDocenteEspecialidads() {
		return this.docenteEspecialidads;
	}

	public void setDocenteEspecialidads(List<DocenteEspecialidad> docenteEspecialidads) {
		this.docenteEspecialidads = docenteEspecialidads;
	}

	public DocenteEspecialidad addDocenteEspecialidad(DocenteEspecialidad docenteEspecialidad) {
		getDocenteEspecialidads().add(docenteEspecialidad);
		docenteEspecialidad.setDocenteAplicacion(this);

		return docenteEspecialidad;
	}

	public DocenteEspecialidad removeDocenteEspecialidad(DocenteEspecialidad docenteEspecialidad) {
		getDocenteEspecialidads().remove(docenteEspecialidad);
		docenteEspecialidad.setDocenteAplicacion(null);

		return docenteEspecialidad;
	}

}