import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class wordCounter extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public wordCounter() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        countButton = new JButton("Count Words");
        countButton.addActionListener(this);
        add(countButton, BorderLayout.SOUTH);

        resultLabel = new JLabel("");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        add(resultLabel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String inputText = textArea.getText();
            int wordCount = countWords(inputText);
            resultLabel.setText("Total Words: " + wordCount);
        }
    }

    private int countWords(String inputText) {
        String[] words = inputText.split("[\\s.,!?;:]+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            wordCounter wordCounterGUI = new wordCounter();
            wordCounterGUI.setVisible(true);
        });
    }
}
