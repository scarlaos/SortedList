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
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());

        createTextPanel();
        createDisplayPanel();
        createButtonPanel();

        mainPanel.add(textPanel, BorderLayout.NORTH);
        mainPanel.add(scroller, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
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



        if(input.isEmpty()){
            JOptionPane.showMessageDialog(textPanel,"Please enter items to be sorted. ");
            return;
        }


        sortedList.add(input);
        sortedArea.append("Added "+input+"\n" );
        updateDisplay();

        addField.setText(""); //clears the text so more items can be added
    }

    public void updateDisplay(){
        sortedArea.append("\n New List: \n");
        if(sortedList.size()==0){
            JOptionPane.showMessageDialog(textPanel,"Please enter the items to be sorted. ");
        }else{
            sortedArea.append(sortedList.toString()+"\n");
        }
    }

    public void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        addButton = new JButton("Add to List");
        addButton.addActionListener(e -> {
            addToList();
        });

        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            searchList();
        });

        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(quitButton);
    }

    public void searchList(){
        String input = addField.getText().trim();

        if(input.isEmpty()){
            JOptionPane.showMessageDialog(textPanel,"Please enter a item to be searched for. ");
            return;
        }

        String result= sortedList.location(input);
        sortedArea.append("Search: " + result+"\n");

        addField.setText("");//resets search
    }

    public static void main(String[] args) {
        SortedListFrame frame = new SortedListFrame();
    }
}
