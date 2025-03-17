package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe responsável por validar entradas e lançar exceções.
 * 
 * @author luanalyz
 */
public class ValidaExcecoes {
	/**
	 * Construtor que inicia a classe.
	 */
	public ValidaExcecoes() {
		
	}
	/**
	 * Valida as entradas em string
	 * @param entrada valor de entrada
	 */
	public void validaEntrada(String entrada) {
		if (entrada == null) {
			throw new NullPointerException("Entrada nula!");
		}
		
		if(entrada.isBlank()) {
			throw new IllegalArgumentException("Entrada vazia!");
		}
	}
	/**
	 * Verifica se a senha está no tamanho correto
	 * @param senha senha a ser verificada
	 */
	public void validaSenhaTam(int senha) {
		String senhaString = Integer.toString(senha);
		if(senhaString.length() != 8) {
			throw new IllegalArgumentException("Senha com tamanho inválido!");
		}
	}
	/**
	 * Verifica se a unidade é um valor válido.
	 * @param unidade unidades da atividade.
	 */
	public void validaUnidade(int unidade) {
		if(unidade < 1) {
			throw new IllegalArgumentException("Unidade inválida!");
		}
	}
}
