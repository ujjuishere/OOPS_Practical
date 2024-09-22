import java.util.*;

interface VehicleOperations {
    void shiftGear(int change);
    void alterVelocity(int change);
    void slowDown(int reduction);
}

class TransportSimulator implements VehicleOperations {
    int currentGear = 0;
    int currentSpeed = 0;

    public void shiftGear(int change) {
        currentGear += change;
    }

    public void alterVelocity(int change) {
        currentSpeed += change;
    }

    public void slowDown(int reduction) {
        currentSpeed -= reduction;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 'Q' at any time to quit the simulation\n");
            System.out.println("1: Pedal Cycle");
            System.out.println("2: Motorcycle");
            System.out.println("3: Automobile");
            System.out.println("4: Lorry");
            System.out.println("Choose your vehicle (1-4):");

            String selection = input.next();
            if (selection.equalsIgnoreCase("Q")) break;

            int vehicleType;
            try {
                vehicleType = Integer.parseInt(selection);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            if (vehicleType > 0 && vehicleType < 5) {
                System.out.println("=== Control Instructions ===");
                System.out.println("'F': Accelerate");
                System.out.println("'S': Decelerate");
                System.out.println("'D': Downshift");
                System.out.println("'U': Upshift");
                System.out.println("'B': Brake");
                System.out.println("'X': Switch Vehicle");
                System.out.println();
                
                switch (vehicleType) {
                    case 1:
                        PedalCycle pc = new PedalCycle();
                        System.out.println("Pedal Cycle Selected");
                        pc.operate(input);
                        break;
                    case 2:
                        Motorcycle mc = new Motorcycle();
                        System.out.println("Motorcycle Selected");
                        mc.operate(input);
                        break;
                    case 3:
                        Automobile auto = new Automobile();
                        System.out.println("Automobile Selected");
                        auto.operate(input);
                        break;
                    case 4:
                        Lorry lorry = new Lorry();
                        System.out.println("Lorry Selected");
                        lorry.operate(input);
                        break;
                }
            } else {
                System.out.println("Invalid selection. Please choose a number between 1 and 4.");
            }
        }
        input.close();
        System.exit(0);
    }
}

abstract class Vehicle extends TransportSimulator {
    int maxSpeed;
    int maxGear;

    abstract void displayInfo();

    void applyBrakes() {
        System.out.print("Enter braking force (km/h): ");
        int force = new Scanner(System.in).nextInt();
        slowDown(force);
        if (currentSpeed < 0) currentSpeed = 0;
    }

    void accelerate() {
        System.out.print("Enter acceleration (km/h): ");
        int acceleration = new Scanner(System.in).nextInt();
        if (currentSpeed + acceleration <= maxSpeed) {
            this.alterVelocity(acceleration);
        } else {
            this.alterVelocity(maxSpeed - currentSpeed);
            System.out.println("Maximum speed reached!");
        }
    }

    void decelerate() {
        System.out.print("Enter deceleration (km/h): ");
        int deceleration = new Scanner(System.in).nextInt();
        if (currentSpeed - deceleration >= 0) {
            this.alterVelocity(-deceleration);
        } else {
            this.alterVelocity(-currentSpeed);
            System.out.println("Vehicle has stopped.");
        }
    }

    void upshift() {
        if (currentGear < maxGear) this.shiftGear(1);
        else System.out.println("Already at highest gear.");
    }

    void downshift() {
        if (currentGear > 0) this.shiftGear(-1);
        else System.out.println("Already at lowest gear.");
    }

    public void operate(Scanner input) {
        String action;
        while (true) {
            displayInfo();
            action = input.next().toUpperCase();
            if (action.equals("X")) break;
            if (action.equals("B")) applyBrakes();
            if (action.equals("F")) accelerate();
            if (action.equals("S")) decelerate();
            if (action.equals("U")) upshift();
            if (action.equals("D")) downshift();
        }
    }
}

class PedalCycle extends Vehicle {
    public PedalCycle() {
        this.alterVelocity(0);
        this.shiftGear(1);
        this.maxSpeed = 50;
        this.maxGear = 24;
    }

    void displayInfo() {
        System.out.println("|----- Pedal Cycle Status -----|");
        System.out.printf("|  Speed: %-3d km/h  Gear: %-2d  |\n", currentSpeed, currentGear);
        System.out.println("|  Max Speed: 50 km/h         |");
        System.out.println("|  Max Gear: 24               |");
        System.out.println("|-------------------------------|");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle() {
        this.alterVelocity(0);
        this.shiftGear(1);
        this.maxSpeed = 200;
        this.maxGear = 6;
    }

    void displayInfo() {
        System.out.println("|----- Motorcycle Status -----|");
        System.out.printf("|  Speed: %-3d km/h  Gear: %-2d  |\n", currentSpeed, currentGear);
        System.out.println("|  Max Speed: 200 km/h        |");
        System.out.println("|  Max Gear: 6                |");
        System.out.println("|------------------------------|");
    }
}

class Automobile extends Vehicle {
    public Automobile() {
        this.alterVelocity(0);
        this.shiftGear(1);
        this.maxSpeed = 180;
        this.maxGear = 6;
    }

    void displayInfo() {
        System.out.println("|----- Automobile Status -----|");
        System.out.printf("|  Speed: %-3d km/h  Gear: %-2d  |\n", currentSpeed, currentGear);
        System.out.println("|  Max Speed: 180 km/h        |");
        System.out.println("|  Max Gear: 6                |");
        System.out.println("|------------------------------|");
    }
}

class Lorry extends Vehicle {
    public Lorry() {
        this.alterVelocity(0);
        this.shiftGear(1);
        this.maxSpeed = 120;
        this.maxGear = 8;
    }

    void displayInfo() {
        System.out.println("|------- Lorry Status --------|");
        System.out.printf("|  Speed: %-3d km/h  Gear: %-2d  |\n", currentSpeed, currentGear);
        System.out.println("|  Max Speed: 120 km/h        |");
        System.out.println("|  Max Gear: 8                |");
        System.out.println("|------------------------------|");
    }
}