package testando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.Aposta;
import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;

class ApostaTest {
	
	private Time time;
	private Campeonato campeonato;
	
	@BeforeEach
	void setUp() {
		this.time = new Time("250_PB", "Nacional de Patos", "Canário");
		this.campeonato = new Campeonato("Copa do Nordeste", 2);
	}
	
	@Test
	void testApostaNulo() {
		String esperado = "ENTRADA NULA!";
		try {
			new Aposta(null, campeonato, 1, 50.00);
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
		
		try {
			new Aposta(time, null, 1, 50.00);
		} catch(NullPointerException npe) {
			assertEquals(esperado, npe.getMessage());
		}
	}
	
	@Test
	void testApostaValoresInvalidos() {
		String esperado = "VALOR INVÁLIDO!";
		try {
			new Aposta(time, campeonato, -1, 50.00);
		} catch(IndexOutOfBoundsException iob) {
			assertEquals(esperado, iob.getMessage());
		}
		try {
			new Aposta(time, campeonato, 1, -50.00);
		} catch(IndexOutOfBoundsException iob) {
			assertEquals(esperado, iob.getMessage());
		}
	}

}
