package technicalTest;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Value {

	private String value;
	private int numWords;
	private ArrayList<Character> alpha = new ArrayList<Character>();
	private String caesersCipher;
	
	
	public Value() {
		requestString();
		setAlphabet();
	}//end constructor
	
	public Value(String value) {
		setValue(value);
		setAlphabet();
	}
	
	public void requestString() {
		setValue(JOptionPane.showInputDialog("Please enter a string:"));
		while (validateString() ==false) {
			setValue(JOptionPane.showInputDialog("Invalid input - string can only contain letters. Please enter a string:"));
		}
	}//end requestString	
	
	public boolean validateString() {
		char letter;
		boolean validString = true;
		for (int i = 0; i<this.value.length();i++) {
			letter = this.value.charAt(i);
			if(!Character.isLetter(letter) && !Character.isWhitespace(letter)) {
				validString = false;
			}
		}//end for
		return validString;
	}//end validateString
	
	public int countWords() {
		char letter;
		int counter = 1;
		for(int i=0; i < this.value.length(); i++) {
			letter = this.value.charAt(i);
			if (Character.isUpperCase(letter)) {
				counter++;
			}
		}
		setNumWords(counter);
		return this.numWords;
	}//end countWords
	
	public String encode() {
		char letter;
		String newString = "";
		for(int i=0; i < this.value.length(); i++) {
			letter = this.value.charAt(i);
			if (!Character.isWhitespace(letter)) {
				int position = this.alpha.indexOf(letter);
				int newPosition = position + 3;
				if(newPosition > 25) {
					newPosition = newPosition - 26;
				}
				char newLetter = this.alpha.get(newPosition);
				newString = newString + Character.toString(newLetter);
			} else {
				newString = newString + " ";
			}
		}//end for loop
		setCaesersCipher(newString);
		return getCaesersCipher();
	}//end encode
	
	public boolean isPangram() {
		setAlphabet();
		char letter;
		for (int i = 0; i <this.value.length(); i++) {
			letter = this.value.charAt(i);
			letter = Character.toLowerCase(letter);
			//if letter still exists in alphabet, remove it
			if (this.alpha.contains(letter)) {
				this.alpha.remove(Character.valueOf(letter));
			}
		}//end for
		int size = getAlphabetLength();

		//if alphabet is empty, string is a pangram
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}//end isPangram
	
	public void setValue(String value) {
		this.value = value;
	}//end setValue
	
	public String getValue() {
		return this.value;
	}//end getValue
	
	public void setNumWords(int num) {
		this.numWords = num;
	}
	
	public int getNumWords() {
		return this.numWords;
	}
	
	public void setCaesersCipher(String newWord) {
		this.caesersCipher = newWord;
	}
	
	public String getCaesersCipher() {
		return this.caesersCipher;
	}
	
	public void setAlphabet() {
		char[]alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		//this.alpha.addAll(alphabet);
		this.alpha.clear();
		for (char letter : alphabet) {
			this.alpha.add(letter);
		}
	}
	
	public int getAlphabetLength() {
		int length = this.alpha.size();
		//int length = this.alphabet.length;
		return length;
	}
	
}//end
