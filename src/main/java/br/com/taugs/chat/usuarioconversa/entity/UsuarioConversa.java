package br.com.taugs.chat.usuarioconversa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.taugs.chat.conversa.entity.Conversa;
import br.com.taugs.chat.usuario.entity.Usuario;
import br.com.taugs.chat.usuarioconversamensagem.entity.UsuarioConversaMensagem;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario_conversa", schema = "chat_db")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@IdClass(UsuarioConversaPK.class)
public class UsuarioConversa extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3698975990993158903L;

	@Id
	@Column(name = "id_conversa")
	private Long idConversa;

	@Id
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nome_conversa")
	private String nomeConversa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("usuario_conversa")
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("conversa_usuario")
	@JoinColumn(name = "id_conversa", insertable = false, updatable = false)
	private Conversa conversa;

	@JsonManagedReference("usuario_conversa_mensagem")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "conversa", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<UsuarioConversaMensagem> listaDeMensagens;

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
