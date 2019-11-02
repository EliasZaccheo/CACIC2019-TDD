package dev;

public class ForwardInterpreter implements CommandInterpreter {

	@Override
	public void processCommand(MarsRover rover) {
		// TODO Auto-generated method stub
		rover.getState().moveForward(rover);
	}

	

}
