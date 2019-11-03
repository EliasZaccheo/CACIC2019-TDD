package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import dev.MarsRover;
import dev.Point;

class MarsRoverTest {

	@Test
	void testWhenInitializeWhitCorrectlyParametersShouldBePositionedCorrectly() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToNorthThenMoveTwoPositionsInForwardShouldBeInTwoPositionsToNorth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		rover.move(new String("ff"));
		pos = new Point (0,2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToNorthThenMoveTwoPositionsInBackwardShouldBeInTwoPositionsToSouth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		rover.move(new String("bb"));
		pos = new Point (0,-2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToSouthThenMoveTwoPositionsInBackwardShouldBeInTwoPositionsToNorth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.SOUTH);
		rover.move(new String("bb"));
		pos = new Point (0,2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToSouthThenMoveTwoPositionsInForwardShouldBeInTwoPositionsToSouth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.SOUTH);
		rover.move(new String("ff"));
		pos = new Point (0,-2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToWestThenMoveTwoPositionsInBackwardShouldBeInTwoPositionsToEast() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.WEST);
		rover.move(new String("bb"));
		pos = new Point (2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToWestThenMoveTwoPositionsInForwardShouldBeInTwoPositionsToWest() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.WEST);
		rover.move(new String("ff"));
		pos = new Point (-2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToEastThenMoveTwoPositionsInBackwardShouldBeInTwoPositionsToWest() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("bb"));
		pos = new Point (-2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToEastThenMoveTwoPositionsInForwardShouldBeInTwoPositionsToEast() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ff"));
		pos = new Point (2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void testWhenIsPositionatedToNorthThenTurnToLeftShouldPositionatedToWest() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		rover.move(new String("l"));
		assertEquals(rover.getDirection(), MarsRover.WEST);
	}
	
	@Test
	void testWhenIsPositionatedToEastThenMoveTwoPositionsForwardAndTurnToLeftShouldBePositionatedToNorthInTwoPositionsEast() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ffl"));
		pos = new Point(2, 0);
		assertEquals(rover.getPosition(), pos);
		assertEquals(rover.getDirection(), MarsRover.NORTH);
	}
	
	@Test
	void testWhenIsPositionatedToEastThenMoveTwoPositionsForwardTurnTwiceToLeftAndMoveTwoPositionsForwardShouldBePositionatedToWestInOriginalPosition() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ffll"));
		assertEquals(rover.getPosition(), new Point(2, 0));
		rover.move(new String("ff"));
		assertEquals(rover.getDirection(), MarsRover.WEST);
		assertEquals(rover.getPosition(), new Point(0, 0));
	}
	
	@Test
	void testWhenIsPositionatedToEastThenMoveTwoPositionsForwardTurnFourEvenToRightAndMoveTwoPositionsBackwardShouldBePositionatedToEastInOriginalPosition() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ffrrrr"));
		assertEquals(rover.getPosition(), new Point(2, 0));
		rover.move(new String("bb"));
		assertEquals(rover.getDirection(), MarsRover.EAST);
		assertEquals(rover.getPosition(), new Point(0, 0));
	}
	
	@Test
	void testWhenIsPositionatedThenSendUppercaseCommandShouldBeMoveCorrectly() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("FF"));
		assertEquals(rover.getPosition(), new Point(2, 0));
		rover.move(new String("BB"));
		assertEquals(rover.getPosition(), new Point(0, 0));
		rover.move(new String("LL"));
		assertEquals(rover.getDirection(), MarsRover.WEST);
		rover.move(new String("R"));
		assertEquals(rover.getDirection(), MarsRover.NORTH);
	}
	
	@Test
	void testWhenIsPositionatedThenSendNotACommandShouldThrowAnException() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		try{
			rover.move(new String("FFPBBBB"));
			fail(); 	// Para garantizar que el test falle si no se levanta la excepci�n por la colaboraci�n
		}
		catch (RuntimeException ex){
			assertEquals(MarsRover.UNKNOWN_COMMAND, ex.getMessage());
		}
		assertEquals(rover.getPosition(), new Point(2, 0));
	}
		
	@Test
	void testWhenInitializeWithWrongParameterShouldThrowAnException() {
		Point pos = new Point (0,0);		
		try{
			new MarsRover(pos.getX(), pos.getY(),'J');
			fail(); 	// Para garantizar que el test falle si no se levanta la excepci�n por la colaboraci�n
		}
		catch (RuntimeException ex){
			assertEquals(MarsRover.UNKNOWN_PARAMETER, ex.getMessage());
		}		
	}
	
	@Test
	void testWhenIsPositionatedThenSendCollectionOfCommandsShouldBeMoveCorrectly() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		Collection<Character> collection=new ArrayList<Character>();
		collection.add('f');
		collection.add('f');
		collection.add('L');
		rover.move(collection);
		assertEquals(rover.getPosition(), new Point(2, 0));
		assertEquals(rover.getDirection(), MarsRover.NORTH);
	}
	
	@Test
	void testWhenIsPositionatedThenSendCollectionOfCommandsAndNotACommandShouldBeMoveCorrectlyAndThrowAnException() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		Collection<Character> collection=new ArrayList<Character>();
		collection.add('f');
		collection.add('f');
		collection.add('M');
		try{
			rover.move(collection);
			fail(); 	// Para garantizar que el test falle si no se levanta la excepci�n por la colaboraci�n
		}
		catch (RuntimeException ex){
			assertEquals(MarsRover.UNKNOWN_COMMAND, ex.getMessage());
		}
		assertEquals(rover.getPosition(), new Point(2, 0));
	}
	
	@Test
	void testWhenInitializeWithLowcaseParameterShouldBePositionatedCorrectly() {
		Point pos = new Point (0,0);		
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),'e');
		assertEquals(rover.getPosition(), pos);		
		rover.move("ff");
		assertEquals(rover.getPosition(), new Point(2, 0));
	}
}
