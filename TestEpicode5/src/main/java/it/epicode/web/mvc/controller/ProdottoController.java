package it.epicode.web.mvc.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.mvc.model.Fornitore;
import it.epicode.web.mvc.model.Prodotto;
import it.epicode.web.mvc.model.data.AbsProdottoDAO;
import it.epicode.web.mvc.model.data.DataException;
import it.epicode.web.mvc.model.data.FornitoreDAO;

public class ProdottoController{

	private AbsProdottoDAO dao;

	public ProdottoController(AbsProdottoDAO dao) {
		this.dao = dao;
	}
	
	
	public ForwOrRedir listaProdotti(HttpServletRequest request, HttpServletResponse response) throws DataException {
		List<Prodotto> result = dao.getAll();
		request.setAttribute("LISTA_PRODOTTI", result);
		return new ForwOrRedir(true,"archivioProdotto.jsp");
	}

	public ForwOrRedir inserisciProdotto(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String stringId = request.getParameter("id");
		long id = Long.parseLong(stringId);
		String codiceProdotto = request.getParameter("codiceProdotto");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String marca = request.getParameter("marca");
		String fornitore = request.getParameter("fornitore");
		FornitoreDAO x = new FornitoreDAO();
		Fornitore ilMale = x.get(fornitore);
		String stringPrezzo = request.getParameter("prezzo");
		
		BigDecimal prezzo = new BigDecimal(stringPrezzo);
		
		Prodotto prod = new Prodotto(id, codiceProdotto, nome, descrizione, marca, ilMale, prezzo);
		dao.save(prod);
		return new ForwOrRedir(false , "archivioProdotto.do");
	}
	
	
	
	public ForwOrRedir caricaProdotto(HttpServletRequest request, HttpServletResponse response) throws DataException {

		long id = Long.parseLong(request.getParameter("id"));
		Prodotto prod = dao.get(id);
		request.setAttribute("prodUpdate", prod);
		return new ForwOrRedir(true, "modificaProdotto.jsp");
	}
	

	public ForwOrRedir updateProdotto(HttpServletRequest request, HttpServletResponse response) throws DataException {

		String stringId = request.getParameter("id");
		long id = Long.parseLong(stringId);
		String codiceProdotto = request.getParameter("codiceProdotto");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String marca = request.getParameter("marca");
		String fornitore = request.getParameter("fornitore");
		FornitoreDAO x = new FornitoreDAO();
		Fornitore ilMale = x.get(fornitore);
		String stringPrezzo = request.getParameter("prezzo");
		BigDecimal prezzo = new BigDecimal(stringPrezzo);
		
		Prodotto prod = new Prodotto(id, codiceProdotto, nome, descrizione, marca, ilMale, prezzo);
		dao.update(prod);
		return new ForwOrRedir(false , "archivioProdotto.do");
		
	}

	public ForwOrRedir deleteProdotto(HttpServletRequest request, HttpServletResponse response) throws DataException {
		
		long id = Long.parseLong(request.getParameter("id"));
		dao.delete(id);
		return new ForwOrRedir(false , "eliminatoProdotto.jsp");
	}
	
	
	
	
	
	
	
}
