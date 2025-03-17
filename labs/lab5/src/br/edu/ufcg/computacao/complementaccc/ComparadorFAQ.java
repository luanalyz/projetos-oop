package br.edu.ufcg.computacao.complementaccc;

import java.util.Comparator;
/**
 * Classe responsável por ordenar por número de destaques a lista de FAQ.
 */
public class ComparadorFAQ implements Comparator<FAQ> {

	@Override
	public int compare(FAQ o1, FAQ o2) {
		if(o1.getDestaques() > o2.getDestaques()) {
			return -1;
		} else if(o1.getDestaques() < o2.getDestaques()) {
			return 1;
		} else {
			return 0;
		}
	}

}
