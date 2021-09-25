import models.EndangeredAnimals;
import models.Not_endangered;
import org.junit.Test;
import static org.junit.Assert.*;

public class EndangeredAnimalsTest {
    @Test
    public void Endangerd_instanceofEndangeredAnimals()throws Exception {
        EndangeredAnimals endangeredAnimals= new EndangeredAnimals("aron","healthy","young","sec3","may3");
        assertEquals(true, endangeredAnimals instanceof EndangeredAnimals);
    }

    @Test
    public void Endangered_objectGetCreatedCorrectly() {
        EndangeredAnimals endangeredAnimals= new EndangeredAnimals("aron","healthy","young","sec3","may3");
        EndangeredAnimals endangeredAnimals5= new EndangeredAnimals("aron","healthy","young","sec3","may3");
        assertEquals(2,endangeredAnimals.getAll().size());

    }

    @Test
    public void non_Endangerd_instanceOFAnimals()throws Exception {
        Not_endangered not_endangered = new Not_endangered("lion");
        assertEquals(true,not_endangered instanceof Not_endangered);
    }

    @Test
    public void Endangerd_nameTaken() {
        EndangeredAnimals endangeredAnimals= new EndangeredAnimals("aron","healthy","young","sec3","may3");
        assertEquals("aron",endangeredAnimals.getName());
    }
}
