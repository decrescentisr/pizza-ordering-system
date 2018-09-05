import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import helpers.OutputHelpers;

public class Total extends JPanel
{
	
	private static final long serialVersionUID = -4677262900786953893L;
	public static JLabel lblTotal;
	public static JTextField txtTotal;
	public static JButton btnSummary;
	public static JLabel lblPrice;
	public static JButton btnTotal;

	private DecimalFormat df = new DecimalFormat("$#,##0.00");
	
	public Total()
	{
		super();
		createPanel();
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
		lblTotal = new JLabel();
		lblTotal.setText("Total: ");
		super.add(lblTotal, bag);
		
		bag.gridx = 1;
		bag.gridy = 0;
		lblPrice = new JLabel();
		super.add(lblPrice, bag);

		bag.gridx = 1;
		bag.gridy = 1;
		btnTotal = new JButton("Get Total");
		btnTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblPrice.setText(df.format(PizzaOrder.getOrderTotal()));
			}
		});
		super.add(btnTotal, bag);

		bag.gridx = 1;
		bag.gridy = 2;
		bag.weightx = 0;
		bag.weighty = 0;
		btnSummary = new JButton("Order Summary");
		btnSummary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StringBuilder order = new StringBuilder();
				order.append("Customer: " + CustomerInformation.txtName.getText() + "\n");
				order.append("Phone: " + CustomerInformation.txtPhoneNumber.getText() + "\n\n");
				if(PizzaSize.itemSmall.isSelected())
					order.append("Pizza: " + PizzaOrder.SMALL + " " + df.format(PizzaOrder.COST_SMALL) + "\n");
				if(PizzaSize.itemMedium.isSelected())
					order.append("Pizza: " + PizzaOrder.MEDIUM + " " + df.format(PizzaOrder.COST_MEDIUM) + "\n");
				if(PizzaSize.itemLarge.isSelected())
					order.append("Pizza: " + PizzaOrder.LARGE + " " + df.format(PizzaOrder.COST_LARGE) + "\n");

				order.append("Toppings: ");

				if(!Toppings.itemPepperoni.getState() && !Toppings.itemMushroom.getState() && !Toppings.itemSausage.getState() && !Toppings.itemSausage.getState())
					order.append("No Toppings");
				else {
					if (Toppings.itemPepperoni.getState())
						order.append(PizzaOrder.PEPPERONI + " ");
					if (Toppings.itemOnion.getState())
						order.append(PizzaOrder.ONION + " ");
					if (Toppings.itemSausage.getState())
						order.append(PizzaOrder.SAUSAGE + " ");
					if (Toppings.itemMushroom.getState())
						order.append(PizzaOrder.MUSHROOM + " ");
				}
				order.append("\n\n");
				order.append("TOTAL: " + df.format(PizzaOrder.getOrderTotal()));

				OutputHelpers.showStandardDialog(order.toString(),"Order Summary");
				}

			}
	);		
		super.add(btnSummary, bag);
	}
}
