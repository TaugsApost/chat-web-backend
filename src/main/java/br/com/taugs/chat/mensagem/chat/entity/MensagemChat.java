package br.com.taugs.chat.mensagem.chat.entity;

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
import br.com.taugs.chat.usuario.entity.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_mensagem_chat")
@PrimaryKeyJoinColumn(name = "id_mensagem_chat")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MensagemChat extends Mensagem {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5774040485566553631L;

	@Column(name = "usuario_emissor")
	private String usernameEmissor;

	@Column(name = "usuario_receptor")
	private String usernameReceptor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("chat_receptor")
	@JoinColumn(name = "usuario_receptor", insertable = false, updatable = false)
	private Usuario receptor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("chat_emissor")
	@JoinColumn(name = "usuario_emissor", insertable = false, updatable = false)
	private Usuario emissor;

}
