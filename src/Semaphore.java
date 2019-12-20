import java.awt.Container;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Semaphore {
	protected int value = 0 ;
	protected Semaphore() { value = 0 ; }
	protected Semaphore(int initial) { value = initial ; }
	public synchronized void P(Device d,JFrame jf,Container c) throws IOException {
		value--;
		if (value < 0) {
		try {
			JLabel label = new JLabel("("+d.getname()+")"+"("+d.gettype()+")"+ " : arrived and Waited");
	    	c.add(label);
			jf.setVisible(true);
			WriteToFile("("+d.getname()+")"+"("+d.gettype()+")"+ " : arrived and Waited");
			System.out.println("("+d.getname()+")"+"("+d.gettype()+")"+ " : arrived and Waited");	
			wait();
		} catch( InterruptedException e ) {
		     }
		}else {
			JLabel label = new JLabel("("+d.getname()+")"+"("+d.gettype()+")"+ " : arrived");
	    	c.add(label);
			jf.setVisible(true);
			WriteToFile("("+d.getname()+")"+"("+d.gettype()+")"+ " : arrived");
			System.out.println("("+d.getname()+")"+"("+d.gettype()+")"+ " : arrived");}
		}
	public synchronized void V(Device d,int n) throws Exception {
		value++ ; 
		if (value <= 0) {
		notify() ;
		d.logout(n);
		}else {d.logout(n);}
		}
	public void WriteToFile(String s) throws IOException {
	    File file = new File("");
	    String path = file.getAbsolutePath();
	    FileWriter fw = new FileWriter(path+"\\"+"file.txt",true);
        fw.write(s+"\r\n");
        fw.flush();
        fw.close();
        }
}