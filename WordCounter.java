import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;
    private JButton clearButton;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create text area
        textArea = new JTextArea();
        textArea.setBackground(new Color(240, 240, 240)); // Light grey background
        textArea.setFont(new Font("Arial", Font.PLAIN, 25)); 
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Create word count label
        wordCountLabel = new JLabel("Word Count: 0");
        wordCountLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create buttons
        countButton = new JButton("Count Words");
        clearButton = new JButton("Clear");

        // Set button colors
        countButton.setBackground(new Color(70, 130, 180)); // Steel blue
        countButton.setForeground(Color.WHITE);
        clearButton.setBackground(new Color(220, 20, 60)); // Crimson
        clearButton.setForeground(Color.WHITE);

        // Add action listeners to buttons
        countButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Create panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Add text area to center of panel
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create bottom panel for label and buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 1));
        bottomPanel.add(wordCountLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(countButton);
        buttonPanel.add(clearButton);
        
        bottomPanel.add(buttonPanel);

        // Add bottom panel to main panel
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Set background color for the panel
        panel.setBackground(new Color(245, 245, 245)); // White smoke

        // Add main panel to frame
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textArea.getText();
            String[] words = text.trim().split("\\s+");
            int wordCount = text.isEmpty() ? 0 : words.length;
            wordCountLabel.setText("Word Count: " + wordCount);
        } else if (e.getSource() == clearButton) {
            textArea.setText("");
            wordCountLabel.setText("Word Count: 0");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounter wc = new WordCounter();
            wc.setVisible(true);
        });
    }
}
