package br.com.taugs.chat.usuarioconversamensagem.entity;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioConverMensagemPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5097181852497302423L;

	protected Long idConversa;

	protected Long idUsuario;

	protected Long idMensagem;

	@Override
	public int hashCode() {
		return Objects.hash(idConversa, idMensagem, idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioConverMensagemPK other = (UsuarioConverMensagemPK) obj;
		return Objects.equals(idConversa, other.idConversa) && Objects.equals(idMensagem, other.idMensagem) && Objects.equals(idUsuario, other.idUsuario);
	}

}
