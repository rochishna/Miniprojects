import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;
class PortScanner {
    public static void main(String[] args) throws Exception {
        String roc;
        Scanner hi=new Scanner (System.in);
        System.out.println("enter Target");
        roc=hi.nextLine();
        InetAddress inetAddress = InetAddress.getByName(roc);
        String hostName = inetAddress.getHostName();
        for (int port = 0; port <= 65535; port++) {
            try {
                Socket socket = new Socket(hostName, port);
                String text = hostName + " is listening on port " + port;
                System.out.println(text);
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}