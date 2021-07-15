package it.epicode.web.mvc.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.epicode.web.mvc.model.Fornitore;
import it.epicode.web.mvc.model.Prodotto;

public class ProdottoDAO {

	public static final String GET_PRODOTTO_FROM_FORNITORE = "SELECT a.id as prod_id,a.codice_prodotto,a.nome as prod_name,a.descrizione,a.marca,a.codice_fornitore_fk,a.prezzo,\r\n"
			+ "b.id as forn_id,b.codice_fornitore,b.nome as forn_name,b.indirizzo,b.citta FROM negozio.prodotto a INNER JOIN negozio.fornitore b ON a.codice_fornitore_fk= b.codice_fornitore\r\n"
			+ "WHERE b.id = ?";
	private static final String GET_PRODOTTO_BY_ID = "SELECT a.id as prod_id,a.codice_prodotto,a.nome as prod_name,a.descrizione,a.marca,a.codice_fornitore_fk,a.prezzo,\r\n"
			+ "			b.id as forn_id,b.codice_fornitore,b.nome as forn_name,b.indirizzo,b.citta FROM negozio.prodotto a INNER JOIN negozio.fornitore b ON a.codice_fornitore_fk= b.codice_fornitore\r\n"
			+ "			 WHERE a.id = ?";
	private static final String SAVE_PRODOTTO = "INSERT INTO negozio.prodotto (id, codice_prodotto, nome, descrizione, marca, codice_fornitore_fk, prezzo) values (?,?,?,?,?,?,?); ";
	private static final String UPDATE_PRODOTTO ="UPDATE negozio.prodotto SET codice_prodotto=?, nome=?, descrizione=?, marca=?, codice_fornitore_fk=?, prezzo=? WHERE id=?";
	private static final String DELETE_PRODOTTO = "DELETE FROM negozio.prodotto WHERE id=?";
	private static final String GET_ALL_PRODOTTO = "SELECT a.id as prod_id,a.codice_prodotto,a.nome as prod_name,a.descrizione,a.marca,a.codice_fornitore_fk,a.prezzo,\r\n"
			+ "			b.id as forn_id,b.codice_fornitore,b.nome as forn_name,b.indirizzo,b.citta FROM negozio.prodotto a INNER JOIN negozio.fornitore b ON a.codice_fornitore_fk= b.codice_fornitore";
	private CreatoreConnessione conn;

	public ProdottoDAO(CreatoreConnessione conn) {
		this.conn = conn;
	}

	public List<Prodotto> getProdottoPerFornitore(Fornitore forn) throws SQLException {
		List<Prodotto> lista = new ArrayList<>();
		try (Connection x = conn.getConnection();
				PreparedStatement psta = x.prepareStatement(GET_PRODOTTO_FROM_FORNITORE);) {
			psta.setLong(1, forn.getId());

			try (ResultSet res = psta.executeQuery();) {
				while (res.next()) {
					lista.add(new Prodotto(res.getLong("prod_id"), res.getString("codice_prodotto"),
							res.getString("prod_name"), res.getString("descrizione"), res.getString("marca"),
							new Fornitore(res.getLong("forn_id"), res.getString("codice_fornitore"),
									res.getString("forn_name"), res.getString("indirizzo"), res.getString("citta")),
							res.getBigDecimal("prezzo")));
				}
			}
		}

		return lista;
	}
	
	public Prodotto get(long id) throws SQLException {
		Prodotto letto = null;
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(GET_PRODOTTO_BY_ID);) {
			psta.setLong(1, id);
			try (ResultSet res = psta.executeQuery();) {
				while (res.next()) {
					letto = new Prodotto(res.getLong("prod_id"), res.getString("codice_prodotto"),
							res.getString("prod_name"), res.getString("descrizione"), res.getString("marca"),
							new Fornitore(res.getLong("forn_id"), res.getString("codice_fornitore"),
									res.getString("forn_name"), res.getString("indirizzo"), res.getString("citta")),
							res.getBigDecimal("prezzo"));
				}
			}
		}
		return letto;
	}

	public List<Prodotto> getAll() throws SQLException {
		List<Prodotto> letto = new ArrayList<>();
		try (Connection x = conn.getConnection();
				Statement stat = x.createStatement();
				ResultSet res = stat.executeQuery(GET_ALL_PRODOTTO);) {
			while (res.next()) {
				letto.add(new Prodotto(res.getLong("prod_id"), res.getString("codice_prodotto"),
						res.getString("prod_name"), res.getString("descrizione"), res.getString("marca"),
						new Fornitore(res.getLong("forn_id"), res.getString("codice_fornitore"),
								res.getString("forn_name"), res.getString("indirizzo"), res.getString("citta")),
						res.getBigDecimal("prezzo")));
			}

		}
		return letto;
	}

	public void save(Prodotto prod) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(SAVE_PRODOTTO);) {
			psta.setLong(1, prod.getId());
			psta.setString(2, prod.getCodiceProdotto());
			psta.setString(3, prod.getNome());
			psta.setString(4, prod.getDescrizione());
			psta.setString(5, prod.getMarca());
			psta.setString(6, prod.getFornitore().getCodiceFornitore());
			psta.setBigDecimal(7, prod.getPrezzo());

			psta.executeUpdate();
		}
	}

	public void update(Prodotto prod) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(UPDATE_PRODOTTO);) {
			psta.setString(1, prod.getCodiceProdotto());
			psta.setString(2, prod.getNome());
			psta.setString(3, prod.getDescrizione());
			psta.setString(4, prod.getMarca());
			psta.setString(5, prod.getFornitore().getCodiceFornitore());
			psta.setBigDecimal(6, prod.getPrezzo());
			psta.setLong(7, prod.getId());

			psta.executeUpdate();
		}
	}

	public void delete(Prodotto prod) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(DELETE_PRODOTTO);) {
			psta.setLong(1, prod.getId());

			psta.executeUpdate();
		}
	}
	public void delete(long id) throws SQLException {
		try (Connection x = conn.getConnection(); PreparedStatement psta = x.prepareStatement(DELETE_PRODOTTO);) {
			psta.setLong(1, id);

			psta.executeUpdate();
		}
	}
	
	
	
}
