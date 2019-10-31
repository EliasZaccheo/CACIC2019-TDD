package dev;

public class MarsRover {

	public static final char NORTH='N';
	public static final char EAST='E';
	public static final char WEST='W';
	public static final char SOUTH='S';
	public static final char FORWARD='f';
	public static final char BACKWARD='b';
	public static final char LEFT='l';
	public static final char RIGHT='r';
	
	private Point actualPosition;
	private char direction;
	
	public MarsRover(int x, int y, char direction) {
		// TODO Auto-generated constructor stub
		actualPosition = new Point(x,y);
		this.direction=direction;
	}


	public Point getPosition() {
		// TODO Auto-generated method stub
		return actualPosition;
	}


	public void move(String instructions) {
		// TODO Auto-generated method stub
		instructions=instructions.toLowerCase();		
		for (int i=0; i<instructions.length(); i++) {			
			switch (instructions.charAt(i)) {
			case 'f':
				switch (direction) {
				case NORTH:
					actualPosition.increaseY();
					break;
				case EAST:
					actualPosition.increaseX();
					break;
				case WEST:
					actualPosition.decrementX();
					break;
				case SOUTH:
					actualPosition.decrementY();
					break;
				}
				break;
			
			case BACKWARD:
				switch (direction) {
				case SOUTH:
					actualPosition.increaseY();
					break;
				case WEST:
					actualPosition.increaseX();
					break;
				case EAST:
					actualPosition.decrementX();
					break;
				case NORTH:
					actualPosition.decrementY();
					break;
				}
				break;
			
			case LEFT:
				switch (direction) {
				case SOUTH:
					direction = EAST;
					break;
				case WEST:
					direction = SOUTH;
					break;
				case EAST:
					direction = NORTH;
					break;
				case NORTH:
					direction = WEST;
					break;
				}
				break;
			case RIGHT:
				switch (direction) {
				case SOUTH:
					direction = WEST;
					break;
				case WEST:
					direction = NORTH;
					break;
				case EAST:
					direction = SOUTH;
					break;
				case NORTH:
					direction = EAST;
					break;
				}
				break;
			}
		}
	}


	public char getDirection() {
		// TODO Auto-generated method stub
		return direction;
	}
	
	
}
