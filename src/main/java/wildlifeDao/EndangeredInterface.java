package wildlifeDao;

import models.EndangeredAnimals;

import java.util.List;

public interface EndangeredInterface {
    void create(EndangeredAnimals endangeredAnimals);
    List<EndangeredAnimals> findAll();
    EndangeredAnimals findById(int id);
//    void update(int id,String);
    void deleteAll();
    void deleteById(int id);
}
