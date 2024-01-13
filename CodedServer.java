package codingMyOwn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class CodedServer {

    public static void main(String[] args) {
        // Create the ServerSocket outside the loop
        try (ServerSocket ss = new ServerSocket(12345)) {
            System.out.println("Server is running and waiting for clients...");

            while (true) {
                System.out.println("Waiting for the client to connect...");
                Socket clientSocket = ss.accept();
                System.out.println("Client Connected!");

                // Handle the client in a separate method
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputFromClient;

            while (true) {
                out.println("Would you Like to see a knock knock joke? Commands: Yes No");
                inputFromClient = in.readLine();
                System.out.println("Client said: " + inputFromClient);

                switch (inputFromClient.toLowerCase()) {
                    case "yes":
                        jokes(out);
                        break;
                    case "no":
                        System.out.println("Client disconnected");
                        in.close();
                        out.close();
                        clientSocket.close();
                        return; // exit the method, but the server continues to run
                    default:
                        out.println("Not a Valid Command");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Random r = new Random();
	static int rand;
	public static void jokes(PrintWriter output)
	{
		rand = r.nextInt(10) + 1;
		switch(rand)
		{
		case 1:
			output.println("Knock, knock. Who’s there? Atch. Atch who? Bless you!");
			break;
		case 2:
			output.println("Knock, knock. Who’s there? Lettuce. Lettuce who? Lettuce in, it’s cold out here!");
			break;
		case 3:
			output.println("Knock, knock. Who’s there? Yah. Yah who? No, I prefer google.");
			break;
		case 4:
			output.println("Knock, knock. Who’s there? I am. I am who? You don’t know who you are?");
			break;
		case 5:
			output.println("Knock, knock. Who’s there? Hoo. Who hoo? Are you an owl?");
			break;
		case 6:
			output.println("Knock, knock. Who’s there? Kanga. Kanga who? No, it’s kangaroo!");
			break;
		case 7:
			output.println("Knock, knock. Who’s there? Annie. Annie who? Annie way you can open the door?");
			break;
		case 8:
			output.println("Knock, knock. Who’s there? Annie. Annie who? Annie way you can open the door?");
			 break;
		case 9:
			output.println("Knock, knock. Who’s there? Leaf. Leaf who? Leaf me alone!");
			break;
		case 10:
			output.println("Knock, knock. Who’s there? Isabel. Isabel who? Isabel working? I had to knock!");
			
		}
	}
}
