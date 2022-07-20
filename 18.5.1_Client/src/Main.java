import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int serverPort = 42320;

        try (
                Scanner scanner = new Scanner(System.in);
                Socket socket = new Socket("127.0.0.1", serverPort);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()
                        )
                );
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()
                        ), true
                )
        ) {

            while (true){


                System.out.println("Ожидается ввод пользователя");
                String userInput = scanner.nextLine();

                System.out.println("Ввод пользователя: " + userInput);
                if (userInput.equals("end")) {
                    break;
                }
                out.println(userInput);
                System.out.println("Ожидание решения от сервера");
                System.out.println("FibonacciNumber = " + in.readLine());
            }

        } catch (Exception e) {
            System.out.println("Ooops :(");
        }

    }
}
