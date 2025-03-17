package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe que representa a atividade complementar de estágio.
 * 
 * @author luanalyz
 */
public class AtvEstagio extends AtividadeAbstrato {

	private String disciplina;
	
	private static final int creditosMax = 18;
	/**
	 * Construtor da classe.
	 * @param codigo código da atividade
	 * @param tipo tipo da atividade
	 * @param unidade unidade da atividade
	 * @param disciplina disciplina da atividade
	 */
	public AtvEstagio(String codigo, String tipo, int unidade, String disciplina) {
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
		double conta = super.getUnidade() / 60.0;
		if(conta > 18) {
			return 18;
		}
		return conta;
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
