import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket ss = new ServerSocket(8080);
            Socket socket = ss.accept();
            System.out.println("Connected to Client : " + socket.getInetAddress().getHostAddress() );

            DataInputStream i = new DataInputStream(socket.getInputStream());
            DataOutputStream o = new DataOutputStream(socket.getOutputStream());

            String message = i.readUTF();
            System.out.println(message);
            o.writeUTF("Alive !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}