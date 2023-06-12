/*
 * https://docs.oracle.com/javase/tutorial/java/data/characters.html
 * 
 */

public class Main {

	public static void main(String[] args) {

		// variables
		String strOriginal = "  Hi, this is my test string    ";
		String strResult = null;

		// \" - escape sequence - Insert a double quote character in the text at this
		// point
		System.out.printf("Original string is: \"%s\"%n%n", strOriginal);

		// .toLowerCase(): The method converts all characters of a String to lower case
		strResult = strOriginal.toLowerCase();
		System.out.printf("String TO LOWERCASE: \"%s\"%n", strResult);

		// .toUpperCase(): The method converts all characters of a String to upper case
		strResult = strOriginal.toUpperCase();
		System.out.printf("String TO UPPERCASE: \"%s\"%n", strResult);

		// .trim(): The method removes any whitespace at the beginning and at the end of
		// a String. If the String contains only spaces, then the method returns an
		// empty String.
		strResult = strOriginal.trim();
		System.out.printf("String TRIMMED: \"%s\"%n%n", strResult);

		int startIndex = 6;
		// .substring(startIndex) This method returns new String object containing the
		// substring of the given string from specified startIndex (inclusive).
		strResult = strOriginal.substring(startIndex);
		System.out.printf("SubString from StartIndex %d: \"%s\"%n", startIndex, strResult);

		startIndex = 6;
		int endIndex = 21;
		// .substring(startIndex, endIndex) his method returns new String object
		// containing the substring of the given string from specified startIndex to
		// endIndex
		strResult = strOriginal.substring(startIndex, endIndex);
		System.out.printf("SubString from StartIndex %d to EndIndex %d: \"%s\"%n", startIndex, endIndex, strResult);

		// .replace(oldCharSequence, newCharSequence) this method returns a string
		// replacing all the old char or CharSequence to new char or CharSequence
		strResult = strOriginal.replace("is", "Xiii");
		System.out.printf("Result String after replacing the charSequence \"is\" with \"Xiii\": \"%s\"%n", strResult);

		// .indexOf(idx): the method returns the position of the first occurrence of the
		// specified character or string in a specified string. method returns the last
		// index of the given character value or substring. If it is not found, it
		// returns -1
		System.out.printf("The first occurrence of the character \'H\' in the string \"%s\" is at position %d%n",
				strOriginal, strOriginal.indexOf('x'));

		// .lastIndexOf(idx): method returns the last index of the given character value
		// or substring. If it is not found, it returns -1. The index counter starts
		// from zero
		System.out.printf("The last occurrence of the char sequence \"ng\" in the string \"%s\" is at position %d%n",
				strOriginal, strOriginal.lastIndexOf("ng"));

	}

}
