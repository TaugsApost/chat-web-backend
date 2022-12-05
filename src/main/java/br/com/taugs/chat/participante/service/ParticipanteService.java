package br.com.taugs.chat.participante.service;

import java.util.List;

import br.com.taugs.chat.participante.entity.Participante;
import br.com.taugs.persistence.IService;
import br.com.taugs.persistence.ServiceException;

public interface ParticipanteService extends IService<Participante, Long> {

	List<Participante> salvar(List<Participante> entity) throws ServiceException;

}
