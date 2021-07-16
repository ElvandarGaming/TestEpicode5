package it.epicode.web.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.mvc.model.Fornitore;
import it.epicode.web.mvc.model.data.AbsFornitoreDAO;
import it.epicode.web.mvc.model.data.DataException;

public class FornitoreController {

	private AbsFornitoreDAO dao;

	public FornitoreController(AbsFornitoreDAO dao) {
		this.dao = dao;
	}
	
	public ForwOrRedir listaFornitori(HttpServletRequest request, HttpServletResponse response) throws DataException {
		List<Fornitore> result = dao.getAll();
		request.setAttribute("LISTA_FORNITORI", result);
		return new ForwOrRedir(true,"archivioFornitore.jsp");
	}

	public ForwOrRedir updateFornitore(HttpServletRequest request, HttpServletResponse response) throws DataException {

		String stringId = request.getParameter("id");
		long id = Long.parseLong(stringId);
		String codiceFornitore = request.getParameter("codiceFornitore");
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		
		Fornitore forn = new Fornitore(id, codiceFornitore, nome, indirizzo, citta);
		dao.update(forn);
		return new ForwOrRedir(false , "archivioFornitore.do");
		
	}

	public ForwOrRedir deleteFornitore(HttpServletRequest request, HttpServletResponse response) throws DataException {
		
		long id = Long.parseLong(request.getParameter("id"));
		dao.delete(id);
		return new ForwOrRedir(false , "eliminatoFornitore.jsp");
	}

	public ForwOrRedir inserisciFornitore(HttpServletRequest request, HttpServletResponse response) throws DataException {

		String stringId = request.getParameter("id");
		long id = Long.parseLong(stringId);
		String codiceFornitore = request.getParameter("codiceFornitore");
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		
		Fornitore forn = new Fornitore(id, codiceFornitore, nome, indirizzo, citta);
		dao.save(forn);
		return new ForwOrRedir(false , "archivioFornitore.do");
	}

	public ForwOrRedir caricaFornitore(HttpServletRequest request, HttpServletResponse response) throws DataException {

		long id = Long.parseLong(request.getParameter("id"));
		Fornitore forn = dao.get(id);
		request.setAttribute("fornUpdate", forn);
		return new ForwOrRedir(true, "modificaFornitore.jsp");
	}
	
	
	
	
	
}
