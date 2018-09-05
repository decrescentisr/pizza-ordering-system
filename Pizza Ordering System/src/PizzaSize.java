import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.*;

public class PizzaSize extends JPanel
{

	public static JRadioButton itemSmall;
	public static JRadioButton itemMedium;
	public static JRadioButton itemLarge;
	public static JLabel lblDirections;
	

	private DecimalFormat df = new DecimalFormat("$#,###.00");
	
	public PizzaSize()
	{
		super();
		createPanel();
		
	}
	
	private void createPanel() {
		super.setLayout(new GridBagLayout());
		GridBagConstraints bag = new GridBagConstraints();

		
		bag.fill = GridBagConstraints.BOTH;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
		bag.gridx = 0;
		bag.gridy = 0;
		bag.gridwidth = 3;
		lblDirections = new JLabel("What size pizza?");
		lblDirections.setFont(new Font("Arial", Font.BOLD, 12));
		lblDirections.setForeground(Color.BLUE);
		this.add(lblDirections, bag);
		
				
		bag.gridx = 1;
		bag.gridy = 1;
		bag.weightx = 0;
		bag.weighty = 0;
		itemSmall = new JRadioButton(PizzaOrder.SMALL + ": " + df.format(PizzaOrder.COST_SMALL));
		super.add(itemSmall, bag);

		bag.gridx = 1;
		bag.gridy = 2;
		bag.weightx = 0;
		bag.weighty = 0;
		itemMedium = new JRadioButton(PizzaOrder.MEDIUM + ": " + df.format(PizzaOrder.COST_MEDIUM));
		super.add(itemMedium, bag);
		
		bag.gridx = 1;
		bag.gridy = 3;
		bag.weightx = 0;
		bag.weighty = 0;
		itemLarge = new JRadioButton(PizzaOrder.LARGE + ": " + df.format(PizzaOrder.COST_LARGE));
		super.add(itemLarge, bag);

		ButtonGroup groupPizzaSizes = new ButtonGroup();
		groupPizzaSizes.add(itemSmall);
		groupPizzaSizes.add(itemMedium);
		groupPizzaSizes.add(itemLarge);
		
	}
}
