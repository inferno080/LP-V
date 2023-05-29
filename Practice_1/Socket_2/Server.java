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
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Server is up. Listening for Clients ...");
            Socket socket = ss.accept();
            
            DataInputStream ip = new DataInputStream(socket.getInputStream());
            DataOutputStream op = new DataOutputStream(socket.getOutputStream());

            String req = ip.readUTF();
            System.out.println("Message from Client " + req);

            op.writeUTF("Server Response :D");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
