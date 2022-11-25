package br.com.taugs.chat.conversa.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_grupo", schema = "chat_db")
@PrimaryKeyJoinColumn(name = "id_grupo")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Grupo extends Conversa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2036416049278950449L;

	@Column(name = "data_criacao")
	private Timestamp dataCriacao;

}
