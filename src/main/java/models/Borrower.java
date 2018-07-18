package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "borrowers")

public class Borrower {

    private int id;
    private String name;
    private List<Book> collection;

    public Borrower(String name) {
        this.name = name;
        this.collection = new ArrayList<Book>();
    }

    public Borrower() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "currentBorrower", fetch = FetchType.LAZY)
    public List<Book> getCollection() {
        return collection;
    }

    public void setCollection(List<Book> collection) {
        this.collection = collection;
    }
}
