package mySocketPrograms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ARPServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1100);
            Socket s = ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String ip;
            ip = br1.readLine();
            Runtime r = Runtime.getRuntime();
            Process p = r.exec("arp -a " + ip);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String str;

            while((str = br2.readLine()) != null) {
                ps.println(str);
            }
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
