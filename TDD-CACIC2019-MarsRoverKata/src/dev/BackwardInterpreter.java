package dev;

public class BackwardInterpreter implements CommandInterpreter {

	@Override
	public void processCommand(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.getState().moveBackward(rover);
	}

}
