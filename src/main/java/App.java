import models.EndangeredAnimals;
//import org.sql2o.Sql2o;

import models.Not_endangered;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import spark.ModelAndView;
import wildlifeDao.Not_endangeredDao;
import wildlifeDao.RecEndangered;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sql2o.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2o sql2o= new Sql2o("jdbc:postgresql://localhost:5432/wildlife","Aron","1234");

        RecEndangered recEndangered = new RecEndangered();
        Not_endangeredDao not_endangeredDao = new Not_endangeredDao();

        get("/",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "/index.hbs");
        },new HandlebarsTemplateEngine());

        get("/endangered",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            model.put("animals", EndangeredAnimals.TYPE);
            return new ModelAndView(model,"sighting.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangered/new",(request, response) -> {
            Map<String, ArrayList<EndangeredAnimals>> model = new HashMap<String, ArrayList<EndangeredAnimals>>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");

            EndangeredAnimals endangeredAnimals =new EndangeredAnimals(health, age, location, ranger);
            recEndangered.create(endangeredAnimals);

//            List<EndangeredAnimals>endangeredAnimals1=recEndangered.findAll();
//            model.put("name",name);
//            model.put("health",health);
//            model.put("age",age);
//            model.put("location",location);
//            model.put("ranger",ranger);
//            model.put("endangeredAnimals1",endangeredAnimals1);
            return  new ModelAndView(model,"landingSighting.hbs");
        },new HandlebarsTemplateEngine());



        get("/endangered/all", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimals>endangeredAll1=recEndangered.findAll();
            model.put("endangeredAll1",endangeredAll1);
            return  new ModelAndView(model,"endangeredView.hbs");
        }, new HandlebarsTemplateEngine());

        get("/AnimalE",(request, response) ->{
            Map<String,Object>model = new HashMap<String, Object>();
            return new ModelAndView(model,"non-endangerdF.hbs");
        },new HandlebarsTemplateEngine() );
//        Map<String, ArrayList<EndangeredAnimals>> model = new HashMap<String, ArrayList<EndangeredAnimals>>();
//        ArrayList endangeredAll = EndangeredAnimals.getAll();
//        String name = request.queryParams("name");
//        String health = request.queryParams("health");
//        String age = request.queryParams("age");
//        String location = request.queryParams("location");
//        String ranger = request.queryParams("ranger");
//        model.put("endangeredAll",endangeredAll);

        post("/nonEndangered/new", (request, response) -> {
            Map<String,ArrayList<Not_endangered>> model = new HashMap<String, ArrayList<Not_endangered>>();
            String name = request.queryParams("name");
            Not_endangered not_endangered = new Not_endangered(name);
            not_endangeredDao.create(not_endangered);
            return new ModelAndView(model,"non_endangeredlanding.hbs");
        }, new HandlebarsTemplateEngine());

        get("/non_endangered/all", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Not_endangered>Not_endangered1=not_endangeredDao.findAll();
            model.put("Not_endangered1",Not_endangered1);
            return  new ModelAndView(model,"nonEndangerdl.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            recEndangered.deleteAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/non_endangered/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            not_endangeredDao.deleteAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


    }

}
