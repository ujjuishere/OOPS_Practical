import java.util.*;

interface properties {
    void gearChange(int a);
    void speedChange(int a);
    void brakes(int n);
}

class Vehicles implements properties {
    int gear = 0;
    int speed = 0;

    public void gearChange(int n) {
        gear += n;
    }

    public void speedChange(int n) {
        speed += n;
    }

    public void brakes(int n) {
        speed -= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press 9 anytime to Exit game\n");
            System.out.println("Press 1 to ride Bicycle");
            System.out.println("Press 2 to ride Bike");
            System.out.println("Press 3 to ride Car");
            System.out.println("Press 4 to ride Truck");

            int choice = sc.nextInt();
            if (choice == 9) break;

            if (choice > 0 && choice < 5) {
                System.out.println("*** Game Rules ***");
                System.out.println("8 to Speed Up");
                System.out.println("2 to Speed Down");
                System.out.println("4 to Gear Down");
                System.out.println("6 to Gear Up");
                System.out.println("5 to Apply Brakes");
                System.out.println("0 to Change Vehicle\n");
                System.out.println();
                
                switch (choice) {
                    case 1:
                        Bicycle b = new Bicycle();
                        System.out.println("Welcome Bicycle Rider");
                        b.run(sc);
                        break;
                    case 2:
                        Bike bk = new Bike();
                        System.out.println("Welcome Bike Rider");
                        bk.run(sc);
                        break;
                    case 3:
                        Car c = new Car();
                        System.out.println("Welcome Car Driver");
                        c.run(sc);
                        break;
                    case 4:
                        Truck t = new Truck();
                        System.out.println("Welcome Truck Driver");
                        t.run(sc);
                        break;
                    default:
                        System.out.println("Please Enter Valid Integer Input Only");
                }
            } else {
                System.out.println("Please Enter Valid Integer Input Only");
            }
        }
        sc.close();
        System.exit(0);
    }
}

class Bicycle extends Vehicles {
    public Bicycle() {
        this.speedChange(0);
        this.gearChange(1);
    }

    void details() {
        System.out.println("\t\t\t Details \t\t\t");
        System.out.printf("\tSpeed: %d\t\tGear: %d\t\n", speed, gear);
        System.out.printf("\tMaxSpeed: 50\tMaxGear: 24\n");
    }

    void applyBrakes() {
        brakes(4);
        if (speed < 0) speed = 0;
    }

    void speedUp() {
        if (speed < 50) this.speedChange(4);
        if (speed > 50) speed = 50;
    }

    void speedDown() {
        if (speed > 0) this.speedChange(-1);
    }

    void gearUp() {
        if (gear < 24) this.gearChange(1);
    }

    void gearDown() {
        if (gear > 0) this.gearChange(-1);
    }

    public void run(Scanner sc) {
        int x;
        while (true) {
            details();
            x = sc.nextInt();
            if (x == 0) break;
            if (x == 5) applyBrakes();
            if (x == 8) speedUp();
            if (x == 2) speedDown();
            if (x == 6) gearUp();
            if (x == 4) gearDown();
        }
    }
}

class Bike extends Vehicles {
    public Bike() {
        this.speedChange(0);
        this.gearChange(1);
    }

    void details() {
        System.out.println("\t\t\t Details \t\t\t");
        System.out.printf("\tSpeed: %d\t\tGear: %d\t\n", speed, gear);
        System.out.printf("\tMaxSpeed: 200\tMaxGear: 8\n");
    }

    void applyBrakes() {
        brakes(5);
        if (speed < 0) speed = 0;
    }

    void speedUp() {
        if (speed < 200) this.speedChange(4);
        if (speed > 200) speed = 200;
    }

    void speedDown() {
        if (speed > 0) this.speedChange(-1);
    }

    void gearUp() {
        if (gear < 8) this.gearChange(1);
    }

    void gearDown() {
        if (gear > 0) this.gearChange(-1);
    }

    public void run(Scanner sc) {
        int x;
        while (true) {
            details();
            x = sc.nextInt();
            if (x == 0) break;
            if (x == 5) applyBrakes();
            if (x == 8) speedUp();
            if (x == 2) speedDown();
            if (x == 6) gearUp();
            if (x == 4) gearDown();
        }
    }
}

class Car extends Vehicles {
    public Car() {
        this.speedChange(0);
        this.gearChange(1);
    }

    void details() {
        System.out.println("\t\t\t Details \t\t\t");
        System.out.printf("\tSpeed: %d\t\tGear: %d\t\n", speed, gear);
        System.out.printf("\tMaxSpeed: 150\tMaxGear: 6\n");
    }

    void applyBrakes() {
        brakes(5);
        if (speed < 0) speed = 0;
    }

    void speedUp() {
        if (speed < 150) this.speedChange(3);
        if (speed > 150) speed = 150;
    }

    void speedDown() {
        if (speed > 0) this.speedChange(-1);
    }

    void gearUp() {
        if (gear < 6) this.gearChange(1);
    }

    void gearDown() {
        if (gear > 0) this.gearChange(-1);
    }

    public void run(Scanner sc) {
        int x;
        while (true) {
            details();
            x = sc.nextInt();
            if (x == 0) break;
            if (x == 5) applyBrakes();
            if (x == 8) speedUp();
            if (x == 2) speedDown();
            if (x == 6) gearUp();
            if (x == 4) gearDown();
        }
    }
}

class Truck extends Vehicles {
    public Truck() {
        this.speedChange(0);
        this.gearChange(1);
    }

    void details() {
        System.out.println("\t\t\t Details \t\t\t");
        System.out.printf("\tSpeed: %d\t\tGear: %d\t\n", speed, gear);
        System.out.printf("\tMaxSpeed: 100\tMaxGear: 5\n");
    }

    void applyBrakes() {
        brakes(2);
        if (speed < 0) speed = 0;
    }

    void speedUp() {
        if (speed < 100) this.speedChange(2);
        if (speed > 100) speed = 100;
    }

    void speedDown() {
        if (speed > 0) this.speedChange(-1);
    }

    void gearUp() {
        if (gear < 5) this.gearChange(1);
    }

    void gearDown() {
        if (gear > 0) this.gearChange(-1);
    }

    public void run(Scanner sc) {
        int x;
        while (true) {
            details();
            x = sc.nextInt();
            if (x == 0) break;
            if (x == 5) applyBrakes();
            if (x == 8) speedUp();
            if (x == 2) speedDown();
            if (x == 6) gearUp();
            if (x == 4) gearDown();
        }
    }
}