package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;
/**
 * Classe abstrata para as atividades complementares.
 * 
 * @author luanalyz
 */
public abstract class AtividadeAbstrato implements Comparable<AtividadeAbstrato> {
	
	private String descricao;
	
	private String codigo;
	
	private String tipo;
	
	private int unidade;
	
	private String link;
	/**
	 * Construtor da classe.
	 * @param codigo código da atividade.
	 * @param tipo tipo de atividade.
	 * @param unidade unidades acumuladas da atividade.
	 */
	public AtividadeAbstrato(String codigo, String tipo, int unidade) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.unidade = unidade;
		this.descricao = null;
		this.link = null;
	}
	/**
	 * Retorna o código de identificação.
	 * @return código de identificação
	 */
	public String getCodigo() {
		return this.codigo;
	}
	/**
	 * Retorna o link de comprovação.
	 * @return link de comprovação
	 */
	public String getLink() {
		return link;
	}
	/**
	 * Muda a descrição da atividade.
	 * @param novaDescricao nova descrição
	 */
	public void setDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
	}
	/**
	 * Muda o link da atividade.
	 * @param novoLink novo link
	 */
	public void setLink(String novoLink) {
		this.link = novoLink;
	}
	/**
	 * Retorna as unidades acumuladas da atividade.
	 * @return unidades
	 */
	public int getUnidade() {
		return this.unidade;
	}
	/**
	 * Retorna o tipo da atividade.
	 * @return tipo
	 */
	public String getTipo() {
		return this.tipo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	/**
	 * Método abstrato para a obtenção dos créditos da atividade.
	 * @return créditos
	 */
	public abstract double getCreditos();

	/**
	 * Método abstrato para a obtenção da quantidade máxima de créditos da atividade.
	 * @return créditos máximos da atividade.
	 */
	public abstract int getCreditosMax();
	
	@Override
	public abstract String toString();
	@Override
	public int compareTo(AtividadeAbstrato o) {
		return this.tipo.compareTo(o.tipo);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtividadeAbstrato other = (AtividadeAbstrato) obj;
		return Objects.equals(tipo, other.tipo);
	}
	
	
}
