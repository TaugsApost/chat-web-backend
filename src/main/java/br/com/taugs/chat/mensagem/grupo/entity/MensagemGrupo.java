package br.com.taugs.chat.mensagem.grupo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.chat.participante.entity.Participante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_mensagem_grupo")
@PrimaryKeyJoinColumn(name = "id_mensagem_grupo")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MensagemGrupo extends Mensagem {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Column(name = "id_grupo")
	private Long idGrupo;

	@Column(name = "usuario_emissor")
	private String username;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("mensagem_grupo")
	@JoinColumn(name = "usuario_emissor", insertable = false, updatable = false)
	@JoinColumn(name = "id_grupo", insertable = false, updatable = false)
	private Participante participante;

}
