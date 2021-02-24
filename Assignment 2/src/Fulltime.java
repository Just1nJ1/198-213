package Project2;

/**
 * Includes specific data and operations to a full-time employee.
 * @author Haochen Ji, Yichen Chen
 */
public class Fulltime extends Employee {
    private static final double PAY_PERIODS = 26.0;
    private int annualSalary;

    /**
     * Constructs a full time employee instance with its profile.
     * @param p the profile of the employee
     * @param salary the annual salary of the employee
     */
    public Fulltime(Profile p, int salary) {
        super(p);
        annualSalary = salary;
    }

    /**
     * Returns a string representation of this full time employee.
     * @return a string representation of this full time employee
     */
    @Override
    public String toString() {
        return super.toString() + "::FULL TIME::Annual Salary $" + annualSalary;
    }

    /**
     * Checking if the obj is an instance of full time employee.
     * @param obj the employee to be checked
     * @return true if the obj is a full time employee instance
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fulltime;
    }

    /**
     * Calculating payment of this part time employee by certain equation.
     */
    @Override
    public void calculatePayment() {
        setPayment(annualSalary / PAY_PERIODS);
    }
}
