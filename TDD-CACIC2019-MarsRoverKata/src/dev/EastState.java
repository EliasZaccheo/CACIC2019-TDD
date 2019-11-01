package dev;

public class EastState implements RoverState {

	@Override
	public void moveForward(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.advanceInX();
	}

	@Override
	public void moveBackward(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.regressInX();
	}

	@Override
	public void turnLeft(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.changeDirection(MarsRover.NORTH);
	}

	@Override
	public void turnRight(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.changeDirection(MarsRover.SOUTH);
	}

	@Override
	public boolean checkCardinalPoint(char cardinal) {
		// TODO Auto-generated method stub
		if (cardinal==MarsRover.EAST)
			return true;
		return false;
	}

	@Override
	public char getCardinalPoint() {
		// TODO Auto-generated method stub
		return MarsRover.EAST;
	}

}
