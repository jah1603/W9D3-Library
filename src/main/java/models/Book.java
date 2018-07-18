package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

    private int id;
    private String title;
    private String author;
    private boolean onLoan;
    private Borrower currentBorrower;
    private enum GENRE;

}
