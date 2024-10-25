package assignments.library;

import assignments.library.Author;
import assignments.library.Book;

public class Library {
    public static void main(String[] args) {
        Author stephenKing = new Author("Stephen King","stephenking@yahoo.com");
        Book institute = new Book("The Institute",2019,stephenKing,69.99);
        printBookDetails(institute);

    }

    public static void printBookDetails(Book book){
        System.out.println(
                "Book " + book.getName() +
                " (" + book.getPrice() + " RON), by " +
                book.getAuthor().getName() +
                ",published in " + book.getYear()
        );

    }
}
