import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class time {
	
	Date date = new Date();
	
	
	public String getTime(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(" dd MMM  hh:mm", Locale.ENGLISH);
		
		String formatted = dateFormat.format(date);
		return formatted;
	}
	
	public static long getDifference(time d, time f){
		
		long diff = d.date.getTime() - f.date.getTime();
		return diff;
		
	}
	
	public static String longFormatted(long l){
		
		  
		  int timeInSeconds = (int)l / 1000;
		  int hours, minutes, seconds;
		  hours = timeInSeconds / 3600;
		  timeInSeconds = timeInSeconds - (hours * 3600);
		  minutes = timeInSeconds / 60;
		  timeInSeconds = timeInSeconds - (minutes * 60);
		  seconds = timeInSeconds;
		
		  String diffTime = (hours<10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds) ;
		  return diffTime;
	}
	
	public static long addTime(time d, time f){
		long add = d.date.getTime() + f.date.getTime();
		return add;
	}

}
