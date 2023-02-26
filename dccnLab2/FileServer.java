package dccnLab2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Waiting ...");
        Socket socket = ss.accept();
        System.out.println("Accepted: " + socket);

        FileInputStream fr = new FileInputStream("F:\\NETWORK PROGRAMMING\\NetworkProgrammingInJava\\src\\dccnLab2\\files\\sample.txt");
        byte[] b = new byte[20000];
        fr.read(b, 0, b.length);
        OutputStream os = socket.getOutputStream();
        os.write(b, 0, b.length);
    }
}
