package models;

import java.util.ArrayList;

public class Not_endangered extends Animal {
    public Not_endangered(String name){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public  void setId(int id){
        this.id=id;
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
