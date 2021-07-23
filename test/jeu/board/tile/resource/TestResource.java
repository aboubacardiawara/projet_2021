/**
 *
 */
package jeu.board.tile.resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author
 *
 */
public class TestResource {
	private Resource resource;
	private int value;

	@Before
	public void before() {
		this.value = 5;
		this.resource = new Corn(5);
	}

	@Test
	public void testGetValue() {
		assertEquals(this.value, this.resource.getValue());
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(jeu.board.tile.resource.TestResource.class);
	}


}
