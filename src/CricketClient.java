import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CricketClient {
    public static void main(String[] args) {
        final int CRICKET_SERVER_PORT = 8888;
        try (Socket socket = new Socket("localhost", CRICKET_SERVER_PORT);
                Scanner socketIn = new Scanner(socket.getInputStream());
                PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
                Scanner userIn = new Scanner(System.in)) {

            System.out.println("Connected to Cricket Server. Enter commands:");

            while (true) {
                System.out.print("Enter command: ");
                String userInput = userIn.nextLine();

                if ("QUIT".equalsIgnoreCase(userInput.split(" ")[0])) {
                    sendCommand(socketOut, socketIn, userInput);
                    break;
                }

                sendCommand(socketOut, socketIn, userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendCommand(PrintWriter out, Scanner in, String command) {
        System.out.println("Sending: " + command);
        out.println(command); // Send command to server
        if (in.hasNextLine()) {
            String response = in.nextLine(); // Read response from server
            System.out.println("Receiving: " + response);
        }
    }
}
