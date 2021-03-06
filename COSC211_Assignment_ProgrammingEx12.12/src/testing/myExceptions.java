package testing;

import java.io.File;

public class myExceptions {

	private String[] args;
	private String s;
	private String s1;

	public myExceptions(String[] args) {
		this.args = args;
	}

	public myExceptions(String[] args, String s, String s1) {
		this.args = args;
		this.s = s;
		this.s1 = s1;
	}

	public String checkCmnd(String[] args) throws Exception {
		this.args = args;
		if (args.length != 1) {
			throw new Exception();
		}
		return "args length equals 1";
	}

	public String checkSrc(String[] args) throws Exception {
		this.args = args;
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			throw new Exception();
		}
		return "Source file exists";
	}

	public String reformatChk(String s, String s1) throws Exception {
		this.s = s;
		this.s1 = s1;
		if (s1.charAt(0) == '{') {
			throw new Exception();
		}
		return s1;
	}

	public String reformator(String s, String s1) throws Exception {
		this.s = s;
		this.s1 = s1;
		if (s1.length() > 1) {
			throw new Exception();
		}
		return s1;
	}

}
