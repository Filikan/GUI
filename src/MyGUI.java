import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGUI extends JFrame implements ActionListener {
    JFrame converterFrame;
    JPanel converterPanel;
    JTextField tempCelsius;
    JLabel celsiusLabel, fahrenheitLabel,kelvinLabel;
    JButton convertTemp;

    public MyGUI() {
        converterFrame = new JFrame("Temperature Converter");
        converterPanel = new JPanel();
        converterPanel.setLayout(new GridLayout(5, 20));

        addComponent();
        converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);

        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        converterFrame.pack();
        converterFrame.setVisible(true);
    }

    private void addComponent() {
        tempCelsius = new JTextField(2);
        celsiusLabel = new JLabel("Celsius", SwingConstants.LEFT);
        convertTemp = new JButton("Convert...");
        fahrenheitLabel = new JLabel("Fahrenheit", SwingConstants.LEFT);
        kelvinLabel = new JLabel("Kelvin",SwingConstants.LEFT);
        //this.setSize(800,800);

        convertTemp.addActionListener(this);

        converterPanel.add(tempCelsius);
        converterPanel.add(celsiusLabel);
        converterPanel.add(convertTemp);
        converterPanel.add(fahrenheitLabel);
        converterPanel.add(kelvinLabel);

        celsiusLabel.setBorder(BorderFactory.createEmptyBorder(25, 25, 5, 250));
        fahrenheitLabel.setBorder(BorderFactory.createEmptyBorder(25, 25, 5, 250));
        kelvinLabel.setBorder(BorderFactory.createEmptyBorder(25,25,5,250));
    }

    public void actionPerformed(ActionEvent event) {
        int tempFahr = (int) ((Double.parseDouble(tempCelsius.getText())) * 1.8 + 32);
        fahrenheitLabel.setText(tempFahr + " Fahrenheit");

        int tempKel = (int) ((Double.parseDouble(tempCelsius.getText()))+273.15);
        kelvinLabel.setText(tempKel + " Kelvin");
    }

    public static void main(String[] args){
        new MyGUI();
    }

}
