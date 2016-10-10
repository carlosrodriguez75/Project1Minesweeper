import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;



public class MyMouseAdapter extends MouseAdapter {
	
	public int event=0;

	private Random generator = new Random();

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
								//Fixed
								
								
									
							}
							event=1;
						

						}
						
					}
				}
			}
			myPanel.repaint();
			break;
		}
	
				
			
				
		case 3:        //Right mouse button

			//Do nothing

			
			

		}

	}
}



