package wildlifeDao;

import models.EndangeredAnimals;
import models.Not_endangered;
import org.junit.Test;

import static org.junit.Assert.*;

public class Not_endangeredDaoTest {
    Not_endangeredDao not_endangeredDao = new Not_endangeredDao();

    @Test
    public void create() {
        Not_endangered not_endangered = new Not_endangered("lion");
        int myid = not_endangered.getId();
        not_endangeredDao.create(not_endangered);
        assertNotEquals(myid,not_endangered.getId());
    }

    @Test
    public void findAll() {
        Not_endangered not_endangered = new Not_endangered("lion");
        not_endangeredDao.create(not_endangered);
        Not_endangered foundEndangered = not_endangeredDao.findById(not_endangered.getId());
        assertNotEquals(not_endangered,foundEndangered);
    }

    @Test
    public void findById() {
        Not_endangered not = new Not_endangered ("lion");
        not_endangeredDao.create(not);
        Not_endangered found = not_endangeredDao.findById(not.getId());
        assertEquals(not, found);
    }

//    @Test
//    public void deleteAll() {
//    }
//
//    @Test
//    public void deleteById() {
//    }
}