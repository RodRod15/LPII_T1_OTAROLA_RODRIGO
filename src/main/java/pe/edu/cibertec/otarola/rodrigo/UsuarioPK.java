package pe.edu.cibertec.otarola.rodrigo;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the usuario database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int iduser;

	@Column(name="role_idrole", insertable=false, updatable=false)
	private int roleIdrole;

	@Column(name="person_idperson", insertable=false, updatable=false)
	private int personIdperson;

	public UsuarioPK() {
	}
	public int getIduser() {
		return this.iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public int getRoleIdrole() {
		return this.roleIdrole;
	}
	public void setRoleIdrole(int roleIdrole) {
		this.roleIdrole = roleIdrole;
	}
	public int getPersonIdperson() {
		return this.personIdperson;
	}
	public void setPersonIdperson(int personIdperson) {
		this.personIdperson = personIdperson;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			(this.iduser == castOther.iduser)
			&& (this.roleIdrole == castOther.roleIdrole)
			&& (this.personIdperson == castOther.personIdperson);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iduser;
		hash = hash * prime + this.roleIdrole;
		hash = hash * prime + this.personIdperson;
		
		return hash;
	}
}