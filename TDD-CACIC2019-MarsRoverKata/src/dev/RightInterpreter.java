package dev;

public class RightInterpreter implements CommandInterpreter {

	@Override
	public void processCommand(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.getState().turnRight(rover);
	}

}
