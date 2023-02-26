package dccnLab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        String line = null;
        InetAddress inetAddr = InetAddress.getByName("localhost");
        DatagramSocket socket = new DatagramSocket();

        br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        byte[] b = line.getBytes();

        DatagramPacket packet = new DatagramPacket(b, b.length, inetAddr, 1234);
        socket.send(packet);
        byte[] d = new byte[200000];
        DatagramPacket packet2 = new DatagramPacket(d, d.length);
        socket.receive(packet2);
        String str = new String(packet2.getData(), 0, packet2.getLength());
        System.out.println("Server: " + str);
        socket.close();
    }
}
