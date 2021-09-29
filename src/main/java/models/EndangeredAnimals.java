package models;

import java.util.ArrayList;
import java.util.Objects;

public class EndangeredAnimals extends Animal {
    public EndangeredAnimals(String health, String age, String location, String ranger) {
        this.health = health;
        this.age = age;
        this.location = location;
        this.ranger = ranger;
    }

    private int id;
    private String health;
    private String age;
    private String location;
    private String ranger;
//    private static ArrayList<EndangeredAnimals> minstances =  new ArrayList<>();


    public static final String TYPE = "endangered";
    public static final String HEALTHY = "healthy";
    public static final String ILL = "sick";
    public static final String OKAY = "average";
    public static final String NEWBORN = "infant";
    public static final String YOUNG = "child";
    public static final String ADULT = "adult";





//    public  static ArrayList<EndangeredAnimals> getAll(){
//            return minstances;
//}
    public String getLocation(){
        return location;
    }
    public String getHealth(){
        return health;
    }
    public String getName(){
        return name;
    }
    public String getRanger(){
        return ranger;
    }

    public String getAge() {
        return age;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimals that = (EndangeredAnimals) o;
        return Objects.equals(health, that.health) &&
                Objects.equals(age, that.age) &&
                Objects.equals(location, that.location) &&
                Objects.equals(ranger, that.ranger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, age, location, ranger);
    }
}
