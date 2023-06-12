/* 
 * Bitwise operators work on binary digits or bits of input values. 
 * We can apply these to the integer types –  long, int, short, char, and byte.
 * https://www.baeldung.com/java-bitwise-operators
 * 
 * How and when to use bitwise operators in Java article:
 * https://www.quora.com/How-and-when-to-use-bitwise-operator-in-Java
 * 
 * Some potential use cases of bitwise operators are:

    Communication stacks where the individual bits in the header attached to the data signify important information
    In embedded systems to set/clear/toggle just one single bit of a specific register without modifying the remaining bits
    To encrypt data for safety issues using the XOR operator
    In data compression by converting data from one representation to another, to reduce the amount of space used
 * 
 * */

public class Main {

	public static void main(String[] args) {

		// variables
		int x = 89; // BIN 0101 1001
		int y = 60; // BIN 0011 1100

		System.out.printf("Bitwise operators examples:%n%n");

		/*
		 * The AND operator compares each binary digit of two integers and gives back 1
		 * if both are 1, otherwise it returns 0. This is similar to the && operator
		 * with boolean values. When the values of two booleans are true the result of a
		 * && operation is true.
		 */
		System.out.printf("Bitwise AND (&) of %d & %d = %d%n", x, y, x & y);
		// expected value 24 (BIN 0001 1000)

		/*
		 * The OR operator compares each binary digit of two integers and gives back 1
		 * if either of them is 1. This is similar to the || logical operator used with
		 * booleans. When two booleans are compared the result is true if either of them
		 * is true. Similarly, the output is 1 when either of them is 1. *
		 */
		System.out.printf("Bitwise OR (|) of %d | %d = %d%n", x, y, x | y);
		// expected value 125 (BIN 0111 1101)

		/*
		 * The XOR operator compares each binary digit of two integers and gives back 1
		 * if both the compared bits are different. This means that if bits of both the
		 * integers are 1 or 0 the result will be 0; otherwise, the result will be 1.
		 **/
		System.out.printf("Bitwise XOR (^) of %d ^ %d = %d%n", x, y, x ^ y);
		// expected value 101 (BIN 0110 0101)

		/*
		 * Bitwise Not or Complement operator simply means the negation of each bit of
		 * the input value. It takes only one integer and it's equivalent to the !
		 * operator. This operator changes each binary digit of the integer, which means
		 * all 0 become 1 and all 1 become 0. The ! operator works similarly for boolean
		 * values: it reverses boolean values from true to false and vice versa.
		 */
		System.out.printf("Bitwise COMPLEMENT (~) of %d = %d%n", y, ~y);
		// expected value -61 (BIN 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111
		// 1111 1111 1111 1111 1100 0011)

		x = 12;
		/*
		 * The left shift operator shifts the bits to the left by the number of times
		 * specified by the right side of the operand. After the left shift, the empty
		 * space in the right is filled with 0. Another important point to note is that
		 * shifting a number by 1 is equivalent to multiplying it by 2, or, in general,
		 * left shifting a number by n positions is equivalent to multiplication by 2^n.
		 */
		System.out.printf("SIGNED LEFT SHIFT [<<] of %d = %d%n", x, x << 2);
		// expected value 48 (BIN 0011 0000)

		/*
		 * The right shift operator shifts all the bits to the right. The empty space in
		 * the left side is filled depending on the input number: When an input number
		 * is negative, where the leftmost bit is 1, then the empty spaces will be
		 * filled with 1 When an input number is positive, where the leftmost bit is 0,
		 * then the empty spaces will be filled with 0
		 */
		System.out.printf("SIGNED RIGHT SHIFT [>>] of %d = %d%n", x, x >> 2);
		// expected value 3 (BIN 0011)

		/*
		 * */
		// System.out.printf("UNSIGNED LEFT SHIFT [<<<] of %d = %d%n", x, x <<< 2);
		// expected value (BIN )

		x = -12;
		/*
		 * This operator is very similar to the signed right shift operator. The only
		 * difference is that the empty spaces in the left are filled with 0
		 * irrespective of whether the number is positive or negative. Therefore, the
		 * result will always be a positive integer.
		 */
		System.out.printf("UNSIGNED RIGHT SHIFT [>>>] of %d = %d%n", x, x >>> 2);
		// expected value 1073741821

		/*
		 * Question: Why is there no unsigned left shift operator in Java !?!?
		 * 
		 * Answer: The reason for this omission is primarily due to the design choices
		 * made by the Java language creators. The designers of Java likely omitted the
		 * unsigned left shift operator to maintain simplicity and reduce the number of
		 * operators, as it can be achieved by performing a signed left shift followed
		 * by a bitwise AND operation with the desired bitmask 0xFFFFFFFF (representing
		 * 32 bits set to 1). This effectively clears the sign bit that would have been
		 * set by the signed left shift, resulting in an equivalent effect to an
		 * unsigned left shift.
		 */

		int number = -1; // Example value
		int unsignedLeftShifted = (number << 1) & 0xFFFFFFFF;

		System.out.printf("UNSIGNED LEFT SHIFT [<<<] of %d = %d%n", number, unsignedLeftShifted);

	}

}
