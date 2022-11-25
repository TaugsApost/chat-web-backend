package br.com.taugs.chat.mensagem.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_mensagem", schema = "chat_db")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mensagem extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5354613634159306651L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mensagem")
	private Long id;

	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "id_conversa")
	private Long idConversa;

	private String conteudo;

	@Column(name = "data_envio")
	private Timestamp dataEnvio;

	// @JsonManagedReference("mensagem")
	// @Fetch(value = FetchMode.SUBSELECT)
	// @OneToMany(mappedBy = "mensagem", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	// private List<UsuarioConversaMensagem> listaDeConversas;

}
