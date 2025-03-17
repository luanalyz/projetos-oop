package br.edu.ufcg.computacao.p2lp2.coisa;

public class Aluno {
	private String nome;
	private int anoNascimento;
	private double cra;

	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.cra = 0.0;
		this.anoNascimento = anoNascimento;
}

	public void setCra(double cra) {
		this.cra = cra;
}

	public int getIdade() {
		return 2021 - anoNascimento;
}

public String toString() {
	return "Aluno - "  + this.nome;
}

}

public class ControleAcademico {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("JOAO", 1990);
		Aluno a2 = new Aluno("MARIA", 2000);
		System.out.println(a1);
		System.out.println(a2);
}
}