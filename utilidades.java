package projeto_integrador;

import java.util.ArrayList;
import java.util.Scanner;

public class utilidades {
	
	//aqui estão armazenados os métodos de validação
	
	public static String validarUnidadecurricular(Scanner scn) {
		String inputUC;
		boolean valido = false;
		do {
			// insira o nome de uma unidade curricular
			inputUC = scn.next();
			// verifica se o INPUT do usuário é valido seguindo as condições
			if(inputUC.matches("[a-zA-Z]+") && (inputUC.equals("FPOO") || inputUC.equals("LIMA")
					|| inputUC.equals("HARE")|| inputUC.equals("SOP"))){
				valido = true;
			}else {
				System.out.println("informação inválida! tente novamente");
			}
			
		} while (!valido);

		return inputUC;
	}
	
	public static String inserirnomedeProfessor(String nomeUC) {
		String prof;
		
		 if (nomeUC.equals("FPOO") || nomeUC.equals("LIMA")) {
		        prof = "Atila";
		    } else if (nomeUC.equals("SOP")) {
		        prof = "Sergio Gal";
		    } else {
		        prof = "Mathias e Wellington";
		    }
		return prof;
	}
	
	public static String validarnome(Scanner scn) {
		String inputNome;
		boolean validar = false;
		do {
			// insira o nome do aluno
			inputNome = scn.next();
			// verifica se o INPUTnome tem somente Letras,seja maiusculas ou minusculas
			if(inputNome.matches("[a-zA-Z]+")){
				validar = true;
			}else {
				System.out.println("informação inválida! Não é permitido o uso de números ou cracteres especiais!");
				System.out.println("Insira o nome do aluno novamente: ");
			}
			
		} while (!validar);

		return inputNome;
	}
	
	public static int validarfalta(Scanner scn) {
		int falta = 0;
		boolean valido;

		do {
			System.out.println("Insira o número total de faltas do aluno (de 0 a 10): ");

			// primeiro insira uma variavel do tipo String para realizar a validação de INT
			String inputfalta = scn.next();

			 // verifica se tem espaços em branco
            int espaco = inputfalta.indexOf(" ");

            // verifica se a variavel inputfalta do tipo string contem mais de um numero "\\d+"
            valido = inputfalta.matches("\\d+");

            if (!valido || espaco != -1){
                System.out.println("informção inválida! Insira um número de faltas válido.");
                continue; // caso a variavel não contenha numeros, Volta para o início do loop
            }

			// Converta String para INT
			falta = Integer.parseInt(inputfalta);

			// Verifique se o N de faltas esta entre a 0 a 10
			if (falta < 0 || falta > 10) {
				System.out.println("Informação inválida! Insira um número de faltas de 0 a 10.");
				valido = false; // isto aqui é para manter o looping caso esteja fora da condição
			}

		} while (!valido);

		return falta;
	}
	
	public static int validarnota(int bimestre, Scanner scn) {
		int notaint = 0;
		boolean sonumero;

		do {
			System.out.println("Insira a nota do " + bimestre + "º bimestre do aluno (de 0 a 100): ");

			// primeiro insira uma variavel do tipo String para realizar a validação de INT
			String stringnota = scn.next();

			// verifica se tem espaços em branco
            int espaco = stringnota.indexOf(" ");

            // verifica se a variavel stringnota do tipo string contem numeros "\\d+"
            sonumero = stringnota.matches("\\d+");

            if (!sonumero || espaco != -1) {
                System.out.println("Nota inválida! Insira uma nota válida.");
                continue; // Volta para o início do loop
            }
			// Converte o tipo da variavel String para INT
			notaint = Integer.parseInt(stringnota);

			// Verifique se a nota esta entre 0 a 100
			if (notaint < 0 || notaint > 100) {
				System.out.println("Nota fora do intervalo! Insira uma nota de 0 a 100.");
				sonumero = false; // isto aqui é para manter o looping caso esteja fora da condição
			}
		} while (!sonumero);
		return notaint;
	}
	
	public static void mediaalunoacimaeabaixoMediageral(ArrayList<aluno> alunos, double mediageral) {
        System.out.println("\nAlunos acima da média da turma: ");
        for (aluno aluno : alunos) {
            if (aluno.getMediaaluno() >= mediageral) {
                System.out.println(aluno.getNome());
            }
        }

        System.out.println("\nAlunos abaixo da média da turma: ");
        for (aluno aluno : alunos) {
            if (aluno.getMediaaluno() < mediageral) {
                System.out.println(aluno.getNome());
            }
        }
    }
}
