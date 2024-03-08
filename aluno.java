
package projeto_integrador;
import java.util.Scanner;
 
public class aluno {

	private String  nome;
	private int   faltas;
	private int [] notas;
	private double mediaaluno;
	private String situacao;
	
	
	//construtor
	public aluno(
		    String  nome,
			int   faltas,
			int [] notas,
			double mediaaluno,
			String situacao) {
		 
		this.nome =      nome;
		this.faltas =  faltas;
		this.notas =    notas;
		this.mediaaluno = mediaaluno;
		this.situacao =		situacao;
	}
	
	//métodos getter and setters	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getFaltas() {
		return faltas;
	}


	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}


	public int[] getNotas() {
		return notas;
	}


	public void setNotas(int[] notas) {
		this.notas = notas;
	}


	public double getMediaaluno() {
		return mediaaluno;
	}


	public void setMediaaluno(double mediaaluno) {
		this.mediaaluno = mediaaluno;	
	}
	
	public String getSituacao() {
		return situacao;
	}
	

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	} 

	
	
	
	
}

		