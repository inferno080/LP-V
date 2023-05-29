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
            System.out.println("Server Started. Waiting for Client Connections ...");

            Socket socket = ss.accept();
            System.out.println("Client Connnected "+ socket.getInetAddress().getHostAddress());

            DataInputStream ip = new DataInputStream(socket.getInputStream());
            DataOutputStream op = new DataOutputStream(socket.getOutputStream());

            System.out.println("Recieved Message from Client");
            String req = ip.readUTF();
            System.out.println(req);

            op.writeUTF("Hello Client !");
            System.out.println("Sent Reply to Client");
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
