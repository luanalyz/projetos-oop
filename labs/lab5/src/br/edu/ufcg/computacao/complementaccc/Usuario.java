package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;
/**
 * Classe abstrata que guarda informações de um usuário.
 * 
 * @author luanalyz
 */
public abstract class Usuario  {

	protected String nome;
	
	protected String cpf;
	
	protected int senha;
	/**
	 * Construtor iniciando a classe.
	 * @param nome nome do usuário
	 * @param cpf cpf do usuário
	 * @param senha senha do usuário
	 */
	public Usuario(String nome, String cpf, int senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	/**
	 * Muda a senha.
	 * @param novaSenha nova senha
	 */
	public void setSenha(int novaSenha) {
		this.senha = novaSenha;
	}
	/**
	 * Valida o login do usuário
	 * @param testeCpf
	 * @param testeSenha
	 */
	public void ValidaUsuario(String cpf, int senha) {
		if(!this.cpf.equals(cpf) || this.senha != senha) {
			throw new IllegalArgumentException("Login inválido!");
		}
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public abstract String toString();
}
