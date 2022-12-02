package br.com.taugs.chat.contato.entity;

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

import br.com.taugs.chat.usuario.entity.Usuario;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_contato", schema = "chat_db")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@IdClass(ContatoPK.class)
public class Contato extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4259695619723837111L;

	public static final String QUERY_PESQUISA = "SELECT contato FROM Contato contato WHERE " //
	        + "(UPPER(REPLACE(contato.nomeContato,'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :nome) "//
	        + "AND contato.usernameUsuario = :username ";

	@Id
	@Column(name = "username_usuario")
	private String usernameUsuario;

	@Id
	@Column(name = "username_contato")
	private String usernameContato;

	private String nomeContato;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("contato_usuario")
	@JoinColumn(name = "username_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	// @ManyToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "username_contato", insertable = false, updatable = false)
	// private Usuario contato;

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
