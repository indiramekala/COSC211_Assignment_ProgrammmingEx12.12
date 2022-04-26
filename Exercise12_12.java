/** COSC211 
 * Name: Sony Mekala
 * Assignment Programming Exercise 12.12
 * 
 */

package testing;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise12_12 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		myExceptions me = new myExceptions(args);
		// Check command line parameter usage

		try {
			me.checkCmnd(args);
		} catch (Exception ex) {
			System.out.println("Usage: java Exercise12_12 filename");
			System.exit(1);
		}

		// Check if source file exists
		try {
			me.checkSrc(args);
		} catch (Exception ex) {
			System.out.println("Source file " + args[0] + " not exist");
			System.exit(2);
		}

		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " not exist");
			System.exit(2);
		}
		StringBuffer buffer = new StringBuffer();
		Scanner input = new Scanner(sourceFile);
		while (input.hasNext()) {
			String s = input.nextLine();
			String s1 = s.trim();
			myExceptions m = new myExceptions(args, s, s1);

			try (PrintWriter output = new PrintWriter(sourceFile)) {
				m.reformator(s, s1);
			} catch (Exception exc) {
				buffer.append("\r\n" + s.replace('{', ' '));
			}
		}

	}

}
