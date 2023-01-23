package FilePackage;
import java.io.File;

public class ListFiles extends FileOperation {

    public ListFiles(String fileName ,String directoryPath) {
        super(fileName,directoryPath);
    }



    public void SortAscendingFiles()
    {
        File directory = createDir();
        //System.out.println(directory);

        // Get a list of files in the directory
        File[] files = directory.listFiles();

        // Sort the list of files using bubble sort
        for (int i = 0; i < files.length - 1; i++) {
            for (int j = 0; j < files.length - i - 1; j++) {
                if (files[j].getName().compareTo(files[j + 1].getName()) > 0) {
                    File temp = files[j];
                    files[j] = files[j + 1];
                    files[j + 1] = temp;
                }
            }
        }

        // Print the sorted list of files
        for (File file : files) {
            System.out.println(file.getName());
        }
    }


}
