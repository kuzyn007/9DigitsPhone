package pl.seweryn;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<Integer, Character[]> digitsMap = new HashMap<Integer, Character[]>();

		int key = 2;
		Character value = 64;
		for (int i = 2; i <= 9; i++) {
			Character[] lettersTab = new Character[3];
			lettersTab[0] = ++value;
			lettersTab[1] = ++value;
			if (lettersTab[1] == 'Q') { // Q is not on 9-digit phone in the task
				lettersTab[1] = ++value;
			}
			lettersTab[2] = ++value;

			digitsMap.put(key, lettersTab);
			key++;
		}

		/*
		 * for (Map.Entry<Integer, Character[]> entry : digitsMap.entrySet()) {
		 * System.out.println("key: " + entry.getKey());
		 * 
		 * for (Character name : entry.getValue()) { System.out.println(
		 * "  name: " + name); } }
		 */
		// System.out.println("One element value test: " + digitsMap.get(2)[0]);

		// String number = in.nextLine();
		//String number = "110015010";
		String number = "338356737";
		//String number = "110015033";

		char[] znak = new char[9];
		int[] oryginal = new int[9];
		int calc = 0;

		for (int i = 0; i < number.length(); i++) {
			znak[i] = number.charAt(i);
			oryginal[i] = Character.getNumericValue(number.charAt(i));

			if (znak[i] < '0' && znak[i] > '9' || number.length() != 9) {
				number = "ERROR";
				System.out.println(number);
				return;
			}

			if (znak[i] >= '2' && znak[i] <= '9') {
				znak[i] = digitsMap.get(oryginal[i])[0];
				calc++;
			}
			System.out.print(znak[i]);
		}
		System.out.println();
		
		int howManyExamples = 1;
		for (int i = 0; i < calc; i++) {
			howManyExamples *= 3;
		}

		for (int i = 0; i < howManyExamples - 1; i++) {
			for (int j = znak.length-1; 0 <= j; j--) {
				if(oryginal[j] == 1 || oryginal[j] == 0) {
					continue;
				}
				if(znak[j] == digitsMap.get(oryginal[j])[0]) {
					znak[j] = digitsMap.get(oryginal[j])[1];
					break;
				}
				else if(znak[j] == digitsMap.get(oryginal[j])[1]) {
					znak[j] = digitsMap.get(oryginal[j])[2];
					break;
				}
				else if(znak[j] == digitsMap.get(oryginal[j])[2]) {
					znak[j] = digitsMap.get(oryginal[j])[0];
					continue;
				}
				
			}
			
			for (int j = 0; j < znak.length; j++) {	
				System.out.print(znak[j]);
			}
			System.out.println();
		}

		in.close();
	}
}
