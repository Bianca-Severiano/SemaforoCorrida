package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

import model.Carro;

public class ControllerCorrida extends Thread {
	Random random = new Random();
	
	private static Semaphore semaforoPista = new Semaphore (5);
	
	public Carro c;
	public Semaphore semaforo;
	public double [] tempo;
	public static int cont = 0;
	public Carro carros[] = new Carro [ 14];
	
	public ControllerCorrida(Carro c, Semaphore semaforo, double [] tempos, Carro[] carros) {
		this.c = c;
		this.semaforo = semaforo;
		this.tempo = tempos;
		this.carros = carros;
	}
	
	public void run () {
		Escuderia();
	}
	
	private void Escuderia() {
		try {
			semaforo.acquire();
			semaforoPista.acquire();
			tempoVoltas();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			semaforoPista.release();
		}
	}
	
	private void tempoVoltas () {
		for (int i = 0; i < 3; i++) {
			c.voltas[i] = 20 + (random.nextDouble() * 70);
			if (c.voltas[i] < c.voltaMaisRapida || c.voltaMaisRapida == 0) {
				c.voltaMaisRapida = c.voltas[i];
			}			
			System.out.println("Carro " + c.idCarro + " - Volta " + i + " = time: " + c.voltas[i]);
		}
		
		System.err.println("Carro " + c.idCarro +  "= time: " + c.voltaMaisRapida);
		tempo[cont] = c.voltaMaisRapida;
		carros[cont] = c;
		cont++;
		
	}
	
	
	
	
}
