package Project1;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * This class implements a Date object with year, month, and day.
 * @author Haochen Ji, Yichen Chen
*/
public class Date implements Comparable<Date>{
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int STARTING_YEAR = 1900;

    private int year;
    private int month;
    private int day;

    /**
     * Create a date instance with a string in the specified format: mm/dd/yyyy.
     * @param date The formatted string
     */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    }

    /**
     * Create a date instance with current time.
     * A temporary instance used for {@link Date#isValid()}
     */
    public Date() {
        Calendar current = Calendar.getInstance();
        this.year = current.get(Calendar.YEAR);
        this.month = current.get(Calendar.MONTH);
        this.day = current.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Checks whether this date is valid or not.
     * @return true if this date is valid; false otherwise.
     */
    public boolean isValid() {
        if (year < STARTING_YEAR) { return false; }
        Date present = new Date();
        if (year > present.year
        || (year == present.year && month > present.month)
        || (year == present.year && month == present.month && day > present.day)){
            return false;
        }
        switch (month - 1){
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                if (day > 31) { return false; }
                break;
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                if (day > 30) { return false; }
                break;
            case Calendar.FEBRUARY:
                boolean leap = false;
                if (year % Date.QUADRENNIAL == 0){
                    if (year % Date.CENTENNIAL == 0){
                        if (year % Date.QUATERCENTENNIAL == 0){
                            leap = true;
                        }
                    } else { leap = true; }
                }
                if (!leap && day > 28) { return false; }
                if (leap && day > 29) { return false; }
            default:
                return false;
        }
        return true;
    }

    /**
     * Returns a textual representation of the Date object.
     * @return the textual representation of the date
     */
    @Override
    public String toString() {
        return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
    }

    /**
     * Compares date instances.
     * First compare the years, then the months if the years are the same, and then the days if the months are the same.
     * @param date Another date for comparison
     * @return 0 if two dates are the same day; -1 if this date is earlier than param date; 1 otherwise
     */
    @Override
    public int compareTo(Date date) {
        if (year < date.year)  { return -1; }
        if (year > date.year)  { return  1; }
        if (month < date.month){ return -1; }
        if (month > date.month){ return  1; }
        if (day < date.day)    { return -1; }
        if (day > date.day)    { return  1; }
        return 0;
    }
    
    /**
     * Testbed main to exercise the methods in this class.
     *
     * @param arg command line arguments
     */
    public static void main(String arg[]) {
        //Testing the isValid() method
        //test case #1, test the wrong day in a date.
        System.out.println("running test case #1");
        Boolean result = new Date("2/29/2009").isValid();
        if(!result)
            System.out.println("test case #1, test the wrong day in a date. PASSED.");
        else
            System.out.println("test case #1, test the wrong day in a date. FAILED.");
        
        //Testing the isValid() method
        //test case #2, test the wrong month in a date.
        System.out.println("running test case #2");
        result = new Date("31/2/2000").isValid();
        if(!result)
            System.out.println("test case #2, test the wrong month in a date. PASSED.");
        else
            System.out.println("test case #2, test the wrong month in a date. FAILED.");
        
        //Testing the isValid() method
        //test case #3, test the year which is more than now in a date.
        System.out.println("running test case #3");
        result = new Date("10/30/2022").isValid();
        if(!result)
            System.out.println("test case #3, test the year which is more than now in a date. PASSED.");
        else
            System.out.println("test case #3, test the year which is more than now in a date. FAILED.");
        
        //Testing the isValid() method
        //test case #4, test the wrong day in a date.
        System.out.println("running test case #4");
        result = new Date("2/29/2001").isValid();
        if(!result)
            System.out.println("test case #4, test the wrong day in a date. PASSED.");
        else
            System.out.println("test case #4, test the wrong day in a date. FAILED.");
        
        //Testing the isValid() method
        //test case #5, test the correct day in leap year.
        System.out.println("running test case #5");
        result = new Date("2/29/2000").isValid();
        if(result)
            System.out.println("test case #5, test the correct day in leap year. PASSED.");
        else
            System.out.println("test case #5, test the correct day in leap year. FAILED.");
        
        //Testing the isValid() method
        //test case #6, test the correct date.
        System.out.println("running test case #6");
        result = new Date("3/31/2008").isValid();
        if(result)
            System.out.println("test case #6, test the correct date. PASSED.");
        else
            System.out.println("test case #6, test the correct date. FAILED.");
    }
}
