import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String args[]) throws IOException {
        System.out.println("Welcome to File System, Choose an operation number:");
        System.out.println("1. Create a new Directory");
        System.out.println("2. Create a new File");
        System.out.println("3. Delete a File or a Directory");
        System.out.println("4. Show all files and Directories");
        System.out.println("5. Exit");
        FileSystem fs = new FileSystem();
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.print("> ");
            commandLine = console.readLine();
            if (!checkInput(commandLine)){
                System.out.println("Wrong input, Try again");
                continue;
            }
            int number = Integer.parseInt(commandLine);
            switch (number){
                case 1:{
                    System.out.println("Enter a parent directory name: ");
                    commandLine = console.readLine();
                    String parentDirectory = commandLine;
                    System.out.println("Enter the new directory name: ");
                    commandLine = console.readLine();
                    String directory = commandLine;
                    fs.addDir(parentDirectory, directory);
                    continue;
                }
                case 2:{
                    System.out.println("Enter a parent directory name: ");
                    commandLine = console.readLine();
                    String parentDirectory = commandLine;
                    System.out.println("Enter the new file name: ");
                    commandLine = console.readLine();
                    String file = commandLine;
                    System.out.println("Enter the file size: ");
                    commandLine = console.readLine();
                    fs.addFile(parentDirectory, file, Integer.parseInt(commandLine));
                    continue;
                }
                case 3:{
                    System.out.println("Enter a directory/file name to delete: ");
                    commandLine = console.readLine();
                    String name = commandLine;
                    fs.delete(name);
                    continue;
                }
                case 4:{
                    fs.showFileSystem();
                    continue;
                }
                default:{
                    return;
                }
            }
        }
    }
    private static boolean checkInput(String input){
        for (char c : input.toCharArray())
            if (!Character.isDigit(c)) return false;
        int number = Integer.parseInt(input);
        if (number < 1 || number > 5)
            return false;
        return true;
    }
}
