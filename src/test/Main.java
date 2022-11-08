package test;

import java.util.List;

import negocio.Casilla;
import negocio.Fruta;
import negocio.Maquina;
import negocio.Premio;

public class Main {

	public static void main(String[] args) {
		
		//Definicion el set de frutas que puede contener cada casilla
		Fruta manzana = new Fruta("Manzana");
		Fruta uva = new Fruta("Uva");
		Fruta frutilla = new Fruta("Frutilla");
		Fruta banana = new Fruta("Banana");
		Fruta guinda = new Fruta("Guinda");
		Fruta sandia = new Fruta("Sandia");
		List<Fruta> frutas = List.of(manzana, uva, frutilla, banana, guinda, sandia);

		//lista hardcoded para ganar //TODO: eliminar este set, es solo para pruebas
		frutas = List.of(frutilla);
		////
		

		//Definicion de casillas y cantidad que tendra la maquina
		Casilla casilla1 = new Casilla(1, frutas);
		Casilla casilla2 = new Casilla(2, frutas);
		Casilla casilla3 = new Casilla(3, frutas);
		List<Casilla> casillas = List.of(casilla1, casilla2, casilla3);
		
		//Definicion de premios
		
		//premio 1: frutilla - frutilla - frutilla
		Casilla primerCasillaPremio1 = new Casilla(1);
		primerCasillaPremio1.setFruta(frutilla);
		Casilla segundaCasillaPremio1 = new Casilla(2);
		segundaCasillaPremio1.setFruta(frutilla);
		Casilla tercerCasillaPremio1 = new Casilla(3);
		tercerCasillaPremio1.setFruta(frutilla);
		List<Casilla> combinacionPremio1 = List.of(primerCasillaPremio1, segundaCasillaPremio1, tercerCasillaPremio1);
				
		Premio premio1 = new Premio();
		premio1.setCombinacion(combinacionPremio1);
		premio1.setNombre("triple frutilla");
		premio1.setPremio(500f);
		

		//premio 2: manzana - manzana - uva
		Casilla primerCasillaPremio2 = new Casilla(1);
		primerCasillaPremio2.setFruta(manzana);
		Casilla segundaCasillaPremio2 = new Casilla(2);
		segundaCasillaPremio2.setFruta(manzana);
		Casilla tercerCasillaPremio2 = new Casilla(3);
		tercerCasillaPremio2.setFruta(uva);
		List<Casilla> combinacionPremio2 = List.of(primerCasillaPremio2, segundaCasillaPremio2, tercerCasillaPremio2);
				
		Premio premio2 = new Premio();
		premio2.setCombinacion(combinacionPremio2);
		premio2.setNombre("doble manzana + uva");
		premio2.setPremio(300f);

		final float RECAUDACION_INICIAL = 1000f;
		final float PRECIO_JUGADA = 10f;
		
		Maquina maquina1 = new Maquina();
		maquina1.setCasillas(casillas);
		maquina1.addPremio(premio1);
		maquina1.addPremio(premio2);
		maquina1.setPrecioJugada(PRECIO_JUGADA);
		maquina1.setRecaudacion(RECAUDACION_INICIAL);
		
		//TODO: eliminar este hardcodeo de credito y hacerlo con el ticket como indicar el enunciado
		maquina1.setCredito(200f);
		
		if (!maquina1.hasRecaudacionMinima()) {
			System.out.print("Se ha alcanzado la recaudación mínima y existe posibilidad de no poder pagar los próximos premios");
		}
		
		if (maquina1.hasCredito()) {
			maquina1.jugar();
		} else {
			System.out.print("La maquina no tiene credito para realizar la jugada");
		}
		
		
	}

}
