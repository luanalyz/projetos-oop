package br.edu.ufcg.computacao.mrbet;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema MrBetSistema.
 * 
 * @author Luana Lyz
 *
 */
public class Main {

	public static void main(String[] args) {
		MrBetSistema mr = new MrBetSistema();
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, mr, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	
	private static String menu(Scanner scanner) {
		System.out.print("\n(M)Minha inclusão de times\n" + 
						"(R)Recuperar time\n" + 
						"(.)Adicionar campeonato\n" + 
						"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" + 
						"(E)Exibir campeonatos que o time participa\n" + 
						"(T)Tentar a sorte e status\n" +
						"(H) Histórico\n" +
						"(!)Já pode fechar o programa!\n" +
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param mr  O sistema MrBetSistema que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, MrBetSistema mr, Scanner scanner) {
		switch (opcao) {
		case "M":
			adicionaTime(mr, scanner);
			break;
		case "R":
			recuperaTime(mr, scanner);
			break;
		case ".":
			adicionaCampeonato(mr, scanner);
			break;
		case "B":
			incluirTime(mr, scanner);
			break;
		case "E":
			exibirCampeonatos(mr, scanner);
			break;
		case "T":
			tentarSorteStatus(mr, scanner);
			break;
		case "H":
			historico(mr);
			break;
		case "!":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * Cadastra um time.
	 * @param mr  Sistema MrBetSistema a ser manipulado.
	 * @param scanner Scanner para captura das informações do time.
	 */
	private static void adicionaTime(MrBetSistema mr, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.nextLine();
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Mascote: ");
		String mascote = scanner.nextLine();
		
		System.out.println(mr.adicionaTime(codigo, nome, mascote));
	}
	
	/**
	 * Retorna as informações do time escolhido.
	 * @param mr  Sistema MrBetSistema a ser manipulado.
	 * @param scanner Scanner para captura do código do time escolhido.
	 */
	private static void recuperaTime(MrBetSistema mr, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.nextLine();
		
		System.out.println(mr.recuperaTimes(codigo));
	}
	
	/**
	 * Cadastra um campeonato
	 * @param mr Sistema MrBetSistema a ser manipulado.
	 * @param scanner Scanner para a captura das informações do campeonato.
	 */
	private static void adicionaCampeonato(MrBetSistema mr, Scanner scanner) {
		System.out.print("\nCampeonato: ");
		String campeonato = scanner.nextLine();
		
		System.out.print("Participantes: ");
		String participantes = scanner.nextLine();
		
		System.out.println(mr.adicionaCampeonato(campeonato, Integer.parseInt(participantes)));
	}
	
	/**
	 * Inclui campeonato ao time ou verifica se o time está no campeonato.
	 * @param mr Sistema MrBetSistema a ser manipulado.
	 * @param scanner Scanner para a captura das informações do campeonato e time.
	 */
	private static void incluirTime(MrBetSistema mr, Scanner scanner) {
		System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		String opcao = scanner.nextLine().toLowerCase();
		
		if(opcao.equals("i")) {
			System.out.print("\nCódigo: ");
			String codigo = scanner.nextLine();
			
			System.out.print("Campeonato: ");
			String campeonato = scanner.nextLine();
			
			System.out.println(mr.incluiTime(codigo, campeonato));
		} else if (opcao.equals("v")) {
			System.out.print("\nCódigo: ");
			String codigo = scanner.nextLine();
			
			System.out.print("\nCampeonato: ");
			String campeonato = scanner.nextLine();
			
			System.out.println(mr.verificaCampeonatoTime(codigo, campeonato));
		}
	}
	/**
	 * Exibe os campeonatos do time.
	 * @param mr Sistema MrBetSistema a ser manipulado.
	 * @param scanner Scanner para a captura das informações do time.
	 */
	private static void exibirCampeonatos(MrBetSistema mr, Scanner scanner) {
		System.out.print("\nTime: ");
		String time = scanner.nextLine();
		
		System.out.println(mr.exibeCampeonatosTime(time));
	}
	/**
	 * Registra aposta no time em relação ao campeonato ou retorna todas as apostas.
	 * @param mr Sistema MrBetSistema a ser manipulado.
	 * @param scanner Scanner para a captura das informações do time.
	 */
	private static void tentarSorteStatus(MrBetSistema mr, Scanner scanner) {
		System.out.print("(A)Apostar ou (S)Status das Apostas? ");
		String opcao = scanner.nextLine().toLowerCase();
		
		if(opcao.equals("a")) {
			System.out.println("\nCódigo: ");
			String codigo = scanner.nextLine();
			
			System.out.print("\nCampeonato: ");
			String campeonato = scanner.nextLine().toLowerCase();
			
			System.out.print("\nColocação: ");
			String colocacao = scanner.nextLine();
			
			System.out.print("\nValor da aposta: ");
			String valor = scanner.nextLine();
			
			System.out.println(mr.cadastraAposta(codigo, campeonato, Integer.parseInt(colocacao), Double.valueOf(valor)));
			
		} else if(opcao.equals("s")) {
			System.out.println(mr.statusApostas());
		}
	}
	/**
	 * Exibe o histórico.
	 * @param mr Sistema MrBetSistema a ser manipulado.
	 */
	private static void historico(MrBetSistema mr) {
		System.out.println(mr.exibirHistorico());
	}
	/**
	 * Encerra o programa.
	 */
	private static void sai() {
		System.out.println("Por hoje é só pessoal!");
		System.exit(0);
	}
	
}