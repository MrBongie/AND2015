package bongie.task;


import java.io.Serializable;

public class Achiv implements Serializable {

    private String name;
    private String place;


    public Achiv(String Name, String Place) {
        this.name = Name;
        this.place = Place;
    }

    public String getAchivName() {
        return name;
    }

    public String getAchivPlace() {
        return place;
    }

}