import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import helpers.FileHelpers;
import helpers.InputHelpers;
import helpers.OutputHelpers;

public class CustomerInformation extends JPanel 
{
	public static JLabel lblName;
	public static JTextField txtName;
	public static JLabel lblPhoneNumber;
	public static JTextField txtPhoneNumber;
	public static JLabel lblDirections;

	
	
	
	
	public CustomerInformation()
	{
		super();
		createPanel();
	}
	
	public void clear()
	{
		txtName.setText("");
		txtPhoneNumber.setText("");
	}
	
	private void createPanel()
	{
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();
		
		bag.fill = GridBagConstraints.BOTH;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
		bag.gridx = 0;
		bag.gridy = 0;
		bag.gridwidth = 2;
		lblDirections = new JLabel("Welcome to Java Pizza");
		lblDirections.setFont(new Font("Arial", Font.BOLD, 12));
		lblDirections.setForeground(Color.BLUE);
		this.add(lblDirections, bag);
		
		bag.gridx = 0;
		bag.gridy = 1;
		lblName = new JLabel();
		lblName.setText("Name: ");
		super.add(lblName, bag);
		
		bag.gridx = 0;
		bag.gridy = 2;
		txtName = new JTextField(20);
		super.add(txtName, bag);
		
		bag.gridx = 0;
		bag.gridy = 3;
		lblPhoneNumber = new JLabel();
		lblPhoneNumber.setText("Phone Number: ");
		super.add(lblPhoneNumber, bag);
		
		bag.gridx = 0;
		bag.gridy = 4;
		txtPhoneNumber = new JTextField(20);
		super.add(txtPhoneNumber, bag);
				
		

	}
	
}