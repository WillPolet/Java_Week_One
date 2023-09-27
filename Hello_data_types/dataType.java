public class dataType {
    // all primitive variables :
    // char - boolean - byte - short - int - long - double - float - reference variable
    public static void main(String[] args) {
        byte b = 100;
        System.out.println("This is a byte : " + b + " size is 8 bits and is between -128 and 127"); // String must have "" and not ''
        short s = 30_000;
        System.out.println("This is a short, it's 16 bits so 2 to the power 15 since one is for the sign : " + s);
        int i = 100_000_000;
        System.out.println("This is an integer (-2^31 -> 2^31 -1) : " + i);
        long l = 100_000_000_000_000L;
        System.out.println("This is a long, don't forget to finish the number by L (2^63) : " + l);
        float f = 1.456f;
        System.out.println("Float : " + f);
        double d = 1.456789012345678;
        System.out.println("Double : " + d);
        char c = 'c';
        System.out.println("Char is only one character");
        boolean bool = true;
        System.out.println("Boolean, you know what it is : " + bool);
    }
}