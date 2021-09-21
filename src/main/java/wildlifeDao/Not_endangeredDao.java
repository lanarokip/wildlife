package wildlifeDao;

import models.Not_endangered;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Not_endangeredDao implements notEnddao {
    Sql2o sql2o= new Sql2o("jdbc:postgresql://localhost:5432/wildlife","kip","1234");
    @Override
    public void create(Not_endangered not_endangered) {
        String sql = "INSERT INTO Notendangered (name) VALUES(:name)";
    try(Connection con = sql2o.open()){
        int id = (int) con.createQuery(sql,true)
                .bind(not_endangered)
                .executeUpdate()
                .getKey();
        not_endangered.setId(id);
    }catch (Sql2oException e){
        System.out.println(e);
        }
    }


    @Override
    public List<Not_endangered> findAll() {
        try( Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Notendangered")
                    .executeAndFetch(Not_endangered.class);
        }
    }

    @Override
    public Not_endangered findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM Notendangered WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Not_endangered.class);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM Notendangered";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM Notendangered WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println("runnn");
        }
    }
}
