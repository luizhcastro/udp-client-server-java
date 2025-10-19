import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9870);
            byte[] receiveData = new byte[1024];

            StringBuilder lineBuffer = new StringBuilder();

            System.out.println("SERVIDOR EM AÇÃO. Aguardando pacotes UDP...");
            System.out.println("---------------------------------------------");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                int dataLength = receivePacket.getLength();
                String characterReceived = new String(receivePacket.getData(), 0, dataLength);

                String logData = characterReceived.equals("\n") ? "[Enter]" : "'" + characterReceived + "'";

                System.out.println(
                        String.format("[LOG] Pacote de %d byte(s) recebido de %s:%d | Dados: %s",
                                dataLength, clientAddress.getHostAddress(), clientPort, logData)
                );

                if (characterReceived.equals("\n")) {
                    System.out.println("--- Frase Completa Recebida ---");
                    System.out.println(lineBuffer.toString());
                    System.out.println("-------------------------------");

                    lineBuffer.setLength(0);
                } else {
                    lineBuffer.append(characterReceived);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
    }
}