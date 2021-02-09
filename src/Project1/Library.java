package Project1;

/**
(一句简介的话描述这个class的用途).
(几句话详细描述这个class是怎么运作的)
@author Haochen Ji, Yichen Chen
*/
public class Library {
    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    /**
    (一句简介的话描述这个Method    default constructor to create an empty bag).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public Library() {
        books = new Book[0];
    }

    /**
    (一句简介的话描述这个Method    helper method to find a book in the bag).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    private int find(Book book) {
        for (int i = 0; i < books.length; i ++){
            if (books[i] != null && book.equals(books[i])){ return i; }
        }
        return -1;
    }

    /**
    (一句简介的话描述这个Method    helper method to grow the capacity by 4).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    private void grow() {
        Book[] temp = new Book[books.length + 4];
        for (int i = 0; i < books.length; i ++){
            temp[i] = books[i];
        }
        books = temp;
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public void add(Book book) {
        if (books.length == numBooks){ grow(); }
        books[numBooks++] = book;
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q)   @return true if checking out is successful, false otherwise)
    */
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

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public boolean checkOut(Book book) {
        int index = find(book);
        if (index == -1){ return false; }
        if (books[index].isCheckedOut()){ return false; }
        books[index].setCheckedOut(true);
        return true;
    }

    /**
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public boolean returns(Book book) {
        int index = find(book);
        if (index == -1){ return false; }
        if (!books[index].isCheckedOut()){ return false; }
        books[index].setCheckedOut(false);
        return true;
    }

    /**
    (一句简介的话描述这个Method    print the list of books in the bag).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
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
    (一句简介的话描述这个Method    print the list of books by datePublished (ascending)).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
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
    (一句简介的话描述这个Method    print the list of books by number (ascending)).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
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
    (一句简介的话描述这个Method).
    (有需要可以在这对这个Method里的一些东西做解释，比如要对参数param解释：@param 巴拉巴拉巴拉，一个解释一行q(≧▽≦q))
    */
    public int getNumBooks() {
        return numBooks;
    }
}
