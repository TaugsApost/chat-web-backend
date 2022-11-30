package br.com.taugs.chat.participante.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ParticipantePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7436307688505738532L;
	private String username;
	private Long idGrupo;

}
