package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe abstrata dos relatórios.
 * 
 * @author luanalyz
 */
public abstract class RelatorioAbstrato {

	private String estudante;
	
	/**
	 * Construtor da classe.
	 * @param estudante representação textual do estudante.
	 * @param credito quantidade de créditos da atividade.
	 */
	public RelatorioAbstrato(String estudante) {
		this.estudante = estudante;
	}
	
	/**
	 * Retorna a representação textual do estudante.
	 * @return representação textual do estudante.
	 */
	public String getEstudante() {
		return this.estudante;
	}
	
	@Override
	public abstract String toString();
}
