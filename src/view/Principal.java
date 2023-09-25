package view;

import java.util.concurrent.Semaphore;
import controller.ControllerCorrida;
import model.Carro;

public class Principal {

	static Semaphore semaforo[] = new Semaphore[7];
	static double tempos[] = new double[14];
	static Carro Carros[] = new Carro[14];

	public static void main(String[] args) {
		Thread[] carros = new ControllerCorrida[14];
		int idCarro = 0;

		for (int i = 0; i < 7; i++) {
			semaforo[i] = new Semaphore(1);

			for (int j = 0; j < 2; j++) {
				Carro c = new Carro();
				c.escuderia = i;
				c.idCarro = idCarro;
				carros[idCarro] = new ControllerCorrida(c, semaforo[i], tempos, Carros);

				carros[idCarro].start();
				idCarro++;
			}
		}

		for (Thread c : carros) {
			try {
				c.join();
			} catch (Exception errJoin) {
				System.err.println(errJoin);
			}
		}
		
		
		Carros = BubbleSort(Carros);
		
		System.err.println("===========================");
		System.err.println("GRID");
		System.err.println("===========================");
		int cont=1;
		for (Carro t : Carros) {
			System.out.println(cont + "# Carro:" + t.idCarro + " - Melhor volta: " + t.voltaMaisRapida);
			cont++;
		}

	}
	
	public static Carro[] BubbleSort(Carro [] vetor) {
		int tamanho = vetor.length;
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho - 1; j++) {
				if (vetor[j].voltaMaisRapida > vetor[j+1].voltaMaisRapida) {
					Carro aux = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = aux;
				}
			}
		}
		return vetor;
	}

}
