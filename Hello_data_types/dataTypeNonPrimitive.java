public class dataTypeNonPrimitive {
        public static void main(String[] args) {
            Integer myInteger = 42;
            Double myDouble = 3.14;
            Character myChar = 'A';
            Boolean myBoolean = true;

            Object[] variables = { myInteger, myDouble, myChar, myBoolean };

            for (Object variable : variables) {
                System.out.println(variable.toString());
            }
        }
    }
