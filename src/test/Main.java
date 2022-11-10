package test;

import java.util.List;

import controller.Controlador;
import negocio.Casilla;
import negocio.Fruta;
import negocio.Maquina;
import negocio.Premio;
import negocio.Ticket;

public class Main {

	public static void main(String[] args) {
		Controlador.getInstance().inicilizarMaquina();
		
		Controlador.getInstance().jugar();

	}

}
