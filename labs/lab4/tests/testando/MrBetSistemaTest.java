package testando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.mrbet.MrBetSistema;

class MrBetSistemaTest {
	
	private MrBetSistema mr;
	
	@BeforeEach
	void setUp() {
		this.mr = new MrBetSistema();
		mr.adicionaTime("250_PB", "Nacional de Patos", "Canário");
		mr.adicionaTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mr.adicionaTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		mr.adicionaTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}

	@Test
	void testAddTime() {
		String esperado = "INCLUSÃO REALIZADA!";
		assertEquals(esperado, mr.adicionaTime("005_PB", "Não Sei FC", "Cachorro"));
	}
	
	@Test
	void testAddTimeJaExistente() {
		String esperado = "TIME JÁ EXISTE!";
		assertEquals(esperado, mr.adicionaTime("250_PB", "Nacional de Patos", "Canário"));
	}
	
	@Test
	void testAddTimeVazio() {
		assertThrows(IllegalArgumentException.class, () -> mr.adicionaTime("", "Não Sei FC", "Cachorro"));
		assertThrows(IllegalArgumentException.class, () -> mr.adicionaTime("005_PB", "Não Sei FC", ""));
		assertThrows(IllegalArgumentException.class, () -> mr.adicionaTime("005_PB", "", "Cachorro"));
		assertThrows(NullPointerException.class, () ->  mr.adicionaTime("005_PB", "Não Sei FC", null));
		assertThrows(NullPointerException.class, () ->  mr.adicionaTime("005_PB", null, "Cachorro"));
		assertThrows(NullPointerException.class, () ->  mr.adicionaTime(null, "Não Sei FC", "Cachorro"));
	}
	
	@Test
	void testRecuperaTimes() {
		String esperado = "[252_PB] Sport Lagoa Seca / Carneiro";
		assertEquals(esperado, mr.recuperaTimes("252_PB"));
	}
	
	@Test
	void testRecuperaTimesNaoExiste() {
		String esperado = "TIME NÃO EXISTE!";
		assertEquals(esperado, mr.recuperaTimes("005_PB"));
	}
	
	@Test
	void testRecuperaTimesExcessoes() {
		assertThrows(IllegalArgumentException.class, () -> mr.recuperaTimes(""));
		assertThrows(NullPointerException.class, () ->  mr.recuperaTimes(null));
	}
	
	@Test
	void testCadastraCampeonato() {
		String esperado = "CAMPEONATO ADICIONADO!";
		assertEquals(esperado, mr.adicionaCampeonato("Brasileirão série A 2023", 1));
	}
	
	@Test
	void testCadastraCampeonatoExcessoes() {
		assertThrows(IllegalArgumentException.class, () -> mr.adicionaCampeonato("", 1));
		assertThrows(NullPointerException.class, () ->  mr.adicionaCampeonato(null, 1));
		assertThrows(IndexOutOfBoundsException.class, () ->  mr.adicionaCampeonato("Brasileirão série A 2023", -1));
	}
	
	@Test 
	void testCadastraCampeonatoJaExistente() {
		String esperado1 = "CAMPEONATO ADICIONADO!";
		assertEquals(esperado1, mr.adicionaCampeonato("Brasileirão série A 2023", 1));
		String esperado = "CAMPEONATO JÁ EXISTE!";
		assertEquals(esperado, mr.adicionaCampeonato("Brasileirão série A 2023", 2));
	}
	
	@Test
	void testincluiTimeCampeonato() {
		mr.adicionaCampeonato("Brasileirão série A 2023", 2);
		String esperado = "TIME INCLUÍDO NO CAMPEONATO!";
		assertEquals(esperado, mr.incluiTime("250_PB", "Brasileirão série A 2023"));
		assertEquals(esperado, mr.incluiTime("252_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void testIncluiTimeCampeonatoExcessoes() {
		assertThrows(IllegalArgumentException.class, () -> mr.incluiTime("", "Brasileirão série A 2023"));
		assertThrows(NullPointerException.class, () ->  mr.incluiTime(null, "Brasileirão série A 2023"));
		assertThrows(IllegalArgumentException.class, () -> mr.incluiTime("250_PB", ""));
		assertThrows(NullPointerException.class, () ->  mr.incluiTime("250_PB", null));
	}
	
	@Test
	void testIncluiTimeJaIncluidoCampeonato() {
		mr.adicionaCampeonato("Brasileirão série A 2023", 2);
		String esperado1 = "TIME INCLUÍDO NO CAMPEONATO!";
		
		assertEquals(esperado1, mr.incluiTime("250_PB", "Brasileirão série A 2023"));
		String esperado2 = "\nNacional de Patos:\n* Brasileirão série A 2023 - 1/2";
		assertEquals(esperado2, mr.exibeCampeonatosTime("250_PB"));
		
		assertEquals(esperado1, mr.incluiTime("252_PB", "Brasileirão série A 2023"));
		String esperado3 = "\nSport Lagoa Seca:\n* Brasileirão série A 2023 - 2/2";
		assertEquals(esperado3, mr.exibeCampeonatosTime("252_PB"));
		assertEquals(esperado1, mr.incluiTime("252_PB", "Brasileirão série A 2023"));
		assertEquals(esperado3, mr.exibeCampeonatosTime("252_PB"));
		
	}

	@Test
	void testIncluiCampeonatoTimeNaoCadastrado() {
		mr.adicionaCampeonato("Brasileirão série A 2023", 2);
		
		String esperado = "TIME NÃO EXISTE!";
		assertEquals(esperado, mr.incluiTime("005_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void testIncluiCampeonatoNaoCadastradoAoTime() {
		String esperado = "CAMPEONATO NÃO EXISTE!";
		assertEquals(esperado, mr.incluiTime("252_PB", "Brasileirão série D 2023"));
	}
	
	@Test
	void testIncluiTimeExcedendoParticipantes() {
		mr.adicionaCampeonato("Brasileirão série A 2023", 1);
		String esperado = "TIME INCLUÍDO NO CAMPEONATO!";
		assertEquals(esperado, mr.incluiTime("252_PB", "Brasileirão série A 2023"));
		
		String esperado2 = "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		assertEquals(esperado2, mr.incluiTime("250_PB", "Brasileirão série A 2023"));
	}
	
	@Test
	void testVerificaTimeCampeonato() {
		mr.adicionaCampeonato("Copa do Nordeste", 1);
		mr.incluiTime("250_PB", "Copa do Nordeste");
		String esperado = "O TIME ESTÁ NO CAMPEONATO!";
		
		assertEquals(esperado, mr.verificaCampeonatoTime("250_PB", "Copa do Nordeste"));
		
		String esperado2 = "O TIME NÃO ESTÁ NO CAMPEONATO!";
		
		assertEquals(esperado2, mr.verificaCampeonatoTime("252_PB", "Copa do Nordeste"));
	}
	
	@Test
	void testVerificaTimeCampeonatoExcessoes() {
		mr.adicionaCampeonato("Brasileirão série A 2023", 1);
		assertThrows(IllegalArgumentException.class, () -> mr.verificaCampeonatoTime("", "Brasileirão série A 2023"));
		assertThrows(NullPointerException.class, () ->  mr.verificaCampeonatoTime(null, "Brasileirão série A 2023"));
		assertThrows(IllegalArgumentException.class, () -> mr.verificaCampeonatoTime("250_PB", ""));
		assertThrows(NullPointerException.class, () ->  mr.verificaCampeonatoTime("250_PB", null));
	}
	
	@Test
	void testVerificaTimeCampeonatoNaoExiste() {
		String esperado = "O CAMPEONATO NÃO EXISTE!";
		assertEquals(esperado, mr.verificaCampeonatoTime("252_PB", "Brasileirão série D 2023"));
	}
	
	@Test
	void testVerificaTimeNaoCadastradoCampeonato() {
		mr.adicionaCampeonato("Copa do Nordeste", 1);
		String esperado = "O TIME NÃO EXISTE!";
		assertEquals(esperado, mr.verificaCampeonatoTime("005_PB", "Brasileirão série D 2023"));
	}
	
	@Test
	void testExibeCampeonatosTime() {
		mr.adicionaCampeonato("Copa do Nordeste", 1);
		mr.incluiTime("250_PB", "Copa Do Nordeste");
		String esperado = "\nNacional de Patos:\n* Copa do Nordeste - 1/1";
		assertEquals(esperado, mr.exibeCampeonatosTime("250_PB"));
	}
	
	@Test
	void testExibeCampeonatosTimeExcessoes() {
		assertThrows(IllegalArgumentException.class, () -> mr.exibeCampeonatosTime(""));
		assertThrows(NullPointerException.class, () ->  mr.exibeCampeonatosTime(null));
	}
	
	@Test
	void testExibeCampeonatosTimeNaoExiste() {
		String esperado = "TIME NÃO CADASTRADO NO SISTEMA!";
		assertEquals(esperado, mr.exibeCampeonatosTime("005_PB"));
	}
	
	@Test
	void testCadastraAposta() {
		mr.adicionaCampeonato("Copa do Nordeste", 2);
		String esperado = "APOSTA REGISTRADA!";
		assertEquals(esperado, mr.cadastraAposta("252_PB", "Copa do Nordeste", 1, 50.00));
	}
	
	@Test
	void testCadastraApostaExcecoes() {
		mr.adicionaCampeonato("Copa do Nordeste", 2);
		assertThrows(IllegalArgumentException.class, () -> mr.cadastraAposta("", "Copa do Nordeste", 1, 50.00));
		assertThrows(NullPointerException.class, () ->  mr.cadastraAposta(null, "Copa do Nordeste", 1, 50.00));
		assertThrows(IllegalArgumentException.class, () -> mr.cadastraAposta("252_PB", "", 1, 50.00));
		assertThrows(NullPointerException.class, () ->  mr.cadastraAposta("252_PB", null, 1, 50.00));
		assertThrows(IndexOutOfBoundsException.class, () -> mr.cadastraAposta("252_PB", "Copa do Nordeste", -1, 50.00));
		assertThrows(IndexOutOfBoundsException.class, () -> mr.cadastraAposta("252_PB", "Copa do Nordeste", 1, -50));
	}
	
	@Test
	void testCadastraApostaTimeInexistente() {
		mr.adicionaCampeonato("Copa do Nordeste", 2);
		String esperado = "TIME NÃO CADASTRADO NO SISTEMA!";
		assertEquals(esperado, mr.cadastraAposta("005_PB", "Copa do Nordeste", 1, 50.00));
	}
	
	@Test
	void testCadastraApostaCampeonatoInexistente() {
		String esperado = "CAMPEONATO NÃO CADASTRADO NO SISTEMA!";
		assertEquals(esperado, mr.cadastraAposta("252_PB", "Não Sei FC", 1, 50.00));
	}
	
	@Test
	void testCadastraApostaColocacaoInvalida() {
		mr.adicionaCampeonato("Copa do Nordeste", 2);
		String esperado = "APOSTA NÃO REGISTRADA!";
		assertEquals(esperado, mr.cadastraAposta("252_PB", "Copa do Nordeste", 50, 50.00));
	}
	
	@Test 
	void testStatusApostaUmaAposta() {
		mr.adicionaCampeonato("Copa do Nordeste", 2);
		mr.cadastraAposta("250_PB", "Copa do Nordeste", 1, 50.00);
		String esperado = "Apostas:\n\n1. [250_PB] Nacional de Patos / Canário\nCopa do Nordeste\n1/2\nR$ 50,00\n";
		assertEquals(esperado, mr.statusApostas());
	}
	
	@Test 
	void testStatusApostaMultiplasApostas() {
		mr.adicionaCampeonato("Copa do Nordeste", 2);
		mr.cadastraAposta("250_PB", "Copa do Nordeste", 1, 50.00);
		mr.cadastraAposta("252_PB", "Copa do Nordeste", 2, 20.00);
		String esperado = "Apostas:\n\n1. [250_PB] Nacional de Patos / Canário\nCopa do Nordeste\n1/2\nR$ 50,00\n" +
				"2. [252_PB] Sport Lagoa Seca / Carneiro\nCopa do Nordeste\n2/2\nR$ 20,00\n";
		assertEquals(esperado, mr.statusApostas());
	}
	
	@Test 
	void testStatusApostaZeroApostas() {
		String esperado = "Apostas:\n\n";
		assertEquals(esperado, mr.statusApostas());
	}
	
	@Test
	void testHistorico() {
		mr.adicionaCampeonato("Copa do Nordeste", 2);
		mr.adicionaCampeonato("Brasileirão série A 2023", 1);
		mr.incluiTime("250_PB", "Copa do Nordeste");
		mr.incluiTime("250_PB", "Brasileirão série A 2023");
		String esperado = "Participação mais frequente em campeonatos\n" + "[250_PB] Nacional de Patos / Canário 2" +
							"\n\nAinda não participou do campeonato\n" + "[002_RJ] Clube de Regatas do Flamengo / Urubu\n[105_PB] Sociedade Recreativa de Monteiro (SOCREMO) / Gavião\n[252_PB] Sport Lagoa Seca / Carneiro";
		assertEquals(esperado, mr.exibirHistorico());
	}
}
