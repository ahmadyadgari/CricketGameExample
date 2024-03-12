import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CricketService implements Runnable {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private CricketLeague league;

    public CricketService(Socket aSocket, CricketLeague aLeague) {
        this.socket = aSocket;
        this.league = aLeague;
    }

    @Override
    public void run() {
        try {
            // Initialize scanner and writer
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true); // Enable auto flush
            // Process all messages from the client
            doService();
        } catch (IOException e) {
            e.printStackTrace(); // Replace with better error handling
        } finally {
            // Always close the resources
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace(); // Replace with better error handling
            }
        }
    }

    private void doService() {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("QUIT")) {
                out.println("Service terminating.");
                break;
            } else {
                executeCommand(line);
            }
        }
    }

    private void executeCommand(String line) {
        String[] tokens = line.split(" ");
        if (tokens.length < 2) {
            out.println("Invalid command format.");
            return;
        }
        String command = tokens[0];
        String countryCode = tokens[1];
        String response;

        switch (command.toUpperCase()) {
            case "SHOW_RECORD":
                response = league.getWinLossRecord(countryCode);
                break;
            case "RECORD_WIN":
                league.recordWin(countryCode);
                response = "Win recorded for " + countryCode;
                break;
            case "RECORD_LOSS":
                league.recordLoss(countryCode);
                response = "Loss recorded for " + countryCode;
                break;
            case "WIN_PCT":
                response = league.getWinPercentage(countryCode);
                break;
            default:
                response = "Invalid command.";
                break;
        }

        out.println(response);
    }
}
