package Project4;

import java.util.Objects;

/**
 * Each instance of this class is a representation of yeast donut.
 * @author Haochen Ji, Yichen Chen
 */
public class YeastDonut extends MenuItem {
    private String flavor;
    public static final double BASED_PRICE = 1.39;

    /**
     * The constructor that takes the quantity of yeast donut and the flavor.
     * @param quantity The quantity of yeast donut
     * @param flavor The flavor of yeast donut
     */
    public YeastDonut(int quantity, String flavor) {
        super(quantity, BASED_PRICE);
        this.flavor = flavor;
    }

    /**
     * Checking if two instance of yeast donut that have the same quantity and flavor
     * @param o The instance to be checked
     * @return true if they have the same quantity and flavor; otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YeastDonut yeastDonut = (YeastDonut) o;
        return super.equals(o) && Objects.equals(flavor, yeastDonut.flavor);
    }

    /**
     * Returns a string representation of yeast donut.
     * @return a string representation of yeast donut.
     */
    @Override
    public String toString() {
        return super.toString() + " " + flavor + " flavor " + DonutController.YEAST_DONUT;
    }
}
