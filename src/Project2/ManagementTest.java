package Project2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for Management class
 * @author Haochen Ji, Yichen Chen
 */
class ManagementTest {
    /**
     * Testing calculate function in Company.
     */
    @Test
    void calculatePayment() {
        Company cp = new Company();
        Employee e1 = new Management(
                new Profile("emp1","CS", new Date("1/1/2020")),
                85000, 1);
        Employee e2 = new Management(
                new Profile("emp1", "CS", new Date("1/2/2020")),
                75000, 2);
        Employee e3 = new Management(
                new Profile("emp1", "CS", new Date("1/3/2020")),
                66000, 3);
        cp.add(e1);
        cp.add(e2);
        cp.add(e3);
        assertEquals(e1.getPayment(), 0);   // Test 9: Checking the number before calculatePayment is called
        cp.processPayments();

        // Test 10: Comparing the result after calculatePayment is called within 2 decimal places.
        assertEquals(Math.round(e1.getPayment()*100)*0.01, Math.round(100*(85000+5000)/26.0)*0.01);
        assertEquals(Math.round(e2.getPayment()*100)*0.01, Math.round(100*(75000+9500)/26.0)*0.01);
        assertEquals(Math.round(e3.getPayment()*100)*0.01, Math.round(100*(66000+12000)/26.0)*0.01);
    }
}