package Task6_Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_Chat {

    public static void main(String[] args) {
        //noinspection InstantiationOfUtilityClass
        Server_Chat server = new Server_Chat();
    }

    public Server_Chat() {

        // розетка сервера
        ServerSocket server = null; // иницилизация локальной перемннной, так что пишу нолик
        // hрозетка клиента, это некий поток, который будет подключаться к серверу
        Socket socket = null;

        try {
            // порт, который будет прослушивать наш сервер
            server = new ServerSocket(3443);
            System.out.println("Server is working...");
            socket = server.accept(); // клиент подключен
            System.out.println("New Client");
            // входящий поток
            Scanner in =  new Scanner(socket.getInputStream());
            // исходящий поток
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //или пишем внизу метод
            // с консоли
            Scanner sc = new Scanner(System.in);

            // отправляем в этом потоке сообщение от сервера
            Thread ran = new Thread(() -> {
                while (true) {
                        String msg = sc.nextLine();
                        System.out.println("The message was send: " + msg);
                        out.println(msg);
                    }
                });

            ran.start();
            // в главном потоке получаем сообщение и шлем эхо
            while (true) {
                String msg = in.nextLine();
                /*if (msg.equals("/end")) {
                    break;
                }*/
                System.out.println("Client: " + msg);
                //               out.flush(); // это автоматический/принудительный сброс буфера вывода
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //assert socket != null;
                socket.close(); // закрываем клиента
                server.close(); // закрываем клиента
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
