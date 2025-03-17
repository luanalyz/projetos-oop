package testando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.Campeonato;

class CampeonatoTest {

	private Campeonato campeonato1;
	
	@BeforeEach
	void setUp() {
		this.campeonato1 = new Campeonato("Copa do Nordeste", 2);
	}
	
	@Test
	void testCampeonatoNulo() {
		String esperado = "ENTRADA NULA!";
		try {
			new Campeonato(null, 2);
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
		
	}
	
	@Test
	void testCampeonatoVazio() {
		String esperado = "ENTRADA VAZIA!";
		try {
			new Campeonato("", 2);
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testVerificaVagas() {
		assertTrue(campeonato1.verificaVagas());
	}
	
	@Test
	void testAddParticipantes() {
		this.campeonato1.addParticipante();
		int esperado = 1;
		assertEquals(esperado, campeonato1.getNumParticipantes());
	}
}
