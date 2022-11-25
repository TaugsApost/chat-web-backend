package br.com.taugs.chat.situacaousuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_situacao_usuario", schema = "chat_db")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class SituacaoUsuario extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3682507087641011362L;

	@Id
	@Column(name = "id_situacao")
	private Long id;

	private Boolean permisao;
}
