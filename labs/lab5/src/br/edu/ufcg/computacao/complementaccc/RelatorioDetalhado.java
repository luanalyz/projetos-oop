package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;

/**
 * Classe que representa o relatório detalhado.
 * 
 * @author luanalyz
 */
public class RelatorioDetalhado extends RelatorioAbstrato {

	private ArrayList<AtividadeAbstrato> atividades;
	/**
	 * Construtor da classe.
	 * @param estudante representação textual do estudante.
	 * @param credito quantidade de créditos da atividade.
	 * @param tipo tipo de atividade
	 * @param descricao descrição da atividade
	 * @param unidade quantidade de unidades acumuladas da atividade.
	 */
	public RelatorioDetalhado(String estudante, ArrayList<AtividadeAbstrato> r) {
		super(estudante);
		this.atividades = r;

	}

	@Override
	public String toString() {
		String out = super.getEstudante() + "\n\n";
		for(AtividadeAbstrato a : atividades) {
			if(out.equals(super.getEstudante() + "\n\n")) {
				out += a.toString();
			} else {
				out += "\n\n"+ a.toString();
			}
		}
		return out;
	}

}
