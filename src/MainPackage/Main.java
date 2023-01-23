package MainPackage;

import FilePackage.FileOperation;
import FilePackage.ListFiles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("---Menu---- \n");
            System.out.println("\t1. Retrieve current filenames in ascending order \n");
            System.out.println("\t2. Business-level operation menu \n");
            System.out.println("\t3. Exit from the application \n");
            System.out.print("Enter your choice which you want to select : ");
            option=scanner.nextInt();

            Businesslevel BSLevel= new Businesslevel();
            switch(option) {

                case 1:

                    BSLevel.Sort();
                    break;
                case 2:
                    int ch;
                    do {
                        System.out.println("---SubMenu---- \n");

                        System.out.println("\t1. Add a file and its content to a directory");
                        System.out.println("\t2. Delete a file from a directory");
                        System.out.println("\t3. Searching a file and showing its content");
                        System.out.println("\t4. Exit from BOL menu");
                        System.out.print("Enter your choice for Business level operation : ");
                        ch=scanner.nextInt();
                        switch(ch) {

                            case 1:
                                    BSLevel.Create();
                                break;
                            case 2:
                                BSLevel.Delete();
                                break;
                            case 3:
                                    BSLevel.search();
                                break;
                            case 4:
                                System.out.println("Exited from the Business Level operation...");
                                System.out.println("---------------------------------\n");
                                break;
                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                    }while(ch!=4);
                    break;
                case 3:
                    System.out.println("Exiting from the application...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            //System.out.println("Press 0 to continue");
        }while(option!=3);

    }

    }
