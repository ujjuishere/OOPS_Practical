import java.util.Scanner;

class Employee {
    int id;
    String name;
    String mail;
    String address;
    long mobno;
    double gross_pay, net_pay;
    double DA, HRA, PF, CF;
    static int count = 0;

    public void input(Scanner sc) {
        System.out.println("Enter Employee ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.println("\nEnter Employee Name: ");
        name = sc.nextLine();

        System.out.println("\nEnter Employee Email: ");
        mail = sc.next();
        sc.nextLine();
        while (!mail.contains("@") || !mail.endsWith(".com")) {
            System.out.println("Invalid Email");
            System.out.println("\nEnter Employee Email: ");
            mail = sc.next();
            sc.nextLine();
        }

        System.out.println("\nEnter Employee Mobile Number: ");
        mobno = sc.nextLong();
        while (String.valueOf(mobno).length() != 10 || mobno >= 0) {
            System.out.println("Invalid Mobile Number");
            System.out.println("\nEnter Employee Mobile Number: ");
            mobno = sc.nextLong();
        }
        sc.nextLine();

        System.out.println("\nEnter Employee Address: ");
        address = sc.nextLine();
    }

    public double gross(float basic_pay) {
        DA = 0.97 * basic_pay;
        HRA = 0.10 * basic_pay;
        PF = 0.12 * basic_pay;
        CF = 0.001 * basic_pay;
        gross_pay = basic_pay + DA + HRA + PF + CF;
        return gross_pay;
    }

    public double net(float gross_pay) {
        net_pay = gross_pay - (PF + CF);
        return net_pay;
    }

    public void PaySlip(float basic_pay, double gross_pay, double net_pay) {
        System.out.println();
        System.out.println("Pay Slip:");
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + mail);
        System.out.println("Mobile Number: " + mobno);
        System.out.println("Address: " + address);
        System.out.println("\nBasic Pay: " + basic_pay);
        System.out.println("DA: " + DA);
        System.out.println("HRA: " + HRA);
        System.out.println("PF: " + PF);
        System.out.println("CF: " + CF);        
        System.out.println("\nGross Pay: " + gross_pay);
        System.out.println("Net Pay: " + net_pay);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Whose PaySlip do you want?");
            System.out.println("1. Project Manager");
            System.out.println("2. Assistant Project Manager");
            System.out.println("3. Team Leader");
            System.out.println("4. Programer");
            System.out.println("0 to Exit");
            choice = sc.nextInt();
            int n = 0;
            float basic = 0;
            switch (choice) {
                case 1:
                    
                    System.out.println("\nEnter Basic Pay: ");
                    basic = sc.nextFloat();
                    while (basic < 0) {
                        System.out.println("Invalid Salary");
                        System.out.println("Enter Basic Pay: ");
                        basic = sc.nextFloat();
                    }
                    
                    
                    break;
                case 2:
                    
                    System.out.println("\nEnter Basic Pay: ");
                    basic = sc.nextFloat();
                    while (basic < 0) {
                        System.out.println("Invalid Salary");
                        System.out.println("Enter Basic Pay: ");
                        basic = sc.nextFloat();
                    }
                    break;
                case 3:
                    
                    System.out.println("\nEnter Basic Pay: ");
                    basic = sc.nextFloat();
                    while (basic < 0) {
                        System.out.println("Invalid Salary");
                        System.out.println("Enter Basic Pay: ");
                        basic = sc.nextFloat();
                    }
                    break;
                case 4:
                    
                    System.out.println("\nEnter Basic Pay: ");
                    basic = sc.nextFloat();
                    while (basic < 0) {
                        System.out.println("Invalid Salary");
                        System.out.println("Enter Basic Pay: ");
                        basic = sc.nextFloat();
                    }
                    break;
                case 0:
                    sc.close();
                    System.out.println("\nYou visited " + count + " employees");
                    System.out.println("Thanks for visiting :)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (choice > 0 && choice < 5);

        sc.close();
    }
}

class PM extends Employee {
    float basic_pay;
    public float in(Scanner sc) {
        System.out.println("\nEnter Basic Pay: ");
        basic_pay = sc.nextFloat();
        while (basic_pay < 0) {
            System.out.println("Invalid Salary");
            System.out.println("Enter Basic Pay: ");
            basic_pay = sc.nextFloat();
        }
        return basic_pay;
    }
}

class APM extends Employee {
    float basic_pay;
    public float in(Scanner sc) {
        System.out.println("\nEnter Basic Pay: ");
        basic_pay = sc.nextFloat();
        while (basic_pay < 0) {
            System.out.println("Invalid Salary");
            System.out.println("Enter Basic Pay: ");
            basic_pay = sc.nextFloat();
        }
        return basic_pay;
    }
}

class TL extends Employee {
    float basic_pay;
    public float in(Scanner sc) {
        System.out.println("\nEnter Basic Pay: ");
        basic_pay = sc.nextFloat();
        while (basic_pay < 0) {
            System.out.println("Invalid Salary");
            System.out.println("Enter Basic Pay: ");
            basic_pay = sc.nextFloat();
        }
        return basic_pay;
    }
}

class Programer extends Employee {
    float basic_pay;
    public float in(Scanner sc) {
        System.out.println("\nEnter Basic Pay: ");
        basic_pay = sc.nextFloat();
        while (basic_pay < 0) {
            System.out.println("Invalid Salary");
            System.out.println("Enter Basic Pay: ");
            basic_pay = sc.nextFloat();
        }
        return basic_pay;
    }
}
