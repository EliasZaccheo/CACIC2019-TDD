package dev;

public class SouthState implements RoverState {

	@Override
	public void moveForward(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.regressInY();
	}

	@Override
	public void moveBackward(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.advanceInY();
	}

	@Override
	public void turnLeft(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.changeDirection(MarsRover.EAST);
	}

	@Override
	public void turnRight(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.changeDirection(MarsRover.WEST);
	}

	@Override
	public boolean checkCardinalPoint(char cardinal) {
		// TODO Auto-generated method stub
		if (cardinal==MarsRover.SOUTH)
			return true;
		return false;
	}
	
	@Override
	public char getCardinalPoint() {
		// TODO Auto-generated method stub
		return MarsRover.SOUTH;
			
	}

}
