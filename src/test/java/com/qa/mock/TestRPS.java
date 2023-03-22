package com.qa.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class TestRPS {

	@Mock // create the mock Random object
	private Random rand;

	@InjectMocks // inserts the mock into the Simulator
	private Simulator sim;

	@Test
	void testRockSuccess() {
//		? Could this be rewritten to use RPS values instead of ints?
//		To future proof!
		Mockito.when(this.rand.nextInt(RPS.values().length)).thenReturn(2);
		assertEquals(Result.WIN, this.sim.playRPS(RPS.ROCK));

		Mockito.verify(this.rand, Mockito.times(1)).nextInt(RPS.values().length);
	}

	@Test
	void testRockFail() {
		Mockito.when(this.rand.nextInt(RPS.values().length)).thenReturn(1);
		assertEquals(Result.LOSE, this.sim.playRPS(RPS.ROCK));
	}

	@Test
	void testRockDraw() {
		Mockito.when(this.rand.nextInt(RPS.values().length)).thenReturn(0);
		assertEquals(Result.DRAW, this.sim.playRPS(RPS.ROCK));
	}
}
