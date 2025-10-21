import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9870);
            byte[] receiveData = new byte[1024];

            System.out.println("SERVIDOR EM AÇÃO. Aguardando pacotes UDP...");
            System.out.println("---------------------------------------------");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String characterReceived = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

                System.out.print(characterReceived);

            }
        } catch (Exception e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
    }
}