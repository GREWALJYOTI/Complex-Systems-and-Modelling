/*********VANDERPOL OSCILLATOR USING RUNGE-KUTTA RK4 METHOD**********/
import java.lang.*;
import java.util.Random;
import java.io.*;
public class vplcpl {
    public static void main(String[] args) { 
BufferedWriter output = null; 
	
	try{
		PrintStream ps=new PrintStream(new FileOutputStream("vplcpl.txt"));
		System.setOut(ps);
	}
	catch ( IOException e ) {
		e.printStackTrace();
	} 


	double x1=Math.random() , y1= Math.random();
	double x2=Math.random() , y2= Math.random();
	double x3=Math.random() , y3= Math.random();
	double dx1, dy1, dx2, dy2, dx3, dy3;
	double xm ;	
	int t;
	double mu = 0.1;
	double h= 0.01;
	double xn1, yn1, xn2, yn2, xn3, yn3, k1, k2, k3, k4, p1, p2, p3, p4, q1, q2, q3, q4, l1, l2, l3, l4, a1, a2, a3, a4, b1, b2, b3, b4;

	

	for(t=1; t<=100000; t++){
		
		xm = (x1 + x2 + x3)/3;

		k1= xf1(x1,y1,xm);
		p1= yf1(x1,y1);
		k2= xf1((x1+(h/2)*k1), (y1+(h/2)*p1), xm);
		p2= yf1((x1+(h/2)*k1), (y1+(h/2)*p1));
		k3= xf1((x1+ (h/2)*k2), (y1+(h/2)*p2), xm);
		p3= yf1((x1+ (h/2)*k2), (y1+(h/2)*p2));
		k4= xf1((x1+h*k3), (y1+h*p3), xm);		
		p4= yf1((x1+h*k3), (y1+h*p3));
		xn1= x1 + (h/6)*(k1+(2*k2)+(2*k3)+k4);
		yn1= y1 + (h/6)*(p1+(2*p2)+(2*p3)+p4);
	
		l1= xf2(x2,y2,xm);
		a1= yf2(x2,y2);
		l2= xf2((x2+(h/2)*l1), (y2+(h/2)*a1),xm);
		a2= yf2((x2+(h/2)*l1), (y2+(h/2)*a1));
		l3= xf2((x2+ (h/2)*l2), (y2+(h/2)*a2),xm);
		a3= yf2((x2+ (h/2)*l2), (y2+(h/2)*a2));
		l4= xf2((x2+h*l3), (y2+h*a3),xm);
		a4= yf2((x2+h*l3), (y2+h*a3));
		xn2= x2 + (h/6)*(l1+(2*l2)+(2*l3)+l4);
		yn2= y2 + (h/6)*(a1+(2*a2)+(2*a3)+a4);
	

		q1= xf3(x3,y3,xm);
		b1= yf3(x3,y3);
		q2= xf3((x3+(h/2)*q1), (y3+(h/2)*b1),xm);
		b2= yf3((x3+(h/2)*q1), (y3+(h/2)*b1));
		q3= xf3((x3+ (h/2)*q2), (y3+(h/2)*b2),xm);
		b3= yf3((x3+ (h/2)*q2), (y3+(h/2)*b2));
		q4= xf3((x3+h*q3), (y3+h*b3),xm);
		b4= yf3((x3+h*q3), (y3+h*b3));
		xn3= x3 + (h/6)*(q1+(2*q2)+(2*q3)+q4);
		yn3= y3 + (h/6)*(b1+(2*b2)+(2*b3)+b4);
	
		double dif1 = Math.pow((xn1-xn2), 2) + Math.pow((yn1-yn2), 2) ;
		double dif2 = Math.pow((xn2-xn3), 2) + Math.pow((yn2-yn3), 2) ;
		double dif3 = Math.pow((xn3-xn1), 2) + Math.pow((yn3-yn1), 2) ;
		
		double ds1 = Math.pow(dif1, 0.5);
		double ds2 = Math.pow(dif2, 0.5);
		double ds3 = Math.pow(dif3, 0.5);

		System.out.println("" + t + "\t" + xn1 + "\t" + xn2 + "\t" + xn3);	
		
		x1=xn1;
		y1=yn1;
		x2=xn2;
		y2=yn2;
		x3=xn3;
		y3=yn3;
		
	}
	
	}
	public static double xf1(double a, double b, double t){
		return (b + 0.5*(t-a));	
	}

	public static double yf1(double c, double d) {
		double j = 0.1*(1-Math.pow(c,2))*d-c;
	
		return j;
 
	}
	public static double xf2(double e , double f, double v){
		return (f + 0.5*(v-e));	
	}

	public static double yf2(double g, double h) {
		double o = 0.1*(1-Math.pow(g,2))*h-g;
	
		return o;
 
	}
	public static double xf3(double i, double l, double u){
		return (l + 0.5*(u-i));	
	}

	public static double yf3(double p, double k) {
		double s = 0.1*(1-Math.pow(p,2))*k-p;
	
		return s;
 
	}
}
