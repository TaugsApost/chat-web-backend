package br.com.taugs.chat.usuario.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.taugs.chat.contato.entity.Contato;
import br.com.taugs.chat.mensagem.chat.entity.MensagemChat;
import br.com.taugs.chat.participante.entity.Participante;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3430731374358564402L;

	public static final String QUERY_CONSULTA = "Select usuario From Usuario usuario WHERE "//
	        + "(UPPER(REPLACE(usuario.username,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :username)";

	public static final String PESQUISAR_USUARIO = "Select usuario From Usuario usuario WHERE "//
	        + "(UPPER(REPLACE(usuario.username,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :usernameContato) " //
	        + "AND usuario.username <> :username";

	public static final String PESQUISAR_POR_ID = "Select usuario From Usuario usuario WHERE "//
	        + "(UPPER(REPLACE(usuario.username,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) = :username)";

	public static final String LOGAR = "Select usuario From Usuario usuario WHERE "//
	        + "(UPPER(REPLACE(usuario.username,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) = :username) "//
	        + "AND (usuario.senha = :senha)";

	@Id
	private String username;

	private String nome;

	private String senha;

	@JsonManagedReference("contato_usuario")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Contato> listaDeContatos;

	@JsonManagedReference("chat_emissor")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "emissor", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<MensagemChat> listaMensagensEnviadas;

	@JsonManagedReference("chat_receptor")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<MensagemChat> listaMensagensRecebidas;

	@JsonManagedReference("grupo_usuario")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Participante> listaGrupos;

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
