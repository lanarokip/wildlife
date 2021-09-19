package models;

public abstract class Animal {
    private static final String TYPE ="animal" ;
    public int id;
    public String name;
    public String type;

    public Animal(String name) {
        this.name=name;
        this.type=TYPE;
    }

    public int getId() {
        return id;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


}
