import java.util.*;

class Publication {
    String title;
    double price;
    int copies;
    static double TotalPrice;
    static Scanner sc = new Scanner(System.in);
    
    void getData() {
        System.out.print("Enter the Price : ");
        price = sc.nextDouble();
        System.out.print("Enter number of copies : ");
        copies = sc.nextInt();
    }
    
    void saleCopy() {
        System.out.println("Total sell by publication house : " + TotalPrice);
    }
}

class Book extends Publication {
    String author;
    public double avg = 50;
    public double bookSell;
    public static double TotalBookSell;
    public static double TotalBookAmount;
    
    void getAuthor() {
        System.out.print("Enter Author's Name : ");
        author = sc.next();
        System.out.print("Enter Title : ");
        title = sc.next();
    }
    
    void getBookData() {
        getAuthor();
        getData();
    }
    
    void Restock() {
        if(this.copies > avg) {
            System.out.println("Restock the values of book and enter the value again");
            avg = avg + 50;
            getData();
        }
        else {
            avg = avg - this.copies;
        }
    }
    
    void saleCopy() {
        bookSell = (this.copies * this.price);
        TotalBookSell += this.copies;
        TotalBookAmount += bookSell;
        TotalPrice += bookSell;
        System.out.println();
        System.out.println("Ordered Book : " + this.title);
        System.out.println("Total Amount : " + bookSell);
        System.out.println();
    }
    
    static void TotalBookSell() {
        System.out.println("Total Book Sell : " + TotalBookSell);
        System.out.println("Total Amount : " + TotalBookAmount);
    }
}

class Magazine extends Publication {
    String author;
    double orderQty;
    double currentIssue;
    double avg = 50;
    public double magSell;
    public static double TotalMagSell;
    public static double TotalMagAmount;
    
    void getAuthor() {
        System.out.print("Enter Magazine's Author's Name : ");
        author = sc.next();
        System.out.print("Enter Title : ");
        title = sc.next();
    }
    
    void getBookData() {
        getAuthor();
        getData();
    }
    
    void Restock() {
        if(this.copies > avg) {
            System.out.println("Restock the values of magazine and enter the value again");
            avg = avg + 50;
            getData();
        }
        else {
            avg = avg - this.copies;
        }
    }
    
    void saleCopy() {
        magSell = (this.copies * this.price);
        TotalMagSell += this.copies;
        TotalMagAmount += magSell;
        TotalPrice += magSell;
        System.out.println();
        System.out.println("Ordered Magazine : " + this.title);
        System.out.println("Total Amount : " + magSell);
        System.out.println();
    }
    
    static void TotalMagSell() {
        System.out.println("Total Magazine Sell : " + TotalMagSell);
        System.out.println("Total Amount : " + TotalMagAmount);
    }
}

public class Driver {
    public static void main(String[] args) {
        Publication p = new Publication();
        Book[] books = new Book[100];  
        Magazine[] magazines = new Magazine[100]; 
        int bookCount = 0;
        int magazineCount = 0;
        Scanner sc = new Scanner(System.in);
        int op;
    do {
    System.out.println("1. Order Book");
    System.out.println("2. Order Magazine");
    System.out.println("3. Total Book Sell");
    System.out.println("4. Total Magazine Sell");
    System.out.println("5. Total Publication Sell");
    System.out.println("6. Display All Books");
    System.out.println("7. Display All Magazines");
    System.out.println("8. Order more than one, enter no");
    System.out.println("9. Restock");
    System.out.println("10. Enter and order from Multiple Books");
    System.out.println("0. Exit");
    System.out.print("Enter your choice : ");
    op = sc.nextInt();
    
    switch(op) {
        case 1:
            System.out.println();
            books[bookCount] = new Book();
            books[bookCount].getBookData();
            books[bookCount].Restock();
            books[bookCount].saleCopy();
            bookCount++;
            System.out.println();
            break;
            
        case 2:
            System.out.println();
            magazines[magazineCount] = new Magazine();
            magazines[magazineCount].getBookData();
            magazines[magazineCount].Restock();
            magazines[magazineCount].saleCopy();
            magazineCount++;
            System.out.println();
            break;
            
        case 3:
            System.out.println();
            Book.TotalBookSell();
            System.out.println();
            break;
            
        case 4:
            System.out.println();
            Magazine.TotalMagSell();
            System.out.println();
            break;
            
        case 5:
            System.out.println();
            Book.TotalBookSell();
            Magazine.TotalMagSell();
            p.saleCopy();
            System.out.println();
            break;
            
        case 6:
            System.out.println("\nList of all Books:");
            for (int i = 0; i < bookCount; i++) {
                System.out.println((i+1) + ". Title: " + books[i].title + 
                                ", Author: " + books[i].author + 
                                ", Price: " + books[i].price + 
                                ", Copies: " + books[i].copies);
            }
            System.out.println();
            break;
            
        case 7:
            System.out.println("\nList of all Magazines:");
            for (int i = 0; i < magazineCount; i++) {
                System.out.println((i+1) + ". Title: " + magazines[i].title + 
                                ", Author: " + magazines[i].author + 
                                ", Price: " + magazines[i].price + 
                                ", Copies: " + magazines[i].copies);
            }
            System.out.println();
            break;
            
        case 8:
            System.out.println();
            System.out.println("Enter number of Books : ");
            int n = sc.nextInt();
            System.out.println("Enter number of Magazines : ");
            int m = sc.nextInt();
            for(int i = 0; i < n; i++) {
                books[bookCount] = new Book();
                books[bookCount].getBookData();
                books[bookCount].Restock();
                books[bookCount].saleCopy();
                bookCount++;
            }
            for(int i = 0; i < m; i++) {
                magazines[magazineCount] = new Magazine();
                magazines[magazineCount].getBookData();
                magazines[magazineCount].Restock();
                magazines[magazineCount].saleCopy();
                magazineCount++;
            }
            System.out.println();
            break;

        case 10:
            System.out.println();
            System.out.println("Enter the number of Books to store: ");
            int numBooks = sc.nextInt();
            Book[] tempBooks = new Book[numBooks]; 

            for (int i = 0; i < numBooks; i++) {
                tempBooks[i] = new Book();
                tempBooks[i].getBookData();
                tempBooks[i].Restock();
            }

            System.out.println("Entered Books:");
            for (int i = 0; i < numBooks; i++) {
                System.out.println((i+1) + ". Title: " + tempBooks[i].title + 
                                ", Author: " + tempBooks[i].author + 
                                ", Price: " + tempBooks[i].price + 
                                ", Copies: " + tempBooks[i].copies);
            }
            System.out.print("Enter the number of the book you want to order: ");
                    int bookIndex = sc.nextInt() - 1;
                    if (bookIndex >= 0 && bookIndex < numBooks) {
                        tempBooks[bookIndex].Restock();
                        tempBooks[bookIndex].saleCopy();
                    } else {
                        System.out.println("Invalid selection.");
                    }
            System.out.println();
            break;
        
        case 0:
            break;
    }
} while(op != 0);

    }
}