package The_CSV_Factory;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static String main(String[] args) {
        try {
            int i = 1;
            boolean created = false;
            while (created == false){
                File myObj = new File("Report"+i+".csv");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                    created = true;
                    return "Report"+i+".csv";
                } else {
                    System.out.println("File already exists.");
                    i++;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
