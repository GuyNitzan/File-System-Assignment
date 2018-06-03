import java.util.Date;

//A class that represent both Directories and Folders
public abstract class Entity {
    protected String name;
    protected Date date;

    public Entity(String name){
        this.name = name;
        date = new Date();
    }

    public String getName() {
        return name;
    }

    public abstract void print();
}
