import java.util.*;
import java.time.*;
import java.time.Duration;

class Vehicle {
    String vehicleNumber;
    String type;
    LocalDateTime entryTime;
    int ratePerHour;

    Vehicle(String vehicleNumber, String type, int ratePerHour) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.ratePerHour = ratePerHour;
        this.entryTime = LocalDateTime.now();
    }

    String getVehicleType() {
        return type;
    }
}

class TwoWheeler extends Vehicle {

    TwoWheeler(String vehicleNumber) {
        super(vehicleNumber, "Bike", 20);
    }
}

class FourWheeler extends Vehicle {

    FourWheeler(String vehicleNumber) {
        super(vehicleNumber, "Car", 50);
    }
}

class ParkingLot {

    int bikeCapacity;
    int carCapacity;

    ArrayList<Vehicle> parkedVehicles = new ArrayList<>();

    ParkingLot(int bikeCapacity, int carCapacity) {
        this.bikeCapacity = bikeCapacity;
        this.carCapacity = carCapacity;
    }

    int getParkedVehicleCount(String type) {
        int count = 0;

        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.type.equals(type)) {
                count++;
            }
        }

        return count;
    }

    void parkVehicle(Vehicle vehicle) {

        for (Vehicle parked : parkedVehicles) {
            if (parked.vehicleNumber.equalsIgnoreCase(
                    vehicle.vehicleNumber)) {
                System.out.println("Vehicle is already parked!");
                return;
            }
        }

        if (vehicle.type.equals("Bike")
                && getParkedVehicleCount("Bike") >= bikeCapacity) {
            System.out.println("Two-wheeler parking is full!");
            return;
        }

        if (vehicle.type.equals("Car")
                && getParkedVehicleCount("Car") >= carCapacity) {
            System.out.println("Four-wheeler parking is full!");
            return;
        }

        parkedVehicles.add(vehicle);

        System.out.println(vehicle.getVehicleType()
                + " parked successfully.");

        System.out.println("Entry Time: " + vehicle.entryTime);
    }

    void releaseParkingSpace(String vehicleNumber) {

        Vehicle found = null;

        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.vehicleNumber.equalsIgnoreCase(vehicleNumber)) {
                found = vehicle;
                break;
            }
        }

        if (found == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        LocalDateTime exitTime = LocalDateTime.now();

        Duration duration = Duration.between(
                found.entryTime, exitTime);

        long minutes = duration.toMinutes();

        // Round up partial hours and charge at least one hour.
        long hours = Math.max(1, (minutes + 59) / 60);

        long parkingFee = hours * found.ratePerHour;

        System.out.println("\n===== PARKING BILL =====");
        System.out.println("Vehicle Number: " + found.vehicleNumber);
        System.out.println("Vehicle Type: " + found.getVehicleType());
        System.out.println("Entry Time: " + found.entryTime);
        System.out.println("Exit Time: " + exitTime);
        System.out.println("Duration: " + minutes + " minutes");
        System.out.println("Charged Hours: " + hours);
        System.out.println("Parking Fee: Rs. " + parkingFee);

        parkedVehicles.remove(found);

        System.out.println("Parking space released successfully.");
    }

    void displayParkingAvailability() {

        System.out.println("\n===== PARKING AVAILABILITY =====");

        System.out.println("Two-wheeler spaces available: "
                + (bikeCapacity - getParkedVehicleCount("Bike")));

        System.out.println("Four-wheeler spaces available: "
                + (carCapacity - getParkedVehicleCount("Car")));

        System.out.println("Total vehicles parked: "
                + parkedVehicles.size());
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two-wheeler parking capacity:");
        int bikeCapacity = sc.nextInt();

        System.out.println("Enter four-wheeler parking capacity:");
        int carCapacity = sc.nextInt();

        if (bikeCapacity < 0 || carCapacity < 0) {
            System.out.println("Capacity cannot be negative.");
            sc.close();
            return;
        }

        ParkingLot parkingLot = new ParkingLot(
                bikeCapacity, carCapacity);

        int choice;

        do {
            System.out.println("\n===== PARKING LOT MANAGEMENT =====");
            System.out.println("1. Park Two Wheeler");
            System.out.println("2. Park Four Wheeler");
            System.out.println("3. Exit Vehicle and Pay");
            System.out.println("4. Display Parking Availability");
            System.out.println("5. Exit Application");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter bike registration number:");
                    String bikeNumber = sc.next();

                    parkingLot.parkVehicle(
                            new TwoWheeler(bikeNumber));
                    break;

                case 2:
                    System.out.println("Enter car registration number:");
                    String carNumber = sc.next();

                    parkingLot.parkVehicle(
                            new FourWheeler(carNumber));
                    break;

                case 3:
                    System.out.println("Enter vehicle registration number:");
                    String vehicleNumber = sc.next();

                    parkingLot.releaseParkingSpace(vehicleNumber);
                    break;

                case 4:
                    parkingLot.displayParkingAvailability();
                    break;

                case 5:
                    System.out.println("Exiting Parking Lot Application...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
