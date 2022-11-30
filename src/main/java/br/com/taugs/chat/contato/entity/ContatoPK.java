package br.com.taugs.chat.contato.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ContatoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1627060041654699873L;
	private String usernameUsuario;
	private String usernameContato;

}
