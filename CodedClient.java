package codingMyOwn;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CodedClient {
	public static void main(String[] args) {
		final String SERVER_IP = "127.0.0.1";  // Change to the server's IP if not running on localhost
        final int SERVER_PORT = 12345;
		//we need a socket to connect to
		try (Socket socket = new Socket(SERVER_IP,SERVER_PORT))
		{
			//we are connected so now we need input and output for the client to talk to the server
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			
			//now its time to write to the server and get the servers messages
			String userInput;
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			while (true)
			{
				//server says to us
				String serverReply = in.readLine();
				System.out.println("Server: " + serverReply);
				//write to the server
				userInput = consoleReader.readLine();
				if (userInput == null || userInput.equalsIgnoreCase("no"))
				{
					if (userInput.equalsIgnoreCase("no"))
					{
						out.println(userInput);
						System.out.println("Connection Ended");
					}
					break;
				}
				out.println(userInput);
				serverReply = in.readLine();
				System.out.println("Server: " + serverReply);
			}
			
			in.close();
			out.close();
			consoleReader.close();
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
