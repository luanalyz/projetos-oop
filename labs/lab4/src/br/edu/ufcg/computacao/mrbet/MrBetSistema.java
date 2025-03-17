package br.edu.ufcg.computacao.mrbet;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Sistema que mantém os times, campeonatos e apostas.
 * 
 * @author Luana Lyz
 */
public class MrBetSistema {
	
	private HashMap<String, Time> mapaTimes; // representação dos times cadastrados.
	
	private HashMap<String, Campeonato> mapaCampeonatos; // representação dos campeonatos cadastrados.
	
	private ArrayList<Aposta> listaApostas; // representação das apostas cadastradas.
	
	/**
	 * Cria o MrBetSistema.
	 */
	public MrBetSistema() {
		this.mapaTimes = new HashMap<>();
		this.mapaCampeonatos = new HashMap<>();
		this.listaApostas = new ArrayList<>();
	}
	/**
	 * Cadastra um novo time.
	 * @param codigo código de identificação do time.
	 * @param nome nome do time.
	 * @param mascote mascote do time.
	 * @return representação textual da ação.
	 */
	public String adicionaTime(String codigo, String nome, String mascote) {
		validaEntrada(codigo);
		validaEntrada(nome);
		validaEntrada(mascote);
		
		if(verificaTime(codigo)) {
			return "TIME JÁ EXISTE!";
		}
		Time novoTime = new Time(codigo, nome, mascote);
		this.mapaTimes.put(codigo, novoTime);
		return "INCLUSÃO REALIZADA!";
	}
	/**
	 * Retorna informações do time escolhido.
	 * @param codigo código de identificação do time.
	 * @return representação textual da ação.
	 */
	public String recuperaTimes(String codigo) {
		validaEntrada(codigo);
		
		if(!verificaTime(codigo)) {
			return "TIME NÃO EXISTE!";
		}
		return this.mapaTimes.get(codigo).toString();
	}
	/**
	 * Verifica se o time existe
	 * @param codigo código de identificação do time.
	 * @return boolean informando se existe ou não.
	 */
	private boolean verificaTime(String codigo) {
		validaEntrada(codigo);
		
		return this.mapaTimes.containsKey(codigo);
	}
	/**
	 * Cadastra um novo campeonato
	 * @param nomeCampeonato nome do campeonato a ser cadastrado.
	 * @param numParticipantes número de participantes do campeonato.
	 * @return representação textual da ação.
	 */
	public String adicionaCampeonato(String nomeCampeonato, int numParticipantes) {
		validaEntrada(nomeCampeonato);
		if (numParticipantes < 0) {
	            throw new IndexOutOfBoundsException("NÚMERO DE PARTICIPANTES INVÁLIDO!");
	    }
		
		String chaveCampeonato = nomeCampeonato.toLowerCase();
		if(verificaCampeonato(chaveCampeonato)) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		Campeonato novoCampeonato = new Campeonato(nomeCampeonato, numParticipantes);
		this.mapaCampeonatos.put(chaveCampeonato, novoCampeonato);
		return "CAMPEONATO ADICIONADO!";
	}
	/**
	 * Verifica se o campeonato existe.
	 * @param nomeCampeonato nome do campeonato.
	 * @return boolean informando se existe ou não.
	 */
	private boolean verificaCampeonato(String nomeCampeonato) {
		validaEntrada(nomeCampeonato);
		
		return this.mapaCampeonatos.containsKey(nomeCampeonato);
    }
	/**
	 * Inclui time no campeonato.
	 * @param codigo código de identificação do time.
	 * @param nomeCampeonato nome do campeonato.
	 * @return representação textual da ação.
	 */
	public String incluiTime(String codigo, String nomeCampeonato) {
		validaEntrada(codigo);
		validaEntrada(nomeCampeonato);
		
		String chaveCampeonato = nomeCampeonato.toLowerCase();
		if(!verificaTime(codigo)) {
			return "TIME NÃO EXISTE!";
		} else if (!verificaCampeonato(chaveCampeonato)) {
			return "CAMPEONATO NÃO EXISTE!";
		}
		
		Time time = this.mapaTimes.get(codigo);
		
		Campeonato campeonato1 = this.mapaCampeonatos.get(chaveCampeonato);
		
		if (time.existeCampeonato(nomeCampeonato)) {
			return "TIME INCLUÍDO NO CAMPEONATO!";
		} else if (!campeonato1.verificaVagas()) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}
		
		time.adicionaParticipacao(campeonato1);
		return "TIME INCLUÍDO NO CAMPEONATO!";
	}
	/**
	 * Verifica se o time está no campeonato.
	 * @param codigo código de identificação do time.
	 * @param nomeCampeonato nome do campeonato.
	 * @return representação textual da ação.
	 */
	public String verificaCampeonatoTime(String codigo, String nomeCampeonato) {
		validaEntrada(codigo);
		validaEntrada(nomeCampeonato);
		
		String chaveCampeonato = nomeCampeonato.toLowerCase();
		if (!verificaTime(codigo)) {
			return "O TIME NÃO EXISTE!";
		} else if (!verificaCampeonato(chaveCampeonato)) {
			return "O CAMPEONATO NÃO EXISTE!";
		}
		
		Time time = this.mapaTimes.get(codigo);
		if (time.existeCampeonato(nomeCampeonato)) {
			return "O TIME ESTÁ NO CAMPEONATO!";
		}
		return "O TIME NÃO ESTÁ NO CAMPEONATO!";
	}
	/**
	 * Retorna todos os campeonatos que o time participa.
	 * @param codigo código de identificação do time.
	 * @return representação textual da ação.
	 */
	public String exibeCampeonatosTime(String codigo) {
		validaEntrada(codigo);
		
		if (!verificaTime(codigo)) {
			return "TIME NÃO CADASTRADO NO SISTEMA!";
		}
		Time timeExibido = this.mapaTimes.get(codigo);
		return "\n" +
				timeExibido.getNome() + 
				":" +
				timeExibido.retornaCampeonatos();
	}
	/**
	 * Cadastra uma nova aposta do time no campeonato.
	 * @param codigo código de identificação do time.
	 * @param nomeCampeonato nome do campeonato.
	 * @param colocacao colocação no campeonato.
	 * @param valor valor da aposta.
	 * @return representação textual da ação.
	 */
	public String cadastraAposta(String codigo, String nomeCampeonato, int colocacao, double valor) {
		validaEntrada(codigo);
		validaEntrada(nomeCampeonato);
		if (colocacao < 0) {
	            throw new IndexOutOfBoundsException("COLOCAÇÃO INVÁLIDA!");
		}
		if (valor < 0) {
	            throw new IndexOutOfBoundsException("VALOR INVÁLIDO!");
		}
		
	    String chaveCampeonato = nomeCampeonato.toLowerCase();
		if(!verificaTime(codigo)) {
			return "TIME NÃO CADASTRADO NO SISTEMA!";
		} else if (!verificaCampeonato(chaveCampeonato)) {
			return "CAMPEONATO NÃO CADASTRADO NO SISTEMA!";
		}
		
		Campeonato novoCampeonato = this.mapaCampeonatos.get(chaveCampeonato);
		
		if (colocacao > novoCampeonato.getInicialParticipantes()) {
			return "APOSTA NÃO REGISTRADA!";
		}
		
		Aposta novaAposta = new Aposta(mapaTimes.get(codigo), novoCampeonato, colocacao, valor);
		listaApostas.add(novaAposta);
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Retorna em ordem todas as apostas.
	 * @return representação textual da ação.
	 */
	public String statusApostas() {
		String output = "Apostas:\n\n";
		int cont = 1;
		for (Aposta a : listaApostas) {
			output += cont + a.toString();
			cont++;
		}
		return output;
	}
	/**
	 * Exibe o histórico de participações.
	 * @return representação textual da ação.
	 */
	public String exibirHistorico() {
		String output = "Participação mais frequente em campeonatos\n" +
						participacaoMaisFrequente() +
						"\n\nAinda não participou do campeonato\n" +
						naoParticipou();
		return output;
	}
	/**
	 * Retorna a participação mais frequente.
	 * @return representação textual da ação.
	 */
	private String participacaoMaisFrequente() {
		String maior = "";
		int maiorNumParticipacao = 0;
		for(Time t : this.mapaTimes.values()) {
			if(t.tamanhoParticipacoes() > maiorNumParticipacao) {
				maior = t.toString() + " " + t.tamanhoParticipacoes();
			} else if (t.tamanhoParticipacoes() == maiorNumParticipacao && maiorNumParticipacao != 0) {
				maior += "\n" + t.toString() + " " + t.tamanhoParticipacoes();;
			}
		}
		return maior;
	}
	/**
	 * Retorna os times que não participaram de nenhum campeonato.
	 * @return representação textual da ação.
	 */
	private String naoParticipou() {
		String output = "";
		for(Time t : this.mapaTimes.values()) {
			if(t.tamanhoParticipacoes() == 0 && output.equals("")) {
				output = t.toString();
			} else if (t.tamanhoParticipacoes() == 0) {
				output+= "\n" + t.toString();
			}
		}
		return output;
	}
	/**
	 * Verifica se a entrada é vazia ou nula.
	 * @param entrada parâmetro informado no método.
	 */
	private void validaEntrada(String entrada) {
		if (entrada == null) {
			throw new NullPointerException("ENTRADA NULA!");
		}
		
		if(entrada.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
	}
	
}