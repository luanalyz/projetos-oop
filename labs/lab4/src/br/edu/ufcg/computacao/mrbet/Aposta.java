package br.edu.ufcg.computacao.mrbet;
/**
 * Classe que representa a aposta.
 * 
 * @author Luana Lyz
 */
public class Aposta {
	private Time time; // objeto time.
	private Campeonato campeonato; // objeto campeonato.
	private int colocacao; // colocação na aposta.
	private double valor; // valor da aposta.
	/**
	 * Construtor com as informações da aposta. 
	 * @param time objeto time.
	 * @param nomeCampeonato objeto campeonato.
	 * @param colocacao colocação na aposta.
	 * @param valor valor da aposta.
	 */
	public Aposta (Time time, Campeonato nomeCampeonato, int colocacao, double valor) {
		if(time == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		if(nomeCampeonato == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		if (colocacao < 0) {
            throw new IndexOutOfBoundsException("VALOR INVÁLIDO!");
		}
		if (valor < 0) {
            throw new IndexOutOfBoundsException("VALOR INVÁLIDO!");
		}
		
		this.time = time;
		this.campeonato = nomeCampeonato;
		this.colocacao = colocacao;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return ". " +
				time.toString() + 
				"\n" +
				campeonato.getCampeonato() +
				"\n" +
				colocacao +
				"/" +
				campeonato.getInicialParticipantes() +
				"\nR$ " +
				String.format("%.2f", valor) +
				"\n";
	}
}
