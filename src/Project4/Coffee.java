package Project4;

import java.util.HashMap;

/**
 * Each instance of this class is a representation of coffee with specific information for coffee.
 * @author Haochen Ji, Yichen Chen
 */
public class Coffee extends MenuItem implements Customizable {
    public static final String CREAM = "Cream";
    public static final String SYRUP = "Syrup";
    public static final String MILK = "Milk";
    public static final String CARAMEL = "Caramel";
    public static final String WHIPPED_CREME = "Whipped Creme";

    public static final String VENTI = "Venti";
    public static final String GRANDE = "Grande";
    public static final String TALL = "Tall";
    public static final String SHORT = "Short";
    public static final int VENTI_NUM = 3;
    public static final int GRANDE_NUM = 2;
    public static final int TALL_NUM = 1;
    public static final int SHORT_NUM = 0;

    public static final double BASED_PRICE = 1.99;
    public static final double UPGRADE_PRICE = 0.5;
    public static final double ADD_INS_PRICE = 0.2;
    public static final int EMPTY = 0;
    public static final int NUMBER_INDEX = 0;
    public static final int ADD_INS_INDEX = 1;

    HashMap<String, Integer> add_ins;
    String type;

    /**
     * The constructor that takes the quantity of coffee and the size of coffee.
     * @param quantity The quantity of coffee
     * @param size The size of coffee
     */
    public Coffee(int quantity, int size) {
        super(quantity, BASED_PRICE + size * UPGRADE_PRICE);
        add_ins = new HashMap<>();
        add_ins.put(CREAM, EMPTY);
        add_ins.put(SYRUP, EMPTY);
        add_ins.put(MILK, EMPTY);
        add_ins.put(CARAMEL, EMPTY);
        add_ins.put(WHIPPED_CREME, EMPTY);
        switch (size){
            case SHORT_NUM:
                type = SHORT;
                break;
            case TALL_NUM:
                type = TALL;
                break;
            case GRANDE_NUM:
                type = GRANDE;
                break;
            case VENTI_NUM:
                type = VENTI;
                break;
            default:
        }
    }

    /**
     * Adding add-ins into this coffee
     * @param obj String representation of add-ins
     * @return true if it is added; otherwise false
     */
    @Override
    public boolean add(Object obj) {
        try {
            int count = Integer.parseInt(obj.toString().substring(NUMBER_INDEX, ADD_INS_INDEX));
            add_ins.merge(obj.toString().substring(ADD_INS_INDEX), count, Integer::sum);
            setPrice(getPrice() + count * ADD_INS_PRICE);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Removing add-ins from this coffee
     * @param obj String representation of add-ins
     * @return true if it is removed; otherwise false
     */
    @Override
    public boolean remove(Object obj) {
        try {
            add_ins.merge(obj.toString().substring(ADD_INS_INDEX),
                    -Integer.parseInt(obj.toString().substring(NUMBER_INDEX, ADD_INS_INDEX)),
                    Integer::sum);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of coffee.
     * @return a string representation of coffee.
     */
    @Override
    public String toString() {
        String str = super.toString() + " " + type + " size coffee";
        for (String s : add_ins.keySet()){
            if (add_ins.get(s) != EMPTY)
                str += " +" + s + ":" + add_ins.get(s);
        }
        return str;
    }
}
