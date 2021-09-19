import models.EndangeredAnimals;
import org.sql2o.Sql2o;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import spark.ModelAndView;
import wildlifeDao.RecEndangered;

import java.util.HashMap;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        RecEndangered recEndangered = new RecEndangered(sql2o);

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
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            model.put("name",name);
            model.put("health",health);
            model.put("age",age);
            model.put("location",location);
            EndangeredAnimals endangeredAnimals =new EndangeredAnimals(name,health,age,location);
            recEndangered.create(endangeredAnimals);
            return  new ModelAndView(model,"landingSighting.hbs");
        },new HandlebarsTemplateEngine());

        get("/AnimalE",(request, response) ->{
            Map<String,Object>model = new HashMap<String, Object>();
            return new ModelAndView(model,"non-endangerdF.hbs");

        },new HandlebarsTemplateEngine() );
    }

}
