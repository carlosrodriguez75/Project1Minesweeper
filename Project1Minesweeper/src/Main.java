import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main {
	static JLabel labelTime;
	
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Minesweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 400);
		

		MyPanel myPanel = new MyPanel();
		myFrame.getContentPane().add(myPanel);
		myPanel.setLayout(null);
		
		
		
		JLabel labelFlags = new JLabel();
		Timer timer2 = new Timer();	
		timer2.schedule(new TimerTask(){
			@Override
			public void run() {
				 labelFlags.setText("Flags: " + MyMouseAdapter.getFlagCounter() );
			}
		},100, 1000); 
		
		 labelFlags.setBounds(28, 8, 38, 15);
		 labelFlags.setFont(new Font("Times New Roman", Font.BOLD, 10));
		 labelFlags.setHorizontalAlignment(SwingConstants.CENTER);
		myPanel.add( labelFlags);
		
		
		
		
		TheTimer counting = new TheTimer();
		Timer timer = new Timer();		
		JLabel labelTime = new JLabel();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				counting.increment();
				labelTime.setText("Time: "  + TheTimer.getTime() +" sec");
			}
		},100, 1000); 

		labelTime.setBounds(235, 9, 174, 15);
		labelTime.setHorizontalAlignment(SwingConstants.LEFT);
		labelTime.setFont(new Font("Times New Roman", Font.BOLD, 12));
		myPanel.add(labelTime);


		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);

		myFrame.setVisible(true);
	}
}
//Rules of the Game
//1.     The initial setup consists of a grid of squares some of which contain hidden mines
//
//2.     The user clicks on squares repeatedly until one of two events occur: 
//a mine is found or the last square without a mine is uncovered.
//
//3.     The user looses the game immediately as soon as he/she clicks on 
//a square that contains a mine.  When this happens the game should uncover all
//remaining squares containing mines.
//
//4.     If the selected square does not contain a mine but one or more of 
//the eight surrounding squares contain a mine, then the game should display a 
//number on the selected square representing how many of the eight surrounding squares contain mines
//
//5.     If the selected square does not contain a mine and none of its eight 
//surrounding squares contain mines, the game should recursively uncover every 
//adjacent square that does not contain a mine until a square that does contain a surrounding mine is uncovered.  This last square should contain a number representing the number of its surrounding squares that contain mines
//
//6.     The user wins when all squares without mines are uncovered.
//
//7.     User may flag squares (using the mouse right click button) that he/she believes contain mines

//Starting Point
//1.     Use the 9x9 grid with white squares as your minefield region
//
//2.     Mines will be represented by black squares
//
//3.     Flags will be represented by red squares and will be toggled with a mouse RIGHT CLICK.
//
//4.     Covered squares will be represented by white squares.
//
//5.     Uncovered squares will be represented by gray squares.
//
//6.     Uncovered squares will reflect the number of surrounding mines or be empty 
//if no such surrounding mine exits.



