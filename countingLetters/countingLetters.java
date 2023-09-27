package countingLetters;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class countingLetters {
    public static void main(String[] args) {
        StringBuilder S = new StringBuilder();
        try{
            FileReader fr=new FileReader("C:\\Users\\willi\\Desktop\\JavaBeCode\\weekOne\\Couting_Words\\read.txt");
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
        String[] array = S.toString().split("(?!^)");
        //System.out.println(Arrays.toString(array));
        ArrayList<String> stringArray = new ArrayList<>();
        for (int i = 0; i < array.length ; i++ ){
            int count = 0;
            for (int j = 0; j < array.length ; j++){
                if (Objects.equals(array[i].toLowerCase(), array[j].toLowerCase())){
                    count += 1;
                }
            }
            if (!stringArray.contains(array[i].toLowerCase())){
                stringArray.add(array[i].toLowerCase());
                System.out.println(array[i] + " : " + count);
            }
        }
    }
}
