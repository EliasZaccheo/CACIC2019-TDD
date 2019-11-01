package dev;

public class WestState implements RoverState {

	@Override
	public void moveForward(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.regressInX();
	}

	@Override
	public void moveBackward(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.advanceInX();
	}

	@Override
	public void turnLeft(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.changeDirection(MarsRover.SOUTH);
	}

	@Override
	public void turnRight(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.changeDirection(MarsRover.NORTH);
	}

	@Override
	public boolean checkCardinalPoint(char cardinal) {
		// TODO Auto-generated method stub
		if (cardinal==MarsRover.WEST)
			return true;
		return false;
	}

	@Override
	public char getCardinalPoint() {
		// TODO Auto-generated method stub
		return MarsRover.WEST;
	}

	

}
