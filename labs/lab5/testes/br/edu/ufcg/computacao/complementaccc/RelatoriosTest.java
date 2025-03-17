package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RelatoriosTest {

	private ControleSistema c;
	@BeforeEach
	void setUp() {
		this.c = new ControleSistema();
		c.cadastrarEstudante("123.456.789-10", "Luana", 12345678, "matricula");
		c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICA", "Título", "DOI", "A1");
		c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "ESTAGIO", 120, "LP2");
		c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 2, "FMCC2");
		c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 10, "P2");
		c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1", "link1");
		c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1", "descrição1");
		c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_2", "link2");
		c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_2", "descrição2");
		c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_3", "link3");
		c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_3", "descrição3");
		c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_4", "link4");
		c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_4", "descrição4");
	}
	
	@Test
	void testCriarRelatorioDetalhado() {
		assertEquals(1, c.criarRelatorioCompleto("123.456.789-10", 12345678));
		
		String mensagem = "";
		try {
			c.criarRelatorioCompleto("123.456.789-10", 87654321);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}
	
	@Test
	void testCriarRelatorioDetalhadoEntradasInvalidas() {
		String mensagem = "";
		try {
			c.criarRelatorioCompleto("123.456.789-10", 1234567);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
		
		String mensagem2 = "";
		try {
			c.criarRelatorioCompleto("", 1234567);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.criarRelatorioCompleto(null, 12345678);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}

	@Test
	void testCriarRelatorioTipo() {
		assertEquals(1, c.criarRelatorioPorATV("123.456.789-10", 12345678, "MONITORIA"));
		assertEquals(2, c.criarRelatorioPorATV("123.456.789-10", 12345678, "ESTAGIO"));
		assertEquals(0, c.criarRelatorioPorATV("123.456.789-10", 12345678, "qualquer coisa"));
		
		String mensagem = "";
		try {
			c.criarRelatorioPorATV("123.456.789-10", 87654321, "MONITORIA");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}

	@Test
	void testCriarRelatorioTipoEntradasInvalidas() {
		String mensagem = "";
		try {
			c.criarRelatorioPorATV("123.456.789-10", 1234567, "MONITORIA");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
		
		String mensagem2 = "";
		try {
			c.criarRelatorioPorATV("", 12345678, "MONITORIA");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.criarRelatorioPorATV("123.456.789-10", 12345678, "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
		
		String mensagem4 = "";
		try {
			c.criarRelatorioPorATV(null, 12345678, "MONITORIA");
		} catch (NullPointerException npe) {
			mensagem4 = npe.getMessage();
		}
		
		assertEquals(mensagem4, "Entrada nula!");
		
		String mensagem5 = "";
		try {
			c.criarRelatorioPorATV("123.456.789-10", 12345678, null);
		} catch (NullPointerException npe) {
			mensagem5 = npe.getMessage();
		}
		
		assertEquals(mensagem5, "Entrada nula!");
	}
	
	@Test
	void testCriarRelatorioResumido() {
		assertEquals(1, c.criarRelatorioResumido("123.456.789-10", 12345678));
		assertEquals(2, c.criarRelatorioResumido("123.456.789-10", 12345678));
		
		
		String mensagem = "";
		try {
			c.criarRelatorioResumido("123.456.789-10", 87654321);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}
	
	@Test
	void testCriarRelatorioResumidoEntradasInvalidas() {
		String mensagem = "";
		try {
			c.criarRelatorioResumido("123.456.789-10", 1234567);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
		
		String mensagem2 = "";
		try {
			c.criarRelatorioResumido("", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.criarRelatorioResumido(null, 12345678);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testExibirRelatorio() {
		c.criarRelatorioCompleto("123.456.789-10", 12345678);
		c.criarRelatorioPorATV("123.456.789-10", 12345678, "MONITORIA");
		c.criarRelatorioPorATV("123.456.789-10", 12345678, "ESTAGIO");
		c.criarRelatorioResumido("123.456.789-10", 12345678);
		
		String esperado1 = "[123.456.789-10] matricula - Luana\n\nESTAGIO: 123.456.789-10_2\nDescrição:descrição2\nLink: link2\nUnidades: 120\nCréditos: 2.0\nDisciplina: LP2\n\nMONITORIA: 123.456.789-10_3\nDescrição:descrição3\nLink: link3\nUnidades: 2\nCréditos: 8.0\nDisciplina: FMCC2\n\nPESQUISA: 123.456.789-10_4\nDescrição:descrição4\nLink: link4\nUnidades: 10\nCréditos: 8.333333333333334\nDisciplina: P2\n\nPUBLICACAO_PERIODICA: 123.456.789-10_1\nDescrição:descrição1\nLink: link1\nUnidades: 1\nCréditos: 3.0\nTitulo do artigo: Título\nDoi: DOI\nQualis: A1";
		assertEquals(esperado1, c.exibirRelatorio("123.456.789-10", 12345678, 1));
		
		String esperado2 = "[123.456.789-10] matricula - Luana\nMONITORIA: 8/16";
		assertEquals(esperado2, c.exibirRelatorio("123.456.789-10", 12345678, 2));
		
		String esperado3 = "[123.456.789-10] matricula - Luana\nESTAGIO: NÃO ATINGIU O VALOR MÍNIMO!";
		assertEquals(esperado3, c.exibirRelatorio("123.456.789-10", 12345678, 3));
		
		String esperado4 = "[123.456.789-10] matricula - Luana" +
				"\nMonitoria: 8/16" +
				"\nPublicação: 3/12" +
				"\nEstagio: NÃO ATINGIU O VALOR MÍNIMO!" +
				"\nPesquisa de extensão: NÃO ATINGIU O VALOR MÍNIMO!";
		assertEquals(esperado4, c.exibirRelatorio("123.456.789-10", 12345678, 4));
		
		c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "ESTAGIO", 180, "LP2");
		c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 2, "P2");
		c.criarRelatorioResumido("123.456.789-10", 12345678);
		
		String esperado5 = "[123.456.789-10] matricula - Luana" +
				"\nMonitoria: 8/16" +
				"\nPublicação: 3/12" +
				"\nEstagio: 5/18" +
				"\nPesquisa de extensão: 10/18";
		assertEquals(esperado5, c.exibirRelatorio("123.456.789-10", 12345678, 5));
		
		c.criarRelatorioPorATV("123.456.789-10", 12345678, "ESTAGIO");
		String esperado = "[123.456.789-10] matricula - Luana\nESTAGIO: 5/18";
		assertEquals(esperado, c.exibirRelatorio("123.456.789-10", 12345678, 6));
		
		c.criarRelatorioPorATV("123.456.789-10", 12345678, "PESQUISA");
		String esperadoDnv = "[123.456.789-10] matricula - Luana\nPESQUISA: 10/18";
		assertEquals(esperadoDnv, c.exibirRelatorio("123.456.789-10", 12345678, 7));
		
		assertEquals("Index inválido!", c.exibirRelatorio("123.456.789-10", 12345678, 8));
		assertEquals("Index inválido!", c.exibirRelatorio("123.456.789-10", 12345678, 0));
		
		String mensagem = "";
		try {
			c.exibirRelatorio("123.456.789-10", 87654321, 1);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
		
	}
	
	@Test
	void testExibirRelatorioExcecoes() {
		String mensagem = "";
		try {
			c.exibirRelatorio("123.456.789-10", 1234567, 2);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
		
		String mensagem2 = "";
		try {
			c.exibirRelatorio("", 87654321, 2);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.exibirRelatorio(null, 87654321, 2);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
}
