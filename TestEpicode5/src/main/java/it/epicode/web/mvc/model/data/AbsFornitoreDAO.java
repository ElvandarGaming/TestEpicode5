package it.epicode.web.mvc.model.data;

import java.util.List;

import it.epicode.web.mvc.model.Fornitore;

public interface AbsFornitoreDAO {

	Fornitore get(long id) throws DataException;

	List<Fornitore> getAll() throws DataException;

	void save(Fornitore forn) throws DataException;

	void update(Fornitore forn) throws DataException;

	void delete(Fornitore forn) throws DataException;

	void delete(long id) throws DataException;

	List<Fornitore> getFornitoriPerCitta(String citta) throws DataException;
}