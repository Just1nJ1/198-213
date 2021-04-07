package Project4;

import java.util.ArrayList;

/**
 * Each instance of this class is a representation of a history orders list
 * @author Haochen Ji, Yichen Chen
 */
public class StoreOrders implements Customizable {
    private ArrayList<Order> orders;

    /**
     * The constructor initializes the orders
     */
    public StoreOrders(){
        orders = new ArrayList<>();
    }

    /**
     * Adding order to the orders list
     * @param obj the order to be added
     * @return true if it is added; otherwise false
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order)
            return orders.add((Order)obj);
        return false;
    }

    /**
     * Removing the order from the orders list
     * @param obj the order to be removed
     * @return true if it is removed; otherwise false
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order)
            return orders.remove(obj);
        return false;
    }

    /**
     * Getting the orders list
     * @return the orders list
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }
}
