package br.edu.ufcg.computacao.complementaccc;

public class AtvPesquisaExtensao extends AtividadeAbstrato {

	private String disciplina;
	
	private static final int creditosMax = 18;
	
	public AtvPesquisaExtensao(String codigo, String tipo, int unidadeAcumulada, String disciplina) {
		super(codigo, tipo, unidadeAcumulada);
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
		double total = (super.getUnidade() / 12.0) * 10.0;
		if(total > 18) {
			return 18;
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
