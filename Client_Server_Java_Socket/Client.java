import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());

            // Create input and output streams for the server
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Send a message to the server
            String message = "Hello, server!";
            output.writeUTF(message);
            System.out.println("Sent message to server: " + message);

            // Receive and print the response from the server
            String response = input.readUTF();
            System.out.println("Received response from server: " + response);

            // Clean up resources
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
