import java.util.*;


 class Complex{
	float real,img;

	public Complex(){
		real=0;
		img=0;
	}
	public Complex(float a ,float b){
		real=a;
		img=b;
	}
	
	public void Display(Complex C1,Complex C2) {
		System.out.println("First Complex Numbers =("+C1.real+")+("+C1.img+")i");
		System.out.println("Second Complex Numbers =("+C2.real+")+("+C2.img+")i");
	}
	
	public void add(Complex C1,Complex C2) {
		float real,img;
		real=(C1.real+C2.real);
		img=(C1.img+C2.img);
		System.out.println("Addition of Complex Numbers =("+real+")+("+img+")i");
	}
	
	public void sub(Complex C1,Complex C2) {
		float real,img;
		real=(C1.real-C2.real);

		img=(C1.img-C2.img);
		System.out.println("Substraction of Complex Numbers =("+real+")+("+img+")i");
	}
	
	public void mul(Complex C1,Complex C2) {
		float real,img;
		real=(C1.real*C2.real-C1.img*C2.img);
		img=(C1.real*C2.img+C1.img*C2.real);
		System.out.println("Multiplication of Complex Numbers =("+real+")+("+img+")i");
	}
	
	public void div(Complex C1,Complex C2) {
		float real,img;
		real=(C1.real*C2.real+C1.img*C2.img)/(C2.real*C2.real+C2.img*C2.img);
		img=(C1.img*C2.real-C1.real*C2.img)/(C2.real*C2.real+C2.img*C2.img);
		System.out.println("Division of Complex Numbers =("+real+")+("+img+")i");
	}

}


public class Main {


	public static void main(String[] args) {
		
		float num1,num2;
		Complex cal=new Complex();
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter the Complex number in a+bi format : ");
		
		System.out.print("Enter real part of First Number: a : ");
		num1=Sc.nextFloat();
		System.out.print("Enter img part of First Number: b : ");
		num2=Sc.nextFloat();
		Complex Com1=new Complex(num1,num2);
		
		System.out.print("Enter real part of Second Number: a : ");
		num1=Sc.nextFloat();
		System.out.print("Enter img part of Second Number: b : ");
		num2=Sc.nextFloat();
		Complex Com2=new Complex(num1,num2);
		Sc.close();
		
		System.out.print("\n");
		cal.Display(Com1,Com2);
		System.out.print("\n");
		cal.add(Com1,Com2);
		cal.sub(Com1,Com2);
		cal.mul(Com1,Com2);
		cal.div(Com1, Com2);
	}

}