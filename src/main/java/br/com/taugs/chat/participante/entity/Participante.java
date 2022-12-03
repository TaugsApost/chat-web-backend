package br.com.taugs.chat.participante.entity;

import java.sql.Timestamp;
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

import br.com.taugs.chat.grupo.entity.Grupo;
import br.com.taugs.chat.mensagem.grupo.entity.MensagemGrupo;
import br.com.taugs.chat.usuario.entity.Usuario;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_participante")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@IdClass(ParticipantePK.class)
public class Participante extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -593025832580475893L;

	@Id
	private String username;

	@Id
	@Column(name = "id_grupo")
	private Long idGrupo;

	private Timestamp dataInscricao;

	@JsonManagedReference("mensagem_grupo")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "participante", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<MensagemGrupo> listaDeMensagens;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("grupo_usuario")
	@JoinColumn(name = "username", insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("part")
	@JoinColumn(name = "id_grupo", insertable = false, updatable = false)
	private Grupo grupo;

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
