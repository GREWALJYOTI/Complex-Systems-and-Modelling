/***VANDERPOL OSCILLATOR USING RK4 METHOD***/
import java.lang.*;
import java.util.Random;
import java.io.*;
public class vplrk {
    public static void main(String[] args) { 
BufferedWriter output = null; 
	
	try{
		PrintStream ps=new PrintStream(new FileOutputStream("vplrk.txt"));
		System.setOut(ps);
	}
	catch ( IOException e ) {
		e.printStackTrace();
	} 


	double x=Math.random() , y= Math.random();
	double dx, dy;
	int t;
	double mu = 0.5;
	double h= 0.01;
	double xn, yn, k1, k2, k3, k4, p1, p2, p3, p4;

	

	for(t=1; t<=10000; t++){
		
		
		k1= xf(x,y);
		p1= yf(x,y);
		k2= xf((x+(h/2)*k1), (y+(h/2)*p1));
		p2= yf((x+(h/2)*k1), (y+(h/2)*p1));
		k3= xf((x+ (h/2)*k2), (y+(h/2)*p2));
		p3= yf((x+ (h/2)*k2), (y+(h/2)*p2));
		k4= xf((x+h*k3), (y+h*p3));
		xn= x + (h/6)*(k1+(2*k2)+(2*k3)+k4);
	
		
		
		
		p4= yf((x+h*k3), (y+h*p3));
		yn= y + (h/6)*(p1+(2*p2)+(2*p3)+p4);
	
	
		System.out.println("" + t + "\t" + xn + "\t" + yn  );	
		x=xn;
		y=yn;
		
	}
	
	}
	public static double xf(double a, double b){
		return b;	
	}

	public static double yf(double c, double d) {
		double s = 0.5*(1-Math.pow(c,2)*d)-c;
	
		return s;
 
	}
}
