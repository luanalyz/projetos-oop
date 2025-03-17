package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Classe que registra a rotina de descanso do aluno.
 * 
 * @author Luana Lyz Araujo Rocha - 123110697
 */
public class Descanso {
	/**
	 * horasSemanais define a média de horas descansadas por semana.
	 */
	private int horasSemanais;
	/**
	 * horas define a quantidade de horas descansadas, iniciando em 0.
	 */
	private int horas = 0;
	/**
	 * semanas define a quantidade de semanas que foi descansado as horas anteriores, iniciando em 0.
	 */
	private int semanas = 0;
	/**
	 * estado define a condição do aluno, iniciando em cansado.
	 */
	private String estado = "cansado";
	/**
	 * Cadastra a quantidade de horas descansadas.
	 * @param horas quantidade de horas descansadas
	 */
	public void defineHorasDescanso(int horas) {
		this.horas = horas;
	}
	/**
	 * Registra o número de semanas em estudo.
	 * @param semanas número de semanas que irão contabilizar.
	 */
	public void defineNumeroSemanas(int semanas) {
		this.semanas = semanas;
	}
	/**
	 * Define se o aluno está descansado.
	 * @return estado estado atual do aluno em string.
	 */
	public String getStatusGeral() {
		if(horas == 0 && semanas == 0) {
			return estado;
		}
		
		this.horasSemanais = horas / semanas;
		
		if(horasSemanais >= 26) {
			this.estado = "descansado";
		} else {
			this.estado = "cansado";
		}
		return estado;
	}
}