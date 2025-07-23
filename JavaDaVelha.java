import java.util.*;
public class JavaDaVelha {
	static String[] tabuleiro = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};	
	public static boolean checaEmpate() {
		for (int contador = 1; contador <= 9; contador++) {
			if (!tabuleiro[contador].equals("X") && !tabuleiro[contador].equals("O")) {
				return false;
			}
		}
		return true;
	}

	public static void escolheCasa(String letraAtual, int casaEscolhida) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("É a vez do "+ letraAtual + ", insira qual casa deseja mudar: ");
		casaEscolhida = entrada.nextInt();
		if ((tabuleiro[casaEscolhida].equals("X")) || (tabuleiro[casaEscolhida].equals("O"))) {
			System.out.println("Casa já escolhida.");
		}	else if (casaEscolhida < 1 && casaEscolhida > 9){
				System.out.println("Casa inválida.");
		} else {
			tabuleiro[casaEscolhida] = letraAtual;	
		}	
	}

	public static void mostraTabuleiro() {
		System.out.println(" ");
		System.out.println("-------------");
		System.out.println("| "+ tabuleiro[1] +" | " + tabuleiro[2] + " | " + tabuleiro[3] + " |");
		System.out.println("-------------");
		System.out.println("| "+ tabuleiro[4] +" | " + tabuleiro[5] + " | " + tabuleiro[6] + " |");
		System.out.println("-------------");
		System.out.println("| "+ tabuleiro[7] +" | " + tabuleiro[8] + " | " + tabuleiro[9] + " |");
		System.out.println("-------------");
	}
	public static String checaVitoria() {
		String linha = null;
		for (int contador = 0; contador < 10; contador++) {
			switch (contador) {
				case 0:
					linha = tabuleiro[1] + tabuleiro[2] + tabuleiro[3];
				break;
				case 1:
					linha = tabuleiro[4] + tabuleiro[5] + tabuleiro[6];
				break;
				case 2:
					linha = tabuleiro[7] + tabuleiro[8] + tabuleiro[9];
				break;
				case 3:
					linha = tabuleiro[1] + tabuleiro[4] + tabuleiro[7];
				break;
				case 4:
					linha = tabuleiro[2] + tabuleiro[5] + tabuleiro[8];
				break;
				case 5:
					linha = tabuleiro[3] + tabuleiro[6] + tabuleiro[9];
				break;
				case 6:
					linha = tabuleiro[1] + tabuleiro[5] + tabuleiro[9];
				break;
				case 7:
					linha = tabuleiro[3] + tabuleiro[5] + tabuleiro[7];
				break;
			}
			if (linha.equals("OOO")) {
				return "O";	
			}
			else if (linha.equals("XXX")) {
				return "X";
			} 
		}
		return " ";
	}

	public static void main(String[] args) {
		boolean empate = false;
		int vez = 1;
		String vitoria = " ";
		int casaEscolhida = 0;
		String escolhe = " ";
		while (!vitoria.equals("X") && !vitoria.equals("O") && !checaEmpate()) {
			mostraTabuleiro();
			if (vez % 2 != 0) {
				escolhe = "X";
				escolheCasa(escolhe, casaEscolhida);
			} else {
				escolhe = "O";
				escolheCasa(escolhe, casaEscolhida);				
			}
			vitoria = checaVitoria();
			empate = checaEmpate();
			++vez;

		}
		mostraTabuleiro();
		if (vitoria.equals("X") || vitoria.equals("O")) {
			System.out.println("Temos um vencedor! O ganhador foi o '"+ vitoria+"'." );
		} else if (empate == true) {
				System.out.println("Temos um empate.");
			}
	}
}
