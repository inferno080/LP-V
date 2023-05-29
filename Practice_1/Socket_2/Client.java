import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client
{
    public static void main(String args[]) 
    {
        try
        {
            Socket socket = new Socket("localhost",3000);
            System.out.println("Connected to Server : "+ socket.getInetAddress().getHostAddress());

            DataInputStream ip = new DataInputStream(socket.getInputStream());
            DataOutputStream op = new DataOutputStream(socket.getOutputStream());

            op.writeUTF("Hello Server");
            System.out.println("Sent a Message to Server");
            String res = ip.readUTF();
            System.out.println("Recieved Reply from Server : "+ res);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}