package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe que representa a atividade complementar de monitoria.
 */
public class AtvMonitoria extends AtividadeAbstrato {

	private String disciplina;
	
	private static final int creditosMax = 16;
	/**
	 * Construtor da classe.
	 * @param codigo código da atividade
	 * @param tipo tipo da atividade
	 * @param unidade unidade acumulada da atividade
	 * @param disciplina disciplina da atividade
	 */
	public AtvMonitoria(String codigo, String tipo, int unidade, String disciplina) {
		super(codigo, tipo, unidade);
		this.disciplina = disciplina;
		
	}

	/**
	 * Retorna os créditos máximos da atividade.
	 */
	public int getCreditosMax() {
		return creditosMax;
	}
	
	@Override
	public double getCreditos() {
		double total = super.getUnidade() * 4.0;
		if(total > 16) {
			return 16;
		}
		return total;
	}
	
	@Override
	public String toString() {
		return super.getTipo() +
				": " +
				super.getCodigo() +
				"\nDescrição:" +
				super.getDescricao() +
				"\nLink: " +
				super.getLink() +
				"\nUnidades: " +
				super.getUnidade() +
				"\nCréditos: " +
				getCreditos() +
				"\nDisciplina: " +
				this.disciplina;
	}
}
