import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFrame;

public class Network extends Thread{
	public void run()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("What is number of WI-FI Connections?"); 
	    int size = scan.nextInt();
	    
	    JFrame frame = new JFrame("Router Simulation");
        frame.setSize(270, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = new Container();
        container.setLayout(new FlowLayout());
	    
	    Router r = new Router(size,frame,container);
	    
	    Scanner scan1 = new Scanner(System.in);
		System.out.println("What is number of devices Clients want to connect?"); 
	    int n = scan1.nextInt();
	    
	    Device d[] = new Device[n]; 
	    
	    for(int x=0;x<n;x++) {
	       Scanner scan2 = new Scanner(System.in);
		   String str = scan2.nextLine();
		   String list[]=str.split(" ");
		   String name=list[0];
		   String type=list[1];
	       d[x] = new Device(r);
	       d[x].setname(name);
		   d[x].settype(type);
	    }
	    
	    /*PrintStream fileOut = null;
		try {
			fileOut = new PrintStream("./file.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setOut(fileOut);
	    */
	    
		for(int x=0;x<n;x++) {
	    	d[x].start();
	    	frame.add(container);
            frame.setVisible(true);
		}
	
	}
}