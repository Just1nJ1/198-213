package Project4;

import java.util.ArrayList;

/**
 * Each instance of this class is a representation of an order
 * @author Haochen Ji, Yichen Chen
 */
public class Order implements Customizable {
    private static int OrderNumber = 1;
    private ArrayList<MenuItem> contents;
    private int number;
    public static final double TAX_RATE = 0.06625;
    public static final int SUBORDER_NUMBER = -1;

    /**
     * The constructor that create an order object that has order number
     * or a sub order object that has -1 as order number
     * @param isSuborder true if it is a sub order; false if it is an order
     */
    public Order(boolean isSuborder){
        if (isSuborder)
            number = SUBORDER_NUMBER;
        else
            number = OrderNumber++;
        contents = new ArrayList<>();
    }

    /**
     * Getting the total price for this order
     * @return the total price for this order
     */
    public double getSumPrice(){
        double sum = 0;
        for (MenuItem mi : contents){
            sum += mi.itemPrice();
        }
        return sum;
    }

    /**
     * Getting the tax that computed by the total price * tax rate
     * @return the tax that computed by the total price * tax rate
     */
    public double getTax(){
        return getSumPrice()* TAX_RATE;
    }

    /**
     * Getting the order number
     * @return the order number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Getting the contents list
     * @return the contents list
     */
    public ArrayList<MenuItem> getContents(){
        return contents;
    }

    /**
     * Adding the obj into the contents list
     * @param obj if it is an instance of order, adding all contents from obj to contents list;
     *            if it is a menu item, adding it to contents list
     * @return true if it is added; otherwise false
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order){
            return contents.addAll(((Order) obj).contents);
        }
        if (obj instanceof MenuItem){
            return contents.add((MenuItem) obj);
        }
        return false;
    }

    /**
     * Removing the item from the contents list
     * @param obj the object to be removed
     * @return true if it is removed; otherwise false
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Integer){
            return contents.remove((int)obj) != null;
        }
        return contents.remove(obj);
    }

    /**
     * Checking if two instance of order has the same order number
     * @param obj The instance to be checked
     * @return true if they have the same order number; otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj instanceof Order && number == ((Order) obj).number);
    }

    /**
     * Returns a string representation of order.
     * @return a string representation of order.
     */
    @Override
    public String toString() {
        String str = "Order #" + number + ":\n";
        for (MenuItem mi : contents){
            str += mi.toString() + "\n";
        }
        str += String.format("Amount: $%.02f\n", getSumPrice() + getTax());
        return str;
    }
}
