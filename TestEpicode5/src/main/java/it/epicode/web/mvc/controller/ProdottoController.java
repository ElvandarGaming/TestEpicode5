package it.epicode.web.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.mvc.model.Prodotto;
import it.epicode.web.mvc.model.data.AbsProdottoDAO;
import it.epicode.web.mvc.model.data.DataException;

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
	
}
