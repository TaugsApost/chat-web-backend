package br.com.taugs.persistence;

import java.util.List;

public interface IService<E extends AbstractEntity<T>, T extends Object> {

	List<E> listarTodos() throws ServiceException;

	E salvar(E entity) throws ServiceException;

	String excluir(T id) throws ServiceException;

	E detalhar(T id) throws ServiceException;
}
