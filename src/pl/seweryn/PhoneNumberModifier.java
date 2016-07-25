package pl.seweryn;

import java.util.*;

public class PhoneNumberModifier {
	private String number;
	private HashMap<Integer, Character[]> digitsMap;
	
	public PhoneNumberModifier(String number) {
		digitsMap = new HashMap<Integer, Character[]>();
		digitsMap();
		this.number = number;
		numberChecker();
	}
	
	private void numberChecker() {
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
	}
	
	private HashMap<Integer, Character[]> digitsMap() {
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
		
		return digitsMap;
	}
}
