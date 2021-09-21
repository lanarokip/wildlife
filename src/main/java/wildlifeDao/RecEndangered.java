package wildlifeDao;

import models.EndangeredAnimals;
import org.sql2o.Connection;
//import org.sql2o.Sql2o;
import org.sql2o.*;
//import org.sql2o.Sql2oException;


import java.util.List;

public class RecEndangered implements EndangeredInterface {
    Sql2o sql2o= new Sql2o("jdbc:postgresql://localhost:5432/wildlife","kip","1234");

    @Override
    public void create(EndangeredAnimals endangeredAnimals) {
        String sql = "INSERT INTO endangered (name,health,age,location,ranger) VALUES(:name,:health,:age,:location,:ranger)";
         try(Connection con= sql2o.open()){
            int id = (int) con.createQuery(sql,true)
            .bind(endangeredAnimals)
            .executeUpdate()
            .getKey();
           endangeredAnimals.setId(id);
         }catch (Sql2oException e){
             System.out.println(e);
         }
    }

    @Override
    public List<EndangeredAnimals> findAll() {
       try( Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangeredAnimals")
                    .executeAndFetch(EndangeredAnimals.class);
        }
    }

    @Override
    public EndangeredAnimals findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM endangeredAnimals WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimals.class);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM endangered";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM endangered WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println("runnn");
        }
    }
}
