package sv.gob.mined.projects.tcd.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuarios_log database table.
 * 
 */
@Entity
@Table(name="usuarios_log")
@NamedQuery(name="UsuariosLog.findAll", query="SELECT u FROM UsuariosLog u")
public class UsuariosLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reg")
	private long idReg;

	private String fallido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String login;

	@Column(name="motivo_fallido")
	private String motivoFallido;

	public UsuariosLog() {
	}

	public long getIdReg() {
		return this.idReg;
	}

	public void setIdReg(long idReg) {
		this.idReg = idReg;
	}

	public String getFallido() {
		return this.fallido;
	}

	public void setFallido(String fallido) {
		this.fallido = fallido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotivoFallido() {
		return this.motivoFallido;
	}

	public void setMotivoFallido(String motivoFallido) {
		this.motivoFallido = motivoFallido;
	}

}