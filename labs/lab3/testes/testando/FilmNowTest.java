package testando;

import static org.junit.jupiter.api.Assertions.*;
import filmnow.FilmNow;
import org.junit.jupiter.api.Test;

class FilmNowTest {
	
	private FilmNow filme = new FilmNow();
	
	// Escolhi não usar BeforeEach para ter mais controle.

	@Test
	void testAddPosicaoVazia() {
		String esperado = "FILME ADICIONADO";
		assertEquals(esperado, filme.cadastraFilme(1, "Avatar", 2009, "Disney+"));
	}
	
	@Test
	void testAddPosicaoExistente() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		String esperado = "FILME ADICIONADO";
		assertEquals(esperado, filme.cadastraFilme(1, "20 dias em Mariupol", 2023, "Cinema"));
	}
	
	@Test
	void testAddFilmeExistente() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		String esperado = "FILME JA ADICIONADO";
		assertEquals(esperado, filme.cadastraFilme(3, "Avatar", 2009, "Disney+"));
	}
	
	@Test
	void testAddFilmeExistenteOutroLocal() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		String esperado = "FILME JA ADICIONADO";
		assertEquals(esperado, filme.cadastraFilme(3, "Avatar", 2009, "Amazon Prime"));
	}
	
	@Test
	void testAddLimite() {
		String esperado = "FILME ADICIONADO";
		assertEquals(esperado, filme.cadastraFilme(100, "Avatar", 2009, "Disney+"));
	}
	
	@Test
	void testAddAcimaDoLimite() {
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado, filme.cadastraFilme(101, "Avatar", 2009, "Disney+"));
	}
	
	@Test
	void testAddAbaixoDoLimite() {
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado, filme.cadastraFilme(0, "Avatar", 2009, "Disney+"));
	}
	
	@Test
	void testAddLocalVazio() {
		String esperado = "FILME INVÁLIDO";
		assertEquals(esperado, filme.cadastraFilme(1, "20 dias em Mariupol", 2023, ""));
	}
	
	@Test
	void testAddAnoVazio() {
		String esperado = "FILME ADICIONADO";
		assertEquals(esperado, filme.cadastraFilme(1, "20 dias em Mariupol", 0, "Cinema"));
	}
	
	@Test
	void testAddNomeVazio() {
		String esperado = "FILME INVÁLIDO";
		assertEquals(esperado, filme.cadastraFilme(1, "", 2023, "Cinema"));
	}
	
	@Test
	void testDetalheFilme() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		String esperado = "Avatar, 2009\nDisney+";
		assertEquals(esperado, filme.detalhaFilme(1));
	}
	
	@Test
	void testDetalheFilmeSemAno() {
		this.filme.cadastraFilme(1, "Avatar", -1, "Disney+");
		String esperado = "Avatar\nDisney+";
		assertEquals(esperado, filme.detalhaFilme(1));
	}
	
	@Test
	void testDetalheSemFilme() {
		String esperado = "";
		assertEquals(esperado, filme.detalhaFilme(1));
	}
	
	@Test
	void testDetalhePosicaoInferior() {
		String esperado = "POSIÇÃO INVÁLIDA!";
		assertEquals(esperado, filme.detalhaFilme(0));
	}
	
	@Test
	void testDetalhePosicaoSuperior() {
		String esperado = "POSIÇÃO INVÁLIDA!";
		assertEquals(esperado, filme.detalhaFilme(101));
	}
	
	@Test
	void testDetalheHotFilme() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		this.filme.cadastraHot(1, 1);
		String esperado = "🔥 Avatar, 2009\nDisney+";
		assertEquals(esperado, filme.detalhaFilme(1));
	}
	
	@Test
	void testAddHoPosicaoVazia() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		String esperado = "ADICIONADO À HOTLIST NA POSIÇÃO 1!";
		assertEquals(esperado, this.filme.cadastraHot(1, 1));
	}
	
	@Test
	void testAddHotPosicaoInvalidaSuperior() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado, this.filme.cadastraHot(1, 11));
	}
	
	@Test
	void testAddHotPosicaoInvalidaInferior() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado, this.filme.cadastraHot(1, 0));
	}

	@Test
	void testAddHotPosicaoExistente() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		this.filme.cadastraHot(1, 1);
		filme.cadastraFilme(2, "20 dias em Mariupol", 2023, "Cinema");
		String esperado = "ADICIONADO À HOTLIST NA POSIÇÃO 1!";
		assertEquals(esperado, this.filme.cadastraHot(2, 1));
	}
	
	@Test
	void testAddHotExistente() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		this.filme.cadastraHot(1, 1);
		String esperado = "FILME JÁ ADICIONADO";
		assertEquals(esperado, this.filme.cadastraHot(1, 2));
	}
	
	@Test
	void testListaHotsUmFilme() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		this.filme.cadastraHot(1, 1);
		String esperado = "\n1 - Avatar, 2009\n";
		assertEquals(esperado, this.filme.listarHots());
	}
	
	@Test
	void testListaHotsMultiplosFilmes() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		this.filme.cadastraHot(1, 1);
		this.filme.cadastraFilme(2, "20 dias em Mariupol", 2023, "Cinema");
		this.filme.cadastraHot(2, 2);
		String esperado = "\n1 - Avatar, 2009\n2 - 20 dias em Mariupol, 2023\n";
		assertEquals(esperado, this.filme.listarHots());
	}
	
	@Test
	void testRemoveHot() {
		this.filme.cadastraFilme(1, "Avatar", 2009, "Disney+");
		this.filme.cadastraHot(1, 1);
		this.filme.removeHot(1);
		String esperado = "\n";
		assertEquals(esperado, this.filme.listarHots());
	}
	
}