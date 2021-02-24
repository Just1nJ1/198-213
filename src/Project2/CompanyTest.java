package Project2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for Company class
 * @author Haochen Ji, Yichen Chen
 */
class CompanyTest {
    /**
     * Testing add function in Company.
     */
    @Test
    void add() {
        Company cp = new Company();
        Employee e1 = new Parttime(new Profile("emp1", "CS", new Date("1/1/2020")), 20f);
        assertTrue(cp.add(e1));     // Test case 1: Adding an employee
        assertFalse(cp.add(e1));    // Test case 2: Adding an existing employee
        Employee e2 = new Parttime(new Profile("emp1", "CS", new Date("1/2/2020")), 20f);
        Employee e3 = new Parttime(new Profile("emp1", "CS", new Date("1/3/2020")), 20f);
        Employee e4 = new Parttime(new Profile("emp1", "CS", new Date("1/4/2020")), 20f);
        Employee e5 = new Parttime(new Profile("emp1", "CS", new Date("1/5/2020")), 20f);
        cp.add(e2);
        cp.add(e3);
        cp.add(e4);
        assertTrue(cp.add(e5));     // Test case 3: Adding when the array is full
    }

    /**
     * Testing remove function in Company.
     */
    @Test
    void remove() {
        Company cp = new Company();
        Employee e1 = new Parttime(new Profile("emp1", "CS", new Date("1/1/2020")), 20f);
        Employee e2 = new Parttime(new Profile("emp1", "CS", new Date("1/2/2020")), 20f);
        cp.add(e1);
        assertFalse(cp.remove(e2)); // Test case 4: Removing an employee that doesn't in the array
        assertTrue(cp.remove(e1));  // Test case 5: Removing an existing employee
        assertFalse(cp.remove(e1)); // Test case 6: Removing a removed employee
    }

    /**
     * Testing setHours function in Company.
     */
    @Test
    void setHours() {
        Company cp = new Company();
        Employee e1 = new Parttime(new Profile("emp1", "CS", new Date("1/1/2020")), 20f);
        Employee e2 = new Parttime(new Profile("emp1", "CS", new Date("1/1/2020")), 10);
        assertFalse(cp.setHours(e1));   // Test case 7: Setting hours for a not existing employee
        cp.add(e1);
        assertTrue(cp.setHours(e2));   // Test case 8: Setting hours by an employee with hours
    }
}