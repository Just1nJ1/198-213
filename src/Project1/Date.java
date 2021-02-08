package Project1;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date>{
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    private int year;
    private int month;
    private int day;
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    } //taking mm/dd/yyyy and create a Project1.Date object

    public Date() {
        Calendar current = Calendar.getInstance();
        this.year = current.get(Calendar.YEAR);
        this.month = current.get(Calendar.MONTH);
        this.day = current.get(Calendar.DAY_OF_MONTH);
    } //create an object with today’s date (see Calendar class)

    public boolean isValid() {
        if (year < 1900) { return false; }
        Date present = new Date();
        if (year > present.year
        || (year == present.year && month > present.month)
        || (year == present.year && month == present.month && day > present.day)){
            return false;
        }
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) { return false; }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) { return false; }
                break;
            default:
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
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
    }

    @Override
    public int compareTo(Date o) {
        if (year < o.year)  { return -1; }
        if (year > o.year)  { return  1; }
        if (month < o.month){ return -1; }
        if (month > o.month){ return  1; }
        if (day < o.day)    { return -1; }
        if (day > o.day)    { return  1; }
        return 0;
    }
}