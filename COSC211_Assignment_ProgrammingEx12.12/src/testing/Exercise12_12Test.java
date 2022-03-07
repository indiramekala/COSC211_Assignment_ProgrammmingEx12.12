package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Exercise12_12Test {

	@Before
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testReformator() throws Exception {
		String[] args = {};
		String s = "{";
		String s1 = s.trim();
		myExceptions me = new myExceptions(args, s, s1);
		String actual = me.reformator(s, s1);
		String expected = "{";
		assertEquals(actual, expected);
	}

	@Test
	void testReformatCheck() throws Exception {
		String[] args = {};
		String s = "{";
		String s1 = s.trim();
		myExceptions me = new myExceptions(args, s, s1);

		Throwable e = null;
		try {
			me.reformatChk(s, s1);
		} catch (Exception ex) {
			e = ex;
		}
		assertTrue(e instanceof Exception);
	}

	@Test
	void testCheckSource() throws Exception {
		String[] args = {};
		myExceptions me = new myExceptions(args);
		Throwable e = null;
		try {
			me.checkSrc(args);
		} catch (Exception ex) {
			System.out.println("source file does not exist");
			e = ex;
		}
		assertTrue(e instanceof Exception);

	}

	@Test
	void testCheckCommand() throws Exception {
		String[] args = { "hi" };
		myExceptions me = new myExceptions(args);
		try {
			me.checkCmnd(args);
		} catch (Exception ex) {
			System.out.println("args length does not equal 1");
		}
		String actual = me.checkCmnd(args);
		String expected = "args length equals 1";
		assertEquals(actual, expected);

	}
}