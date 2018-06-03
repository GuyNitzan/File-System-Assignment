import java.util.*;

public class FileSystem {
    private Directory home; //a root directory
    private HashMap<String, Entity> allEntities;    //a map that holds references to all entities in the system
    private HashMap<String, Directory> parents;     //a map that holds references to the parent Directory name of each entity

    public FileSystem(){
        home = new Directory("home");
        allEntities = new HashMap<String, Entity>();
        allEntities.put("home", home);
        parents = new HashMap<String, Directory>();
    }

    public void addFile (String parentDirName, String fileName, int fileSize){
        if (fileName.length() > 32){
            System.out.println("File name is too long, Enter a name with a maximum of 32 characters");
            return;
        }
        if (fileSize <= 0){
            System.out.println("File size is illegal, Enter a positive size only");
            return;
        }
        if (!allEntities.containsKey(parentDirName) || allEntities.get(parentDirName) instanceof File){
            System.out.println("Directory doesn't exist, Try another Directory");
            return;
        }
        if (allEntities.containsKey(fileName)){
            System.out.println("File name is already in use, Enter another name");
            return;
        }
        //input is ok, we create the File and update the maps
        File file = new File(fileName, fileSize);
        ((Directory)allEntities.get(parentDirName)).addFile(file);
        allEntities.put(fileName, file);
        parents.put(fileName, (Directory)allEntities.get(parentDirName));
    }

    public void addDir (String parentDirName, String dirName){
        if (dirName.length() > 32){
            System.out.println("Directory name is too long, Enter a name with a maximum of 32 characters");
            return;
        }
        if (!allEntities.containsKey(parentDirName) || allEntities.get(parentDirName) instanceof File){
            System.out.println("Directory doesn't exist, Try another Directory");
            return;
        }
        if (allEntities.containsKey(dirName)){
            System.out.println("Directory name is already in use, Enter another name");
            return;
        }
        //input is ok, we create the Directory and update the maps
        Directory dir = new Directory(dirName);
        ((Directory)allEntities.get(parentDirName)).addDir(dir);
        allEntities.put(dirName, dir);
        parents.put(dirName, (Directory)allEntities.get(parentDirName));
    }

    public void delete(String name){
        if (!allEntities.containsKey(name)) {
            System.out.println("There is no Directory or a File named "+name+"!");
            return;
        }
        //input is ok, find the parent directory and call its delete method
        (parents.get(name)).delete(name);
        System.out.println(name+" was deleted successfully");
    }

    public void showFileSystem(){
        home.print();   //display home details
        home.displayContent();  //display home's content
    }
}
