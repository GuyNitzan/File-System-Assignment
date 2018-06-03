import java.util.*;

public class Directory extends Entity{
    private Map<String, Entity> entities;   //all sub-entities in this Directory

    public Directory(String name){
        super(name);
        entities = new HashMap<String, Entity>();
    }

    public void print(){
        System.out.println("Directory name: "+name+", Creation date: "+date);
    }
    //adds the given File to the map of entities
    public void addFile(File file){
        entities.put(file.getName(), file);
    }
    //adds the given Directory to the map of entities
    public void addDir(Directory dir){
        entities.put(dir.getName(), dir);
    }
    /*
    given an entity name to delete, that is contained in this Directory (checked outside of the call)
    if the entity is a File, it is simply removed. otherwise, there's a recursive call to delete its content
    after that the Directory is removed from the map
     */
    public void delete(String name){
        if (entities.get(name) instanceof File) {
            entities.remove(name);
            return;
        }
        ((Directory)entities.get(name)).deleteAll();
        entities.remove(name);
    }
    // A function that recursively deletes all content of the Directory
    public void deleteAll(){
        Iterator it = entities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getValue() instanceof File) {
                it.remove(); // avoids a ConcurrentModificationException
                return;
            }
            ((Directory)pair.getValue()).deleteAll();
            it.remove();
        }
    }
    //displays the details of this Directory. then, if it isn't empty, recursively displays the details of all sub-entities
    public void displayContent(){
        if (entities.isEmpty()) return;
        System.out.println(this.name+" content:");
        for (Map.Entry<String, Entity> entry : entities.entrySet())
            entry.getValue().print();
        System.out.println("\n");
        for (Map.Entry<String, Entity> entry : entities.entrySet()) {
            if (entry.getValue() instanceof Directory)
                ((Directory) entry.getValue()).displayContent();
        }
    }
}
