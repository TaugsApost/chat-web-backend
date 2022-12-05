package br.com.taugs.chat.participante.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.taugs.chat.grupo.entity.Grupo;
import br.com.taugs.chat.grupo.service.GrupoService;
import br.com.taugs.chat.participante.entity.Participante;
import br.com.taugs.persistence.AbstractServiceBean;
import br.com.taugs.persistence.ServiceException;

@Service
@Transactional
public class ParticipanteServiceBean extends AbstractServiceBean<Participante, Long> implements ParticipanteService {

	@Autowired
	private GrupoService grupoService;

	public ParticipanteServiceBean(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Participante> listarTodos() throws ServiceException {
		return this.listarTodosEntity();
	}

	@Override
	public Participante salvar(Participante entity) throws ServiceException {
		return this.salvarEntity(entity);
	}

	@Override
	public String excluir(Long id) throws ServiceException {
		return this.excluirEntity(id);
	}

	@Override
	public Participante detalhar(Long id) throws ServiceException {
		return this.detalharEntity(id);
	}

	@Override
	public List<Participante> salvar(List<Participante> entity) throws ServiceException {
		List<Participante> retorno = new ArrayList<Participante>();
		Grupo grupo = this.grupoService.detalhar(entity.get(0).getIdGrupo());
		if (entity.size() + grupo.getListaParticipantes().size() > 5)
			throw new ServiceException("O numero de participantes excede o permitido (5)");
		entity.forEach(e -> {
			try {
				retorno.add(this.salvar(e));
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		return retorno;
	}

}
