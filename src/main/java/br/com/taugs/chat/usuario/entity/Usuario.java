package br.com.taugs.chat.usuario.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.taugs.chat.contato.entity.Contato;
import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversa;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario", schema = "chat_db")
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
	        + "(UPPER(TRANSLATE(COALESCE(usuario.userName,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :userName)";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	private String nome;

	private String senha;

	@Column(name = "user_name")
	private String userName;

	private Boolean permissao;

	@JsonManagedReference("contato_usuario")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Contato> listaDeContatos;

	@JsonManagedReference("usuario_conversa")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<UsuarioConversa> listaDeConversas;

}
