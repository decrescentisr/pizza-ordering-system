// This class holds all constants and the getOrderTotal method

public class PizzaOrder {
    public static final double COST_SMALL = 8.00;
    public static final double COST_MEDIUM = 10.00;
    public static final double COST_LARGE = 12.00;

    public static final String SMALL = "Small";
    public static final String MEDIUM = "Medium";
    public static final String LARGE = "Large";

    public static String NONE = "None";
    public static String SAUSAGE = "Sausage";
    public static String PEPPERONI = "Pepperoni";
    public static String MUSHROOM = "Mushroom";
    public static String ONION = "Onion";

    public static final double COST_SAUSAGE = 2.00;
    public static final double COST_PEPPERONI = 2.00;
    public static final double COST_MUSHROOM = 2.00;
    public static final double COST_ONION = 2.00;


    public static double getOrderTotal() {
        double total = 0;
        if(PizzaSize.itemSmall.isSelected()) {
            total += PizzaOrder.COST_SMALL;
        }
        else if(PizzaSize.itemMedium.isSelected()) {
            total += PizzaOrder.COST_MEDIUM;
        } else if(PizzaSize.itemLarge.isSelected()) {
            total += PizzaOrder.COST_LARGE;
        }

        if(Toppings.itemMushroom.getState())
            total += PizzaOrder.COST_MUSHROOM;
        if(Toppings.itemOnion.getState())
            total += PizzaOrder.COST_ONION;
        if(Toppings.itemPepperoni.getState())
            total += PizzaOrder.COST_PEPPERONI;
        if(Toppings.itemSausage.getState())
            total += PizzaOrder.COST_SAUSAGE;

        return total;
    }

}
