package MainPackage;
import FilePackage.FileOperation;
import FilePackage.ListFiles;

import java.util.Scanner;
public class Businesslevel {
    Scanner scanner = new Scanner(System.in);
    String  FileName ;

    FileOperation FileOP= new FileOperation(FileName ,"src/Resources");
    void Create()
    {

        System.out.print("Enter the File Name that you need to create it: ");
         FileName = scanner.next();
        FileOP.createFile(FileName);
    }
    void Delete()
    {
        System.out.print("Enter the File Name that you want to Delete it: ");
        String  DFileName = scanner.next();
        FileOP.DeleteFile(DFileName);
    }
 void search()
   {
       System.out.print("Enter the File Name that you want to Search it: ");
       String  SFileName = scanner.next();
       FileOP.searchForFile(SFileName);
   }

   void Sort()
   {  System.out.println("File sorted Acsending : ");
       ListFiles AscendingFiles=new ListFiles(FileName ,"src/Resources");
       AscendingFiles.SortAscendingFiles();
   }

}
