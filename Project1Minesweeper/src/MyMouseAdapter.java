import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;



public class MyMouseAdapter extends MouseAdapter {
	
	public int event=0;
	public int mines = 5;
	public static int flag = 0;
	Mines minesClass = new Mines();

	private Random generator = new Random();
	
	public static String getFlagCounter()
	{

		return "" +flag;
	}
	
	public void increment(){
		
		flag++;
		
	}

	public void mousePressed(MouseEvent e) {
		switch(e.getButton()){
		case 1: //Left Mouse Button
		
		Component c = e.getComponent();

		while (!(c instanceof JFrame)) {

			c = c.getParent();

			if (c == null) {

				return;

			}

		}

		JFrame myFrame = (JFrame) c;

		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
		Insets myInsets = myFrame.getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		e.translatePoint(-x1, -y1);
		int x = e.getX();
		int y = e.getY();
		myPanel.x = x;
		myPanel.y = y;
		myPanel.mouseDownGridX = myPanel.getGridX(x, y);
		myPanel.mouseDownGridY = myPanel.getGridY(x, y);
		myPanel.repaint();
		break;
		case 3:        //Right mouse button
			Component c1 = e.getComponent();
			while (!(c1 instanceof JFrame)) {
				c1 = c1.getParent();
				if (c1 == null) {
					return;
				}
			}
			JFrame myFrame1 = (JFrame) c1;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);
			Insets myInsets1 = myFrame1.getInsets();
			int x11 = myInsets1.left;
			int y11 = myInsets1.top;
			e.translatePoint(-x11, -y11);
			int X = e.getX();
			int Y = e.getY();
			myPanel1.x = X;
			myPanel1.y = Y;
			myPanel1.mouseDownGridX = myPanel1.getGridX(X, Y);
			myPanel1.mouseDownGridY = myPanel1.getGridY(X, Y);
			myPanel1.repaint();
			break;//Right mouse button
		default: //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}







	public void mouseReleased(MouseEvent e) {
		switch(e.getButton()){
		case 1: //Left Mouse Button
		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		JFrame myFrame = (JFrame)c;
		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
		Insets myInsets = myFrame.getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		e.translatePoint(-x1, -y1);
		int x = e.getX();
		int y = e.getY();
		myPanel.x = x;
		myPanel.y = y;
		int gridX = myPanel.getGridX(x, y);
		int gridY = myPanel.getGridY(x, y);

		if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
			//Had pressed outside
			//Do nothing
		} else {
			if ((gridX == -1) || (gridY == -1)) {
				//Is releasing outside
				//Do nothing
			} else {
				if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
					//Released the mouse button on a different cell where it was pressed
					//Do nothing
				} else {
					//Released the mouse button on the same cell where it was pressed
					if ((gridX == -1) || (gridY == -1)) {
						//Added
					} else {
						if ((gridX == -1) || (gridY == -1)) {
							//Added
						}else{ 
							if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.RED){
								//Color newColor = Color.red;
							}

							else {
								//On the grid other than on the left column and on the top row:
								Color newColor = Color.LIGHT_GRAY;
								
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
								//Fixed!!!!
								
								if(event==0){

									ArrayList<Point> mineArray = minesClass.mineGen(gridX, gridY, mines);

									for(int i =0; i <= mines-1;i++){
										int mineX=(int) mineArray.get(i).getX();
										int mineY=(int) mineArray.get(i).getY();

										
										Color newColor1 = Color.BLACK;
										myPanel.colorArray[mineX][mineY] = newColor1;
								
										

									}
								}
									
									

								}
							event=1;
						

						}
						
					}
				}
			}
			myPanel.repaint();
			break;
		}
	
				
			
				
		case 3:    
			
			 //Right mouse button
			Component c1 = e.getComponent();
			while (!(c1 instanceof JFrame)) {
				c1 = c1.getParent();
				if (c1 == null) {
					return;
				}
			}
			JFrame myFrame1 = (JFrame)c1;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0); //Can also loop among components to find MyPanel
			Insets myInsets1 = myFrame1.getInsets();
			int x11 = myInsets1.left;
			int y11 = myInsets1.top;
			e.translatePoint(-x11, -y11);
			int X = e.getX();
			int Y = e.getY();
			myPanel1.x = X;
			myPanel1.y = X;
			int gridX1 = myPanel1.getGridX(X, Y);
			int gridY1 = myPanel1.getGridY(X, Y);
			if ((myPanel1.mouseDownGridX == -1) || (myPanel1.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
		
			} else {
				if ((gridX1 == -1) || (gridY1 == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel1.mouseDownGridX != gridX1) || (myPanel1.mouseDownGridY != gridY1)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					}
					else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX1 == 100)) {
							//Top Row
							Color newColor = null;
							switch (generator.nextInt(1)) {
							case 0:

								newColor = Color.RED;
								increment();
								break;
							}
							myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = newColor;
							myPanel1.repaint();
						}
						else if(myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] == Color.RED)
						{
							myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = Color.WHITE;
							myPanel1.repaint();
						}

						else if(myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] == Color.LIGHT_GRAY){


						}

						else {
							//On the grid other than on the left column and on the top row:
							Color newColor = null;
							switch (generator.nextInt(1)) {
							case 0:
								newColor = Color.RED;
								increment();
								break;
							}
							if(myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] == Color.RED)
							{
								myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = Color.WHITE;
								myPanel1.repaint();
							}
							myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = newColor;
							myPanel1.repaint();
						}
					}
				}
			}
			break;
		default: //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}

	}
}


