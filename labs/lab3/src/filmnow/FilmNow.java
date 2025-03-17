package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 *
 */
public class FilmNow {
	
	private static final int TAM_FILMES = 100;
	
	private static final int TAM_HOTS = 10;
	
	private Filme[] filmes; //uma representacao simploria da lista de filmes
	
	private Filme[] hots; //uma representação simploria da lista de filmes que precisa ser assistido.
	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAM_FILMES];
		this.hots = new Filme[TAM_HOTS];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	
	public String detalhaFilme(int posicao) {
		if(posicao > 100 || posicao < 1) {
			return "POSIÇÃO INVÁLIDA!";
		}
		if(verificaExistencia(posicao)) {
			return "";
		}
		return filmes[posicao - 1].toString();
	}
	
	/**
	 * Verifica se a posição está vazia.
	 * @param posicao
	 * @return boolean
	 */
	private boolean verificaExistencia(int posicao) {
		if(filmes[posicao - 1] == null) {
			return true;
		}
		return false;
	}
	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 * @return String informando a ação.
	 */
	public String cadastraFilme(int posicao, String nome, int ano, String local) {
		if(verificaFilme(nome, ano)) {
			return "FILME JA ADICIONADO";
		} else if (posicao > 100 || posicao < 1) {
			return "POSIÇÃO INVÁLIDA";
		} else if (nome.equals("") || local.equals("")) {
			return "FILME INVÁLIDO";
		} else {
			this.filmes[posicao - 1] = new Filme(nome, ano, local);
			return "FILME ADICIONADO";
		}
	}
	/**
	 * Verifica se o filme já existe.
	 * @param nome nome do filme.
	 * @param ano ano do filme.
	 * @return boolean.
	 */
	private boolean verificaFilme(String nome, int ano) {
		for (int i = 0; i < filmes.length; i++) {
			if(filmes[i] != null) {
				if (filmes[i].getNome().equals(nome) && filmes[i].getAno() == ano) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Retorna todos os filmes da HotList.
	 * @return String com todos os filmes.
	 */
	public String listarHots() {
		String output = "\n";
		for(int i = 0; i < hots.length; i++) {
			if(hots[i] != null) { 
				int posicao = i + 1;
				output += posicao + " - " + hots[i].getNome() + ", " + hots[i].getAno() + "\n";
			}
		}
		return output;
	}
	
	/**
	 * Cadastra um filme na HotList.
	 * @param filme filme a ser cadastrado
	 * @param posicao posição na lista HotList
	 * @return String confirmando se foi adicionado ou não.
	 */
	public String cadastraHot(int filme, int posicao) {
		if(posicao > 10 || posicao < 1) {
			return "POSIÇÃO INVÁLIDA";
		}
		if(verificaHot(filmes[filme-1].getNome())) {
			return "FILME JÁ ADICIONADO";
		}
		if (hots[posicao-1] == null) {
			hots[posicao-1] = filmes[filme-1];
		} else {
			hots[posicao-1].removeHot();
			hots[posicao-1] = filmes[filme-1];
		}
		filmes[filme-1].addHot();
		return "ADICIONADO À HOTLIST NA POSIÇÃO " + posicao + "!";
	}
	
	/**
	 * Remove um filme da HotList
	 * @param posicao posição do filme a ser retirado.
	 */
	public void removeHot(int posicao) {
		hots[posicao-1].removeHot();
		hots[posicao-1] = null;
	}
	
	/**
	 * Verifica se o filme já está na HotList.
	 * @param nome nome do filme
	 * @return boolean se o filme está ou não.
	 */
	private boolean verificaHot(String nome) {
		for(int i = 0; i < hots.length; i++) {
			if(hots[i] != null) {
				if (hots[i].getNome().equals(nome)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
