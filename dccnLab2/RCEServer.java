package dccnLab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RCEServer {
    public static void main(String[] args) {
        try {
            String str = null;
            ServerSocket ss = new ServerSocket(1234);
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            do {
                str = br.readLine();
                if(str != "exit") {
                    Runtime r = Runtime.getRuntime();
                    Process p = r.exec(str);
                }
            } while(!str.equalsIgnoreCase("quit"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
