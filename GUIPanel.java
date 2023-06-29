import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

public class GUIPanel extends JPanel {
    private JButton runButton;
    private JToggleButton singlyLinkedListToggle;
    private JToggleButton arrayListToggle;
    private JToggleButton doublyLinkedListToggle;
    private JToggleButton bubbleSortToggle;
    private JToggleButton insertionSortToggle;
    private JToggleButton binarySearchToggle;
    private JToggleButton linearSearchToggle;
    private JTextArea resultsBox;
    private DoublyLinkedListVgSales<VgSales> doubly;
    private VgSalesLinkedList singly;
    private CustomArrayListVgSales array;
    private StopWatch stopWatch;
    private JTextArea resultTimeBox;
    private int counter;
    private VgSales thingSold;

    public GUIPanel() {
        doubly = new DoublyLinkedListVgSales<>();
        singly = new VgSalesLinkedList();
        array = new CustomArrayListVgSales();
        stopWatch = new StopWatch();
        counter = 0;
        thingSold = new VgSales(8818, "Serious Sam", "2002");

        String csvFile = "vgsales.csv"; // path to your dataset
        String line;
        VgSalesLinkedList.Node<VgSales> head = null; // Head of the linked list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header(Rank, Name, Year) line
            br.readLine();
            // Process the remaining lines
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // Split the lines into columns with ','
                int rank = Integer.parseInt(columns[0]);
                String name = columns[1];
                String year = columns[3]; // Reasoning for this is because the dataset has N/A as some years
                VgSales vgSales = new VgSales(rank, name, year);
                doubly.addEnd(vgSales);
                array.add(vgSales);
                singly.add(vgSales);
                counter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        doubly.addEnd(thingSold);
        singly.add(thingSold);
        array.add(thingSold);
        counter++;
        this.setupUI();
    }

    private void setupUI() {
        this.setLayout(new BorderLayout(0, 10));
//        this.setBackground(Color.decode("#121212"));
        JLabel titleLabel = new JLabel();
        titleLabel.setFont(this.getFont());
//        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setText("Algorithms Sorting and Searching");
        titleLabel.setVerticalAlignment(1);
        titleLabel.setVerticalTextPosition(1);
        titleLabel.setBorder(new CompoundBorder(titleLabel.getBorder(), new EmptyBorder(10, 10, 10, 10)));
        this.add(titleLabel, "North");

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(1, 3));
        this.add(selectionPanel);

        JPanel listTypeSelector = new JPanel();
        listTypeSelector.setLayout(new GridLayout(3, 1));
        selectionPanel.add(listTypeSelector);

        JPanel algoSelector = new JPanel();
        algoSelector.setLayout(new GridLayout(5, 1));
        selectionPanel.add(algoSelector);

        resultsBox = new JTextArea(3, 1);
        resultsBox.setLocation(100, 100);
        resultsBox.setSize(50, 50);
        resultsBox.setText("HELLO THERE");
        resultsBox.setEnabled(true);
//        resultsBox.setBackground(Color.decode("#121010"));
//        resultsBox.setForeground(Color.white);
//        selectionPanel.add(resultsBox);
        JScrollPane scrollPane = new JScrollPane(resultsBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        selectionPanel.add(scrollPane);

        //create buttons and add listeners
        singlyLinkedListToggle = new JToggleButton();
        singlyLinkedListToggle.setText("Singly Linked List");
        singlyLinkedListToggle.addActionListener(e -> {
            if (singlyLinkedListToggle.isSelected()) {
                resetLists();
                singlyLinkedListToggle.setSelected(true);
            }
        });
        listTypeSelector.add(singlyLinkedListToggle);

        arrayListToggle = new JToggleButton();
        arrayListToggle.setText("ArrayList");
        arrayListToggle.addActionListener(e -> {
            if (arrayListToggle.isSelected()) {
                resetLists();
                arrayListToggle.setSelected(true);
            }
        });
        listTypeSelector.add(arrayListToggle);

        doublyLinkedListToggle = new JToggleButton();
        doublyLinkedListToggle.setText("Doubly Linked List");
        doublyLinkedListToggle.addActionListener(e -> {
            if (doublyLinkedListToggle.isSelected()) {
                resetLists();
                doublyLinkedListToggle.setSelected(true);
            }
        });
        listTypeSelector.add(doublyLinkedListToggle);

        bubbleSortToggle = new JToggleButton();
        bubbleSortToggle.setText("Bubble Sort");
        bubbleSortToggle.addActionListener(e -> {
            if (bubbleSortToggle.isSelected()) {
                resetAlgorithms();
                bubbleSortToggle.setSelected(true);
            }
        });
        algoSelector.add(bubbleSortToggle);

        insertionSortToggle = new JToggleButton();
        insertionSortToggle.setText("Insertion Sort");
        insertionSortToggle.addActionListener(e -> {
            if (insertionSortToggle.isSelected()) {
                resetAlgorithms();
                insertionSortToggle.setSelected(true);
            }
        });
        algoSelector.add(insertionSortToggle);

        binarySearchToggle = new JToggleButton();
        binarySearchToggle.setText("Binary Search");
        binarySearchToggle.addActionListener(e -> {
            if (binarySearchToggle.isSelected()) {
                resetAlgorithms();
                binarySearchToggle.setSelected(true);
            }
        });
        algoSelector.add(binarySearchToggle);

        linearSearchToggle = new JToggleButton();
        linearSearchToggle.setText("Linear Search");
        linearSearchToggle.addActionListener(e -> {
            if (linearSearchToggle.isSelected()) {
                resetAlgorithms();
                linearSearchToggle.setSelected(true);
            }
        });
        algoSelector.add(linearSearchToggle);

        runButton = new JButton("Run");
        runButton.addActionListener((e -> {
            if (singlyLinkedListToggle.isSelected() || arrayListToggle.isSelected() || doublyLinkedListToggle.isSelected()) {
                if (bubbleSortToggle.isSelected() || insertionSortToggle.isSelected() || binarySearchToggle.isSelected() || linearSearchToggle.isSelected()) {
                    if (singlyLinkedListToggle.isSelected()) {
                        if (bubbleSortToggle.isSelected()) {
                            stopWatch.start();
                            singly.bubbleSort(singly.getHead(), Comparator.comparing(VgSales::getName));
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            VgSalesLinkedList.Node<VgSales> current = singly.getHead();
                            while (current != null) {
                                results += current.getData().getRank() + " | " + current.getData().getName() + " | " + current.getData().getYear() + "\n";
                                current = current.getNext();
                            }
                            System.out.println(results);
                            setText(results);
                        }
                        if (insertionSortToggle.isSelected()) {
                            stopWatch.start();
                            singly.insertionSort(singly.getHead(), Comparator.comparing(VgSales::getYear));
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            VgSalesLinkedList.Node<VgSales> current = singly.getHead();
                            while (current != null) {
                                results += current.getData().getRank() + " | " + current.getData().getName() + " | " + current.getData().getYear() + "\n";
                                current = current.getNext();
                            }
                            System.out.println(results);
                            setText(results);
                        }
                        if (binarySearchToggle.isSelected()) {
                            stopWatch.start();
                            String result = singly.rBinarySearch(singly.getHead(), thingSold, 0, counter, Comparator.comparing(VgSales::getYear));
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            results += result;
                            setText(results);


                        }
                        if (linearSearchToggle.isSelected()) {
                            //todo
                            stopWatch.start();
                            String result = singly.rLinearSearch(singly.getHead(), thingSold);
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            results += result;
                            setText(results);

                        }
                    }
                    if (arrayListToggle.isSelected()) {
                        if (bubbleSortToggle.isSelected()) {
                            stopWatch.start();
                            array.bubbleSort(array, Comparator.comparing(VgSales::getName));
                            stopWatch.stop();

                            String results = "";
                            results += "Time passed: " + stopWatch.getElapsedTimeMillis() + " Milliseconds\n";
                            for (int i = 0; i < array.getSize(); i++) {
                                // Type casting here needs to be changed
                                VgSales vgsale = (VgSales) array.get(i);
                                results += vgsale.getRank() + " | " + vgsale.getName() + " | " + vgsale.getYear() + "\n";
                            }
                            System.out.println(results);
                            setText(results);
                        }
                        if (insertionSortToggle.isSelected()) {
                            stopWatch.start();
                            array.insertionSort(array, Comparator.comparing(VgSales::getYear));
                            stopWatch.stop();

                            String results = "";
                            results += "Time passed: " + stopWatch.getElapsedTimeMillis() + " Milliseconds\n";
                            for (int i = 0; i < array.getSize(); i++) {
                                // Type casting here needs to be changed
                                VgSales vgsale = (VgSales) array.get(i);
                                results += vgsale.getRank() + " | " + vgsale.getName() + " | " + vgsale.getYear() + "\n";
                            }
                            System.out.println(results);
                            setText(results);
                        }
                        if (binarySearchToggle.isSelected()) {
                            //todo
                            stopWatch.start();
                            String result = array.rBinarySearch(array, 0, counter, thingSold);
                            stopWatch.stop();

                            String results = "";
                            results += "Time passed: " + stopWatch.getElapsedTimeMillis() + " Milliseconds\n";
                            results += result;
                            setText(results);

                        }
                        if (linearSearchToggle.isSelected()) {
                            //todo

                            stopWatch.start();
                            String result = array.rLinearSearch(counter, array, thingSold);
                            stopWatch.stop();

                            String results = "";
                            results += "Time passed: " + stopWatch.getElapsedTimeMillis() + " Milliseconds\n";
                            results += result;
                            setText(results);
                        }
                    }
                    if (doublyLinkedListToggle.isSelected()) {
                        if (bubbleSortToggle.isSelected()) {
                            stopWatch.start();
                            doubly.bubbleSort(Comparator.comparing(VgSales::getYear));
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            DoublyLinkedListVgSales.Node<VgSales> current = doubly.getHead();
                            while (current != null) {
                                results += current.getData().getRank() + " | " + current.getData().getName() + " | " + current.getData().getYear() + "\n";
                                current = current.getNext();
                            }
                            setText(results);
                        }
                        if (insertionSortToggle.isSelected()) {
                            stopWatch.start();
                            doubly.insertionSort(Comparator.comparing(VgSales::getYear));
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            DoublyLinkedListVgSales.Node<VgSales> current = doubly.getHead();
                            while (current != null) {
                                results += current.getData().getRank() + " | " + current.getData().getName() + " | " + current.getData().getYear() + "\n";
                                current = current.getNext();
                            }
                            setText(results);
                        }
                        if (binarySearchToggle.isSelected()) {
                            stopWatch.start();
                            String result = doubly.rBinarySearch(doubly.getHead(), thingSold, 0, counter);
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            results += result;
                            setText(results);
                        }
                        if (linearSearchToggle.isSelected()) {
                            //todo
                            stopWatch.start();
                            String result = doubly.rLinearSearch(doubly.getHead(), thingSold);
                            stopWatch.stop();
                            String results = "";
                            results += "Time passed: " + (stopWatch.getElapsedTimeMillis()) + " Milliseconds \n";
                            results += result;

                            setText(results);
                        }
                    }
                }
            }

        }));
        algoSelector.add(runButton);
    }

    public Font getFont() {
        return new Font("Arial", 1, 24);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    private void resetLists() {
        singlyLinkedListToggle.setSelected(false);
        arrayListToggle.setSelected(false);
        doublyLinkedListToggle.setSelected(false);
    }

    private void resetAlgorithms() {
        bubbleSortToggle.setSelected(false);
        insertionSortToggle.setSelected(false);
        binarySearchToggle.setSelected(false);
        linearSearchToggle.setSelected(false);
    }

    public void setText(String results) {
        resultsBox.setText(results);
    }
}
