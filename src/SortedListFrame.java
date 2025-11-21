import javax.swing.*;
import java.awt.*;

public class SortedListFrame extends JFrame {
    JPanel mainPanel;
    JPanel textPanel;
    JPanel buttonPanel;

    JTextField addField;
    JLabel addLabel;

    JTextArea sortedArea;
    JScrollPane scroller;


    JButton addButton;
    JButton searchButton;
    JButton quitButton;

    SortedList sortedList;

    public SortedListFrame() {
        sortedList = new SortedList();
        mainPanel = new JPanel();
        setTitle("Sorted List");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createTextPanel();
        createDisplayPanel();
        createButtonPanel();

        mainPanel.add(textPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public void createDisplayPanel(){
        sortedArea = new JTextArea();
        sortedArea.setEditable(false);

        scroller= new JScrollPane(sortedArea);

        sortedArea.append("Sorted List Program \n");
        sortedArea.append("Add items to be sorted. \n");
    }

    public void createTextPanel() {
        textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());

        addLabel = new JLabel("Add to List: ");
        addField = new JTextField(30);

        addField.addActionListener(e -> {
            addToList();
        });

        textPanel.add(addLabel);
        textPanel.add(addField);
    }

    public void addToList() {
        String input = addField.getText().trim();
    }

    public void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        addButton = new JButton("Add to List");
        addButton.addActionListener(e -> {
            addList();
        });

        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {

        });

        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(quitButton);
    }
    public void addList() {

    }
}
