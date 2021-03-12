package Project3;

/**
 * Defines the common data and operations for all employee type.
 * @author Haochen Ji, Yichen Chen
 */
public class Employee {
    private Profile profile;
    private double payment;

    /**
     * Constructs an employee instance with its profile.
     * @param p the profile of the employee
     */
    public Employee(Profile p){ profile = p; }

    /**
     * Gets employee's current payment.
     * @return employee's current payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Sets employee's payment
     * @param payment payment to be sat
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * Gets employee's profile
     * @return employee's profile
     */
    public Profile getProfile(){ return profile; }

    /**
     * Returns a string representation of this employee.
     * @return a string representation of this employee
     */
    @Override
    public String toString() {
        return profile.toString() + "::Payment $" + String.format("%.2f", payment);
    }

    /**
     * Checking if the obj is an instance of employee.
     * @param obj the employee to be checked
     * @return true if the obj is an employee instance
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee;
    }

    /**
     * Calculating payment of this part time employee by certain equation.
     * It is empty for this class, but it is implements in subclasses.
     */
    public void calculatePayment(){ }
}
