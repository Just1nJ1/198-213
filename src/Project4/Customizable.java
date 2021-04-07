package Project4;

/**
 * The interface for customizable objects that has add and remove function
 * @author Haochen Ji, Yichen Chen
 */
public interface Customizable {
    /**
     * Adding an object
     * @param obj the object
     * @return true if obj is added; otherwise false
     */
    boolean add(Object obj);

    /**
     * Removing an object
     * @param obj the object
     * @return true if obj is removed; otherwise false
     */
    boolean remove(Object obj);
}