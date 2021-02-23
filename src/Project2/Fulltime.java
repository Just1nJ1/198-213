package Project2;

/**
 * Includes specific data and operations to a full-time employee.
 * @author Haochen Ji, Yichen Chen
 */
public class Fulltime extends Employee {
    private int annualSalary;

    public Fulltime(){}

    /**
     *
     * @param p
     * @param salary
     */
    public Fulltime(Profile p, int salary) {
        super(p);
        annualSalary = salary;
    }

    /**
     * Output a string.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "::FULL TIME::Annual Salary $" + annualSalary;
    }

    /**
     * Make comparation.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fulltime;
    }

    /**
     * Calculate payments.
     */
    @Override
    public void calculatePayment() {
        setPayment(annualSalary / 26.0);
    }
}
