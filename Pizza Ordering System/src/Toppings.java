import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toppings extends JPanel
{
	public static Checkbox itemPepperoni;
	public static Checkbox itemSausage;
	public static Checkbox itemMushroom;
	public static Checkbox itemOnion;
	public static JLabel lblDirections;

	private DecimalFormat df = new DecimalFormat("$#,##0.00");

	public Toppings()
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
		bag.gridwidth = 2;
		lblDirections = new JLabel("Choose Your Toppings");
		lblDirections.setFont(new Font("Arial", Font.BOLD, 12));
		lblDirections.setForeground(Color.BLUE);
		this.add(lblDirections, bag);
		
				
		bag.gridx = 0;
		bag.gridy = 1;
		bag.weightx = 0;
		bag.weighty = 0;
		itemPepperoni = new Checkbox(PizzaOrder.PEPPERONI + ": " + df.format(PizzaOrder.COST_PEPPERONI));

		super.add(itemPepperoni, bag);
		
		bag.gridx = 0;
		bag.gridy = 2;
		bag.weightx = 0;
		bag.weighty = 0;
		itemSausage = new Checkbox(PizzaOrder.SAUSAGE + ": " + df.format(PizzaOrder.COST_SAUSAGE));
		super.add(itemSausage, bag);
		
		bag.gridx = 0;
		bag.gridy = 3;
		bag.weightx = 0;
		bag.weighty = 0;
		itemMushroom = new Checkbox(PizzaOrder.MUSHROOM + ": " + df.format(PizzaOrder.COST_MUSHROOM));
		super.add(itemMushroom, bag);
		
		bag.gridx = 0;
		bag.gridy = 4;
		bag.weightx = 0;
		bag.weighty = 0;
		itemOnion = new Checkbox(PizzaOrder.ONION + ": " + df.format(PizzaOrder.COST_ONION));
		super.add(itemOnion, bag);
	}

}

