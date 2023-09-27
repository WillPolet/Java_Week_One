package Hello_exceptions;

public class exceptions {
    public static void main(String[] args) {
        Integer[] array = new Integer [10]; // If I try to put object in it what happen ?
        for (int i = 0; i < array.length; i++) {
            int min = 0;
            int max = 10;
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
            array[i] = random_int;
            if (i == 0){
                try{
                    System.out.println(array[i]/array[i]);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else {
                try {
                    float num = (float) array[i];
                    float den = (float) array[i - 1];
                    float result = (num/den);
                    System.out.println(result);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}
