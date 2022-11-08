package negocio;

import java.util.ArrayList;
import java.util.List;

public class Maquina {
	private List<Casilla> casillas;
	private float recaudacion;
	private List<Premio> premios;
	private float minimo;
	private float precioJugada;
	private float credito;
	
	public Maquina() {
		premios = new ArrayList<Premio>();
	}
	
	public List<Casilla> getCasillas() {
		return casillas;
	}
	
	public void setCasillas(List<Casilla> casillas) {
		this.casillas = casillas;
	}
	
	public float getRecaudacion() {
		return recaudacion;
	}
	
	public void setRecaudacion(float recaudacion) {
		this.recaudacion = recaudacion;
	}
	
	public List<Premio> getPremios() {
		return premios;
	}
	
	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}
	
	public float getMinimo() {
		return minimo;
	}
	
	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}
	
	public float getPrecioJugada() {
		return precioJugada;
	}
	
	public void setPrecioJugada(float precioJugada) {
		this.precioJugada = precioJugada;
	}
	
	public float getCredito() {
		return credito;
	}
	
	public void setCredito(float credito) {
		this.credito = credito;
	}
	
	
	public void jugar() {
		boolean hasPremio = false;
		
		//se seleccionan frutas al azar por cada casilla
		for (Casilla casilla : casillas) {
			casilla.setFrutaAleatoria();
			
			//TODO: eliminar este sout
			System.out.println(casilla.getNumeroCasilla() + " - " + casilla.getFruta().getNombre());
			
		}
		
		//se comprueba si la combinacion tiene premio
		for (Premio premio : premios) {
			
			//tiene premio
			if (premio.soyElPremio(casillas)) {
				float montoPremio = premio.getPremio();
				sumarCredito(montoPremio);
				restarRecaudacion(montoPremio);
				hasPremio = true;
				
				//TODO: este sout no va aca moverlo al controlador o lugar correspondiente
				System.out.println("Ganaste: $" + premio.getPremio() + " ("+ premio.getNombre() +")" );
			}
		}
		
		//si no se gano nada, entonces sumo la jugada a la recaudacion de la maquina
		if (!hasPremio) {
			incrementarRecaudacion(precioJugada);
			//se resta el precio de la jugada
			restarCredito(precioJugada);
			
			//TODO: eliminar este sout
			System.out.println("Perdiste! la recaudacion es de: $" + recaudacion);
		}
		


		//TODO: eliminar souts
		System.out.println("La recaudacion de la maquina quedo en: $" + this.recaudacion);
		System.out.println("El credito disponible es: $" + this.credito);
		
	}
	
	public void addPremio(Premio premio) {
		this.premios.add(premio);
	}
	
	public void incrementarRecaudacion(float monto) {
		this.recaudacion += monto;
	}
	
	public void restarRecaudacion(float monto) {
		recaudacion -= monto;
	}
	
	public void ingresarCredito(int numeroTicket) {
		//existe ticket?
			//no fue utilizado?
				//agregar credito
	}
	
	public void generarComprobante() {
		//poner credito en comprobante o ticket
		//poner credito en 0
	}

	public void sumarCredito(float monto) {
		credito += monto;
	}
	
	public void restarCredito(float monto) {
		credito -= monto;
	}
	
	public boolean hasRecaudacionMinima() {
		return this.recaudacion >= this.getPremioMaximo(); 
	}
	
	private float getPremioMaximo() {
		Float max = null;
		
		for (Premio premio : premios) {
			if(max == null || premio.getPremio() > max) {
				max = premio.getPremio();
			}
		}
		
		return max;
	}
	
	public boolean hasCredito() {
		return credito >= precioJugada; 
	}
	
	
	
}
