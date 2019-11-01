package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dev.MarsRover;
import dev.Point;

class MarsRoverTest {

	@Test
	void test001Marcianizate() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test002MoveTwoInForwardWhenRoverIsOrientedToNorth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		rover.move(new String("ff"));
		pos = new Point (0,2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test003MoveTwoInBackwardWhenRoverIsOrientedToNorth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		rover.move(new String("bb"));
		pos = new Point (0,-2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test004MoveTwoInBackwardWhenRoverIsOrientedToSouth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.SOUTH);
		rover.move(new String("bb"));
		pos = new Point (0,2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test005MoveTwoInForwardWhenRoverIsOrientedToSouth() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.SOUTH);
		rover.move(new String("ff"));
		pos = new Point (0,-2);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test006MoveTwoInBackwardWhenRoverIsOrientedToWest() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.WEST);
		rover.move(new String("bb"));
		pos = new Point (2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test007MoveTwoInForwardWhenRoverIsOrientedToWest() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.WEST);
		rover.move(new String("ff"));
		pos = new Point (-2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test008MoveTwoInBackwardWhenRoverIsOrientedToEast() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("bb"));
		pos = new Point (-2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test009MoveTwoInForwardWhenRoverIsOrientedToEast() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ff"));
		pos = new Point (2,0);
		assertEquals(rover.getPosition(),pos);
	}
	
	@Test
	void test010TurnLeft() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.NORTH);
		rover.move(new String("l"));
		assertEquals(rover.getDirection(), MarsRover.WEST);
	}
	
	@Test
	void test011MoveTwoInForwardToEastAndTurnLeft() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ffl"));
		pos = new Point(2, 0);
		assertEquals(rover.getPosition(), pos);
		assertEquals(rover.getDirection(), MarsRover.NORTH);
	}
	
	@Test
	void test012MoveTwoInForwardToEastAndTurnAroundAndBackward() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ffll"));
		assertEquals(rover.getPosition(), new Point(2, 0));
		rover.move(new String("ff"));
		assertEquals(rover.getDirection(), MarsRover.WEST);
		assertEquals(rover.getPosition(), new Point(0, 0));
	}
	
	@Test
	void test013MoveTwoInForwardToEastAndFullAroundAndBackward() {
		Point pos = new Point (0,0);
		MarsRover rover = new MarsRover(pos.getX(), pos.getY(),MarsRover.EAST);
		rover.move(new String("ffrrrr"));
		assertEquals(rover.getPosition(), new Point(2, 0));
		rover.move(new String("bb"));
		assertEquals(rover.getDirection(), MarsRover.EAST);
		assertEquals(rover.getPosition(), new Point(0, 0));
	}
	
	
}
