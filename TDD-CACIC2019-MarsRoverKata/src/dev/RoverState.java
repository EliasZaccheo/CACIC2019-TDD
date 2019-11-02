package dev;

public interface RoverState {

	/**Move forward one position in current orientation.
	 * Avanza una posición en la orientación actual*/
	public void moveForward(MarsRover rover);
	
	/**Move back one position in current orientation. 
	 * Retrocede una posición en la orientación actual*/
	public void moveBackward(MarsRover rover);
	
	/**Turn ninety degrees to left. 
	 * Gira noventa grados a la izquierda*/
	public void turnLeft(MarsRover rover);
	
	/**Turn ninety degrees to right. 
	 * Gira noventa grados hacia la derecha*/
	public void turnRight(MarsRover rover);
	
	/**Return true if parameter match with the current orientation. 
	 * Retorna true si el parámetro coincide con la orientación actual*/
	public boolean checkCardinalPoint (char cardinal);
	
	/**Return the current orientation.  
	 * Retorna la orientación actual*/
	public char getCardinalPoint();
}
