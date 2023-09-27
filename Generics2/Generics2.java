package Generics2;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


class ListOfFiles {
    public static ArrayList<String> list() throws IOException {
        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\willi\\Desktop\\JavaBeCode\\weekOne\\texts");
        //List of all files and directories
        File filesList[] = directoryPath.listFiles();
//        System.out.println("List of files and directories in the specified directory:");
        ArrayList<String> paths = new ArrayList<String>();
//        System.out.println(Arrays.stream(filesList).toList());
        for(File file : filesList) {
//            System.out.println("File name: "+file.getName());
//            System.out.println("File path: "+file.getAbsolutePath());
//            System.out.println("Size :"+file.getTotalSpace());
//            System.out.println(" ");
            paths.add(file.getAbsolutePath());
        }
        return paths;
    }
}



class countingWords {
    public static void counting(ArrayList<String> paths) {
        Map<String, Integer> Occurs = new HashMap<String, Integer>();
        for (String path : paths){
        StringBuilder S = new StringBuilder(); // Need to do a hashmap
        ArrayList<String> stringArray = new ArrayList<>();
            try{
                FileReader fr=new FileReader(path);
                int r=0;
                while((r=fr.read())!=-1)
                {
                    //System.out.print((char)r);  //prints the content of the file
                    S.append((char) r);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
            String[] array = S.toString().split("[^\\p{IsAlphabetic}0-9']+"); // Need to be there because I need to split after appending all characters
            //System.out.println(Arrays.toString(array));
            for (int i = 0; i < array.length ; i++ ){
                int count = 0;
                for (int j = 0; j < array.length ; j++){
                    if (Objects.equals(array[i].toLowerCase(), array[j].toLowerCase())){
                        count += 1;
                    }
                }
                String lowercaseWord = array[i].toLowerCase();  // Convert word to lowercase
                if (!stringArray.contains(lowercaseWord)) {
                    if (Occurs.containsKey(lowercaseWord)) {
                        int value = Occurs.get(lowercaseWord);
                        count += value;
                        Occurs.replace(lowercaseWord, count);
                        stringArray.add(lowercaseWord);
                    } else {
                        Occurs.put(lowercaseWord, count);
                        stringArray.add(lowercaseWord);
                    }
                }
            }
        }
        System.out.println(Occurs);
    }
}


public class Generics2 {
    public static void main(String[] args) throws IOException {
        ArrayList list = ListOfFiles.list();
        System.out.println(list.toString());
        countingWords.counting(list);

    }
}
