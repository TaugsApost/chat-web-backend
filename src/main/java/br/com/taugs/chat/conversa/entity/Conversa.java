package br.com.taugs.chat.conversa.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.taugs.chat.usuarioconversa.entity.UsuarioConversa;
import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_conversa", schema = "chat_db")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Conversa extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2645238825264419986L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conversa")
	private Long id;

	@Column(name = "data_alteracao")
	private Timestamp dataAlteracao;

	@JsonManagedReference("conversa_usuario")
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "conversa", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<UsuarioConversa> listaDeUsuarios;

}
