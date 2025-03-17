package br.edu.ufcg.computacao.mrbet;

import java.util.HashSet;
/**
 * Classe que representa o time.
 * 
 * @author Luana Lyz
 */
public class Time {
	
	private String codigo; // código que identifica o time.
	private String nome; // nome do time.
	private String mascote; // mascote do time.
	private HashSet<Campeonato> participacao; // lista com todos os campeonatos que o time participa.
	
	/**
	 * Construtor com as informações do time.
	 * @param codigo código de identificação do time.
	 * @param nome nome do time.
	 * @param mascote mascote do time.
	 */
	public Time(String codigo, String nome, String mascote) {
		if(codigo == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		if(codigo.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
		if(nome == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		if(nome.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
		if(mascote == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		if(mascote.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
		
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
		this.participacao = new HashSet<>();
	}
	/**
	 * Retorna o nome do time.
	 * @return nome do time.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Cadastra um novo campeonato que o time irá participar.
	 * @param campeonato campeonato a ser participado.
	 */
	public void adicionaParticipacao(Campeonato campeonato) {
		if(campeonato == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		
		if(!existeCampeonato(campeonato.getCampeonato())) {
			participacao.add(campeonato);
			campeonato.addParticipante();
		}
	}
	/**
	 * Verifica se o time participa do campeonato.
	 * @param campeonato campeonato a ser verificado.
	 * @return boolean indicando se participa ou não.
	 */
	public boolean existeCampeonato(String campeonato) {
		if(campeonato == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		if(campeonato.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
		
		for(Campeonato c : participacao) {
			if(c.getCampeonato().equalsIgnoreCase(campeonato)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Retorna uma representação textual de todos os campeonatos que o time participa.
	 * @return representação textual de todos os campeonatos que o time participa.
	 */
	public String retornaCampeonatos() {
		String output = "";
		for(Campeonato c : participacao) {
			output+= "\n" + c.toString();
		}
		return output;
	}
	/**
	 * Retorna a quantidade de campeonatos participados.
	 * @return quantidade em int dos campeonatos participados.
	 */
	public int tamanhoParticipacoes() {
		return participacao.size();
	}
	
	@Override
	public String toString() {
		return "["+
				codigo +
				"] " +
				nome + 
				" / " +
				mascote;
	}
	
}