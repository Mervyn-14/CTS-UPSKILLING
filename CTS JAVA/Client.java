import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket =
new Socket("localhost", 6000);
            PrintWriter pw =
            new PrintWriter(
            socket.getOutputStream(),
            true);
            BufferedReader br =
            new BufferedReader(
            new InputStreamReader(
            socket.getInputStream()));
            pw.println(
            "Hello Server!");
            String reply = br.readLine();
            System.out.println(
            "Server says: " + reply);
            socket.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}