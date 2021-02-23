package Project2;

/**
 * (...)
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
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "::FULL TIME::Annual Salary $" + annualSalary;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fulltime;
    }

    /**
     *
     */
    @Override
    public void calculatePayment() {
        setPayment(annualSalary / 26.0);
    }
}
