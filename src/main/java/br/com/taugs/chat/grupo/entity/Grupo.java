package br.com.taugs.chat.grupo.entity;

import java.sql.Timestamp;
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

import br.com.taugs.chat.participante.entity.Participante;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_grupo")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Grupo extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3858891167485937630L;

	public static final String PESQUISAR_POR_NOME = "SELECT grupo FROM Grupo grupo WHERE " //
	        + "(UPPER(TRANSLATE(COALESCE(grupo.nome,''),'áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ','aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII')) LIKE :nome)";

	public static final String BUSCAR_GRUPO_POR_USUARIO = "SELECT grupo FROM Grupo grupo "//
	        + "LEFT JOIN FETCH grupo.listaParticipantes participante " //
	        + "WHERE participante.username = :username";

	@Id
	@Column(name = "id_grupo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Timestamp dataAlteracao;

	private Timestamp dataCriacao;

	@JsonManagedReference("part")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Participante> listaParticipantes;

}
