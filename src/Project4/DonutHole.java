package Project4;

import java.util.Objects;

/**
 * Each instance of this class is a representation of donut hole.
 * @author Haochen Ji, Yichen Chen
 */
public class DonutHole extends MenuItem {
    private String flavor;
    public static final double BASED_PRICE = 0.33;

    /**
     * The constructor that takes the quantity of donut hole and the flavor.
     * @param quantity the quantity of donut hole
     * @param flavor the flavor of donut hole
     */
    public DonutHole(int quantity, String flavor) {
        super(quantity, BASED_PRICE);
        this.flavor = flavor;
    }

    /**
     * Checking if two instance of donut hole that have the same quantity and flavor
     * @param o the instance to be checked
     * @return true if they have the same quantity and flavor; otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonutHole donutHole = (DonutHole) o;
        return super.equals(o) && Objects.equals(flavor, donutHole.flavor);
    }

    /**
     * Returns a string representation of donut hole.
     * @return a string representation of donut hole.
     */
    @Override
    public String toString() {
        return super.toString() + " " + flavor + " flavor " + DonutController.DONUT_HOLE;
    }
}
