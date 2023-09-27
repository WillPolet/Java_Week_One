import java.util.*;

public class Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter size of array : ");
        int sizeOfArray = sc.nextInt();
        System.out.println("Enter maximum size a number can take : ");
        int maximumSize = sc.nextInt();
        int[] array = new int[sizeOfArray]; // There's sizeOfArray integers inside the array
        for (int i = 0; i < array.length; i++) {
            int min = 0;
            int max = 100;
            int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
            array[i] = random_int;
            if (array[i] < maximumSize) {
                System.out.println("Element at index " + i
                        + " : " + array[i] + " is lower than " + maximumSize);
            }
        }
    }
}
