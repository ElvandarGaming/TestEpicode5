package it.epicode.web.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.mvc.model.data.FornitoreDAO;
import it.epicode.web.mvc.model.data.ProdottoDAO;

@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getRequestURI();
		int slash = path.lastIndexOf('/');
		String action = path.substring(slash + 1, path.length() - 3);

		BaseController bc = new BaseController();
		FornitoreController fc = new FornitoreController(new FornitoreDAO());
		ProdottoController pc = new ProdottoController(new ProdottoDAO());
		ForwOrRedir fr = null;

		try {
			switch (action.toLowerCase()) {
			case "homepage": {
				fr = bc.getHomePage();
			}
				break;
			case "showinseriscifornitore": {
				fr = new ForwOrRedir(true, "aggiungiFornitore.jsp");
			}
				break;
		
			case "showmodificafornitore": {
				fr = fc.caricaFornitore(request, response);
			}
				break;
				
			case "updatefornitore": {
				fr = fc.updateFornitore(request, response);
			}
				break;
			
			case "archiviofornitore": {
				fr = fc.listaFornitori(request, response);
			}
				break;
			case "inseriscifornitore": {
				fr = fc.inserisciFornitore(request, response);
			}
				break;
			
			case "deletefornitore": {
				fr = fc.deleteFornitore(request, response);
			}
				break;
			case "archivioprodotto": {
				fr = pc.listaProdotti(request, response);
			}
				break;
			default:
				fr = bc.getMissingPage(request, response);
			}
		} catch (Exception e) {

		}

		if (fr.isForward()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(fr.getUrl());
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(fr.getUrl());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}