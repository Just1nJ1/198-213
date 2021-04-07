package Project4;

/**
 * A parent class for all items in the menu.
 * @author Haochen Ji, Yichen Chen
 */
public class MenuItem {

    private int quantity;
    private double price;

    public static final int EQUAL = 0;

    /**
     * The constructor that takes the quantity of the item and the price of the item
     * @param quantity the quantity of the item
     * @param price the price of the item
     */
    public MenuItem(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Getting the total price for this item
     * @return the total price for this item
     */
    public double itemPrice(){
        return quantity * price;
    }

    /**
     * Setting the unit price for the item
     * @param price the unit price for the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getting the unit price for the item
     * @return the unit price for the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Checking if two instances of menu item has the same quantity and unit price
     * @param o the instance to be checked
     * @return true if they have the same quantity and unit price; otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return quantity == menuItem.quantity &&
                Double.compare(menuItem.price, price) == EQUAL;
    }

    /**
     * Returns a string representation of menu item.
     * @return a string representation of menu item.
     */
    @Override
    public String toString() {
        return "Quantity: " + quantity;
    }
}
