package br.edu.ufcg.computacao.complementaccc;
/**
 * Facade do projeto.
 */
public class ComplementaCCCFacade {
	
	private ControleSistema c;
	/**
	 * Construtor do facade.
	 */
	public ComplementaCCCFacade() {
		this.c = new ControleSistema();
	}

	/**
	 * Cadastra um novo estudante.
	 * @param cpf cpf do novo estudante.
	 * @param nome nome do novo estudante.
	 * @param senha senha de acesso.
	 * @param matricula matricula do novo estudante.
	 * @return valor booleano informando se foi possível cadastrar o estudante.
	 */
	boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		return c.cadastrarEstudante(cpf, nome, senha, matricula);
	}
	
	/**
	 * Exibe os estudantes em ordem alfabética.
	 * @param cpf cpf do administrador.
	 * @param senha senha do administrador.
	 * @return array de strings com a representação textual de todos estudantes.
	 */
	String[] exibirEstudantes(String cpf, int senha){
		//ADMIN
		return c.exibeEstudantes(cpf, senha);
	}
	
	/**
	 * Edita determinado valor dos dados do estudante.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipoAlteracao o valor a ser alterado
	 * @param novoValor o novo valor
	 * @return valor booleano informando se foi possível fazer a troca.
	 */
	boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		return c.editarEstudante(cpf, senha, tipoAlteracao, novoValor);
	}
	
	/**
	 * Exibe informações do administrador.
	 * @param cpf cpf do administrador
	 * @param senha senha do administrador
	 * @return representação textual do administrador.
	 */
	String exibirAdmin(String cpf, int senha){
		return c.exibeAdmin(cpf, senha);
		//ADMIN
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
	boolean configurarNovoADMIN(String cpf, int senhaAtual, String cpfNovo, int senhaNova){
		return c.novoAdmin(cpfNovo, senhaAtual, cpf, cpfNovo, senhaNova);
		//ADMIN
	}
	
	/**
	 * Muda a senha do administrador.
	 * @param cpf cpf do adm
	 * @param senhaAtual senha atual do adm
	 * @param senhaNova nova senha do adm
	 * @return valor booleano indicando se foi possível mudar a senha.
	 */
	boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		return c.mudarSenhaAdmin(cpf, senhaAtual, senhaNova);
		//ADMIN
	}
	
	/**
	 * Adiciona pergunta ao FAQ.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param pergunta pergunta a ser adicionada
	 * @return valor booleano indicando se foi possível adicionar a pergunta.
	 */
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		return c.addItemFAQ(cpf, senha, pergunta);
		//ADMIN
	}
	
	/**
	 * Adiciona pergunta ao FAQ, junto com a resposta.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param pergunta pergunta a ser adicionada
	 * @param resposta resposta da pergunta
	 * @return valor booleano indicando se foi possível adicionar a pergunta.
	 */
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		return c.addItemFAQ(cpf, senha, pergunta, resposta);
		//ADMIN
	}
	
	/**
	 * Altera resposta de uma pergunta que já existe.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param itemIndex index da pergunta
	 * @param novaResposta nova resposta
	 * @return valor booleano indicando se foi possível alterar a resposta.
	 */
	boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		return c.alteraResposta(cpf, senha, itemIndex, resposta);
		//ADMIN
	}
	
	/**
	 * Retorna todas as perguntas no FAQ.
	 * @return array de strings com a representação textual de todas perguntas
	 */
	String[] listarFAQ() {
		return c.listaFAQ();
	}
	
	/**
	 * Retorna todas as perguntas no FAQ ordenadas por destaque.
	 * @return array de strings com a representação textual de todas perguntas ordenadas.
	 */
	String[] listarFAQPorDestaque() {
		return c.listaFAQDestaque();
	}
	
	/**
	 * Destaca uma pergunta
	 * @param index index da pergunta
	 * @return valor booleano indicando se foi possível destacar a pergunta.
	 */
	boolean destacarItem(int itemIndex) {
		return c.destacaItem(itemIndex);
	}
	/**
	 * Atribui tags à pergunta.
	 * @param cpf cpf do adm
	 * @param senha senha do adm
	 * @param itemIndex index da pergunta
	 * @param tags tags a serem adicionadas
	 * @return valor booleano indicando se foi possível adicionar as tags.
	 */
	boolean atribuirTagsItemFAQ(String cpf, int senha,int itemIndex, String[] tags) {
		return c.atribuirTags(cpf, senha, itemIndex, tags);
		//ADMIN
	}
	
	/**
	 * Busca perguntas a partir de tags pré selecionadas.
	 * @param tags tags a serem buscadas
	 * @return array de strings com todas as perguntas que obedecem ao pré requisito.
	 */
	String[] buscarItemFAQ(String[] tags) {
		return c.buscarItem(tags);
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
	String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return c.criarAtividadeMonitoriaEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * Altera a descrição de uma atividade.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade código da atividade a ser alterada
	 * @param descricao nova descrição.
	 * @return valor booleano indicando se foi possível alterar a descrição.
	 */
	boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		return c.alterarDescricaoAtividade(cpf, senha, codigoAtividade, descricao);
	}
	
	/**
	 * Altera o link de comprovação da atividade.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade código da atividade a ser alterada.
	 * @param linkComprovacao novo link de comprovação
	 * @return valor booleano indicando se foi possível alterar o link.
	 */
	boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		return c.alterarComprovacaoAtividade(cpf, senha, codigoAtividade, linkComprovacao);
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
	String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return c.criarAtividadePesquisaExtensaoEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina);
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
	String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return c.criarAtividadeEstagioEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina);
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
	String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		return c.criarAtividadePublicacaoEmEstudante(cpf, senha, tipo, tituloArtigo, doi, qualis);
	}
	
	/**
	 * Informa a quantidade de créditos que determinada atividade oferece ou pode oferecer
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param codigoAtividade código de identificação da atividade
	 * @return quantidade de créditos.
	 */
	double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		return c.creditosAtividade(cpf, senha, codigoAtividade);
	}

	/**
	 * Adiciona um relatório completo das atividades de determinado estudante.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @return index do relatório.
	 */
	int criarRelatorioCompleto(String cpf, String senha) {
		return c.criarRelatorioCompleto(cpf, Integer.parseInt(senha));
	}
	
	/**
	 * Adiciona um relatório resumido
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @return index do relatorio
	 */
	int criarRelatorioResumido(String cpf, String senha) {
		return c.criarRelatorioResumido(cpf, Integer.parseInt(senha));
	}
	
	/**
	 * Cria um relatório por tipo.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param tipoAtividade tipo de atividade
	 * @return index do relatório
	 */
	int criarRelatorioPorATV(String cpf, String senha, String tipoAtividade) {
		return c.criarRelatorioPorATV(cpf, Integer.parseInt(senha), tipoAtividade);
	}
	
	/**
	 * Exibe relatório escolhido.
	 * @param cpf cpf do estudante
	 * @param senha senha do estudante
	 * @param indexRelatorio index do relatório
	 * @return representação textual do relatório
	 */
	String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
		return c.exibirRelatorio(cpf, Integer.parseInt(senha), indexRelatorio);
	}

}
