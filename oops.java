public class oops{
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.color = "red";
        t1.display();
    }
}

class Shape{
    String color;

}

class Triangle extends Shape{
    void display(){
        System.out.println(this.color);
    }
}

class eqtr extends Triangle{
    
}