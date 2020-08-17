
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Julie Greger 
 * Homework 4 - Dog Groomer
 */
//constructs the frame
public class DogGroomingChoice extends JFrame {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 320;

    private JLabel startingPriceLabel;
    private JLabel totalLabel;
    private JLabel priceLabel;
    private JComboBox breedComboBox;
    private JRadioButton washAndBrushButton;
    private JRadioButton washAndHaircutButton;
    private JRadioButton deluxeWashButton;
    private JCheckBox nailTrimBox;
    private JCheckBox fleaDipBox;
    private JCheckBox teethBrushedBox;
    private final ActionListener listener;

//doggroomingchoice constructor   
    public DogGroomingChoice() {
        listener = new ChoiceListener();
        createControlPanel();
        setGroomingPrice();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
//listener for all components

    class ChoiceListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            setGroomingPrice();
        }
    }
//create control panel 

    private void createControlPanel() {
        JPanel breedComboBox = createComboBox();
        JPanel extrasGroupPanel = createCheckBoxes();
        JPanel groomingGroupPanel = createRadioButtons();

        totalLabel = new JLabel("Cost of Grooming");
        priceLabel = new JLabel();

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 1));
        controlPanel.add(breedComboBox);
        controlPanel.add(groomingGroupPanel);
        controlPanel.add(extrasGroupPanel);
        controlPanel.add(totalLabel);
        controlPanel.add(priceLabel);
        add(controlPanel, BorderLayout.NORTH);
    }
//panel with create combo box

    public JPanel createComboBox() {

//label with base cost for grooming       
        startingPriceLabel = new JLabel("WASH & BRUSH PRICES:  "
                + "***  Chihuahua $20  ***  Labrador Retriever $35  ***  Poodle $40   "
                + "***  Pug $25   ***  Siberian Husky $35  ***");
//populate combo box       
        breedComboBox = new JComboBox();
        breedComboBox.addItem("Chihuahua");
        breedComboBox.addItem("Labrador Retriever");
        breedComboBox.addItem("Poodle");
        breedComboBox.addItem("Pug");
        breedComboBox.addItem("Siberian Husky");
        breedComboBox.addActionListener(listener);
//add lable and combo box to panel
        JPanel panel = new JPanel();
        panel.add(startingPriceLabel);
        panel.add(breedComboBox);
        return panel;
    }
//creates radio button panel

    public JPanel createRadioButtons() {
        washAndBrushButton = new JRadioButton("Wash & Brush");
        washAndBrushButton.addActionListener(listener);
//create default selection        
        washAndBrushButton.setSelected(true);

        washAndHaircutButton = new JRadioButton("Wash, Brush & Haircut - add $20");
        washAndHaircutButton.addActionListener(listener);

        deluxeWashButton = new JRadioButton("Bubble Bath, Brush, Haircut, Fluff Dry & Bandana - add $35");
        deluxeWashButton.addActionListener(listener);

//create button group
        ButtonGroup groomGroup = new ButtonGroup();
        groomGroup.add(washAndBrushButton);
        groomGroup.add(washAndHaircutButton);
        groomGroup.add(deluxeWashButton);
//add rado buttons to panel
        JPanel panel = new JPanel();
        panel.add(washAndBrushButton);
        panel.add(washAndHaircutButton);
        panel.add(deluxeWashButton);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Choose one:"));
        return panel;
    }
//create panel for check boxes

    public JPanel createCheckBoxes() {
        nailTrimBox = new JCheckBox("Nail Trim - add $10");
        nailTrimBox.addActionListener(listener);
        fleaDipBox = new JCheckBox("Flea Dip - add $8");
        fleaDipBox.addActionListener(listener);
        teethBrushedBox = new JCheckBox("Teeth Brushed - add $12");
        teethBrushedBox.addActionListener(listener);
//add check boxes to panel
        JPanel panel = new JPanel();
        panel.add(nailTrimBox);
        panel.add(fleaDipBox);
        panel.add(teethBrushedBox);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Choose extras:"));
        return panel;
    }
//method to calculate total price

    public void setGroomingPrice() {
        int groomChoice = 0;
        final int CHIHUAHUA_WASHANDBRUSH = 20;
        final int LABRADOR_WASHANDBRUSH = 35;
        final int POODLE_WASHANDBRUSH = 40;
        final int PUG_WASHANDBRUSH = 25;
        final int SIBHUSKY_WASHANDBRUSH = 35;
        final int PLUS_HAIRCUT = 20;
        final int PLUS_DELUXE = 35;
        final int NAIL_TRIM = 10;
        final int FLEA_DIP = 8;
        final int TEETH_BRUSHED = 12;

        String breed = (String) breedComboBox.getSelectedItem();
        int extraCost = 0;

        if (breed.equals("Chihuahua")) {
            groomChoice = CHIHUAHUA_WASHANDBRUSH;
        } else if (breed.equals("Labrador Retriever")) {
            groomChoice = LABRADOR_WASHANDBRUSH;
        } else if (breed.equals("Poodle")) {
            groomChoice = POODLE_WASHANDBRUSH;
        } else if (breed.equals("Pug")) {
            groomChoice = PUG_WASHANDBRUSH;
        } else if (breed.equals("Siberian Husky")) {
            groomChoice = SIBHUSKY_WASHANDBRUSH;
        }
        if (washAndHaircutButton.isSelected()) {
            extraCost += PLUS_HAIRCUT;
        } else {
            extraCost += 0;
        }
        if (deluxeWashButton.isSelected()) {
            extraCost += PLUS_DELUXE;
        } else {
            extraCost += 0;
        }

        if (nailTrimBox.isSelected()) {
            extraCost += NAIL_TRIM;
        } else {
            extraCost += 0;
        }
        if (fleaDipBox.isSelected()) {
            extraCost += FLEA_DIP;
        } else {
            extraCost += 0;
        }
        if (teethBrushedBox.isSelected()) {
            extraCost += TEETH_BRUSHED;
        } else {
            extraCost += 0;
        }
        int groomingPrice = extraCost + groomChoice;
        priceLabel.setText(Integer.toString(groomingPrice));
        priceLabel.repaint();

    }
}
