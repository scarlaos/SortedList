import javax.swing.*;
import java.awt.*;

public class SortedListFrame extends JFrame {
    JPanel mainPanel;
    JPanel textPanel;
    JPanel buttonPanel;

    JTextField addField;
    JLabel addLabel;

    JTextArea sortedField;


    JButton addButton;
    JButton quitButton;

    public SortedListFrame() {
        mainPanel = new JPanel();
        setTitle("Sorted List");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createTextPanel();
        createButtonPanel();

        mainPanel.add(textPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
    public void createTextPanel() {
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3,3));

        addLabel = new JLabel("Add to List: ");
        addField = new JTextField();
        textPanel.add(addLabel);
        textPanel.add(addField);
    }
    public void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        addButton = new JButton("Add to List");
        addButton.addActionListener(e -> {
            addList();
        });

        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        buttonPanel.add(addButton);
        buttonPanel.add(quitButton);
    }
    public void addList() {

    }
}
