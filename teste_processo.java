
package projeto_integrador;
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class teste_processo {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scn = new Scanner(System.in);
		ArrayList<aluno> alunos = new ArrayList<>();
		
		System.out.println("Hora de criar um Boletim Geral!");
		System.out.println("///////////////////////////////");
		
		System.out.println("Insira o nome da Grade curricular(FPOO,LIMA,HARE ou SOP): ");
		String nomeUC = utilidades.validarUnidadecurricular(scn);
  
		System.out.println("Professor(es) responsável por lecionar a grade curricular de "+nomeUC+" : ");
		String prof   = utilidades.inserirnomedeProfessor(nomeUC);
		System.out.println(prof);
 
		System.out.println("\nInsira o nome da turma a ser avaliada: ");
		String turma = scn.next();
		System.out.println("");
		
		boletim boletim = new boletim(nomeUC,prof,turma, alunos);

		for (int a = 0; a < 1; a++) {
			aluno aluno = novoaluno();
			alunos.add(aluno);
		}
		
		// exibe o boletim e as informações de cada aluno
		//////////// 
		exibirBoletim(boletim);
		////////////
		
		// informações adicionais sobre a turma de modo geral logo abaixo
		
		
		// aqui será computado o aluno com maior media,aluno com menor média e o melhor aluno
		aluno maiorMedia = Collections.max(alunos, Comparator.comparingDouble(aluno::getMediaaluno));
		aluno menorMedia = Collections.min(alunos, Comparator.comparingDouble(aluno::getMediaaluno));
		ArrayList<aluno> aprovados = new ArrayList<>();

		for(aluno aluno : alunos) {
			if(aluno.getSituacao() == "Aprovado(a)") {
				aprovados.add(aluno);
			}
		}
		aluno melhorAluno = Collections.max(aprovados, Comparator.comparingDouble(aluno::getMediaaluno));
		
		// media geral da turma será calculado aqui
		double mediageral = calcularMediageral(alunos);
		
		//aqui a média será formatada e exibida para o usuario
		String iamformat = "%.1f";
		String mediaformat = String.format(iamformat, mediageral);
	    System.out.println("\nMédia Geral da Turma: " + mediaformat);
	    
	    // irá exibir quais os alunos que ficaram acima ou abaixo da média geral
	    mediaalunoacimaeabaixoMediageral(alunos, mediageral);   
		 
		System.out.println("\nAluno com a maior média final: " + maiorMedia.getNome());
		System.out.println("Aluno com a pior média final: " + menorMedia.getNome());
		System.out.println("\nMelhor aluno: " + melhorAluno.getNome() + " | " + "Média: " + melhorAluno.getMediaaluno());
		
		// saída final aqui 
		System.out.println("\nDeseja salvar o Boletim geral em formato de arquivo txt?");
		Salvarboletim(boletim,scn);
		
		
 } // public static void main termina aqui


	private static  aluno novoaluno() {
        Scanner scn = new Scanner(System.in);
        
        String nome;
        int	 faltas;
        int[] notas = new int[4];
        double mediaaluno;
        String 	 situacao;
        
        System.out.println("Insira o nome do aluno: ");
        nome = utilidades.validarnome(scn);

        // pede ao usuario para inserir o Numero de faltas do aluno
        faltas = utilidades.validarfalta(scn);
       
        // pede ao usuario para inserir as notas do aluno
        for (int i = 0; i < notas.length; i++) {
            notas[i]= utilidades.validarnota(i+1, scn);
        }
        
        //após coletar as notas, a média do aluno será calculada logo abaixo
        double soma = 0;
        for (int nota : notas) {
            soma += nota;
        }
        mediaaluno = soma / notas.length;
        
        //após coletar a média do aluno, o prorgrama irá avaliar a situacao do aluno
        if(mediaaluno >= 70 && faltas <= 2) {
        	situacao = "Aprovado(a)";
        }
        else if(mediaaluno < 70 && mediaaluno >= 50 || faltas < 5) {
        	situacao = "Em Recuperação";
        }
        else {
        	situacao = "Reprovado(a)";
        }

        return new aluno(nome, faltas, notas, mediaaluno,situacao);
   }
	
	private static void exibirBoletim(boletim iamboletim) {
		System.out.println("\nBoletim Geral:  ");
		System.out.println("");
		System.out.println("Informações do Boletim:");
        System.out.println("Unidade Curricular: " +  iamboletim.getNomeUC());
        System.out.println("Professor: " +           iamboletim.getProf());
        System.out.println("Turma: " +               iamboletim.getTurma());
        System.out.println("");
		
		for(aluno aluno : iamboletim.getAlunos()) {
			
			System.out.println("nome do aluno: "	+aluno.getNome()+  " ");
			System.out.println("Nº faltas: "		+aluno.getFaltas()+" ");
			
			// aqui a array notas será iterada
			int[] notas = aluno.getNotas();
            for (int i = 0; i < notas.length; i++) {
                System.out.print("Nota " +(i + 1)+ "º bimestre: " + notas[i] + " | ");
            }
            
            System.out.println("Média final do aluno: " + aluno.getMediaaluno());
            System.out.println("Situação do aluno: "    + aluno.getSituacao());
            System.out.println("   -----------------------------------------------------  "); 
        }
	}
	
	private static double calcularMediageral(ArrayList<aluno> alunos) {
        double somamedias = 0;
        for (aluno aluno : alunos) {
            somamedias += aluno.getMediaaluno();
        }
        return somamedias / alunos.size();
    }
	
	private static void mediaalunoacimaeabaixoMediageral(ArrayList<aluno> alunos, double mediageral) {
		
        System.out.println("\nAlunos acima da média geral da turma: ");
        for (aluno aluno : alunos) {
            if (aluno.getMediaaluno() >= mediageral) {
                System.out.println(aluno.getNome());
            }
        }

        System.out.println("\nAlunos abaixo da média geral da turma: ");
        for (aluno aluno : alunos) {
            if (aluno.getMediaaluno() < mediageral) {
                System.out.println(aluno.getNome());
            }
        }	
	}
	
	private static void Salvarboletim(boletim boletim,Scanner scn) throws FileNotFoundException {
		
		System.out.println("\nDeseja salvar o Boletim geral em formato de arquivo txt?");
		System.out.println("Digite SIM/sim para imprimir em arquivo txt ou digite NÃO/não para finalizar programa:");
		boolean valido = false;
		do {
			String opcao = scn.next();
			 
			if(opcao.equals("SIM") || opcao.equals("sim")) {
				valido = true;
				System.out.println("insira o nome do arquivo: ");
				String arquivo = scn.next();

				System.out.println("Arquivo "+arquivo+" foi gerado com sucesso!");
				System.out.println("\nFim do programa....");
				
				//esta é a função responsavel por imprimir o arquivo em txt e definir o caminho do arquivo
				PrintStream boletimPI = new PrintStream("C:\\Users\\acer\\Documents\\"+arquivo+".txt");
				System.setOut(boletimPI);
				exibirBoletim(boletim);

			} else if(opcao.equals("NÃO") || opcao.equals("não")) {
				System.out.println("\nFim do programa....");
				valido = true;
				
			} else {
				System.out.println("Opção inválida ou inexistente!");
				System.out.println("Insira uma opção válida: ");
			}
		} while(!valido);
		
	}
	
	
	
	
	
}