package wildlifeDao;

import models.EndangeredAnimals;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class RecEndangeredTest {
    RecEndangered recEndangered= new RecEndangered();

    @Test
    public void createAnimal()throws Exception {
        EndangeredAnimals endangeredAnimals= new EndangeredAnimals("aro","heatlth","young","secB","aro");
        int myid = endangeredAnimals.getId();
        recEndangered.create(endangeredAnimals);
        assertNotEquals(myid,endangeredAnimals.getId());
    }
    @Test
    public void createdAnimalCanBeFoundByfindAll() throws Exception {
        EndangeredAnimals endangeredAnimals= new EndangeredAnimals("aro","heatlth","young","secB","aro");
        recEndangered.create(endangeredAnimals);
        EndangeredAnimals foundEndangered = recEndangered.findById(endangeredAnimals.getId());
        assertEquals(endangeredAnimals,foundEndangered);
    }

//    @Test
//    public void create() {
//    }

//    @Test
//    public void findAll() {
//    }
}