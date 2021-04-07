package Project4;

import java.util.Objects;

/**
 * Each instance of this class is a representation of cake donut.
 * @author Haochen Ji, Yichen Chen
 */
public class CakeDonut extends MenuItem {
    private String flavor;
    public static final double BASED_PRICE = 1.59;

    /**
     * The constructor that takes the quantity of cake donut and the flavor.
     * @param quantity The quantity of cake donut
     * @param flavor The flavor of cake donut
     */
    public CakeDonut(int quantity, String flavor) {
        super(quantity, BASED_PRICE);
        this.flavor = flavor;
    }

    /**
     * Checking if two instance of cake donut that have the same quantity and flavor
     * @param o The instance to be checked
     * @return true if they have the same quantity and flavor; otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CakeDonut cakeDonut = (CakeDonut) o;
        return super.equals(o) && Objects.equals(flavor, cakeDonut.flavor);
    }

    /**
     * Returns a string representation of cake donut.
     * @return a string representation of cake donut.
     */
    @Override
    public String toString() {
        return super.toString() + " " + flavor + " flavor " + DonutController.CAKE_DONUT;
    }
}
