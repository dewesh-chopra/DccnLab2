package dccnLab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        String line = null;

        DatagramSocket socket = new DatagramSocket(1234);
        System.out.println("Server started ...");
        byte[] b = new byte[200000];
        DatagramPacket packet = new DatagramPacket(b, b.length);

        socket.receive(packet);
        String str = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Client: " + str);
        br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine();
        byte[] d = line.getBytes();
        InetAddress inetAddr = InetAddress.getLocalHost();
        DatagramPacket packet2 = new DatagramPacket(d, d.length, inetAddr, packet.getPort());
        socket.send(packet2);
        socket.close();
    }
}
