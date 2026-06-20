import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField messageField;
    JButton sendButton;

    public ChatBot() {

        setTitle("AI ChatBot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(this);
        messageField.addActionListener(this);

        chatArea.append("Bot : Hello! I am your chatbot.\n");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userMessage = messageField.getText();

        if (userMessage.trim().isEmpty()) {
            return;
        }

        chatArea.append("You : " + userMessage + "\n");

        String botReply = getReply(userMessage);

        chatArea.append("Bot : " + botReply + "\n\n");

        messageField.setText("");
    }

    public String getReply(String msg) {

        msg = msg.toLowerCase();

        if (msg.contains("hi") || msg.contains("hello")) {
            return "Hello! How can I help you?";
        }

        else if (msg.contains("name")) {
            return "My name is Java ChatBot.";
        }

        else if (msg.contains("how are you")) {
            return "I am fine. Thank you for asking.";
        }

        else if (msg.contains("course")) {
            return "I can provide information about courses and subjects.";
        }

        else if (msg.contains("java")) {
            return "Java is an object-oriented programming language.";
        }

        else if (msg.contains("college")) {
            return "Please enter your college name.";
        }

        else if (msg.contains("bye")) {
            return "Goodbye! Have a great day.";
        }

        else {
            return "Sorry, I don't understand that question.";
        }
    }

    public static void main(String[] args) {
        new ChatBot();
    }
}
