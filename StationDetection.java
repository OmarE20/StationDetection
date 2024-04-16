import java.util.Random;

class AutonomousVehicle {
    private static final int MAX_DISTANCE = 100;
    private static final int STATION_DISTANCE_THRESHOLD = 10;

    private double currentX;
    private double currentY;

    // Constructor to initialize the vehicle's starting position
    public AutonomousVehicle(double initialX, double initialY) {
        this.currentX = initialX;
        this.currentY = initialY;
    }

    // Method to simulate the movement of the vehicle
    public void move(double deltaX, double deltaY) {
        this.currentX += deltaX;
        this.currentY += deltaY;
    }

    // Method to align the vehicle to a charging station
    public void alignToStation(double stationX, double stationY) {
        // Implement alignment logic here
        System.out.println("Aligning to station...");
        // Assume alignment is successful
    }

    // Method to check if the charging station is detected based on distance
    public boolean isStationDetected(double stationX, double stationY) {
        double distanceToStation = calculateDistance(stationX, stationY);
        return distanceToStation <= STATION_DISTANCE_THRESHOLD;
    }

    // Helper method to calculate the distance between the vehicle and a point
    private double calculateDistance(double targetX, double targetY) {
        return Math.sqrt(Math.pow((currentX - targetX), 2) + Math.pow((currentY - targetY), 2));
    }

    // Main method for testing the autonomous vehicle functionality
    public static void main(String[] args) {
        AutonomousVehicle vehicle = new AutonomousVehicle(0, 0);
        Random random = new Random();

        // Simulate vehicle movement
        for (int i = 0; i < 5; i++) {
            double deltaX = random.nextDouble() * MAX_DISTANCE;
            double deltaY = random.nextDouble() * MAX_DISTANCE;
            vehicle.move(deltaX, deltaY);

            System.out.println("Current Position: (" + vehicle.currentX + ", " + vehicle.currentY + ")");

            // Simulate station detection
            double stationX = 50; // Example station coordinates
            double stationY = 50;
            if (vehicle.isStationDetected(stationX, stationY)) {
                System.out.println("Charging station detected!");
                vehicle.alignToStation(stationX, stationY);
                // Code to navigate to the station and charge
            }
        }
    }
}
