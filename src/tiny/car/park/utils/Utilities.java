package tiny.car.park.utils;

import java.io.IOException;

public class Utilities {
	
	/**
	 * @param str1
	 * @param str2
	 * @return true if string1 equals string2
	 */
	public static boolean isEquals(String str1, String str2) {
		return (null != str1 && null != str2) && str1.equals(str2);
	}
	
	/**
	 * clear console screen
	 * @throws IOException 
	 */
	public static void clearScreen() throws IOException {
		String[] cls = new String[] {"cmd.exe", "/c", "cls"};
		Runtime.getRuntime().exec(cls);
	}
	
}
