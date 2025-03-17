package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que representa o relatório por tipo específico.
 * 
 * @author luanalyz
 */
public class RelatorioTipo extends RelatorioAbstrato {

	private double creditos;
	
	private int creditosMax;
	
	private String tipo;
	/**
	 * Construtor da classe.
	 * @param estudante representação textual do estudante.
	 * @param credito quantidade de créditos da atividade.
	 * @param creditoMax quantidade máxima de créditos da atividade.
	 */
	public RelatorioTipo(String estudante, double creditos, int creditosMax, String tipo) {
		super(estudante);
		this.creditos = creditos;
		this.creditosMax = creditosMax;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		String s = ": " + (int)creditos + "/" + creditosMax;
		if(creditos == -1) {
			s = ": NÃO ATINGIU O VALOR MÍNIMO!";
		}
		String out = super.getEstudante() + "\n" + this.tipo + s;
		
		
		return out;
	}

}