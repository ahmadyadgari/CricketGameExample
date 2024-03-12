import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CricketServer {
    public static void main(String[] args) {
        final int CRICKET_SERVER_PORT = 8888;
        CricketLeague league = new CricketLeague(); // Initialize the league

        try (ServerSocket serverSocket = new ServerSocket(CRICKET_SERVER_PORT)) {
            System.out.println("Cricket Server is waiting for clients to connect...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                CricketService service = new CricketService(clientSocket, league);
                new Thread(service).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
