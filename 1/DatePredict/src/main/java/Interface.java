import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by caopeng on 16/3/19.
 */
public class Interface extends JFrame implements ActionListener {
    JLabel inputLabel, outputLabel;
    JLabel splitLine,splitLine2;
    JButton submitButton;
    JTextField yearText, monthText, dayText;
    JTextField outputText;
    JButton testButton;
    JLabel testLabel;

    Interface(){
        setSize(300,200);
        setLayout(null);
        addComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//In the middle
        submitButton.addActionListener(this);
        testButton.addActionListener(this);
        setVisible(true);
    }

    /**
     * UI Components
     */
    private void addComponents(){
        inputLabel = new JLabel("Input:");
        inputLabel.setBounds(20,20,70,20);
        this.add(inputLabel);
        splitLine = new JLabel("/");
        splitLine2 = new JLabel("/");
        yearText = new JTextField(4);
        yearText.setBounds(100,20,50,20);
        this.add(yearText);
        splitLine.setBounds(152,20,10,20);
        this.add(splitLine);
        monthText = new JTextField(2);
        monthText.setBounds(164,20,30,20);
        this.add(monthText);
        splitLine2.setBounds(196,20,10,20);
        this.add(splitLine2);
        dayText = new JTextField(2);
        dayText.setBounds(208,20,30,20);
        this.add(dayText);
        submitButton = new JButton("Submit");
        submitButton.setBounds(110,60,70,20);
        this.add(submitButton);

        outputLabel = new JLabel("the Next Day:");
        outputLabel.setBounds(20,90,100,20);
        this.add(outputLabel);
        outputText = new JTextField(10);
        outputText.setEditable(false);
        outputText.setBounds(110,90,120,20);
        this.add(outputText);

        testButton = new JButton("Test");
        testButton.setBounds(110,120,70,20);
        this.add(testButton);
        testLabel = new JLabel("Data from .xls file");
        testLabel.setBounds(110,140,200,20);
        this.add(testLabel);
    }

    /**
     * Submit Button
     */
    private void submitButtonClicked()
    {
        Predict predict = new Predict();
        String yearString = yearText.getText();
        String monthString = monthText.getText();
        String dayString = dayText.getText();
        if(isNumeric(yearString) && isNumeric(monthString) && isNumeric(dayString))
        {
            int year = Integer.parseInt(yearString);
            int month = Integer.parseInt(monthString);
            int day = Integer.parseInt(dayString);
            String result = predict.predictTheNextDay(year,month,day);
            if(result.equals("false"))
            {
                JOptionPane.showMessageDialog(this,"Please Input Again!","Input Error!",JOptionPane.ERROR_MESSAGE);
            }else {
                outputText.setText(result);
                yearText.setText("");
                monthText.setText("");
                dayText.setText("");
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Please Input Again!","Input Error!",JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Test Button
     */
    private void testButtonClicked()
    {

    }

    public void actionPerformed(ActionEvent arg0){
        if (arg0.getActionCommand()=="Test")
        {
            testButtonClicked();
        }else if (arg0.getActionCommand()=="Submit")
        {
            submitButtonClicked();
        }
    }

    /**
     * Judge Util
     * @param string Str to be judged
     * @return Judge Result
     */
    private boolean isNumeric(String string){
        if (string.length()==0)
            return false;
        for(int i =0;i<string.length();i++){
            if(!Character.isDigit(string.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
