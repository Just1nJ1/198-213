package Project1;

/**
 * This class defines the ADT Library; an instance of Library can hold a list of book objects.
 * @author Haochen Ji, Yichen Chen
 */
public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag
    public static final int NOT_FOUND = -1;
    public static final int GROWTH_SIZE = 4;

    /**
     * Creates a Library instance with empty books.
     */
    public Library() {
        books = new Book[0];
        numBooks = 0;
    }

    /**
     * Finds the index of the book in this library.
     * @param book A book has same number with the target
     * @return The index of the target; NOT_FOUND if it is not found
     */
    private int find(Book book) {
        for (int i = 0; i < books.length; i ++){
            if (books[i] != null && book.equals(books[i])){ return i; }
        }
        return NOT_FOUND;
    }

    /**
     * Increases the size of the books by GROWTH_SIZE and move all books from previous.
     */
    private void grow() {
        Book[] temp = new Book[books.length + GROWTH_SIZE];
        for (int i = 0; i < books.length; i ++){
            temp[i] = books[i];
        }
        books = temp;
    }

    /**
     * Adds the book into this library.
     * @param book The book to be added
     */
    public void add(Book book) {
        if (books.length == numBooks){ grow(); }
        books[numBooks++] = book;
    }

    /**
     * Removes the book from this library.
     * @param book A book has same number with the target
     * @return true if it removes that book successfully; false otherwise
     */
    public boolean remove(Book book) {
        int index = find(book);
        if (index == NOT_FOUND){ return false; }
        for (int i = index; i < books.length - 1; i ++){
            books[i] = books[i+1];
        }
        books[books.length - 1] = null;
        numBooks --;
        return true;
    }

    /**
     * Checks out the book from this library.
     * @param book A book has same number with the target
     * @return true if it checks out that book successfully; false otherwise
     */
    public boolean checkOut(Book book) {
        int index = find(book);
        if (index == NOT_FOUND){ return false; }
        if (books[index].isCheckedOut()){ return false; }
        books[index].setCheckedOut(true);
        return true;
    }

    /**
     * Returns the book in this library.
     * @param book A book has same number with the target
     * @return true if it returns that book successfully; false otherwise
     */
    public boolean returns(Book book) {
        int index = find(book);
        if (index == NOT_FOUND){ return false; }
        if (!books[index].isCheckedOut()){ return false; }
        books[index].setCheckedOut(false);
        return true;
    }

    /**
     * Prints the list of books to the console with the current sequence.
     */
    public void print() {
        System.out.println("**List of books in the library.");
        for (Book b : books){
            if(b != null) {
                System.out.println(b);
            }
        }
        System.out.println("**End of list");
    }

    /**
     * Prints the list of books by the dates published in ascending order.
     */
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
    }

    /**
     * Prints the list of books by the book numbers in ascending order.
     */
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
    }

    /**
     * Gets how many books there are in this library.
     * @return The number of books this library has
     */
    public int getNumBooks() {
        return numBooks;
    }
}
