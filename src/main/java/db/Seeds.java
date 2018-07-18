package db;

import models.Book;
import models.Borrower;
import models.Genre;

public class Seeds {

    public static void main(String[] args) {
        DBHelper.deleteAll(Book.class);
        DBHelper.deleteAll(Borrower.class);

        Borrower borrower1 = new Borrower("Donald Trump");
        DBHelper.save(borrower1);

        Borrower borrower2 = new Borrower("Donald Trump Jr");
        DBHelper.save(borrower2);

        Book book1 = new Book("The Art of the Deal", "Donald Trump", false, borrower1, Genre.POLITICS);
        DBHelper.save(book1);

        Book book2 = new Book("The Jungle Book", "Rudyard Kipling", false, borrower2, Genre.TEEN);
        DBHelper.save(book2);

        Book book3 = new Book("Far From The Madding Crowd", "Thomas Hardy", false, borrower2, Genre.POLITICS);
        DBHelper.save(book3);

        Book book4 = new Book("Twilight", "Stephanie Meyer", false, borrower1, Genre.TEEN);
        DBHelper.save(book4);






    }


}
