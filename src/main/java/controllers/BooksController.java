package controllers;

import db.DBHelper;
import models.Book;
import models.Borrower;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class BooksController {


    public BooksController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/books", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/books/index.vtl");

            List<Book> books = DBHelper.getAll(Book.class);
            model.put("books", books);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/books/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Book> collection = DBHelper.getAll(Book.class);
            model.put("books", collection);
            model.put("template", "templates/books/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }

}
