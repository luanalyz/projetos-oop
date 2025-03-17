package testando;

import static org.junit.jupiter.api.Assertions.*;
import filmnow.Filme;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class FilmeTest {
	
	private Filme filmeComAno;
	private Filme filmeSemAno;
	
	@BeforeEach
	void preparaFilme() {
		this.filmeComAno = new Filme("Avatar", 2009, "Disney+");
		this.filmeSemAno = new Filme("Avatar", -1, "Disney+");
	}
	
	@Test
	void testToStringComAno() {
		String esperado = "Avatar, 2009\nDisney+";
		assertEquals(esperado, filmeComAno.toString());
	}
	
	@Test
	void testToStringSemAno() {
		String esperado = "Avatar\nDisney+";
		assertEquals(esperado, filmeSemAno.toString());
	}
	
	@Test
	void testToStringHotComAno() {
		filmeComAno.addHot();
		String esperado = "🔥 Avatar, 2009\nDisney+";
		assertEquals(esperado, filmeComAno.toString());
	}

	@Test
	void testToStringHotSemAno() {
		filmeSemAno.addHot();
		String esperado = "🔥 Avatar\nDisney+";
		assertEquals(esperado, filmeSemAno.toString());
	}
	
	@Test
	void testAddHot() {
		filmeComAno.addHot();
		assertTrue(filmeComAno.getHot());
	}
	
	@Test
	void testRemoveHot() {
		filmeComAno.addHot();
		assertTrue(filmeComAno.getHot());
		filmeComAno.removeHot();
		assertFalse(filmeComAno.getHot());
	}
}
