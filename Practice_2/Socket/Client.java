import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client
{
    public static void main(String args[])
    {
        try
        {
            Socket socket = new Socket("127.0.0.1",8080);
            System.out.println("Connected to Server : " + socket.getInetAddress().getHostAddress() );

            DataInputStream i = new DataInputStream(socket.getInputStream());
            DataOutputStream o = new DataOutputStream(socket.getOutputStream());

            o.writeUTF("Ping !");
            String response = i.readUTF();
            System.out.println(response);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}