package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FAQTest {

	private ControleSistema c;
	
	@BeforeEach
	void setUp() {
		c = new ControleSistema();
		c.novoAdmin("qualquer cpf", 98653214, "Zé", "123.456.789-10", 12345678);
	}

	@Test
	void testAddItemFAQ() {
		assertEquals(true, c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1"));
		assertEquals(false, c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1"));
		assertEquals(true, c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 2", "Resposta 1"));
		assertEquals(false, c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 2", "Resposta 2"));
		
		String mensagem = "";
		try {
			c.addItemFAQ("cpf errado", 12345678, "Pergunta 3");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals("Login inválido!", mensagem);
		
		String mensagem2 = "";
		try {
			c.addItemFAQ("123.456.789-10", 98287589, "Pergunta 3");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		assertEquals("Login inválido!", mensagem2);
	}

	@Test
	void testAddItemFAQEntradaVazia() {
		String mensagem = "";
		try {
			c.addItemFAQ("", 12345678, "Pergunta 1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.addItemFAQ("123.456.789-10", 12345678, "");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada vazia!");
	}
	
	@Test
	void testAddItemFAQEntradaNula() {
		String mensagem = "";
		try {
			c.addItemFAQ(null, 12345678, "Pergunta 1");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.addItemFAQ("123.456.789-10", 12345678, null);
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
	}
	
	@Test
	void testAddItemFAQSenhaInvalida() {
		String mensagem = "";
		try {
			c.addItemFAQ("123.456.789-10", 1234567, "Pergunta 1");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testAlteraResposta() {
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1", "Resposta 1");
		assertEquals(true, c.alteraResposta("123.456.789-10", 12345678, 1, "Nova Resposta"));
		assertEquals(false, c.alteraResposta("123.456.789-10", 12345678, 2, "Nova Resposta"));
		
		String mensagem = "";
		try {
			c.alteraResposta("cpf errado", 12345678, 1, "Nova Resposta");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals("Login inválido!", mensagem);
		
		String mensagem2 = "";
		try {
			c.alteraResposta("123.456.789-10", 87654321, 1, "Nova Resposta");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		assertEquals("Login inválido!", mensagem2);
	}
	
	@Test
	void testAlteraRespostaSenhaInvalida() {
		String mensagem = "";
		try {
			c.alteraResposta("123.456.789-10", 1234567, 1, "Nova Resposta");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testAlteraRespostaEntradaNula() {
		String mensagem = "";
		try {
			c.alteraResposta(null, 12345678, 1, "Nova Resposta");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.alteraResposta("123.456.789-10", 12345678, 1, null);
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
	}
	
	@Test
	void testAlteraRespostaEntradaVazia() {
		String mensagem = "";
		try {
			c.alteraResposta("", 12345678, 1, "Nova Resposta");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.alteraResposta("123.456.789-10", 12345678, 1, "");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada vazia!");
	}
	
	@Test
	void testListaFAQ() {
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1", "Resposta 1");
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 2");
		String esperado1 = "Pergunta 1\nResposta 1";
		String esperado2 = "Pergunta 2\nSem resposta.";
		assertEquals(esperado1, c.listaFAQ()[0]);
		assertEquals(esperado2, c.listaFAQ()[1]);
		
	}
	
	@Test
	void testListaFAQDestaque() {
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1", "Resposta 1");
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 2");
		assertEquals(true, c.destacaItem(2));
		String esperado1 = "Pergunta 2\nSem resposta.";
		String esperado2 = "Pergunta 1\nResposta 1";
		assertEquals(esperado1, c.listaFAQDestaque()[0]);
		assertEquals(esperado2, c.listaFAQDestaque()[1]);
	}
	
	@Test
	void testDestacar() {
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1", "Resposta 1");
		assertEquals(true, c.destacaItem(1));
		assertEquals(false, c.destacaItem(2));
		assertEquals(false, c.destacaItem(0));
	}
	
	@Test
	void testAtribuiTags() {
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1", "Resposta 1");
		String[] tags = {"tag1", "tag2", "tag3"};
		String[] tags2 = {"tag1"};
		String[] tags3 = {"tag1", "tag2", "tag3", "tag4"};
		assertEquals(true, c.atribuirTags("123.456.789-10", 12345678, 1, tags));
		assertEquals(false, c.atribuirTags("123.456.789-10", 12345678, 0, tags));
		assertEquals(false, c.atribuirTags("123.456.789-10", 12345678, 2, tags));
		assertEquals(true, c.atribuirTags("123.456.789-10", 12345678, 1, tags2));
		assertEquals(false, c.atribuirTags("123.456.789-10", 12345678, 1, tags3));
		
		String mensagem = "";
		try {
			c.atribuirTags("cpf errado", 12345678, 1, tags);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals("Login inválido!", mensagem);
		
		String mensagem2 = "";
		try {
			c.atribuirTags("123.456.789-10", 87654321, 1, tags);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		assertEquals("Login inválido!", mensagem2);
	}
	
	@Test
	void testAtribuiTagsEntradasIncorretas() {
		String[] tags = {"tag1", "tag2", "tag3"};
		String mensagem = "";
		try {
			c.atribuirTags("", 12345678, 1, tags);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.atribuirTags(null, 12345678, 1, tags);
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.atribuirTags("123.456.789-10", 12345678, 1, null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
		
		String mensagem4 = "";
		try {
			c.atribuirTags("123.456.789-10", 1234567, 1, tags);
		} catch (IllegalArgumentException iae) {
			mensagem4 = iae.getMessage();
		}
		
		assertEquals(mensagem4, "Senha com tamanho inválido!");
	}
	
	@Test
	void testBuscarTags() {
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 1", "Resposta 1");
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 2");
		c.addItemFAQ("123.456.789-10", 12345678, "Pergunta 3");
		String[] tags1 = {"tag1", "tag2", "tag3"};
		String[] tags2 = {"tag4", "tag5", "tag6"};
		String[] tags3 = {"tag1", "tag5", "tag6"};
		String[] tags4 = {"tag1", "tag7"};
		String[] tags5 = {"tag7", "tag8"};
		c.atribuirTags("123.456.789-10", 12345678, 1, tags1);
		c.atribuirTags("123.456.789-10", 12345678, 2, tags2);
		c.atribuirTags("123.456.789-10", 12345678, 3, tags3);
		
		String esperado1 = "Pergunta 1\nResposta 1";
		String esperado2 = "Pergunta 3\nSem resposta.";
		int esperado3 = 0;
		assertEquals(esperado1, c.buscarItem(tags4)[0]);
		assertEquals(esperado2, c.buscarItem(tags4)[1]);
		assertEquals(esperado3, c.buscarItem(tags5).length);
	}
	
	@Test
	void TestBuscarTagsNula() {
		String mensagem = "";
		try {
			c.buscarItem(null);
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
	}
}
