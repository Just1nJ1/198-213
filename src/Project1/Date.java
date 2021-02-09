package Project1;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
(一句简介的话描述这个class的用途).
(几句话详细描述这个class是怎么运作的)
@author Haochen Ji, Yichen Chen
*/
public class Date implements Comparable<Date>{
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    private int year;
    private int month;
    private int day;
    
    /**
    (一句简介的话描述这个Method    taking mm/dd/yyyy and create a Project1.Date object).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    }

    /**
    (一句简介的话描述这个Method    create an object with today’s date (see Calendar class)).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public Date() {
        Calendar current = Calendar.getInstance();
        this.year = current.get(Calendar.YEAR);
        this.month = current.get(Calendar.MONTH);
        this.day = current.get(Calendar.DAY_OF_MONTH);
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
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
            case 2:
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

    @Override
    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public String toString() {
        return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
    }

    @Override
    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
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
