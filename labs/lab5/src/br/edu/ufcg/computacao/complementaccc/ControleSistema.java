package br.edu.ufcg.computacao.complementaccc;
/**
 * Sistema que mantém os estudantes, as perguntas frequentes, as atividades extracurriculares e os relatórios.
 * 
 * @author luanalyz
 */
public class ControleSistema {

	private ValidaExcecoes v;

	private ControleUsuario ce;

	private ControleFAQ cf;
	/**
	 * Cria o sistema responsável por delegar responsabilidades para os controllers certos e validar entradas.
	 */
	public ControleSistema() {
		this.v = new ValidaExcecoes();
		this.ce = new ControleUsuario();
		this.cf = new ControleFAQ();
	}
	/**
	 * Cadastra um novo estudante.
	 * @param cpf cpf do novo estudante.
	 * @param nome nome do novo estudante.
	 * @param senha senha de acesso.
	 * @param matricula matricula do novo estudante.
	 * @return valor booleano informando se foi possível cadastrar o estudante.
	 */
	public boolean cadastrarEstudante(String cpf, String nome, int senha, String matricula) {
		v.validaEntrada(cpf);
		v.validaEntrada(nome);
		v.validaEntrada(matricula);
		v.validaSenhaTam(senha);
		
		return ce.cadastraEstudante(cpf, nome, senha, matricula);
	}
	/**
	 * Exibe os estudantes em ordem alfabética.
	 * @param cpf cpf do administrador.
	 * @param senha senha do administrador.
	 * @return array de strings com a representação textual de todos estudantes.
	 */
	public String[] exibeEstudantes(String cpf, int senha) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		ce.validaAdmin(cpf, senha);
		
		return ce.exibeEstudantes();
	}
	/**
	 * Edita determinado valor dos dados do estudante.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipoAlteracao o valor a ser alterado
	 * @param novoValor o novo valor
	 * @return valor booleano informando se foi possível fazer a troca.
	 */
	public boolean editarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		v.validaEntrada(cpf);
		v.validaEntrada(tipoAlteracao);
		v.validaEntrada(novoValor);
		v.validaSenhaTam(senha);
		
		if(tipoAlteracao.toLowerCase().equals("senha")) {
			v.validaSenhaTam(Integer.parseInt(novoValor));
		}
		
		return ce.editaEstudante(cpf, senha, tipoAlteracao, novoValor);
	}
	/**
	 * Exibe informações do administrador.
	 * @param cpf cpf do administrador
	 * @param senha senha do administrador
	 * @return representação textual do administrador.
	 */
	public String exibeAdmin(String cpf, int senha) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		ce.validaAdmin(cpf, senha);
		
		return ce.exibeADMIN();
	}
	/**
	 * Cadastra um novo administrador
	 * @param cpf cpf do adm atual
	 * @param senhaAtual senha do adm atual
	 * @param nomeNovo novo nome do adm
	 * @param cpfNovo cpf do novo adm
	 * @param senhaNova nova senha do novo adm
	 * @return valor booleano indicando se foi possível mudar de administrador ou não.
	 */
	public boolean novoAdmin(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senhaAtual);
		ce.validaAdmin(cpf, senhaAtual);
		v.validaEntrada(nomeNovo);
		v.validaEntrada(cpfNovo);
		v.validaSenhaTam(senhaNova);
		
		return ce.novoAdmin(nomeNovo, cpfNovo, senhaNova);
	}
	/**
	 * Muda a senha do administrador.
	 * @param cpf cpf do adm
	 * @param senhaAtual senha atual do adm
	 * @param senhaNova nova senha do adm
	 * @return valor booleano indicando se foi possível mudar a senha.
	 */
	public boolean mudarSenhaAdmin(String cpf, int senhaAtual, int senhaNova) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senhaAtual);
		v.validaSenhaTam(senhaNova);
		ce.validaAdmin(cpf, senhaAtual);
		
		return ce.mudarSenhaAdmin(senhaNova);
	}

	/**
	 * Adiciona pergunta ao FAQ.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param pergunta pergunta a ser adicionada
	 * @return valor booleano indicando se foi possível adicionar a pergunta.
	 */
	public boolean addItemFAQ(String cpf, int senha, String pergunta) {
		v.validaEntrada(cpf);
		v.validaEntrada(pergunta);
		v.validaSenhaTam(senha);
		ce.validaAdmin(cpf, senha);
		
		return cf.addItemFAQ(pergunta);
	}
	/**
	 * Adiciona pergunta ao FAQ, junto com a resposta.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param pergunta pergunta a ser adicionada
	 * @param resposta resposta da pergunta
	 * @return valor booleano indicando se foi possível adicionar a pergunta.
	 */
	public boolean addItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		v.validaEntrada(cpf);
		v.validaEntrada(pergunta);
		v.validaSenhaTam(senha);
		v.validaEntrada(resposta);
		ce.validaAdmin(cpf, senha);
	
		return cf.addItemFAQ(pergunta, resposta);
	}
	/**
	 * Altera resposta de uma pergunta que já existe.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param itemIndex index da pergunta
	 * @param novaResposta nova resposta
	 * @return valor booleano indicando se foi possível alterar a resposta.
	 */
	public boolean alteraResposta(String cpf, int senha, int itemIndex, String novaResposta) {
		v.validaEntrada(cpf);
		v.validaEntrada(novaResposta);
		v.validaSenhaTam(senha);
		ce.validaAdmin(cpf, senha);
		
		return cf.alterarResposta(itemIndex, novaResposta);
	}
	/**
	 * Retorna todas as perguntas no FAQ.
	 * @return array de strings com a representação textual de todas perguntas
	 */
	public String[] listaFAQ() {
		return cf.listaFAQ();
	}
	/**
	 * Retorna todas as perguntas no FAQ ordenadas por destaque.
	 * @return array de strings com a representação textual de todas perguntas ordenadas.
	 */
	public String[] listaFAQDestaque() {
		return cf.listarFAQdestaque();
	}
	/**
	 * Destaca uma pergunta
	 * @param index index da pergunta
	 * @return valor booleano indicando se foi possível destacar a pergunta.
	 */
	public boolean destacaItem(int index) {
		return cf.destacar(index);
	}
	/**
	 * Atribui tags à pergunta.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param itemIndex index da pergunta
	 * @param tags tags a serem adicionadas
	 * @return valor booleano indicando se foi possível adicionar as tags.
	 */
	public boolean atribuirTags(String cpf, int senha, int itemIndex, String[] tags) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		if (tags == null) {
			throw new NullPointerException("Entrada nula!");
		}
		ce.validaAdmin(cpf, senha);
		
		return cf.atribuiTag(itemIndex, tags);
	}
	/**
	 * Busca perguntas a partir de tags pré selecionadas.
	 * @param tags tags a serem buscadas
	 * @return array de strings com todas as perguntas que obedecem ao pré requisito.
	 */
	public String[] buscarItem(String[] tags) {
		if (tags == null) {
			throw new NullPointerException("Entrada nula!");
		}
		
		return cf.buscarFAQ(tags);
	}
	
	/**
	 * Cria uma nova atividade de monitoria e atribui a um estudante.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipo tipo de atividade
	 * @param unidadeAcumulada quantidade de semestres que durou a atividade
	 * @param disciplina disciplina da monitoria
	 * @return código de identificação da atividade.
	 */
	public String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		v.validaEntrada(tipo);
		v.validaEntrada(disciplina);
		v.validaUnidade(unidadeAcumulada);
		if(!ce.temEstudante(cpf)) {
			return "Estudante não existe!";
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.criaAtvMonitoria(cpf, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * Altera a descrição de uma atividade.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade código da atividade a ser alterada
	 * @param descricao nova descrição.
	 * @return valor booleano indicando se foi possível alterar a descrição.
	 */
	public boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		v.validaEntrada(cpf);
		v.validaEntrada(codigoAtividade);
		v.validaEntrada(descricao);
		v.validaSenhaTam(senha);
		if(!ce.temEstudante(cpf)) {
			return false;
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.alteraDescricao(cpf, codigoAtividade, descricao);
	}

	/**
	 * Altera o link de comprovação da atividade.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade código da atividade a ser alterada.
	 * @param linkComprovacao novo link de comprovação
	 * @return valor booleano indicando se foi possível alterar o link.
	 */
	public boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		v.validaEntrada(cpf);
		v.validaEntrada(codigoAtividade);
		v.validaEntrada(linkComprovacao);
		v.validaSenhaTam(senha);
		if(!ce.temEstudante(cpf)) {
			return false;
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.alterarComprovacaoAtividade(cpf, codigoAtividade, linkComprovacao);
	}
	
	/**
	 * Cria uma nova pesquisa de extensão e atribui a um estudante.
	 * @param cpf cpf do estudante.
	 * @param senha senha do estudante.
	 * @param tipo tipo de atividade.
	 * @param unidadeAcumulada quantidade de meses que durou a atividade
	 * @param disciplina disciplina da pesquisa
	 * @return código de identificação da atividade.
	 */
	public String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		v.validaEntrada(tipo);
		v.validaEntrada(disciplina);
		v.validaUnidade(unidadeAcumulada);
		if(!ce.temEstudante(cpf)) {
			return "Estudante não existe!";
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.criarAtvPesquisaExtensao(cpf, tipo, unidadeAcumulada, disciplina);
	}

	/**
	 * Cria uma nova atividade de estágio e atribui a um estudante.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipo tipo de atividade
	 * @param unidadeAcumulada quantidade de horas somadas da atividade
	 * @param disciplina disciplina do estágio
	 * @return código de identificação da atividade.
	 */
	public String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		v.validaEntrada(tipo);
		v.validaEntrada(disciplina);
		v.validaUnidade(unidadeAcumulada);
		if(!ce.temEstudante(cpf)) {
			return "Estudante não existe!";
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.criarAtvEstagio(cpf, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * Cria uma publicação e atribui a um estudante.
	 * @param cpf cpf do estudante.
	 * @param senha senha do estudante
	 * @param tipo tipo de atividade
	 * @param tituloArtigo título do artigo
	 * @param doi Digital Object Identifier
	 * @param qualis índice qualis de referência
	 * @return código identificador da atividade.
	 */
	public String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		v.validaEntrada(cpf);
		v.validaEntrada(tipo);
		v.validaEntrada(tituloArtigo);
		v.validaEntrada(doi);
		v.validaEntrada(qualis);
		v.validaSenhaTam(senha);
		if(!qualis.toLowerCase().equals("a1") && !qualis.toLowerCase().equals("a2") && !qualis.toLowerCase().equals("a3") && !qualis.toLowerCase().equals("a4") && !qualis.toLowerCase().equals("b1")) {
			throw new IllegalArgumentException("Qualis inválido!");
		}
		if(!ce.temEstudante(cpf)) {
			return "Estudante não existe!";
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.criarAtvPublicacao(cpf, tipo, tituloArtigo, doi, qualis);
	}
	
	/**
	 * Informa a quantidade de créditos que determinada atividade oferece ou pode oferecer
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade código de identificação da atividade
	 * @return quantidade de créditos.
	 */
	public double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		v.validaEntrada(codigoAtividade);
		if(!ce.temEstudante(cpf)) {
			return -1;
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.creditosAtividade(cpf, codigoAtividade);
	}

	/**
	 * Adiciona um relatório completo das atividades de determinado estudante.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @return index do relatório.
	 */
	public int criarRelatorioCompleto(String cpf, int senha) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		
		if(!ce.temEstudante(cpf)) {
			return 0;
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.criarRelatorioCompleto(cpf);
	}
	
	/**
	 * Adiciona um relatório resumido
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @return index do relatorio
	 */
	public int criarRelatorioResumido(String cpf, int senha) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		
		if(!ce.temEstudante(cpf)) {
			return 0;
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.criarRelatorioResumido(cpf);
	}
	
	
	/**
	 * Cria um relatório por tipo.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipoAtividade tipo de atividade
	 * @return index do relatório
	 */
	public int criarRelatorioPorATV(String cpf, int senha, String tipoAtividade) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		v.validaEntrada(tipoAtividade);
		
		if(!ce.temEstudante(cpf)) {
			return 0;
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.criarRelatorioPorATV(cpf, tipoAtividade);
	}
	
	/**
	 * Exibe relatório escolhido.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param indexRelatorio index do relatório
	 * @return representação textual do relatório
	 */
	public String exibirRelatorio(String cpf, int senha, int indexRelatorio) {
		v.validaEntrada(cpf);
		v.validaSenhaTam(senha);
		
		if(!ce.temEstudante(cpf)) {
			return "Estudante não existe!";
		}
		
		Estudante e = ce.pegaEstudante(cpf);
		e.ValidaUsuario(cpf, senha);
		
		return ce.exibirRelatorio(cpf, indexRelatorio);
	}

}
