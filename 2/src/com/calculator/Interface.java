package com.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fowafolo
 * Date: 16/4/16
 * Time: 15:30
 */
public class Interface extends JFrame implements ActionListener {
    JLabel minuteLabel, totalCountLabel, historyFeeLabel, payWayLabel, accountLabel, passwordLabel;
    JTextField minuteText, totalCountText, historyText, accountText, passwordText;
    JButton calculateButton;
    JComboBox comboBox;


    Interface(){
        setSize(600,400);
        setLayout(null);
        addComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//In the middle
        calculateButton.addActionListener(this);
        setVisible(true);
    }

    /**
     * UI Components
     */
    private void addComponents(){
        minuteLabel = new JLabel("本月通话分钟数");
        minuteLabel.setBounds(100, 50, 100, 20);
        this.add(minuteLabel);

        totalCountLabel = new JLabel("本年度至本月未缴费次数");
        totalCountLabel.setBounds(100, 100, 150, 20);
        this.add(totalCountLabel);

        historyFeeLabel = new JLabel("跨年度未交费用");
        historyFeeLabel.setBounds(100, 150, 100, 20);
        this.add(historyFeeLabel);

        payWayLabel = new JLabel("请选择支付方式");
        payWayLabel.setBounds(100, 200, 100, 20);
        this.add(payWayLabel);

        minuteText = new JTextField(100);
        minuteText.setBounds(250, 50, 200, 20);
        this.add(minuteText);

        totalCountText = new JTextField(100);
        totalCountText.setBounds(250, 100, 200, 20);
        this.add(totalCountText);

        historyText = new JTextField(100);
        historyText.setBounds(250, 150, 200, 20);
        this.add(historyText);

        comboBox=new JComboBox();
        comboBox.addItem("支付宝");
        comboBox.addItem("银行卡");
        comboBox.setBounds(250, 200, 100, 20);
        this.add(comboBox);

        accountLabel = new JLabel("卡号:");
        accountLabel.setBounds(250, 230, 50, 20);
        this.add(accountLabel);

        accountText = new JTextField(100);
        accountText.setBounds(300, 230, 150, 20);
        this.add(accountText);

        passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(250, 260, 50, 20);
        this.add(passwordLabel);

        passwordText = new JTextField(100);
        passwordText.setBounds(300, 260, 150, 20);
        this.add(passwordText);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(250,300,70,40);
        this.add(calculateButton);
    }

    /**
     * Submit Button
     */
    private void calculateButtonClicked()
    {
        String payWay = comboBox.getSelectedItem().toString();
        if (accountText.getText().isEmpty() || passwordText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid password or account Id");
        }else {
            if (isNumeric(minuteText.getText()) && isNumeric(totalCountText.getText())
                    && isNumeric(historyText.getText())) {
                int total = Integer.parseInt(totalCountText.getText());
                double minute = Double.valueOf(minuteText.getText().toString());
                double history = Double.valueOf(historyText.getText());
                Bill bill = Calculate.getAmount(new Bill(minute, history, total));
                bill.setPayWay(payWay);
                String password = passwordText.getText();
                String account = passwordText.getText();
                if (PaySystem.getPayStatus(bill, account, password)) {
                    JOptionPane.showMessageDialog(this, "You have successfully paid : \n" + bill.getActualAmount() + "\n by\n" + bill.getPayWay()+
                    "\nWith Account: "+account);
                }else {
                    JOptionPane.showMessageDialog(this, "Timeout, please try again!");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Please input valid numbers!");
            }
        }
    }

    /**
     * Test Button
     */
    public void actionPerformed(ActionEvent arg0){
        if (arg0.getActionCommand()=="Calculate") {
            calculateButtonClicked();
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
