package br.edu.ufcg.computacao.p2lp2.coisa;
/**
 * Classe que registra as quantidades de horas de internet que o aluno tem dedicado a determinada disciplina remota. 
 * 
 * @author Luana Lyz Araujo Rocha - 123110697
 * */
public class RegistroTempoOnline {
	/**
	 * nomeDisciplina define o nome da disciplina.
	 */
	private String nomeDisciplina;
	/**
	 * tempoOnlineEsperado define o tempo online que se espera que o aluno se dedique online a disciplina.
	 */
	private int tempoOnlineEsperado;
	/**
	 * tempoTotal define o total de horas estudadas pelo aluno em determinada disciplina.
	 */
	private int tempoTotal = 0;
	/**
	 * Registra qual a disciplina a ser estudada, já estabelecendo o tempo online esperado. 
	 * @param nomeDisciplina o nome da disciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoTotal = 0;
		this.tempoOnlineEsperado = 120;
	}
	/**
	 * Registra qual a disciplina a ser estudada e qual o tempo online esperado.
	 * @param nomeDisciplina o nome da disciplina
	 * @param tempoOnlineEsperado o tempo, em horas, esperado
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	/**
	 * Adiciona ao registro de tempo total estudado.
	 * @param tempo tempo estudado
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoTotal += tempo;
	}
	/**
	 * Indica se o tempo online esperado foi atendido ou não.
	 * @return true or false
	 */
	public boolean atingiuMetaTempoOnline() {
		if(tempoTotal >= tempoOnlineEsperado) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna em String a disciplina e o tempo online em relação ao tempo esperado.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.tempoTotal + "/" + this.tempoOnlineEsperado;
	}
}