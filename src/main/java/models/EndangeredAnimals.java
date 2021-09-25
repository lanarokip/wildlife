package models;

import java.util.ArrayList;

public class EndangeredAnimals extends Animal {
    private String health;
    private String age;
    private String location;
    private String ranger;
    private static ArrayList<EndangeredAnimals> minstances =  new ArrayList<EndangeredAnimals>();


    public static final String TYPE = "endangered";
    public static final String HEALTHY = "healthy";
    public static final String ILL = "sick";
    public static final String OKAY = "average";
    public static final String NEWBORN = "infant";
    public static final String YOUNG = "child";
    public static final String ADULT = "adult";


    public EndangeredAnimals(String name, String health, String age, String location,String ranger){
//        super(name);
        this.id =id;
        this.name=name;
        this.type=TYPE;
        this.health= health;
        this.age=age;
        this.location=location;
        minstances.add(this);
        this.id = minstances.size();
        this.ranger= ranger;


    }



    public  static ArrayList<EndangeredAnimals> getAll(){
            return minstances;
}
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
    public boolean equals(Object o){
        if (o instanceof Animal){
            Animal animal = (Animal) o;
            return (this.getName().equals(animal.getName()));
        }
        return false;
    }




}
