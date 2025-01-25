package org.expertifie.lld;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CabBookings {

    public class Main {
        public static void main(String[] args) {
            // Create the cab service
            CabBookingService cabBookingService = new CabBookingService();

            // Add some cabs
            cabBookingService.addCab(new Driver(1, new Location(12.9715987, 77.5945627)));
            cabBookingService.addCab(new Driver(2, new Location(12.935242, 77.624486)));
            cabBookingService.addCab(new Driver(3, new Location(12.9611159, 77.6362214)));

            // Search location
            Location searchLocation = new Location(12.9611159, 77.6362214);

            // Find nearby cabs within 500 meters
            List<Driver> nearbyDrivers = cabBookingService.findNearbyDriver(searchLocation, 500);

            // Print the nearby cabs
            System.out.println("Nearby cabs within 500 meters:");
            for (Driver driver : nearbyDrivers) {
                System.out.println("Driver ID: " + driver.getDriverId());
            }
        }
    }


}

class CabBookingService {
    @Autowired
    LocationService locationService;
    private final List<Driver> drivers = new ArrayList<>();

    public void addCab(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> findNearbyDriver(Location location, double proximityMeters) {
        List<Driver> nearbyDriver = new ArrayList<>();
        for (Driver driver : drivers) {
            double distance = locationService.calculateDistance(location, driver.getLocation());
            if (distance <= proximityMeters && driver.isAvailableForBooking()) {
                nearbyDriver.add(driver);
            }
        }
        return nearbyDriver;
    }
}

@Getter
@Setter
class Location{

    int locationId;
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

@Getter
@Setter
class Driver{
    int driverId;
    String driverName;
    String vehicleNo;
    String availableStatus;
    int rating;
    Location location;
    boolean isAvailableForBooking;

    public Driver(int driverId, Location location) {
        this.driverId = driverId;
        this.location = location;
    }
}

@Getter
@Setter
class Rider{
int userId;
String userName;
String email;
String rating;
}

@Getter
@Setter
class BookingRequest{
    int requestId;
    int userId;
    int driverId;
    String pickupLocation;
    String DropOffLocation;
    LocalDateTime pickupDateTime;
    String status;

}
