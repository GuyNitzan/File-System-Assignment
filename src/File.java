import java.util.Date;

public class File extends Entity{
    private long size;

    public File(String name, long size){
        super(name);
        this.size = size;
    }

    public void print(){
        System.out.println("File name: "+name+", size: "+size+", creation date: "+date);
    }
}
