package Hello_Classes;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class CSVReaderTest {
    public static void read (String csvFilePath) {
        String path = csvFilePath;
        try {
            // Open the CSV file using a Scanner
            Scanner scanner = new Scanner(new File(path));

            // Read and process each line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                // Process the values as needed
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println(); // Move to the next line
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found: " + e.getMessage());
        }
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) { // This is a constructor
        this.name = name;
        this.age = age;
    }

   // public Cat() {
  //  }

    public void sayMeow() {
        System.out.println("Meow!");
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
        if (Objects.equals(name, "")){
            System.out.println("Please give a name to the cat");
        } else {
        this.name = name;}
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class writeFile {
    public static void write (String quote){
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\willi\\Desktop\\JavaBeCode\\weekOne\\Hello_Classes\\test.txt", true);
            myWriter.write(System.lineSeparator());
            myWriter.write(quote);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class ReadCSV {
    public static void read (String rowOrCol, int col, int row){
        String csvFilePath = "C:\\Users\\willi\\Desktop\\JavaBeCode\\weekOne\\Hello_Classes\\addresses.csv";
        if (Objects.equals(rowOrCol, "col")) {
            String line = "";
            String cvsSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(cvsSplitBy);

                    if (data.length > 0) {
                        String column = data[col];
                        System.out.println(column);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Objects.equals(rowOrCol, "row")){
            int targetLine = row; // Replace with the line number you want to print
            int currentLine = 1;

            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (currentLine == targetLine) {
                        System.out.println("Line " + targetLine + ": " + line);
                        break; // Remove this line if you want to continue searching after finding the line
                    }
                    currentLine++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            //String line = "";
            String cvsSplitBy = ",";
            int targetLine = row; // Replace with the line number you want to print
            int currentLine = 1;

            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (currentLine == targetLine) {
                        String[] data = line.split(cvsSplitBy);
                        if (data.length > 0) {
                            String column = data[col - 1];
                            System.out.println(column);
                        }
                        break; // Remove this line if you want to continue searching after finding the line
                    }
                    currentLine++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}


public class HelloClasses {
    public static void main(String[] args) {
        // Specify the path to your CSV file
        /*String csvFilePath = "C:\\Users\\willi\\Desktop\\JavaBeCode\\weekOne\\Hello_Classes\\addresses.csv";
        CSVReaderTest.read(csvFilePath);
        String quote = "Here's a fifth sentence";
        writeFile.write(quote);*/
        /*Cat Garfield = new Cat("", 26);
        Garfield.setName(""); // I can just create a cat with arguments in parentheses
        Garfield.setAge(26);
        System.out.println(Garfield.getName());*/
        ReadCSV.read("both", 3,3);
    }
}



