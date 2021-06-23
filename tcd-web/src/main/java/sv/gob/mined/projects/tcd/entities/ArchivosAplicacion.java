package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the archivos_aplicacion database table.
 * 
 */
@Entity
@Table(name="archivos_aplicacion")
@NamedQuery(name="ArchivosAplicacion.findAll", query="SELECT a FROM ArchivosAplicacion a")
public class ArchivosAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_archivo")
	private long idArchivo;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	//bi-directional many-to-one association to DocenteAplicacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nip_docente")
	private DocenteAplicacion docenteAplicacion;

	//bi-directional many-to-one association to TipoArchivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_archivo")
	private TipoArchivo tipoArchivo;

	public ArchivosAplicacion() {
	}

	public long getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(long idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public DocenteAplicacion getDocenteAplicacion() {
		return this.docenteAplicacion;
	}

	public void setDocenteAplicacion(DocenteAplicacion docenteAplicacion) {
		this.docenteAplicacion = docenteAplicacion;
	}

	public TipoArchivo getTipoArchivo() {
		return this.tipoArchivo;
	}

	public void setTipoArchivo(TipoArchivo tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

}