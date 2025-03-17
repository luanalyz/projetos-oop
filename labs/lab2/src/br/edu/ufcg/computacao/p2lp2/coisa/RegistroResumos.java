package br.edu.ufcg.computacao.p2lp2.coisa;
/**
 * Classe que cria um resumo a partir do tema e resumo registrados.
 * 
 * @author Luana Lyz Araujo Rocha - 123110697
 */
public class RegistroResumos {
	/**
	 * numeroDeResumos indica até quantos resumos podem ser armazenados.
	 */
	private int numeroDeResumos;
	/**
	 * contadorTemaseResumos indica quantos resumos foram armazenados, começando em 0.
	 */
	private int contadorTemaseResumos = 0;
	/**
	 * resumos é um array de Strings que armazena o tema e o resumo em um único índice.
	 */
	private String[] resumos; 
	/**
	 * listaTemas é um array de Strings que armazena todos os temas.
	 */
	private String[] listaTemas;
	/**
	 * Construtor que registra resumos a partir de uma quantidade.
	 * @param numeroDeResumos limite de numero de resumos
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.numeroDeResumos = numeroDeResumos;
		this.listaTemas = new String[numeroDeResumos];
		this.resumos = new String[numeroDeResumos];
	}
	/**
	 * Adiciona os temas e os resumos para os devidos arrays.
	 * @param tema
	 * @param resumo
	 */
	public void adiciona(String tema, String resumo) {
		if(contadorTemaseResumos == numeroDeResumos) {
			contadorTemaseResumos = 0;
		}

		this.listaTemas[contadorTemaseResumos] = tema;
		this.resumos[contadorTemaseResumos] = tema + ": " + resumo;
		contadorTemaseResumos++;
	}
	/**
	 * Retorna a lista de resumos.
	 * @return resumos
	 */
	public String[] pegaResumos() {
		return resumos;
	}
	/**
	 * Retorna, em String, a quantidade de temas e quais são.
	 * @return String
	 */
	public String imprimeResumos() {
		String out = "- ";
		for(int l = 0; l < contadorTemaseResumos; l++) {
			if(l == 0) {
				out = out + listaTemas[l];
			} else {
				out = out + " | " + listaTemas[l]; 
			}
		}
		return "- " + contadorTemaseResumos + " resumo(s) cadastrado(s)" + "\n" + out;
	}
	/**
	 * Retorna a quantidade de temas.
	 * @return quantidade
	 */
	public int conta() {
		int quantidade = 0;
		for(int i = 0; i < numeroDeResumos; i++) {
			if (listaTemas[i] == null) {
				break;
			} else {
				quantidade++;
			}
		}
		return quantidade;
	}
	/**
	 * Retorna se o tema em questão possui um resumo.
	 * @param tema
	 * @return true or false
	 */
	public boolean temResumo(String tema) {
		for(int k = 0; k < contadorTemaseResumos; k++) {
			if(listaTemas[k].toLowerCase().equals(tema.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
