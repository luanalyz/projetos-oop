package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Classe que inicia a lista de perguntas frequentes.
 * 
 * @author luanalyz
 */
public class ControleFAQ {

	private List<FAQ> faqs;
	/**
	 * Construtor que inicia a classe.
	 */
	public ControleFAQ() {
		this.faqs = new ArrayList<>();
	}
	
	/**
	 * Adiciona pergunta
	 * @param pergunta nova pergunta
	 * @return valor booleano indicando se foi possível adicioar a pergunta.
	 */
	public boolean addItemFAQ(String pergunta) {
		FAQ novaFaq = new FAQ(pergunta, "Sem resposta.");
		
		if(temPergunta(pergunta)) {
			return false;
		}
		
		faqs.add(novaFaq);
		return true;
	}
	
	/**
	 * Adiciona pergunta com a resposta
	 * @param pergunta nova pergunta
	 * @param resposta nova resposta
	 * @return valor booleano indicando se foi possível adicionar a pergunta.
	 */
	public boolean addItemFAQ(String pergunta, String resposta) {
		FAQ novaFaq = new FAQ(pergunta, resposta);
		
		if(temPergunta(pergunta)) {
			return false;
		}
		
		faqs.add(novaFaq);
		return true;
	}
	
	/**
	 * Altera a resposta de determinada pergunta.
	 * @param itemIndex index da pergunta
	 * @param novaResposta nova resposta
	 * @return valor booleano indicando se foi possível alterar a pergunta
	 */
	public boolean alterarResposta(int itemIndex, String novaResposta) {
		if(itemIndex > faqs.size() || itemIndex < 1) {
			return false;
		}
		faqs.get(itemIndex - 1).setResposta(novaResposta);
		return true;
	}
	
	/**
	 * Lista todas as perguntas por ordem de inserção.
	 * @return array de strings com as representações textuais de todas as perguntas.
	 */
	public String[] listaFAQ() {
		String[] lista = new String[faqs.size()];
		int cont = 0;
		for(FAQ f : faqs) {
			lista[cont] = f.toString();
			cont++;
		}
		return lista;
	}
	
	/**
	 * Lista todas as perguntas por ordem de destaque.
	 * @return array de strings com as representações textuais de todas as perguntas de forma ordenada.
	 */
	public String[] listarFAQdestaque() {
		ArrayList<FAQ> faqsNovo = new ArrayList<>();
		for(FAQ f : faqs) {
			faqsNovo.add(f);
		}
		
		Collections.sort(faqsNovo, new ComparadorFAQ());

		String[] lista = new String[faqsNovo.size()];
		int cont = 0;
		for(FAQ f : faqsNovo) {
			lista[cont] = f.toString();
			cont++;
		}
		
		return lista;
	}
	
	/**
	 * Destaca uma pergunta.
	 * @param itemIndex index da pergunta.
	 * @return valor booleano indicando se foi possível destacar a pergunta.
	 */
	public boolean destacar(int itemIndex) {
		if(itemIndex > faqs.size() || itemIndex < 1) {
			return false;
		}
		faqs.get(itemIndex - 1).destacar();
		return true;
	}
	
	/**
	 * Atribui um array de tags a uma pergunta.
	 * @param itemIndex index da pergunta
	 * @param tags array de strings com as tags
	 * @return valor booleano indicando se foi possível adicionar as tags.
	 */
	public boolean atribuiTag(int itemIndex, String[] tags) {
		if(itemIndex > faqs.size() || itemIndex < 1 || tags.length > 3) {
			return false;
		}
		
		String[] novasTags = new String[3];
		
		for(int i = 0; i < tags.length; i++) {
			novasTags[i] = tags[i];
		}
		
		FAQ faq = faqs.get(itemIndex - 1);
		
		faq.setTag(novasTags);
		return true;
	}
	
	/**
	 * Busca perguntas a partir de tags pré selecionadas.
	 * @param tags array de tags a serem buscadas
	 * @return array de strings com todas as perguntas encontradas.
	 */
	public String[] buscarFAQ(String[] tags) {
		ArrayList<String> achados = new ArrayList<>();
		for(String s : tags) {
			for(FAQ f : faqs) {
				if(f.temTag(s)) {
					if(!achados.contains(f.toString())) {
						achados.add(f.toString());
					}
				}
			}
		}
		
		String[] out = new String[achados.size()];
		int cont = 0;
		for(String s : achados) {
			out[cont] = s;
			cont++;
		}
		return out;
	}
	
	private boolean temPergunta(String pergunta) {
		for(FAQ f : faqs) {
			if(f.getPergunta().equals(pergunta)) {
				return true;
			}
		}
		return false;
	}
}
