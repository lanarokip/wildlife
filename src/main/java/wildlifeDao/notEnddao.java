package wildlifeDao;

import models.Not_endangered;

import java.util.List;

public interface notEnddao {
    void create (Not_endangered not_endangered);
    List<Not_endangered> findAll();
    Not_endangered findById(int id);
    void deleteAll();
    void deleteById(int id);
}
