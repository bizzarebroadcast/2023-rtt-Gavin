package Homework;

public class Hw926 {

	public static void main(String[] args) {
		// find the position of the first space in the string
				String example = "This is an example";
				int firstSpaceIndex = example.indexOf(" ");
			    System.out.println("Position of the first space: " + firstSpaceIndex);

				// find the position of the last space in the string
			    int lastSpaceIndex = example.lastIndexOf(" ");
			    System.out.println("Position of the last space: " + lastSpaceIndex);
				// substring of the characters between the first and last space of the string
			    String betweenSpaces = example.substring(firstSpaceIndex + 1, lastSpaceIndex);
			    System.out.println("Characters between the first and last space: " + betweenSpaces);
				
				// do the same thing to find the substring of the first and last vowel of the string
			    int firstVowelIndex = -1;
			    for (int i = 0; i < example.length(); i++) {
			        char ch = example.charAt(i);
			        if (isVowel(ch)) {
			            firstVowelIndex = i;
			            break;
			        }
			    }
			    System.out.println("Position of the first vowel: " + firstVowelIndex);
			    
			    int lastVowelIndex = -1;
			    for (int i = example.length() - 1; i >= 0; i--) {
			        char ch = example.charAt(i);
			        if (isVowel(ch)) {
			            lastVowelIndex = i;
			            break;
			        }
			    }
			    System.out.println("Position of the last vowel: " + lastVowelIndex);
				
				// use the string.charAt function and use a for loop to loop over the entire string
				// and print out each character with a new line after it.
				// you need to use the string.length() function also
			    for (int i = 0; i < example.length(); i++) {
			        System.out.println(example.charAt(i));
			    }
				
				// using only indexOf(" ") print the substring that contains the word "is"
				// use 2 substrings to do this.
			    int firstIsIndex = example.indexOf("is");
			    if (firstIsIndex != -1) {
			        int secondIsIndex = example.indexOf("is", firstIsIndex + 1);
			        if (secondIsIndex != -1) {
			            String substringWithIs = example.substring(firstIsIndex, secondIsIndex + 2);
			            System.out.println("Substring containing 'is': " + substringWithIs);
			        	}
			        }
			       
			    }
			    
			    
			 // Function to check if a character is a vowel
			    public static boolean isVowel(char ch) {
			        ch = Character.toLowerCase(ch);
			        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
			    }



}
