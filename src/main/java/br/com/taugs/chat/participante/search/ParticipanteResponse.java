package br.com.taugs.chat.participante.search;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipanteResponse {

	private Long idGrupo;
	private String nomeGrupo;
	private String mensagem;
	private Timestamp dataAlteracao;

}
