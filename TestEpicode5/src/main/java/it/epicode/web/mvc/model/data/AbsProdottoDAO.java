package it.epicode.web.mvc.model.data;

import java.util.List;

import it.epicode.web.mvc.model.Fornitore;
import it.epicode.web.mvc.model.Prodotto;

public interface AbsProdottoDAO {

	public List<Prodotto> getProdottoPerFornitore(Fornitore forn) throws DataException;
	
	public Prodotto get(long id) throws DataException;

	public List<Prodotto> getAll() throws DataException;

	public void save(Prodotto prod) throws DataException;

	public void update(Prodotto prod) throws DataException;

	public void delete(Prodotto prod) throws DataException;
	public void delete(long id) throws DataException;
	
}
