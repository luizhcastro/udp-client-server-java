import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class CustomKeyListener implements KeyListener {

    private final JPanel messagePanel;
    private final JTextField textField;
    private final DatagramSocket socket;
    private final InetAddress address;
    private final int port;

    public CustomKeyListener(JPanel messagePanel, JTextField textField, String host, int port) throws SocketException, UnknownHostException {
        this.messagePanel = messagePanel;
        this.textField = textField;
        this.address = InetAddress.getByName(host);
        this.port = port;
        this.socket = new DatagramSocket();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            char c = e.getKeyChar();
            byte[] byteArray = String.valueOf(c).getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(byteArray, byteArray.length, address, port);

            socket.send(packet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            JLabel label = new JLabel(textField.getText());
            messagePanel.add(label);
            messagePanel.revalidate();
            messagePanel.repaint();
            textField.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
