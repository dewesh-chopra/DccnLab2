package dccnLab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RCEClient {
    public static void main(String[] args) {
        try {
            String str = null;
            Socket socket = new Socket("localhost", 1234);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter command: ");
            do {
                str = br.readLine();
                ps.println(str);
            } while(!str.equalsIgnoreCase("quit"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
