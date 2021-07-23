package jeu.board;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import jeu.board.*;

import jeu.board.tile.*;

/**
 * testClassicBoard
 */
public class TestClassicBoard {

	private ClassicBoard classicBoard;

	@Before
	public void before(){
		this.classicBoard = new BoardFarmGame(10, 10);
	}

	@Test
	public void testNumberOfTile(){
		int numberOfTiles = this.classicBoard.getWidth() * this.classicBoard.getLength();
		int numberOfOcenTileOcean = this.classicBoard.numberOfOcenTile();
		assertTrue(numberOfOcenTileOcean >= (2/3) * numberOfTiles);
	}

	@Test
	public void everyTileShouldHaveAtLessOneAdjacenteUsableTile(){
		for (int i=0; i<this.classicBoard.getWidth(); i++) {
			for (int j=0; j<this.classicBoard.getLength(); j++) {
				if (this.classicBoard.getTile(i, j) instanceof UsableTile)
					assertTrue(this.classicBoard.hasMoreThanZeroAdjacentUsableTile(i, j));
			}
		}
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(jeu.board.TestClassicBoard.class);
	}
}
