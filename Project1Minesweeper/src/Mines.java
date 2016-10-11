
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
//This class will generate the mine positions for x and y and save them into arrays
public class Mines {
	ArrayList <Point> mineArray = new ArrayList <Point>();
	Random generator = new Random();
	public ArrayList<Point> mineGen(int gridX,int gridY, int mines){
		mineArray.add(new Point(0,0));


		for( int i = 0; i <= mines - 1; i++){
			int mineX = generator.nextInt(mines -1);
			int mineY = generator.nextInt(mines -1);
			if(mineX <= gridX+1 && mineY <=gridY+1 && mineX >= gridX-1 && mineY >= gridY-1){
				i--;
			}
			else{
				for (int j=0; j<i;j++ ){
					Boolean repeats = mineArray.get(j).equals(new Point(mineX,mineY));
					if (repeats){
						j=i;
						i=i-1;
					}

					
				}
					mineArray.add(new Point(mineX,mineY));
			}
		}
		return mineArray;
	}

}

