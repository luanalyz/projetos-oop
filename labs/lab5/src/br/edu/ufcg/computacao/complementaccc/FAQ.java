package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;
/**
 * Classe que representa as perguntas mais frequentes dos estudantes.
 * 
 * @author luanalyz
 */
public class FAQ {
	
	private String pergunta;
	
	private String[] tags;
	
	private int destaques;
	
	private String resposta;
	/**
	 * Construtor da classe.
	 * @param pergunta pergunta da FAQ
	 * @param resposta resposta da FAQ
	 */
	public FAQ(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.tags = new String[3];
		this.destaques = 0;
	}
	/**
	 * Retorna a pergunta.
	 * @return pergunta
	 */
	public String getPergunta() {
		return this.pergunta;
	}
	/**
	 * Muda a resposta.
	 * @param novaResposta nova resposta
	 */
	public void setResposta(String novaResposta) {
		this.resposta = novaResposta;
	}
	/**
	 * Aumenta em um o número de destaques da pergunta.
	 */
	public void destacar() {
		destaques++;
	}
	/**
	 * Retorna a quantidade de destaques.
	 * @return destaques
	 */
	public int getDestaques() {
		return destaques;
	}
	/**
	 * Muda as tags da pergunta.
	 * @param novaTag novas tags.
	 */
	public void setTag(String[] novaTag) {
		this.tags = novaTag;
	}

	/**
	 * Verifica se existe a tag
	 * @param tag tag procurada
	 * @return valor booleano indicando se a tag existe.
	 */
	public boolean temTag(String tag) {
		for(String t : tags) {
			if(t.equals(tag)) {
				return true;
			}
 		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pergunta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FAQ other = (FAQ) obj;
		return Objects.equals(pergunta, other.pergunta);
	}

	@Override
	public String toString() {
		return pergunta + "\n" + resposta;
	}

}
