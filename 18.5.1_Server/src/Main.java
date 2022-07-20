import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        final int serverPort = 42320;
        System.out.println("Сервер запущен...");
        while (true) {
            try (
                    ServerSocket serverSocket = new ServerSocket(serverPort);
                    Socket socket = serverSocket.accept();
                    BufferedReader in =
                            new BufferedReader(
                                    new InputStreamReader(
                                            socket.getInputStream()
                                    ));
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()
                            ), true
                    )
            ) {
                System.out.println("Сервер подключен...");
                while (true) {
                    System.out.println("Ожидается ввод пользователя");
                    int sequenceNumber = Integer.parseInt(in.readLine());
                    System.out.println("Ввод пользователя " + sequenceNumber);
                    int fibonacciNumber = getFibonacciNumber(sequenceNumber);
                    out.println(fibonacciNumber);
                    System.out.println("FibonacciNumber = " + fibonacciNumber);
                }

            } catch (Exception e) {
                System.out.println("Ooops :(");
            }
        }
    }

    public static int getFibonacciNumber(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        }
    }

}

