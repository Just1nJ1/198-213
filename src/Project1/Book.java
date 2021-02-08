package Project1;

public class Book {
    private static int CurrentNumber = 10001;
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut; //set to true if the book has been checked out
    private Date datePublished;

    public Book(String name, Date date){
        this.number = Integer.toString(Book.CurrentNumber++);
        this.name = name;
        this.checkedOut = false;
        this.datePublished = date;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Book){
            return this.number.equals(((Book) obj).number);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book#" + number + "::" + name + "::" + datePublished;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public String getNumber() {
        return number;
    }
}