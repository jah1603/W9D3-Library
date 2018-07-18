package models;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {

    private int id;
    private String title;
    private String author;
    private boolean onLoan;
    private Borrower currentBorrower;
    private Genre genre;


    public Book() {

    }

    public Book(String title, String author, boolean onLoan, Borrower currentBorrower, Genre genre) {
        this.title = title;
        this.author = author;
        this.onLoan = onLoan;
        this.currentBorrower = currentBorrower;
        this.genre = genre;

    }

        @Id
        @GeneratedValue
        @Column(name = "id")
        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        @Column(name = "title")
        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        @Column(name = "author")
        public String getAuthor () {
            return author;
        }

        public void setAuthor (String author){
            this.author = author;
        }

        @Column(name = "availability")
        public boolean isOnLoan () {
            return onLoan;
        }

        public void setOnLoan ( boolean onLoan){
            this.onLoan = onLoan;
        }

        @ManyToOne
        @JoinColumn(name = "borrower_id", nullable = false)
        public Borrower getCurrentBorrower () {
            return currentBorrower;
        }

        public void setCurrentBorrower (Borrower currentBorrower){
            this.currentBorrower = currentBorrower;
        }

        @Column(name = "genre")
        public Genre getGenre () {
            return genre;
        }

        public void setGenre (Genre genre){
            this.genre = genre;
        }

        public String titleGenre () {
            return this.genre.getTitleGenre();
        }


    }

