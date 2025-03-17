package br.edu.ufcg.computacao.complementaccc;

public class RelatorioResumido extends RelatorioAbstrato {

	private double monitoriaC;
	private double estagioC;
	private double pesquisaC;
	private double publicacaoC;
	
	public RelatorioResumido(String estudante, double monitoriaC, double estagioC, double pesquisaC, double publicacaoC) {
		super(estudante);
		this.monitoriaC = monitoriaC;
		this.estagioC = estagioC;
		this.pesquisaC = pesquisaC;
		this.publicacaoC = publicacaoC;
	}

	@Override
	public String toString() {	
		String out =  super.getEstudante() +
				"\nMonitoria: " +
				(int)monitoriaC +
				"/16\nPublicação: " +
				(int)publicacaoC +
				"/12\nEstagio: ";
				
		if(estagioC == -1) {
			out += "NÃO ATINGIU O VALOR MÍNIMO!\nPesquisa de extensão: ";
		} else {
			out += (int)estagioC +
					"/18\nPesquisa de extensão: ";
		}
		
		if(pesquisaC == -1) {
			out += "NÃO ATINGIU O VALOR MÍNIMO!";
		} else {
			out += (int)pesquisaC +
					"/18";
		}
		return out;
	}

}
