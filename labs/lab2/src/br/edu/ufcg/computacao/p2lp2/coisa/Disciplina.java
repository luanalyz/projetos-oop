package br.edu.ufcg.computacao.p2lp2.coisa;
import java.util.*;
/**
 * Classe que representa as notas da disciplina, sua média e as horas de estudo.
 * 
 * @author Luana Lyz
 */
public class Disciplina {
	/**
	 *  nomeDisciplina indica o nome da disciplina.
	 */
	private String nomeDisciplina;
	/**
	 * horas indica a quantidade de horas estudadas.
	 */
	private int horas = 0;
	/**
	 * media indica a media entre todas as notas.
	 */
	private double media;
	/**
	 * organizado é um array de double onde será armazenado as quatro notas.
	 */
	private double[] organizado = new double[4];
	/**
	 * Registra qual a disciplina será armazenada.
	 * @param nomeDisciplina nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	/**
	 * Registra a quantidade de horas estudadas.
	 * @param horas horas estudadas
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}
	/**
	 * Registra a nota e a armazena no seu devido espaço.
	 * @param nota nota da avaliação
	 * @param valorNota qual a avaliação em questão
	 */
	public void cadastraNota(int nota, double valorNota) {
		organizado[nota - 1] = valorNota;
	}
	/**
	 * Analiza se o aluno está na média e retorna se está aprovado ou não.
	 * @return true or false
	 */
	public boolean aprovado() {
		double somaNotas = 0;
		
		for(int i = 0; i < organizado.length; i++) {
			somaNotas += organizado[i];
		}
		
		media = somaNotas / 4;
		
		if(media >= 7.0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retorna, em String, a disciplina, as horas estudadas, a média e as notas.
	 */
	public String toString() {
		return nomeDisciplina + " " + horas + " " + media + " " + Arrays.toString(organizado);
	}
}
