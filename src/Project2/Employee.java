package Project2;

/**
 * Defines the common data and operations for all employee type.
 * @author Haochen Ji, Yichen Chen
 */
public class Employee {
    private Profile profile;
    private double payment;

    /**
     *
     */
    public Employee(){}

    /**
     *
     * @param p
     */
    public Employee(Profile p){ profile = p; }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Profile getProfile(){ return profile; }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return profile.toString() + "::Payment $" + String.format("%.2f", payment);
    }

    /**
     * Make comparing.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee;
    }

    /**
     * Calculate payments.
     */
    public void calculatePayment(){

    }
}
