package dev;

public interface RoverState {

	public void moveForward(MarsRover rover);
	
	public void moveBackward(MarsRover rover);
	
	public void turnLeft(MarsRover rover);
	
	public void turnRight(MarsRover rover);
	
	public boolean checkCardinalPoint (char cardinal);
	
	public char getCardinalPoint();
}
