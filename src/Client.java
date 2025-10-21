import javax.swing.*;
import java.awt.*;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        JFrame frame = new JFrame("Chat tempo real");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        JTextField message = new JTextField(20);
        frame.add(message, BorderLayout.NORTH);

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(messagePanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        CustomKeyListener listener = new CustomKeyListener(messagePanel, message, "172.20.10.4", 9870);

        message.addKeyListener(listener);

        frame.setVisible(true);
    }
}