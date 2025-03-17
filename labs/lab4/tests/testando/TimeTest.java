package testando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;

class TimeTest {
	
	private Time time1;
	private Campeonato campeonato;
	
	@BeforeEach
	void setUp() {
		this.time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		this.campeonato = new Campeonato("Copa do Nordeste", 2);
	}
	
	@Test
	void testTimeVazio() {
		String esperado = "ENTRADA VAZIA!";
		try {
			new Time("", "Não Sei FC", "Cachorro");
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
		
		try {
			new Time("005_PB", "", "Cachorro");
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
		
		try {
			new Time("005_PB", "Não Sei FC", "");
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado, iae.getMessage());
		}
	}
	
	@Test
	void testTimeNulo() {
		String esperado = "ENTRADA NULA!";
		try {
			new Time(null, "Não Sei FC", "Cachorro");
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
		
		try {
			new Time("005_PB", null, "Cachorro");
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
		
		try {
			new Time("005_PB", "Não Sei FC", null);
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testAdicionaParticipacao() {
		time1.adicionaParticipacao(campeonato);
		String esperado = "\n* Copa do Nordeste - 1/2";
		assertEquals(esperado, time1.retornaCampeonatos());
	}
	
	@Test
	void testAdicionaParticipacaoNula() {
		assertThrows(NullPointerException.class, () ->  time1.adicionaParticipacao(null));
	}
	
	@Test
	void testExisteCampeonato() {
		assertFalse(this.time1.existeCampeonato("Copa do Nordeste"));
		time1.adicionaParticipacao(campeonato);
		assertTrue(this.time1.existeCampeonato("Copa do Nordeste"));
	}
	
	@Test
	void testExisteCampeonatoExcecoes() {
		String esperado1 = "ENTRADA NULA!";
		String esperado2 = "ENTRADA VAZIA!";
		try {
			time1.existeCampeonato(null);
		} catch(NullPointerException npe) {
			assertEquals(esperado1, npe.getMessage());
		}
		try {
			time1.existeCampeonato("");
		} catch(IllegalArgumentException iae) {
			assertEquals(esperado2, iae.getMessage());
		}
		
	}
	
	@Test
	void testRetornaCampeonatos() {
		String esperado1 = "";
		String esperado2 = "\n* Copa do Nordeste - 1/2";
		assertEquals(esperado1, time1.retornaCampeonatos());
		time1.adicionaParticipacao(campeonato);
		assertEquals(esperado2, time1.retornaCampeonatos());
	}
	
	@Test
	void testTamParticipacoes() {
		int esperado1 = 0;
		int esperado2 = 1;
		assertEquals(esperado1, this.time1.tamanhoParticipacoes());
		time1.adicionaParticipacao(campeonato);
		assertEquals(esperado2, this.time1.tamanhoParticipacoes());
	}
	
}
