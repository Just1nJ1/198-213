package Project1;

/**
(一句简介的话描述这个class的用途).
(几句话详细描述这个class是怎么运作的)
@author Haochen Ji, Yichen Chen
*/
public class Book {
    private static int CurrentNumber = 10001;
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut; //set to true if the book has been checked out
    private Date datePublished;

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public Book(String name, Date date){
        this.number = Integer.toString(Book.CurrentNumber++);
        this.name = name;
        this.checkedOut = false;
        this.datePublished = date;
    }
    
    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public Book(String number){
        this.number = number;
    }
    
    @Override
    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public boolean equals(Object obj){
        if (obj instanceof Book){
            return this.number.equals(((Book) obj).number);
        }
        return false;
    }
    
    @Override
    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public String toString() {
        return "Book#" + number +
                "::" + name +
                "::" + datePublished +
                "::" + (!isCheckedOut() ? "is available" : "is checked out.");
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public boolean isCheckedOut() {
        return checkedOut;
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public Date getDatePublished() {
        return datePublished;
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public String getNumber() {
        return number;
    }
}
