import java.lang.*;
import java.util.Random;
import java.io.*;
public class lorenz {
    public static void main(String[] args) { 
BufferedWriter output = null; 
	try {
		File file = new File("FileName2.txt");
		output = new BufferedWriter(new FileWriter(file));   

		output.write("Write your text here");

		output.close(); 
	} catch ( IOException e ) {
		e.printStackTrace();
	} 



	try{
		PrintStream ps=new PrintStream(new FileOutputStream("lorenz.txt"));
		System.setOut(ps);
	}
	catch ( IOException e ) {
		e.printStackTrace();
	} 

double x=Math.random(), y= Math.random(), z= Math.random();
double dx, dy, dz;
int t;
double sig=10.0, rho= 28.0, beta=8/3;
double h= 0.01;
double xn, yn, zn;


for(t=1; t<=1000; t++){
	dx= sig*(y-x);
	dy= x*(rho-z)-y;
	dz= (x*y) - (beta*z);	
	xn= x + (h*dx);
	yn= y + (h*dy);
	zn= z + (h*dz);

	System.out.println("" + t + "\t" + x + "\t" + y + "\t" + z );	
	x=xn;
	y=yn;
	z=zn;
}


	}
}
