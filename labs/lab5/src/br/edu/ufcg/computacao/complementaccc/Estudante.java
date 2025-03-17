package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * Classe que inicia o objeto estudante.
 * 
 * @author luanalyz
 */
public class Estudante extends Usuario implements Comparable<Estudante>{

	private String matricula;
	
	private HashMap<String, AtividadeAbstrato> atividades;
	
	private ArrayList<RelatorioAbstrato> relatorios;
	/**
	 * Construtor que inicia a classe.
	 * @param nome nome do estudante
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param matricula matricula do estudante
	 */
	public Estudante(String nome, String cpf, int senha, String matricula) {
		super(nome, cpf, senha);
		this.matricula = matricula;
		this.atividades = new HashMap<>();
		this.relatorios = new ArrayList<>();
	}
	
	/**
	 * Muda o nome.
	 * @param novoNome novo nome
	 */
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	/**
	 * Gera o código da atividade.
	 * @return código da atividade.
	 */
	public String gerarCodigo() {
		return cpf + "_" + (atividades.size() + 1);
	}
	
	/**
	 * Adiciona uma atividade
	 * @param codigo codigo da atividade
	 * @param atv objeto Atividade
	 */
	public void adicionaAtividade(String codigo, AtividadeAbstrato atv) {
		this.atividades.put(codigo, atv);
	}
	
	/**
	 * Indica se existe a atividade
	 * @param codigo código da atividade
	 * @return valor booleano indicando se a atividade existe
	 */
	public boolean temAtv(String codigo) {
		return this.atividades.containsKey(codigo);
	}
	
	/**
	 * Muda a descrição da atividade.
	 * @param codigo código da atividade
	 * @param descricao nova descrição
	 */
	public void setDescricao(String codigo, String descricao) {
		this.atividades.get(codigo).setDescricao(descricao);
	}
	
	/**
	 * Muda o link da atividade
	 * @param codigo codigo da atividade
	 * @param link novo link
	 */
	public void setLink(String codigo, String link) {
		this.atividades.get(codigo).setLink(link);
	}
	
	/**
	 * Retorna a quantidade de créditos da atividadee.
	 * @param codigo código da atividade
	 * @return créditos da atividade
	 */
	public double getAtividadeCreditos(String codigo) {
		return this.atividades.get(codigo).getCreditos();
	}
	
	/**
	 * Adiciona o relatório detalhado de cada atividade por ordem.
	 * @return índice do relatório na lista
	 */
	public int addRelatorioDetalhado() {
		
		ArrayList<AtividadeAbstrato> r = new ArrayList<>();
		
		for(AtividadeAbstrato a : atividades.values() ) {
	 		r.add(a);
	 	}
	 	
	 	Collections.sort(r);

	 	RelatorioDetalhado relatorio = new RelatorioDetalhado(toString(), r);
	 	
	 	this.relatorios.add(relatorio);
	 	
	 	return this.relatorios.size();
	}
	
	/**
	 * Exibe o relatório escolhido.
	 * @param index index do relatório
	 * @return relatório
	 */
	public String exibeRelatorio(int index) {
		if(index < 1 || index > this.relatorios.size()) {
			return "Index inválido!";
		}
		
		return this.relatorios.get(index - 1).toString();
	}
	
	/**
	 * Adiciona relatório de um tipo específico.
	 * @param tipo tipo de relatório
	 * @return index do relatório
	 */
	public int addRelatorioTipo(String tipo) {
		if(!tipo.startsWith("PUBLICACAO") && !tipo.equals("MONITORIA") && !tipo.equals("ESTAGIO") && !tipo.equals("PESQUISA")) {
			return 0;
		}
		
		double creditos = 0;
		
		for(AtividadeAbstrato a : atividades.values() ) {
			if(tipo.startsWith("PUBLICACAO")) {
				if(a.getTipo().startsWith("PUBLICACAO")) {
					creditos += a.getCreditos();
				}
			} else if(a.getTipo().equals(tipo)) {
				creditos += a.getCreditos();
			}
		}
		
		int creditosMax = 0;
		if(tipo.startsWith("PUBLICACAO")) {
			if(creditos > 12) {
				creditos = 12;
			}
			creditosMax = 12;
		} if(tipo.equals("MONITORIA")) {
			if(creditos > 16) {
				creditos = 16;
			}
			creditosMax = 16;
		} if(tipo.equals("ESTAGIO")) {
			if(creditos > 18) {
				creditos = 18;		
			} else if(creditos < 5) {
				creditos = -1;
			}
			creditosMax = 18;
		} if(tipo.equals("PESQUISA")) {
			if(creditos > 18) {
				creditos = 18;		
			} else if(creditos < 10) {
				creditos = -1;
			}
			creditosMax = 18;
		}
		
		RelatorioTipo relatorio = new RelatorioTipo(toString(), creditos, creditosMax, tipo);
	 	
	 	this.relatorios.add(relatorio);
	 	
		return this.relatorios.size();
	}
	
	/**
	 * Adiciona relatório resumido.
	 * @return index do relatório.
	 */
	public int addRelatorioResumido() {
		double monitoriaC = 0;
		double estagioC = 0;
		double pesquisaC = 0;
		double publicacaoC = 0;
		
		String tipo = "";
		for(AtividadeAbstrato a : atividades.values() ) {
			tipo = a.getTipo();
			if(tipo.startsWith("PUBLICACAO"))  {
				publicacaoC += a.getCreditos();
			} else if(tipo.equals("MONITORIA")) {
				monitoriaC += a.getCreditos();
			} else if(tipo.equals("ESTAGIO")) {
				estagioC += a.getCreditos();
			} else if(tipo.equals("PESQUISA")) {
				pesquisaC += a.getCreditos();
			}
		}
		
		if(publicacaoC > 12) {
			publicacaoC = 12;
		}
		
		if(monitoriaC > 16) {
			monitoriaC = 16;
		}
		
		if(estagioC > 18) {
			estagioC = 18;		
		} else if(estagioC < 5) {
			estagioC = -1;
		}
		if(pesquisaC > 18) {
			pesquisaC = 18;
		}
		if(pesquisaC < 10) {
			pesquisaC = -1;
		}
		
		RelatorioResumido relatorio = new RelatorioResumido(toString(), monitoriaC, estagioC, pesquisaC, publicacaoC);
		this.relatorios.add(relatorio);
		return this.relatorios.size();
	}
	
	
	@Override
	public String toString() {
		return "[" + cpf + "] " + matricula + " - " + nome;
	}

	@Override
	public int compareTo(Estudante o) {
		return this.nome.compareTo(o.nome);
	}
	
}
