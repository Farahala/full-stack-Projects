package FilePackage;

import java.io.File;
import java.io.IOException;

public class FileOperation {
    private String fileName ;
    private String directoryPath ;

    public FileOperation(String fileName ,String directoryPath) {
        this.fileName=fileName;
        this .directoryPath= directoryPath ;
    }



    public File createDir() {

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Create the directory if it doesn't exist
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return directory;
    }
    public File createFile(String fileName) {
        // create directory
        File directory = createDir();
        // Create a File object for the file
        File file = new File(directory, fileName);

        // Create the file if it doesn't exist
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created successfully ");
            }
            else {
                System.out.println("File Already exists");
            }
        } catch (IOException e) {
            System.out.println("File cannot be created ");
            e.printStackTrace();
        }
        return file;
    }
    public void DeleteFile(String fileName) {

        File directory = createDir();
        // Create a File object for the file
        File file = new File(directory, fileName);
        if (file.isFile() && file.exists()) {
            file.delete();
            System.out.println("File Deleted successfully ");
        }
        else {
            System.out.println("failed to  Delete the file");
        }
    }
    public void searchForFile(String fileName)
    {
        File Sfile = createDir();
        String[] SearchFile = Sfile.list();

            for (int i = 0; i < SearchFile.length; i++) {
                if (fileName.equals(SearchFile[i])) {
                    System.out.println(" File Exist Name is " + fileName);
                }
                else {

                        System.out.println("does not exist or is not a directory");
                        break;
                }

            }


    }

    }

