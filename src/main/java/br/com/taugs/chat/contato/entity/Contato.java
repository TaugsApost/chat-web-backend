package br.com.taugs.chat.contato.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Contato extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4259695619723837111L;

	public static final String QUERY_PESQUISA = "SELECT contato FROM Contato contato WHERE " //
	        + "(UPPER(TRANSLATE(COALESCE(contato.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :nome)";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;

	@Column(name = "id_usuario_contato")
	private Long idUsuarioContato;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("contato_usuario")
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	@Column(name = "id_usuario")
	private Long idUsuario;

	private String nome;

}
