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
import static spark.Spark.post;

public class BorrowersController {

    public BorrowersController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/borrowers", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/borrowers/index.vtl");

            List<Borrower> borrowers = DBHelper.getAll(Borrower.class);
            model.put("borrowers", borrowers);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/borrowers/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Book> collection = DBHelper.getAll(Book.class);
            model.put("books", collection);
            model.put("template", "templates/borrowers/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/borrowers/delete/:id", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            int borrowerId = Integer.parseInt(req.params(":id"));
            Borrower borrowerToDelete = DBHelper.find(borrowerId, Borrower.class);
            DBHelper.delete(borrowerToDelete);

            res.redirect("/borrowers");
            return null;
        }, new VelocityTemplateEngine());

    }
}