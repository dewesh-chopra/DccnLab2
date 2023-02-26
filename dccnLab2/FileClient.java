package dccnLab2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[20000];
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connecting ...");

        InputStream is = socket.getInputStream();
        FileOutputStream fr = new FileOutputStream("F:\\NETWORK PROGRAMMING\\NetworkProgrammingInJava\\src\\dccnLab2\\sample2.txt");
        is.read(b, 0, b.length);
        fr.write(b, 0, b.length);
    }
}
