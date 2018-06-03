File System Assignment (Written by Guy Nitzan on 26/05/2018)

Overview:
The file system consists of Files and Directories.
The File and Directory classes extend the Entity abstract class.
The FileSystem class contains a root directory (home), which is the ancestor of all entities in the system, which reside in a tree structure.
The FileSystem class also holds two HashMaps: allEntities and parents.
allEntities is a map of String-Entity pairs where each value is a reference
to the same directory that reside in the tree structure, rooted by the home directory.
parents is a map of String-Directory pairs, where for each name of entity, holds a reference to its parent directory  
Every directory holds all its entities in a HashMap of String-Entity pairs.
The system supports the following operations:

* addFile (string parentDirName, String fileName, integer fileSize)

	Adds new File under the Directory branch

* addDir (string parentDirName, String dirName)

	Adds new Directory under the parent Directory

* delete (string name)

	Deletes the Directory or the File with this name

* showFileSystem ()

	Displays all files & directories with their hierarchical structure
	
The main function of the program operates a shell command line that supports the following commands:
1. Create a new Directory
2. Create a new File
3. Delete a File or a Directory
4. Show all files and Directories

the shell expects a command number only (1 to 4). 
given the number inserted by the user, the shell then asks the user for further data, if necessary.

At any point, if the user enters an invalid input, e.g. illegal or already used entity name, illegal file size, a non-existing parent directory
or an illegal command, an error prompt is printed and the system will wait for another command.





