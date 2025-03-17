package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe que representa o administrador.
 * 
 * @author luanalyz
 */
public class Admin extends Usuario {
	
	/**
	 * Construtor da classe Admin.
	 * @param nome nome do adm
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 */
	public Admin(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}
	
	@Override
	public String toString() {
		return "[" + cpf + "] " + nome;
	}

}
