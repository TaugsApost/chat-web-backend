package br.com.taugs.chat.usuarioconversa.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioConversaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5304571251997128725L;

	private Long idUsuario;

	private Long idConversa;

	@Override
	public int hashCode() {
		return Objects.hash(idConversa, idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioConversaPK other = (UsuarioConversaPK) obj;
		return Objects.equals(idConversa, other.idConversa) && Objects.equals(idUsuario, other.idUsuario);
	}

	public UsuarioConversaPK(Long idUsuario, Long idConversa) {
		super();
		this.idUsuario = idUsuario;
		this.idConversa = idConversa;
	}

}
