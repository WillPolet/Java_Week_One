package The_CSV_Factory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Objects;
import java.util.Random;
import java.time.LocalDate;
import java.time.Month;
import The_CSV_Factory.CreateFile;

class RandomName {
    public static String[] Name (){
        String[] firstNames = {
                "James", "Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Isabella",
                "Ethan", "Sophia", "Michael", "Mia", "Alexander", "Charlotte", "David", "Amelia",
                "Benjamin", "Harper", "Henry", "Evelyn", "Daniel", "Abigail", "Jackson", "Emily",
                "Matthew", "Elizabeth", "Lucas", "Sofia", "Joseph", "Avery", "Samuel", "Ella",
                "Sebastian", "Scarlett", "Gabriel", "Grace", "Carter", "Chloe", "Owen", "Victoria",
                "John", "Riley", "Dylan", "Aria"
        };
        String[] lastNames = {
                "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
                "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin",
                "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee",
                "Walker", "Hall", "Allen", "Young", "Hernandez", "King"
        };
        int min = 0;
        int max = 39;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int min2 = 0;
        int max2 = 29;
        int random_int2 = (int)Math.floor(Math.random() * (max2 - min2 + 1) + min2);
        String randomFirstName = firstNames[random_int];
        String randomLastName = lastNames[random_int2];
        String[] name = {randomFirstName, randomLastName};
        return name;
    }
}

class Reason {
    public static String AppointmentOrVisit () {
        Random rd = new Random(); // creating Random object
        if (rd.nextBoolean() == true){
            String reason = "Appointment";
            return reason;
        }
        else {
            String reason = "Visit";
            return reason;
        }
    }
}

class DepartmentVisit {
    public static String[] PlaceAndDate (String a){
            if (Objects.equals(a, "Appointment")){
                int min = 0;
                int max = 4;
                int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
                String[] Department = {"Cardiology", "Radiology", "Pediatrics", "Geriatrics","Pulmonology"};
                return new String[]{Department[random_int], ""};
            }
            else {
                int year = 2023; // Replace with the desired year
                int monthValue = Month.AUGUST.getValue(); // Replace with the desired month's value

                int daysInMonth = YearMonth.of(year, monthValue).lengthOfMonth();
                int day = new Random().nextInt(daysInMonth) + 1;

                LocalDate randomDate = LocalDate.of(year, monthValue, day);
                String[] Date = {"", randomDate.toString()};
                return Date;
            }
    }
}

class writeFile {
    public static void write (String path,String firstName, String lastName, String reason, String department, String date){
        try {
            FileWriter myWriter = new FileWriter(path, true);
            myWriter.write(System.lineSeparator());
            String quote = firstName + "," + lastName + "," + reason + "," + department + "," + date;
            myWriter.write(quote);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

public class CSVFactory {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(RandomName.Name())); // Function to get random first name and last name works
        String fileName = CreateFile.main(args);
        int i = 0;
        while ( i < 10) {
            String[] name = RandomName.Name();
            String firstName = name[0];
            String lastName = name[1];
            String reason = Reason.AppointmentOrVisit();
            String[] info = DepartmentVisit.PlaceAndDate(reason);
            //System.out.println(info[0] + info[1]);
            //System.out.println(fileName);
            writeFile.write("C:\\Users\\willi\\Desktop\\JavaBeCode\\weekOne\\" + fileName, firstName, lastName, reason, info[0], info[1]);
            i++;
        }

    }
}
