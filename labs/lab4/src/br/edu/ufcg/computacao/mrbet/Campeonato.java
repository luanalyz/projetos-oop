package br.edu.ufcg.computacao.mrbet;
/**
 * Classe que representa o campeonato.
 * 
 * @author Luana Lyz
 */
public class Campeonato {
	
	private String nomeCampeonato; // nome do campeonato. 
	private int numParticipantes; // número de participantes do campeonato.
	private int inicialParticipantes; // número inicial de vagas do campeonato.
	/**
	 * Construtor com as informações do campeonato.
	 * @param nomeCampeonato nome do campeonato.
	 * @param inicialParticipantes número inicial de vagas do campeonato.
	 */
	public Campeonato(String nomeCampeonato, int inicialParticipantes) {
		if(nomeCampeonato == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		if(nomeCampeonato.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
		if (inicialParticipantes < 0) {
            throw new IndexOutOfBoundsException("NÚMERO DE PARTICIPANTES INVÁLIDO!");
		}
		
		this.nomeCampeonato = nomeCampeonato;
		this.numParticipantes = 0;
		this.inicialParticipantes = inicialParticipantes;
	}
	/**
	 * Retorna o nome do campeonato.
	 * @return nome do campeonato.
	 */
	public String getCampeonato() {
		return nomeCampeonato;
	}
	/**
	 * Retorna o número inicial de vagas do campeonato.
	 * @return número inicial de vagas do campeonato.
	 */
	public int getInicialParticipantes() {
		return inicialParticipantes;
	}
	/**
	 * Retorna o número de participantes do campeonato.
	 * @return número de participantes do campeonato.
	 */
	public int getNumParticipantes() {
		return numParticipantes;
	}
	/**
	 * Verifica se ainda há vagas.
	 * @return boolean indicando se ainda há vagas.
	 */
	public boolean verificaVagas() {
		if(numParticipantes == inicialParticipantes) {
			return false;
		}
		return true;
	}
	/**
	 * Preenche uma vaga.
	 */
	public void addParticipante() {
		numParticipantes++;
	}
	
	@Override
	public String toString() {
		return "* " +
				nomeCampeonato +
				" - " +
				numParticipantes +
				"/" +
				inicialParticipantes;
	}
	
}
