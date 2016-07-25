package pl.seweryn;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//String number = in.nextLine();
		String number = "110015010";
		//String number = "338356737";
		//String number = "110015033";
		PhoneNumberModifier ref = new PhoneNumberModifier(number);
		

		in.close();
	}
}
