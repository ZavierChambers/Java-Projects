
/*
 * Created By: Zavier Chambers
 * Date: 12/23/2023
 * This Program is meant to simulate a very basic version of an asymmetric system for encryption. 
 * The user is able to create a secret tunnel of communication by allowing another person to know
 *  the offset of the message which will allow them to speak with security in mind. 
 *
 * Last Modified: 12/23/2023 10:56 PM
 */
import java.util.Scanner;

//used to perform encryption and decryption on messages based on a given offset
public abstract class Encryptor {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Would you like to encrypt or decrypt a message: (type hint for command list)");
			switch (s.nextLine().toLowerCase()) {
			case "encrypt":
				System.out.println("Enter message to encrypt and an offset integer Ex.\"Hi There |Enter Key| 15\"");
				try {
					System.out.println(
							"Your Encrypted message: " + encrypt(s.nextLine(), Integer.parseInt(s.nextLine())) + "\n");
				} catch (NumberFormatException e) {
					System.out.println("Invaild entry for offset: must be a Integer Value");
				}
				break;
			case "decrypt":
				System.out.println("Enter message to decrypt and the offset integer Ex.\"*h%4f3 [Enter Key] 15\"");
				try {
					System.out.println(
							"Your Decrypted message: " + decrypt(s.nextLine(), Integer.parseInt(s.nextLine())) + "\n");
				} catch (NumberFormatException e) {
					System.out.println("Invaild entry for offset: must be a Integer Value");
				}
				break;
			case "exit", "quit", "close":
				System.out.println("Thank you for using my example encryption model\n\tMade by: Zavier Chambers");
				s.close();
				System.exit(0);
				break;
			case "hint":
				System.out.println("Command List: " + "\nencrypt - will encrypt a message for you to send"
						+ "\ndecrypt - will decrypt a message that was encrypted using this program"
						+ "\nexit,quit,close - close the program\n");
				break;
			default:
				System.out.println("Invaild entry");
			}

		}

	}
	//will encrypt a given string based on it's passed in offset number,
	//using addition to the unicode value of chars
	public static String encrypt(String input, int offset) {

		char[] encrypt = new char[input.length()];
		StringBuilder sb = new StringBuilder();
		//value of original string being altered to (unicode value plus offset) to each char in string
		for (int i = 0; i < input.length(); i++) {
			encrypt[i] = (char) (input.charAt(i) + offset);
			sb.append(encrypt[i]);
		}

		return sb.toString();
	}
	//will decrypt a given string based on it's passed in offset number,
	//using subtraction to the unicode value of chars
	public static String decrypt(String input, int offset) {
		char[] decrypt = new char[input.length()];
		StringBuilder sb = new StringBuilder();
		//value of original string being altered to (unicode value minus offset) to each char in string
		for (int i = 0; i < input.length(); i++) {
			decrypt[i] = (char) (input.charAt(i) - offset);
			sb.append(decrypt[i]);
		}

		return sb.toString();
	}
}
