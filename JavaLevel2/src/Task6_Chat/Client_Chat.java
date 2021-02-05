package Task6_Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client_Chat {

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("localhost", 3443);
            // входящий поток
            Scanner in =  new Scanner(socket.getInputStream());
            // исходящий поток
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // с консоли
            Scanner sc = new Scanner(System.in);

            // получаем в этом потоке информацию от сервера
            Thread ran = new Thread(() -> {
                while (true) {
                        String msg = in.nextLine();
                        System.out.println("Server: " + msg);
                    }

            });
            ran.start();

            // в главном потоке отправляем сообщение серверу
            while (true) {

                String msg = sc.nextLine();

                System.out.println("From server: " + msg);
                if (msg.equals("end")) {
                    break;
                }
                // сообщение улетело серверу
                out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
               // assert socket != null;

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
