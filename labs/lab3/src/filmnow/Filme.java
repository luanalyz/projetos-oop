package filmnow;

import java.util.Objects;

/**
 * Classe que representa o filme.
 * 
 * @author Luana Lyz
 */
public class Filme {
	/**
	 * nome do filme.
	 */
	private String nome;
	/**
	 * ano do filme.
	 */
	private int ano;
	/*
	 * indica se o filme é hot.
	 */
	private boolean hot = false;
	/**
	 * local de streaming do filme.
	 */
	private String local;
	/**
	 * Construtor com informações do filme.
	 * @param nome nome do filme.
	 * @param ano ano do filme.
	 * @param local local de streaming do filme.
	 */
	public Filme(String nome, int ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
	}
	/**
	 * Recupera o nome do filme.
	 * @return o nome do filme.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Recupera o ano do filme.
	 * @return o ano do filme.
	 */
	public int getAno() {
		return ano;
	}
	/**
	 * Representação em String do filme.
	 * @return representação em string do nome, ano e local do filme.
	 */
	
	@Override
	public String toString() {
		if(hot) {
			if(ano == -1) {
				return "🔥 " + nome + "\n" + local;
			}
			return "🔥 " + nome + ", " + ano + "\n" + local;
		}
		if(ano == -1) {
			return nome + "\n" + local;
		}
		return nome + ", " + ano + "\n" + local;
	}
	/**
	 * Acessa o valor de hot.
	 * @return boolean de hot.
	 */
	public boolean getHot() {
		return hot;
	}
	/**
	 * Torna o filme hot.
	 */
	public void addHot() {
		this.hot = true;
	}
	/**
	 * Retira a característica hot do filme.
	 */
	public void removeHot() {
		this.hot = false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return ano == other.ano && Objects.equals(nome, other.nome);
	}

}