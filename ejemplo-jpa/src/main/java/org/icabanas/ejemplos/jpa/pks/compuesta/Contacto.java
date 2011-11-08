package org.icabanas.ejemplos.jpa.pks.compuesta;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CONTACTO")
public class Contacto implements Serializable {

	@EmbeddedId
	private ContactoPK contactoPK;

	public Contacto() {
	}

	public ContactoPK getContactoPK() {
		return contactoPK;
	}

	public void setContactoPK(ContactoPK contactoPK) {
		this.contactoPK = contactoPK;
	}
	
	
}
