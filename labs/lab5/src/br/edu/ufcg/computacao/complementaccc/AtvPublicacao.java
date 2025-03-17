package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe que representa a atividade complementar de publicação.
 */
public class AtvPublicacao extends AtividadeAbstrato {

	private String tituloArtigo;
	private String doi;
	private String qualis;
	private static final int creditosMax = 12;
	/**
	 * Construtor da classe
	 * @param codigo código da atividade
	 * @param tipo tipo da atividade
	 * @param tituloArtigo título do artigo
	 * @param doi Digital Object Identifier
	 * @param qualis Referencia da Capes
	 */
	public AtvPublicacao(String codigo, String tipo, String tituloArtigo, String doi, String qualis) {
		super(codigo, tipo, 1);
		this.tituloArtigo = tituloArtigo;
		this.doi = doi;
		this.qualis = qualis;
	}
	
	/**
	 * Retorna os créditos máximos da atividade.
	 */
	public int getCreditosMax() {
		return creditosMax;
	}
	
	@Override
	public String toString() {
		return super.getTipo() +
				": " +
				super.getCodigo() +
				"\nDescrição:" +
				super.getDescricao() +
				"\nLink: " +
				super.getLink() +
				"\nUnidades: " +
				super.getUnidade() +
				"\nCréditos: " +
				getCreditos() +
				"\nTitulo do artigo: "+
				this.tituloArtigo +
				"\nDoi: " +
				this.doi +
				"\nQualis: " +
				this.qualis;
	}
	@Override
	public double getCreditos() {
		if(qualis.equals("A4") || qualis.equals("B1"))
			return 1;
		
		int conta = 0;
		if(qualis.equals("A1") || qualis.equals("A2")) 
			conta = 3;
		if(qualis.equals("A3"))
			conta = 2;
		if(super.getTipo().endsWith("PERIODICO")) {
			conta++;
		}
		return conta;
	}

}
