package br.com.taugs.chat.usuarioconversamensagem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.chat.mensagem.entity.Mensagem;
import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversa;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario_conversa_mensagem", schema = "chat_db")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@IdClass(UsuarioConverMensagemPK.class)
public class UsuarioConversaMensagem extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2533167964511120790L;

	public UsuarioConversaMensagem(Long idConvera, Long idMensagem, Long idUsuario) {
		this.idConversa = idConvera;
		this.idUsuario = idUsuario;
		this.idMensagem = idMensagem;
	}

	@Id
	@Column(name = "id_conversa")
	private Long idConversa;

	@Id
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Id
	@Column(name = "id_mensagem")
	private Long idMensagem;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("usuario_conversa_mensagem")
	@JoinColumn(referencedColumnName = "id_usuario", insertable = false, updatable = false)
	@JoinColumn(referencedColumnName = "id_conversa", insertable = false, updatable = false)
	private UsuarioConversa conversa;

	// @JsonBackReference("mensagem")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mensagem", insertable = false, updatable = false)
	private Mensagem mensagem;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

}
