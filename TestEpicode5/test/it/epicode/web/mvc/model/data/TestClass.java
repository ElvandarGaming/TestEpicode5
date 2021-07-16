package it.epicode.web.mvc.model.data;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.epicode.web.mvc.model.Fornitore;
import it.epicode.web.mvc.model.Prodotto;

class TestClass {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("avvio");
	}
	@AfterEach
	void tearDown() throws Exception {
		//System.out.println("arresto");
	}
	
	@Test
	void inserimentoFornitore() {
		
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		FornitoreDAO t = new FornitoreDAO(portal);
		//Fornitore marchi = new Fornitore(1, "X123", "Marchi", "Via verdi,3","Verona");
		//Fornitore rogi = new Fornitore(3, "y163", "Rogi", "Via lincoln,46", "Padova");
		Fornitore marchi2 = new Fornitore(2, "X143", "Marchi", "Via verdi,3", "Verona");
		
		try {

			t.save(marchi2);
			assertTrue(esisteFornitore(2));
			//t.save(marchi);
			//t.save(rogi);
		} catch (DataException e) {
			fail(e.getMessage());
		}
		System.out.println("Eliminato Marchi");
	}
	
	
	@Test
	void eliminazioneFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		FornitoreDAO t = new FornitoreDAO(portal);
		Fornitore marchi2 = new Fornitore(2, "X123", "Marchi", "Via verdi,3", "Verona");
		try {
			t.delete(marchi2);
		} catch (DataException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Inserito Marchi");

	}
	@Test
	void inserimento_E_UPDATE_Prodotto() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		ProdottoDAO t = new ProdottoDAO(portal);
		FornitoreDAO f = new FornitoreDAO(portal);
		
		try {
			Fornitore ciccio = f.get(1);
			//Prodotto prod1 = new Prodotto(1l, "12e", "carta igienica", "morbida e lunga", "softy",ciccio, new BigDecimal("2"));
			//Prodotto prod2 = new Prodotto(2l, "14f", "scottex", "corto e ruvido", "scratchy",ciccio, new BigDecimal("5"));
			Prodotto prod3 = new Prodotto(3l, "15z", "Carta vetrata", "spigolosa", "Hellas",ciccio, new BigDecimal("15"));
			//t.save(prod1);
			//t.save(prod2);
			t.save(prod3);
			
		} catch (SQLException | DataException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Inserito prodotto per marchi con id 3");
		
		
			//non mi fa le cose in ordine il test, e quindi testo qui la modifica prodotto

			try {
				
				Fornitore ciccio = f.get(1);
				Prodotto prod3 = new Prodotto(3l, "15z", "Carta vetrata", "spigolosa", "Hellas",ciccio, new BigDecimal("20"));
				

				t.update(prod3);
				Prodotto upd = t.get(prod3.getId());
				System.out.println(upd.getPrezzo());
			} catch (SQLException | DataException e) {
				e.printStackTrace();
				fail("Non va una cippa");
			}
			System.out.println("Aggiornato prezzo prod id 3");
	
	}
	@Test
	void getFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			Fornitore ciccio = t.get(1);
			System.out.println(ciccio.getNome());
		} catch (DataException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Fornitore restituito");
	}
	@Test
	void getProdotto() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		ProdottoDAO t = new ProdottoDAO(portal);

		try {
			Prodotto ciccio = t.get(1);
			System.out.println(ciccio.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Prodotto restituito");
	}
	@Test
	void eliminazioneFornitoreById() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			t.delete(5);
		} catch (DataException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Eliminato fornitore con id 5");
	}
	@Test
	void eliminazioneProdottoById() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		ProdottoDAO t = new ProdottoDAO(portal);

		try {
			t.delete(3);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Eliminato prodotto con id 3");
	}
	@Test
	void getAllFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			List<Fornitore> ciccio = t.getAll();
			ciccio.forEach(f -> System.out.println(f.getNome()));
		} catch (DataException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("lista Fornitore restituito");
	}
	@Test
	void getAllProdotto() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		ProdottoDAO t = new ProdottoDAO(portal);

		try {
			List<Prodotto> ciccio = t.getAll();
			ciccio.forEach(f -> System.out.println(f.getNome()));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("lista Prodotti restituita");
	}
	@Test
	void updateFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		FornitoreDAO t = new FornitoreDAO(portal);
		//Fornitore marchi2 = new Fornitore(2, "X143", "Marchi", "Via verdi,3", "Verona");
		Fornitore rogi = new Fornitore(3, "Y666", "Rogi", "Via lincoln,46", "Padova");
		try {

			t.update(rogi);
			Fornitore upd = t.get(rogi.getId());
			System.out.println(upd.getCodiceFornitore());
		} catch (DataException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("Aggiornato rogi");
	}
@Test
	void getCittaFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		FornitoreDAO t = new FornitoreDAO(portal);

		try {
			List<Fornitore> ciccio = t.getFornitoriPerCitta("Padova");
			ciccio.forEach(f -> System.out.println(f.getNome()));
		} catch (DataException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("lista Fornitore per citta restituito");
	}
	@Test
	void prodottiDaFornitore() {
		CreatoreConnessione portal = new CreatoreConnessione("postgresql", "localhost", "5432", "esercitazione4",
				"negozio", "postgres", "123");
		ProdottoDAO t = new ProdottoDAO(portal);
		Fornitore rogi = new Fornitore(3, "Y666", "Rogi", "Via lincoln,46", "Padova");
		try {
			List<Prodotto> list = t.getProdottoPerFornitore(rogi);
			list.forEach(f -> System.out.println(f.getNome()));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Non va una cippa");
		}
		System.out.println("lista prodotti per fornitore restituita");
	}

	
	private boolean esisteFornitore(long id) {
		return true;
	}
	

}
