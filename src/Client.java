import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("server");
            int port = 9870;

            System.out.println("Digite um texto e pressione Enter. Cada caractere será enviado individualmente.");
            System.out.println("Para encerrar, pressione Ctrl+C.");

            String line;
            while ((line = inFromUser.readLine()) != null) {

                for (char c : line.toCharArray()) {
                    String charToSend = String.valueOf(c);
                    byte[] sendData = charToSend.getBytes();

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    clientSocket.send(sendPacket);
                }

                byte[] newlineData = "\n".getBytes();
                DatagramPacket newlinePacket = new DatagramPacket(newlineData, newlineData.length, IPAddress, port);
                clientSocket.send(newlinePacket);

                System.out.println("Linha enviada com sucesso! Pode digitar a próxima.");
            }

            clientSocket.close();
        } catch (Exception e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}