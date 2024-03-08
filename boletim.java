
package projeto_integrador;
import java.util.ArrayList;
public class boletim {

	
	//atributos do boletim
	private String 			 nomeUC;
	private String 			   prof;
	private String 			  turma;
	private ArrayList<aluno> alunos;
 


	//construtor
	public boletim(
			String nomeUC,
			String prof,
			String turma,
			ArrayList<aluno> alunos) {
		this.nomeUC = nomeUC;
		this.prof = prof;
		this.turma = turma;
		this.alunos = alunos;
	}


	//métodos getters and setters
	public String getNomeUC() {
		return nomeUC;
	}



	public void setNomeUC(String nomeUC) {
		this.nomeUC = nomeUC;
	}



	public String getProf() {
		return prof;
	}



	public void setProf(String prof) {
		this.prof = prof;
	}



	public String getTurma() {
		return turma;
	}



	public void setTurma(String turma) {
		this.turma = turma;
	}



	public ArrayList<aluno> getAlunos() {
		return alunos;
	}



	public void setAlunos(ArrayList<aluno> alunos) {
		this.alunos = alunos;
	}

	




}
