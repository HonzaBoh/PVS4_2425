package threads.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";//akceptuje i "localhost"
        int serverPort = 54321;

        try(Socket socket = new Socket(serverAddress, serverPort)){

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            String serverMessage = in.readLine();
            System.out.println(serverMessage);

            Scanner sc = new Scanner(System.in);
            System.out.println("Zadej odpoved: ");
            String userAnswer = sc.nextLine();

            pw.println(userAnswer);

            serverMessage = in.readLine();
            System.out.println(serverMessage);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
