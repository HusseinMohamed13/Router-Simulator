import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class main {
	
	public static void main(String[] args) throws FileNotFoundException {
		Network net = new Network();
		net.start();
	}
}
