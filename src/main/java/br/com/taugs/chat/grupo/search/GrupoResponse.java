package br.com.taugs.chat.grupo.search;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoResponse {

	private Long idGrupo;
	private String nome;
	private Timestamp dataAlteracao;
	private String mensagem;

}
