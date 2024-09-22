import java.util.*;

interface Properties {
    void gearChange(int a);
    void speedChange(int a);
}

class Vehicles implements Properties {
    int gear = 0;
    int speed = 0;

    public void gearChange(int n) {
        gear += n;
        speedGear();
    }

    public void speedChange(int n) {
        speed += n;
        if(speed < 0 )speed  = 0;
        gearSpeed();
    }

    public void gearSpeed() {
        if (speed <= 0) gear = 0;
        else if (speed <= 10) gear = 1;
        else if (speed <= 30) gear = 2;
        else if (speed <= 50) gear = 3;
        else if (speed <= 70) gear = 4;
        else if (speed <= 90) gear = 5;
        else gear = 6;
    }

    public void speedGear() {
        switch (gear) {
            case 0:
                speed = 0;
                break;
            case 1:
                if (speed > 10) speed = 10;
                break;
            case 2:
                if (speed < 10) speed = 10;
                else if (speed > 30) speed = 30;
                break;
            case 3:
                if (speed < 30) speed = 30;
                else if (speed > 80) speed = 80;
                break;
            case 4:
                if (speed < 80) speed = 80;
                else if (speed > 120) speed = 120;
                break;
            case 5:
                if (speed < 120) speed = 120;
                else if (speed > 160) speed = 160;
                break;
            case 6:
                if (speed < 160) speed = 200;
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press 9 to Exit \n");
            System.out.println("Press 1 for Bicycle");
            System.out.println("Press 2 for Bike");
            System.out.println("Press 3 for Car");

            int choice = sc.nextInt();
            if (choice == 9) break;

            if (choice > 0 && choice < 5) {
                System.out.println("*** Options ***");
                System.out.println("1 to Speed Up");
                System.out.println("2 to Gear Down");
                System.out.println("3 to Gear Up");
                System.out.println("5 to Apply Brakes");
                System.out.println("0 to Change Vehicle\n");

                switch (choice) {
                    case 1:
                        Bicycle b = new Bicycle();
                        System.out.println("Bicycle Equipped");
                        b.run(sc);
                        break;
                    case 2:
                        Bike bk = new Bike();
                        System.out.println("Bike Equipped");
                        bk.run(sc);
                        break;
                    case 3:
                        Car c = new Car();
                        System.out.println("Car Equipped");
                        c.run(sc);
                        break;
                    default:
                        System.out.println("Please Enter Valid Integer Input Only");
                }
            }
        }
        sc.close();
        System.exit(0);
    }
}

class Bicycle extends Vehicles {
    public Bicycle() {
        this.speedChange(0);
        this.gearChange(0);
    }

    void details() {
        System.out.println("+-----------------+----------------+");
        System.out.println("|  Element       |  Value          |");
        System.out.println("+-----------------+----------------+");
        System.out.printf("| Speed           | %-14d |\n", speed);
        System.out.printf("| Gear            | %-14d |\n", gear);
        System.out.printf("| Max Speed       | %-14d |\n", 50);
        System.out.printf("| Max Gear        | %-14d |\n", 3);
        System.out.println("+-----------------+----------------+");
    }

    public void speedChange(int n) {
        super.speedChange(n);
        if (speed > 50) speed = 50;
    }

    public void run(Scanner sc) {
        int x;
        while (true) {
            details();
            x = sc.nextInt();
            if (x == 0) break;
            if (x == 5) speedChange(-4);
            if (x == 1) speedChange(4);
            if (x == 3) gearChange(1);
            if (x == 2) gearChange(-1);
        }
    }
}

class Bike extends Vehicles {
    public Bike() {
        this.speedChange(0);
        this.gearChange(1);
    }

    void details() {
        System.out.println("+-----------------+----------------+");
        System.out.println("|  Attribute      |  Value          |");
        System.out.println("+-----------------+----------------+");
        System.out.printf("| Speed           | %-14d |\n", speed);
        System.out.printf("| Gear            | %-14d |\n", gear);
        System.out.printf("| Max Speed       | %-14d |\n", 200);
        System.out.printf("| Max Gear        | %-14d |\n", 6);
        System.out.println("+-----------------+----------------+");
    }

    public void speedChange(int n) {
        super.speedChange(n);
        if (speed > 200) speed = 200; 
    }

    public void run(Scanner sc) {
        int x;
        while (true) {
            details();
            x = sc.nextInt();
            if (x == 0) break;
            if (x == 5) speedChange(-5);
            if (x == 1) speedChange(6);
            if (x == 3) gearChange(1);
            if (x == 2) gearChange(-1);
        }
    }
}

class Car extends Vehicles {
    public Car() {
        this.speedChange(0);
        this.gearChange(1);
    }

    void details() {
        System.out.println("+-----------------+----------------+");
        System.out.println("|  Attribute      |  Value          |");
        System.out.println("+-----------------+----------------+");
        System.out.printf("| Speed           | %-14d |\n", speed);
        System.out.printf("| Gear            | %-14d |\n", gear);
        System.out.printf("| Max Speed       | %-14d |\n", 150);
        System.out.printf("| Max Gear        | %-14d |\n", 6);
        System.out.println("+-----------------+----------------+");
    }

    public void speedChange(int n) {
        super.speedChange(n);
        if (speed > 150) speed = 150; 
    }

    public void run(Scanner sc) {
        int x;
        while (true) {
            details();
            x = sc.nextInt();
            if (x == 0) break;
            if (x == 5) speedChange(-6);
            if (x == 1) speedChange(5);
            if (x == 3) gearChange(1);
            if (x == 2) gearChange(-1);
        }
    }
}