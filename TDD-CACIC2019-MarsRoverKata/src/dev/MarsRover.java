package dev;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MarsRover {

	public static final char NORTH='N';
	public static final char EAST='E';
	public static final char WEST='W';
	public static final char SOUTH='S';
	public static final char FORWARD='f';
	public static final char BACKWARD='b';
	public static final char LEFT='l';
	public static final char RIGHT='r';
	public static final String UNKNOWN_COMMAND="Comando desconocido";
	public static final String UNKNOWN_PARAMETER="Parametro de inicio desconocido. Dirección actual: Norte";

	
	private Map<Character, CommandInterpreter> interpreters;
	private Point actualPosition;
	private RoverState state;
	private static final List<RoverState> states = Arrays.asList(
			new NorthState(),
			new SouthState(),
			new WestState(),
			new EastState());

	public MarsRover(int x, int y, char direction) {
		// TODO Auto-generated constructor stub
		actualPosition = new Point(x,y);
		initializeInterpreters();
		changeDirection(direction);
	}


	public Point getPosition() {
		// TODO Auto-generated method stub
		return actualPosition;
	}
	
	protected void advanceInX() {
		actualPosition = new Point(actualPosition.getX()+1, actualPosition.getY());
	}
	
	protected void regressInX() {
		actualPosition = new Point(actualPosition.getX()-1, actualPosition.getY());
	}
	
	protected void advanceInY() {
		actualPosition = new Point(actualPosition.getX(), actualPosition.getY()+1);
	}
	
	protected void regressInY() {
		actualPosition = new Point(actualPosition.getX(), actualPosition.getY()-1);
	}

	protected void changeDirection(char cardinal) {
		try{
			state=states.stream().filter(s -> s.checkCardinalPoint(cardinal)).findFirst().get();
		}
		catch (RuntimeException ex) {
			state=states.stream().filter(s -> s.checkCardinalPoint(MarsRover.NORTH)).findFirst().get();
			throw new RuntimeException(MarsRover.UNKNOWN_PARAMETER);
			
		}
	}

	public char getDirection() {
		// TODO Auto-generated method stub
		return state.getCardinalPoint();
	}
	
	protected RoverState getState() {
		// TODO Auto-generated method stub
		return state;
	}
	
	private void initializeInterpreters() {
		interpreters = new HashMap<Character, CommandInterpreter>();
		interpreters.put(MarsRover.FORWARD,new ForwardInterpreter());
		interpreters.put(MarsRover.BACKWARD,new BackwardInterpreter());
		interpreters.put(MarsRover.RIGHT,new RightInterpreter());
		interpreters.put(MarsRover.LEFT,new LeftInterpreter());
		
	}
	
	public void move(String instructions) {
		// TODO Auto-generated method stub
		instructions.toLowerCase().chars().mapToObj(command->(char)command).forEach(i-> {		// Convertimos el string en un stream de caracteres (en minúscula)
			CommandInterpreter interpreter = interpreters.get(i);	// Capturamos el interprete correcto para ese comando
		    if (interpreter == null) {		// Si no existe un intérprete designado para ese comando
		    	throw new RuntimeException(MarsRover.UNKNOWN_COMMAND);
		    }
		    interpreter.processCommand(this);	// Interpretamos el comando
		});
	}
}
