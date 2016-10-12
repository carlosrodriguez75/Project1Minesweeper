public class TheTimer {
	
	public static int seconds = 0;


	public static String getTime()
	{
		
		//Counting

		if(seconds < 10)
			return "00"+seconds;
		else if(seconds < 100)
			return "0"+seconds;
		else
			return ""+seconds;
	}

	public void increment(){
		//invrementing the seconds
		seconds++;
		
	}
}