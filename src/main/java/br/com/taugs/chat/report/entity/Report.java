package br.com.taugs.chat.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.taugs.persistence.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_report_msg", schema = "chat_db")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@IdClass(ReportPK.class)
public class Report extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2932482217833230940L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_report")
	private Long id;

	@Column(name = "id_mensagem")
	private Long idMensagem;

	private Integer motivo;

	private Integer situacao;

	private Boolean aprovada;

}
