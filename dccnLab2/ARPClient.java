package mySocketPrograms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ARPClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 1100);
            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String ip;
            System.out.print("Enter IP: ");
            ip = br1.readLine();
            ps.println(ip);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str;
            System.out.println("Server reply:");

            do {
                str = br2.readLine();
                System.out.println(str);
            } while(!(str.equalsIgnoreCase("exit")));
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
