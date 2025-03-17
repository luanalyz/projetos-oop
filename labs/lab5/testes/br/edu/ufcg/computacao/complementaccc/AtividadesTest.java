package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtividadesTest {

	private ControleSistema c;
	
	@BeforeEach
	void setUp() {
	c = new ControleSistema();
	c.cadastrarEstudante("123.456.789-10", "João", 12345678, "matricula");
	}

	@Test
	void testCriarAtvMonitoria() {
		assertEquals("123.456.789-10_1", c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 2, "FMCC2"));
		assertEquals("Estudante não existe!", c.criarAtividadeMonitoriaEmEstudante("cpf qualquer", 12345678, "MONITORIA", 2, "FMCC2"));
		
		String mensagem = "";
		try {
			c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 87654321, "MONITORIA", 2, "FMCC2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}

	@Test
	void testCriarAtvMonitoriaSenhaInvalida() {
		String mensagem = "";
		try {
			c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 8765432, "MONITORIA", 2, "FMCC2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testCriarAtvMonitoriaEntradaVazia() {
		String mensagem = "";
		try {
			c.criarAtividadeMonitoriaEmEstudante("", 12345678, "MONITORIA", 2, "FMCC2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "", 2, "FMCC2");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 2, "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test 
	void testCriarAtvMonitoriaEntradaNula() {
		String mensagem = "";
		try {
			 c.criarAtividadeMonitoriaEmEstudante(null, 12345678, "MONITORIA", 2, "FMCC2");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			 c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, null, 2, "FMCC2");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			 c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 2, null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testCriarAtvMonitoriaUnidadeInvalida() {
		String mensagem = "";
		try {
			c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 0, "FMCC2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Unidade inválida!");
	}
	
	@Test
	void testCriarAtvPesquisa() {
		assertEquals("123.456.789-10_1", c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 12, "P2"));
		assertEquals("Estudante não existe!", c.criarAtividadePesquisaExtensaoEmEstudante("cpf qualquer", 12345678, "PESQUISA", 12, "P2"));
		
		String mensagem = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 87654321, "PESQUISA", 12, "P2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}

	@Test
	void testCriarAtvPesquisaSenhaInvalida() {
		String mensagem = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 1234567, "PESQUISA", 0, "P2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testCriarAtvPesquisaEntradaVazia() {
		String mensagem = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("", 12345678, "PESQUISA", 12, "P2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "", 12, "P2");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 12, "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test 
	void testCriarAtvPesquisaEntradaNula() {
		String mensagem = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante(null, 12345678, "PESQUISA", 12, "P2");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, null, 12, "P2");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 12, null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testCriarAtvPesquisaUnidadeInvalida() {
		String mensagem = "";
		try {
			c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 0, "P2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Unidade inválida!");
	}
	
	@Test
	void testCriarAtvEstagio() {
		assertEquals("123.456.789-10_1", c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "ESTAGIO", 120, "LP2"));
		assertEquals("Estudante não existe!", c.criarAtividadeEstagioEmEstudante("cpf qualquer", 12345678, "ESTAGIO", 120, "LP2"));
		
		String mensagem = "";
		try {
			c.criarAtividadeEstagioEmEstudante("123.456.789-10", 87654321, "ESTAGIO", 120, "LP2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}

	@Test
	void testCriarAtvEstagioSenhaInvalida() {
		String mensagem = "";
		try {
			c.criarAtividadeEstagioEmEstudante("123.456.789-10", 1234567, "ESTAGIO", 120, "LP2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testCriarAtvEstagioEntradaVazia() {
		String mensagem = "";
		try {
			c.criarAtividadeEstagioEmEstudante("", 12345678, "ESTAGIO", 120, "LP2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "", 120, "LP2");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "ESTAGIO", 120, "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test 
	void testCriarAtvEstagioEntradaNula() {
		String mensagem = "";
		try {
			c.criarAtividadeEstagioEmEstudante(null, 12345678, "ESTAGIO", 120, "LP2");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, null, 120, "LP2");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "ESTAGIO", 120, null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testCriarAtvEstagioUnidadeInvalida() {
		String mensagem = "";
		try {
			c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "ESTAGIO", 0, "LP2");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Unidade inválida!");
	}
	
	@Test
	void testCriarAtvPublicacao() {
		assertEquals("123.456.789-10_1", c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "A1"));
		assertEquals("Estudante não existe!", c.criarAtividadePublicacaoEmEstudante("cpf qualquer", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "A1"));
		
		String mensagem = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 87654321, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "A1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}

	@Test
	void testCriarAtvPublicacaoSenhaInvalida() {
		String mensagem = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 1234567, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "A1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testCriarAtvPublicacaoEntradaVazia() {
		String mensagem = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "A1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "", "Titulo", "Doi", "A1");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "", "Doi", "A1");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
		
		String mensagem4 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "", "A1");
		} catch (IllegalArgumentException iae) {
			mensagem4 = iae.getMessage();
		}
		
		assertEquals(mensagem4, "Entrada vazia!");
		
		String mensagem5 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "");
		} catch (IllegalArgumentException iae) {
			mensagem5 = iae.getMessage();
		}
		
		assertEquals(mensagem5, "Entrada vazia!");
	}
	
	@Test 
	void testCriarAtvPublicacaoEntradaNula() {
		String mensagem = "";
		try {
			c.criarAtividadePublicacaoEmEstudante(null, 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "A1");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, null, "Titulo", "Doi", "A1");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", null, "Doi", "A1");
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
		
		String mensagem4 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "Titulo", null, "A1");
		} catch (NullPointerException npe) {
			mensagem4 = npe.getMessage();
		}
		
		assertEquals(mensagem4, "Entrada nula!");
		
		String mensagem5 = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", null);
		} catch (NullPointerException npe) {
			mensagem5 = npe.getMessage();
		}
		
		assertEquals(mensagem5, "Entrada nula!");
	}
	
	@Test
	void testCriarAtvPublicacaoQualisInvalido() {
		String mensagem = "";
		try {
			c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "qualquer");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Qualis inválido!");
	}
	
	@Test
	void testAlterarDescricaoAtividade() {
		c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 2, "FMCC2");
		
		assertEquals(true, c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1", "Descrição"));
		assertEquals(false, c.alterarDescricaoAtividade("cpf qualquer", 12345678, "123.456.789-10_1", "Descrição"));
		assertEquals(false, c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_2", "Descrição"));
		
		String mensagem = "";
		try {
			c.alterarDescricaoAtividade("123.456.789-10", 87654321, "123.456.789-10_1", "Descrição");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}
	
	@Test
	void testAlterarDescricaoAtividadeSenhaInvalida() {
		String mensagem = "";
		try {
			c.alterarDescricaoAtividade("123.456.789-10", 1234567, "123.456.789-10_1", "Descrição");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testAlterarDescricaoAtividadeEntradaVazia() {
		String mensagem = "";
		try {
			c.alterarDescricaoAtividade("", 12345678, "123.456.789-10_1", "Descrição");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.alterarDescricaoAtividade("123.456.789-10", 12345678, "", "Descrição");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1", "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test 
	void testAlterarDescricaoAtividadeEntradaNula() {
		String mensagem = "";
		try {
			c.alterarDescricaoAtividade(null, 12345678, "123.456.789-10_1", "Descrição");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.alterarDescricaoAtividade("123.456.789-10", 12345678, null, "Descrição");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.alterarDescricaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1",null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testAlterarComprovacaoAtividade() {
		c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 2, "FMCC2");
		
		assertEquals(true, c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1", "Link"));
		assertEquals(false, c.alterarComprovacaoAtividade("cpf qualquer", 12345678, "123.456.789-10_1", "Link"));
		assertEquals(false,c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_2", "Link"));
		
		String mensagem = "";
		try {
			c.alterarComprovacaoAtividade("123.456.789-10", 87654321, "123.456.789-10_1", "Link");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}
	
	@Test
	void testAlterarComprovacaoAtividadeSenhaInvalida() {
		String mensagem = "";
		try {
			c.alterarComprovacaoAtividade("123.456.789-10", 1234567, "123.456.789-10_1", "Link");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testAlterarComprovacaoAtividadeEntradaVazia() {
		String mensagem = "";
		try {
			c.alterarComprovacaoAtividade("", 12345678, "123.456.789-10_1", "Link");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "", "Link");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1", "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test 
	void testAlterarComprovacaoAtividadeEntradaNula() {
		String mensagem = "";
		try {
			c.alterarComprovacaoAtividade(null, 12345678, "123.456.789-10_1", "Link");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.alterarComprovacaoAtividade("123.456.789-10", 12345678, null, "Link");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.alterarComprovacaoAtividade("123.456.789-10", 12345678, "123.456.789-10_1", null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testCreditosAtividade() {
		c.criarAtividadeMonitoriaEmEstudante("123.456.789-10", 12345678, "MONITORIA", 2, "FMCC2");
		c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 12, "P2");
		c.criarAtividadeEstagioEmEstudante("123.456.789-10", 12345678, "ESTAGIO", 150, "LP2");
		c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_CONFERENCIA", "Titulo", "Doi", "A1");
		c.criarAtividadePublicacaoEmEstudante("123.456.789-10", 12345678, "PUBLICACAO_PERIODICO", "Titulo", "Doi", "A1");
		c.criarAtividadePesquisaExtensaoEmEstudante("123.456.789-10", 12345678, "PESQUISA", 8, "P2");
		
		assertEquals(8, c.creditosAtividade("123.456.789-10", 12345678, "123.456.789-10_1"));
		assertEquals(10, c.creditosAtividade("123.456.789-10", 12345678, "123.456.789-10_2"));
		assertEquals(2.5, c.creditosAtividade("123.456.789-10", 12345678, "123.456.789-10_3"));
		assertEquals(3, c.creditosAtividade("123.456.789-10", 12345678, "123.456.789-10_4"));
		assertEquals(4, c.creditosAtividade("123.456.789-10", 12345678, "123.456.789-10_5"));
		assertEquals(6.666666666666666, c.creditosAtividade("123.456.789-10", 12345678, "123.456.789-10_6"));
		
		assertEquals(-1, c.creditosAtividade("123.456.789-10", 12345678, "codigo qualquer"));
		assertEquals(-1, c.creditosAtividade("123.456.789-11", 12345678, "123.456.789-10_6"));
		
		String mensagem = "";
		try {
			c.creditosAtividade("123.456.789-10", 87654321, "123.456.789-10_1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}
	
	@Test
	void testCreditosAtividadeEntradaVazia() {
		String mensagem = "";
		try {
			c.creditosAtividade("", 12345678, "123.456.789-10_1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.creditosAtividade("123.456.789-10", 12345678, "");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
	}
	
	@Test
	void testCreditosAtividadeEntradaNula() {
		String mensagem = "";
		try {
			c.creditosAtividade(null, 12345678, "123.456.789-10_1");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.creditosAtividade("123.456.789-10", 12345678, null);
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
	}
	
	@Test
	void testCreditosAtividadeSenhaTamInvalido() {
		String mensagem = "";
		try {
			c.creditosAtividade("123.456.789-10", 1234567, "123.456.789-10_1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
}
