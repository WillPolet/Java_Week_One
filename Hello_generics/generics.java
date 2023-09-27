package Hello_generics;
import java.util.ArrayList;
import java.util.List;
import Hello_generics.Car;
import Hello_generics.Truck;



public class generics {
    public static void main(String[] args) {
        // Create instances of Car and Truck
        Car car = new Car(4);
        Truck truck = new Truck(6);

        // Create a List to hold objects of both classes
        List<Object> vehicleList = new ArrayList<>();
        vehicleList.add(car);
        vehicleList.add(truck);

        // Iterate through the list and print the number of wheels for each vehicle
        for (Object vehicle : vehicleList) {
            if (vehicle instanceof Car) { // Check for each object if it's an instance of Car or Truck
                Car c = (Car) vehicle; // Cast the object into Car object to allow to use get method.
                System.out.println("Car has " + c.getNumberOfWheels() + " wheels.");
            } else if (vehicle instanceof Truck) {
                Truck t = (Truck) vehicle;
                System.out.println("Truck has " + t.getNumberOfWheels() + " wheels.");
            }
        }
    }
}
