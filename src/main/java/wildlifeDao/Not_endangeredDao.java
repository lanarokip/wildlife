package wildlifeDao;

import models.Not_endangered;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class not_endangered implements notEnddao {
    Sql2o sql2o= new Sql2o("jdbc:postgresql://localhost:5432/wildlife","kip","1234");
    @Override
    public void create(Not_endangered not_endangered) {
        String sql = "INSERT INTO Notendangered (name,health,age,location) VALUES(:name,:health,:age,:location)";
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
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(int id) {

    }
}
