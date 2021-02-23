package Project2;

/**
 * (...)
 * @author Haochen Ji, Yichen Chen
 */
public class Fulltime extends Employee {
    private int annualSalary;

    public Fulltime(){}

    public Fulltime(Profile p, int salary) {
        super(p);
        annualSalary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "::FULL TIME::Annual Salary $" + annualSalary;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fulltime;
    }

    @Override
    public void calculatePayment() {
        setPayment(annualSalary / 26.0);
    }
}
