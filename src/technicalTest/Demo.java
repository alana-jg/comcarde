package technicalTest;

public class Demo {

	public static void main(String[] args) {
		
		Value v1 = new Value();
		
		//Camel Case - count num of words in string
		System.out.println(v1.countWords());

		//Caeser's Cipher 
		System.out.println(v1.encode());
		
		//Pangram
		System.out.println(v1.isPangram());
		
	}

}
