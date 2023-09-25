package model;

import java.util.Arrays;

public class Carro {
	public int idCarro;
	public int escuderia;
	public double voltas[] = {0.0, 0.0, 0.0};;
	public double voltaMaisRapida;
	
	public Carro(int idCarro, int escuderia, double[] voltas) {
		this.idCarro = idCarro;
		this.escuderia = escuderia;
		this.voltas = voltas;
		this.voltaMaisRapida = 0.0;
		
	}
	
	public Carro() {
		super();
	}

	@Override
	public String toString() {
		return "Carro [idCarro=" + idCarro + ", escuderia=" + escuderia + ", voltas=" + Arrays.toString(voltas)
				+ ", voltaMaisRapida=" + voltaMaisRapida + "]";
	}
	
	

}
