package br.com.taugs.chat.report.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Long id;

	protected Long idMensagem;

	@Override
	public int hashCode() {
		return Objects.hash(id, idMensagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportPK other = (ReportPK) obj;
		return Objects.equals(id, other.id) && Objects.equals(idMensagem, other.idMensagem);
	}

}
