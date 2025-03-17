package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * Classe que inicia os estudantes e o administrador.
 * 
 * @author luanalyz
 */
public class ControleUsuario {

	private HashMap<String, Estudante> estudantes;
	
	private Admin admin;
	
	/**
	 * Construtor da classe.
	 */
	public ControleUsuario() {
		this.estudantes = new HashMap<>();
		this.admin = null;
	}
	
	/**
	 * Cadastra um novo estudante
	 * @param cpf cpf do estudante
	 * @param nome nome do estudante
	 * @param senha senha do estudante
	 * @param matricula matricula do estudante
	 * @return valor booleano indicando se foi possível cadastrar o estudante.
	 */
	public boolean cadastraEstudante(String cpf, String nome, int senha, String matricula) {
		if(estudantes.containsKey(cpf)) {
			return false;
		}
		this.estudantes.put(cpf, new Estudante(nome, cpf, senha, matricula));
		return true;
	}
	
	/**
	 * Exibe uma lista ordenada com todos os estudantes.
	 * @return array de strings com as representações textuais dos estudantes.
	 */
	public String[] exibeEstudantes() {
		ArrayList<Estudante> lista = new ArrayList<>();
		for(Estudante e : estudantes.values()) {
			lista.add(e);
		}
		Collections.sort(lista);
		String[] estudantes = new String[lista.size()];
		int cont = 0;
		for(Estudante e : lista) {
			estudantes[cont] = e.toString();
			cont++;
		}
		return estudantes;
	}
	
	/**
	 * Edita um valor do estudante
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipoAlteracao tipo de valor a ser alterado
	 * @param novoValor o novo valor
	 * @return valor booleano indicando se foi possível alterar o valor.
	 */
	public boolean editaEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		if(!this.estudantes.containsKey(cpf)) {
			return false;
		}
		
		Estudante estudante = this.estudantes.get(cpf);
		
		estudante.ValidaUsuario(cpf, senha);
		
		if(tipoAlteracao.toLowerCase().equals("senha")) {
			estudante.setSenha(Integer.parseInt(novoValor));
		} else if(tipoAlteracao.toLowerCase().equals("nome")) {
			estudante.setNome(novoValor);
		} else {
			return false;
		}
		return true;
	}
	
	/**
	 * Exibe representação textual do administrador.
	 * @return representação textual do adm.
	 */
	public String exibeADMIN() {
		return this.admin.toString();
	}
	
	
	// n sei a função de boolean aqui sendo sincera
	/**
	 * Cadastra um novo administrador.
	 * @param nomeNovo novo nome
	 * @param cpfNovo novo cpf
	 * @param senhaNova nova senha
	 * @return valor booleano indicando se foi possível cadastrar o novo adm.
	 */
	public boolean novoAdmin(String nomeNovo, String cpfNovo, int senhaNova) {
		this.admin = new Admin(nomeNovo, cpfNovo, senhaNova);
		return true;
	}
	
	// aqui tb nao
	/**
	 * Muda senha do administrador
	 * @param senhaNova nova senha
	 * @return valor booleano indicando se foi possível mudar a senha.
	 */
	public boolean mudarSenhaAdmin(int senhaNova) {
		this.admin.setSenha(senhaNova);
		return true;
	}
	
	/**
	 * Cria uma nova atividade de monitoria.
	 * @param cpf cpf do estudante
	 * @param tipo tipo de atividade
	 * @param unidadeAcumulada quantidade de semestres que durou a atividade
	 * @param disciplina disciplina da monitoria
	 * @return código de identificação da atividade.
	 */
	public String criaAtvMonitoria(String cpf, String tipo, int unidadeAcumulada, String disciplina) {
		Estudante e = pegaEstudante(cpf);
		
		String codigo = e.gerarCodigo();
		AtividadeAbstrato atv = new AtvMonitoria(codigo, tipo, unidadeAcumulada, disciplina);
		e.adicionaAtividade(codigo, atv);
		return codigo;
	}
	
	/**
	 * Altera a descrição de uma atividade.
	 * @param cpf cpf do estudante
	 * @param codigoAtividade código da atividade a ser alterada
	 * @param descricao nova descrição.
	 * @return valor booleano indicando se foi possível alterar a descrição.
	 */
	public boolean alteraDescricao(String cpf, String codigoAtividade, String descricao) {
		
		Estudante e = pegaEstudante(cpf);
		
		if(!e.temAtv(codigoAtividade)) {
			return false;
		}
		
		e.setDescricao(codigoAtividade, descricao);
		return true;
	}
	
	/**
	 * Altera o link de comprovação da atividade.
	 * @param cpf cpf do estudante
	 * @param codigoAtividade código da atividade a ser alterada.
	 * @param linkComprovacao novo link de comprovação
	 * @return valor booleano indicando se foi possível alterar o link.
	 */
	public boolean alterarComprovacaoAtividade(String cpf, String codigoAtividade, String linkComprovacao) {

		Estudante e = pegaEstudante(cpf);
		
		if(!e.temAtv(codigoAtividade)) {
			return false;
		}
		
		e.setLink(codigoAtividade, linkComprovacao);
		return true;
	}
	
	/**
	 * Cria uma nova pesquisa de extensão e atribui a um estudante.
	 * @param cpf cpf do estudante.
	 * @param tipo tipo de atividade.
	 * @param unidadeAcumulada quantidade de meses que durou a atividade
	 * @param disciplina disciplina da pesquisa
	 * @return código de identificação da atividade.
	 */
	public String criarAtvPesquisaExtensao(String cpf,String tipo, int unidadeAcumulada, String disciplina) {

		Estudante e = pegaEstudante(cpf);
		
		String codigo = e.gerarCodigo();
		AtividadeAbstrato atv = new AtvPesquisaExtensao(codigo, tipo, unidadeAcumulada, disciplina);
		e.adicionaAtividade(codigo, atv);
		return codigo;
	}
	
	/**
	 * Cria uma nova atividade de estágio e atribui a um estudante.
	 * @param cpf cpf do estudante
	 * @param tipo tipo de atividade
	 * @param unidadeAcumulada quantidade de horas somadas da atividade
	 * @param disciplina disciplina do estágio
	 * @return código de identificação da atividade.
	 */
	public String criarAtvEstagio(String cpf, String tipo, int unidadeAcumulada, String disciplina) {

		Estudante e = pegaEstudante(cpf);
		
		String codigo = e.gerarCodigo();
		AtividadeAbstrato atv = new AtvEstagio(codigo, tipo, unidadeAcumulada, disciplina);
		e.adicionaAtividade(codigo, atv);
		return codigo;
	}
	
	/**
	 * Cria uma publicação e atribui a um estudante.
	 * @param cpf cpf do estudante.
	 * @param tipo tipo de atividade
	 * @param tituloArtigo título do artigo
	 * @param doi Digital Object Identifier
	 * @param qualis índice qualis de referência
	 * @return código identificador da atividade.
	 */
	public String criarAtvPublicacao(String cpf, String tipo, String tituloArtigo, String doi, String qualis) {

		Estudante e = pegaEstudante(cpf);
		
		String codigo = e.gerarCodigo();
		AtividadeAbstrato atv = new AtvPublicacao(codigo, tipo, tituloArtigo, doi, qualis);
		e.adicionaAtividade(codigo, atv);
		return codigo;
	}
	
	/**
	 * Informa a quantidade de créditos que determinada atividade oferece ou pode oferecer
	 * @param cpf cpf do estudante
	 * @param codigoAtividade código de identificação da atividade
	 * @return quantidade de créditos.
	 */
	public double creditosAtividade(String cpf, String codigoAtividade) {
	
		Estudante e = pegaEstudante(cpf);
		
		if(!e.temAtv(codigoAtividade)) {
			return -1;
		}
		
		return e.getAtividadeCreditos(codigoAtividade);
	}
	/**
	 * Indica se existe o estudante.
	 * @param cpf cpf do estudante
	 * @return valor booleano indicando se existe o estudante.
	 */
	public boolean temEstudante(String cpf) {
		return this.estudantes.containsKey(cpf);
	}
	/**
	 * Retorna o estudante com determinado cpf.
	 * @param cpf cpf do estudante
	 * @return objeto Estudante
	 */
	public Estudante pegaEstudante(String cpf) {
		return this.estudantes.get(cpf);
	}
	/**
	 * Cria um relatório detalhado.
	 * @param cpf cpf do estudante
	 * @return index do relatório.
	 */
	public int criarRelatorioCompleto(String cpf) {
		return this.estudantes.get(cpf).addRelatorioDetalhado();
	}
	
	/**
	 * Cria um relatório por tipo de atividade.
	 * @param cpf cpf do estudante
	 * @param tipoAtividade tipo de atividade
	 * @return index do relatório.
	 */
	public int criarRelatorioPorATV(String cpf, String tipoAtividade) {
		return this.estudantes.get(cpf).addRelatorioTipo(tipoAtividade);
	}
	
	/**
	 * Cria um relatório resumido.
	 * @param cpf cpf do estudante.
	 * @return index do relatório.
	 */
	public int criarRelatorioResumido(String cpf) {
		return this.estudantes.get(cpf).addRelatorioResumido();
	}
	/**
	 * Exibe relatório escolhido.
	 * @param cpf cpf do estudante
	 * @param index index do relatório
	 * @return representação textual do relatório
	 */
	public String exibirRelatorio(String cpf, int index) {
		return this.estudantes.get(cpf).exibeRelatorio(index);
	}
	
	private boolean temAdmin() {
		if(this.admin == null) {
			return false;
		}
		return true;
	}
	/**
	 * Valida o login do administrador. Se não houver administrador cadastrado, o acesso é automaticamente liberado.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 */
	public void validaAdmin(String cpf, int senha) {
		if(temAdmin()) {
			this.admin.ValidaUsuario(cpf, senha);
		}
	}
}
