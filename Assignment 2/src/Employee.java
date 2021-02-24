package Project2;

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

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

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
