package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	private ControleSistema c;
	
	@BeforeEach
	void setUp() {
		c = new ControleSistema();
	}
	
	@Test
	void testCadastraEstudante() {
		assertEquals(true, c.cadastrarEstudante("123.456.789-10", "Joao", 12345678, "matricula"));
	}
	
	@Test
	void testCadastraEstudanteCpfDuplicado() {
		assertEquals(true, c.cadastrarEstudante("123.456.789-10", "Joao", 12345678, "matricula"));
		assertEquals(false, c.cadastrarEstudante("123.456.789-10", "Jorge", 12345678, "matricula1"));
	}
	
	@Test
	void testCadastraEstudanteSenhaInvalida() {
		String mensagem = "";
		try {
			c.cadastrarEstudante("123.456.789-11", "Jorge", 1234567, "matricula");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testCadastraEstudanteEntradaNula() {
		String mensagem = "";
		try {
			c.cadastrarEstudante(null, "Jorge", 12345678, "matricula");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.cadastrarEstudante("123.456.789-11", null, 12345678, "matricula");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.cadastrarEstudante("123.456.789-11", "Jorge", 12345678, null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testCadastraEstudanteEntradaVazia() {
		String mensagem = "";
		try {
			c.cadastrarEstudante("", "Jorge", 12345678, "matricula");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.cadastrarEstudante("123.456.789-11", "", 12345678, "matricula");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.cadastrarEstudante("123.456.789-11", "Jorge", 12345678, "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test
	void testCriarAdmin() {
		assertEquals(true, c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", "123.456.78-12", 12345678));
		assertEquals(true, c.novoAdmin("123.456.78-12", 12345678, "Zé", "123.456.78-13", 12345678));
		String mensagem = "";
		try {
			c.novoAdmin("cpf errado", 12345678, "Zé", "123.456.78-13", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
		
		String mensagem2 = "";
		try {
			c.novoAdmin("123.456.78-13", 87654321, "Zé", "123.456.78-13", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		assertEquals(mensagem2, "Login inválido!");
	}

	@Test
	void testCriarAdminEntradaNula() {
		String mensagem = "";
		try {
			c.novoAdmin(null, 87654321, "Paula", "123.456.78-12", 12345678);
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.novoAdmin("não importa, não tem admin cadastrado", 92762314,null, "123.456.78-12", 12345678);
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", null, 12345678);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testCriarAdminEntradaVazia() {
		String mensagem = "";
		try {
			c.novoAdmin("", 92762314, "Paula", "123.456.78-12", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "", "123.456.78-12", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", "", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test
	void testCriarAdminSenhaInvalida() {
		String mensagem = "";
		try {
			c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", "123.456.78-12", 1234567);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
	}
	
	@Test
	void testListaEstudantes() {
		c.cadastrarEstudante("123.456.789-10", "Joao", 12345678, "matricula");
		c.cadastrarEstudante("123.456.789-14", "Amanda", 12345678, "matricula2");
		String esperado1 = "[123.456.789-14] matricula2 - Amanda";
		String esperado2 = "[123.456.789-10] matricula - Joao";
		assertEquals(esperado1, c.exibeEstudantes("admin n cadastrado", 12345678)[0]);
		assertEquals(esperado2, c.exibeEstudantes("admin n cadastrado", 12345678)[1]);
		
		String mensagem = "";
		assertEquals(true, c.novoAdmin("Qualquer cpf", 92762314, "Paula", "123.456.78-12", 12345678));
		try  {
			c.exibeEstudantes("cpf errado", 45151698);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		assertEquals(mensagem, "Login inválido!");
	}
	
	@Test
	void testListaEstudantesExcecoes() {
		String mensagem = "";
		try {
			c.exibeEstudantes("", 45151698);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.exibeEstudantes(null, 45151698);
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.exibeEstudantes("cpf não importa", 1234567);
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Senha com tamanho inválido!");
	}
	
	@Test
	void testEditarEstudante() {
		c.cadastrarEstudante("123.456.789-10", "Joao", 12345678, "matricula");
		assertEquals(true, c.editarEstudante("123.456.789-10", 12345678, "senha", "87654321"));
		assertEquals(true, c.editarEstudante("123.456.789-10", 87654321, "nome", "novo nome"));
		assertEquals(false, c.editarEstudante("cpf errado", 87654321, "nome", "novo nome"));
		
		String mensagem2 = "";
		try {
			c.editarEstudante("123.456.789-10", 78563214, "nome", "novo nome");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Login inválido!");
	}
	
	@Test
	void testEditarEstudanteEntradaNula() {
		String mensagem = "";
		try {
			c.editarEstudante(null, 12345678, "senha", "87654321");
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.editarEstudante("123.456.789-10", 12345678, null, "87654321");
		} catch (NullPointerException npe) {
			mensagem2 = npe.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada nula!");
		
		String mensagem3 = "";
		try {
			c.editarEstudante("123.456.789-10", 12345678, "senha", null);
		} catch (NullPointerException npe) {
			mensagem3 = npe.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada nula!");
	}
	
	@Test
	void testEditarEstudanteEntradaVazia() {
		String mensagem = "";
		try {
			c.editarEstudante("", 12345678, "senha", "87654321");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.editarEstudante("123.456.789-10", 12345678,"", "87654321");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2,  "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.editarEstudante("123.456.789-10", 12345678, "senha", "");
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Entrada vazia!");
	}
	
	@Test
	void testEditarEstudanteSenhaInvalida() {
		String mensagem = "";
		try {
			c.editarEstudante("123.456.789-10", 1234567, "senha", "87654321");
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Senha com tamanho inválido!");
		
		String mensagem2 = "";
		try {
			c.editarEstudante("123.456.789-10", 12345678, "senha", "1234567");
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Senha com tamanho inválido!");
		
	}
	
	@Test
	void testMudarSenhaAdmin() {
		c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", "123.456.789-12", 12345678);
		assertEquals(true, c.mudarSenhaAdmin("123.456.789-12", 12345678, 98765432));
		
		String mensagem = "";
		try {
			c.mudarSenhaAdmin("123.456.789-12", 12345678, 98765432);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Login inválido!");
		
		String mensagem2 = "";
		try {
			c.mudarSenhaAdmin("cpf errado", 98765432, 78546321);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Login inválido!");
	}
	
	@Test
	void MudarSenhaAdminExcecoes() {
		c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", "123.456.789-12", 12345678);
		
		String mensagem = "";
		try {
			c.mudarSenhaAdmin("", 12345678, 98765432);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Entrada vazia!");
		
		String mensagem2 = "";
		try {
			c.mudarSenhaAdmin("123.456.789-12", 1234567, 98765432);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Senha com tamanho inválido!");
		
		String mensagem3 = "";
		try {
			c.mudarSenhaAdmin("123.456.789-12", 12345678, 1234567);
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Senha com tamanho inválido!");
	}
	
	@Test
	void testExibeAdmin() {
		c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", "123.456.789-12", 12345678);
		String esperado = "[123.456.789-12] Paula";
		assertEquals(esperado, c.exibeAdmin("123.456.789-12", 12345678));
		
		String mensagem = "";
		try {
			 c.exibeAdmin("123.456.789-11", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem = iae.getMessage();
		}
		
		assertEquals(mensagem, "Login inválido!");
		
		String mensagem2 = "";
		try {
			c.exibeAdmin("123.456.789-12", 12345679);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Login inválido!");
	}
	
	@Test
	void testExibeAdminExcecoes() {
		c.novoAdmin("não importa, não tem admin cadastrado", 92762314, "Paula", "123.456.789-12", 12345678);
		
		String mensagem = "";
		try {
			 c.exibeAdmin(null, 12345678);
		} catch (NullPointerException npe) {
			mensagem = npe.getMessage();
		}
		
		assertEquals(mensagem, "Entrada nula!");
		
		String mensagem2 = "";
		try {
			c.exibeAdmin("", 12345678);
		} catch (IllegalArgumentException iae) {
			mensagem2 = iae.getMessage();
		}
		
		assertEquals(mensagem2, "Entrada vazia!");
		
		String mensagem3 = "";
		try {
			c.exibeAdmin("123.456.789-12", 1234567);
		} catch (IllegalArgumentException iae) {
			mensagem3 = iae.getMessage();
		}
		
		assertEquals(mensagem3, "Senha com tamanho inválido!");
	}
	
}
