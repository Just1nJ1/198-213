package Project1;

/**
 * The Book class is used to represent each Book with a name, unique number, and publication date.
 * @author Haochen Ji, Yichen Chen
*/
public class Book {
    private static int currentNumber = 10001;
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut; //set to true if the book has been checked out
    private Date datePublished;

    /**
     * Create a book instance with the specified name and publication date.
     * @param name The book's name
     * @param date The book's publication date
    */
    public Book(String name, Date date){
        this.number = Integer.toString(Book.currentNumber++);
        this.name = name;
        this.checkedOut = false;
        this.datePublished = date;
    }
    
    /**
     * Create a book instance with its specific serial number.
     * A temporary instance used for {@link Library#find(Book)}
     * @param number The number of a particular book
    */
    public Book(String number){
        this.number = number;
    }

    /**
     * Compares 2 book instances by comparing their number.
     * @param obj Another book for comparison
     * @return true if the other book's number is equal to this book's number
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Book){
            return this.number.equals(((Book) obj).number);
        }
        return false;
    }

    /**
     * Returns a textual representation of the Book object.
     * @return the string representation of this instance
     */
    @Override
    public String toString() {
        return "Book#" + number +
                "::" + name +
                "::" + datePublished +
                "::" + (!isCheckedOut() ? "is available" : "is checked out.");
    }

    /**
     * Checks if the book has already been checked out.
     * @return Current checkedOut flag
     */
    public boolean isCheckedOut() {
        return checkedOut;
    }

    /**
     * Sets the checkedOut flag to a given status, true or false.
     * @param checkedOut Change checkedOut flag
     */
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    /**
     * Returns the publish date of the book.
     * @return This book's publication date
     */
    public Date getDatePublished() {
        return datePublished;
    }

    /**
     * Returns the book number.
     * @return This book's number
     */
    public String getNumber() {
        return number;
    }
}
