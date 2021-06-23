package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_archivo database table.
 * 
 */
@Entity
@Table(name="tipo_archivo")
@NamedQuery(name="TipoArchivo.findAll", query="SELECT t FROM TipoArchivo t")
public class TipoArchivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_archivo")
	private long idTipoArchivo;

	@Column(name="abrev_tipo_archivo")
	private String abrevTipoArchivo;

	@Column(name="nombre_tipo_archivo")
	private String nombreTipoArchivo;

	//bi-directional many-to-one association to ArchivosAplicacion
	@OneToMany(mappedBy="tipoArchivo")
	private List<ArchivosAplicacion> archivosAplicacions;

	public TipoArchivo() {
	}

	public long getIdTipoArchivo() {
		return this.idTipoArchivo;
	}

	public void setIdTipoArchivo(long idTipoArchivo) {
		this.idTipoArchivo = idTipoArchivo;
	}

	public String getAbrevTipoArchivo() {
		return this.abrevTipoArchivo;
	}

	public void setAbrevTipoArchivo(String abrevTipoArchivo) {
		this.abrevTipoArchivo = abrevTipoArchivo;
	}

	public String getNombreTipoArchivo() {
		return this.nombreTipoArchivo;
	}

	public void setNombreTipoArchivo(String nombreTipoArchivo) {
		this.nombreTipoArchivo = nombreTipoArchivo;
	}

	public List<ArchivosAplicacion> getArchivosAplicacions() {
		return this.archivosAplicacions;
	}

	public void setArchivosAplicacions(List<ArchivosAplicacion> archivosAplicacions) {
		this.archivosAplicacions = archivosAplicacions;
	}

	public ArchivosAplicacion addArchivosAplicacion(ArchivosAplicacion archivosAplicacion) {
		getArchivosAplicacions().add(archivosAplicacion);
		archivosAplicacion.setTipoArchivo(this);

		return archivosAplicacion;
	}

	public ArchivosAplicacion removeArchivosAplicacion(ArchivosAplicacion archivosAplicacion) {
		getArchivosAplicacions().remove(archivosAplicacion);
		archivosAplicacion.setTipoArchivo(null);

		return archivosAplicacion;
	}

}