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

	// public static final String LISTAR_MENSAGENS_USUARIO = "SELECT MAX(msg) FROM MensagemChat msg zWHERE "//
	// + "((msg.usernameEmissor = :username) OR (msg.usernameReceptor = :username)) " //
	// + "group by msg.usernameEmissor, msg.usernameReceptor ";
	// + "order by msg.dataEnvio DESC";

	public static final String LISTAR_MENSAGENS_USUARIO = "SELECT MAX(msg) FROM MensagemChat msg "//
	        + "LEFT JOIN msg.receptor.listaDeContatos contatoReceptor "//
	        + "LEFT JOIN msg.emissor.listaDeContatos contatoEmissor "//
	        + "WHERE "//
	        + "("//
	        + "	((msg.usernameEmissor = :username) "//
	        + "		AND( "//
	        + "			(UPPER(REPLACE(contatoEmissor.nomeContato,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :str) "//
	        + "			OR (UPPER(REPLACE(msg.conteudo,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :str) "//
	        + "		) "//
	        + "	) " //
	        + "	OR ((msg.usernameReceptor = :username) "//
	        + "		AND( "//
	        + "			(UPPER(REPLACE(contatoReceptor.nomeContato,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :str) "//
	        + "			OR (UPPER(REPLACE(msg.conteudo,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :str) "//
	        + "		)"//
	        + "	)" //
	        + ") "//
	        + "group by msg.usernameEmissor, msg.usernameReceptor ";

	public static final String LISTAR_MENSAGENS_CONVERSA = "SELECT msg FROM MensagemChat msg WHERE "//
	        + "((msg.usernameEmissor = :username1) AND (msg.usernameReceptor = :username2)) "//
	        + " OR ((msg.usernameEmissor = :username2) AND (msg.usernameReceptor = :username1))";

	@Column(name = "usuario_emissor")
	private String usernameEmissor;

	@Column(name = "usuario_receptor")
	private String usernameReceptor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference("chat_receptor")
	@JoinColumn(name = "usuario_receptor", insertable = false, updatable = false)
	private Usuario receptor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference("chat_emissor")
	@JoinColumn(name = "usuario_emissor", insertable = false, updatable = false)
	private Usuario emissor;

}
