package Project1;

public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    public Library() {
        books = new Book[0];
    } //default constructor to create an empty bag

    private int find(Book book) {
        for (int i = 0; i < books.length; i ++){
            if (books[i] != null && book.equals(books[i])){ return i; }
        }
        return -1;
    } // helper method to find a book in the bag

    private void grow() {
        Book[] temp = new Book[books.length + 4];
        for (int i = 0; i < books.length; i ++){
            temp[i] = books[i];
        }
        books = temp;
    } // helper method to grow the capacity by 4

    public void add(Book book) {
        if (books.length == numBooks){ grow(); }
        books[numBooks++] = book;
    }

    public boolean remove(Book book) {
        int index = find(book);
        if (index == -1){ return false; }
        for (int i = index; i < books.length - 1; i ++){
            books[i] = books[i+1];
        }
        books[books.length - 1] = null;
        numBooks --;
        return true;
    }

    public boolean checkOut(Book book) {
        int index = find(book);
        if (index == -1){ return false; }
        if (books[index].isCheckedOut()){ return false; }
        books[index].setCheckedOut(true);
        return true;
    } //true if checking out is successful

    public boolean returns(Book book) {
        int index = find(book);
        if (index == -1){ return false; }
        if (!books[index].isCheckedOut()){ return false; }
        books[index].setCheckedOut(false);
        return true;
    }

    public void print() {
        System.out.println("**List of books in the library.");
        for (Book b : books){
            if(b != null) {
                System.out.println(b);
            }
        }
        System.out.println("**End of list");
    } //print the list of books in the bag

    public void printByDate() {
        for (int i = 0; i < numBooks; i++)
        {
            for (int j = i + 1; j < numBooks; j++) {
                if (books[i].getDatePublished().compareTo(books[j].getDatePublished()) > 0)
                {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("**List of books by the dates published.");
        for (Book b : books){
            if(b != null) {
                System.out.println(b);
            }
        }
        System.out.println("**End of list");
    } //print the list of books by datePublished (ascending)

    public void printByNumber() {
        for (int i = 0; i < numBooks; i++) {
            for (int j = i + 1; j < numBooks; j++) {
                if (books[i].getNumber().compareTo(books[j].getNumber()) > 0)
                {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("**List of books by the book numbers.");
        for (Book b : books){
            if(b != null) {
                System.out.println(b);
            }
        }
        System.out.println("**End of list");
    } //print the list of books by number (ascending)

    public int getNumBooks() {
        return numBooks;
    }
}