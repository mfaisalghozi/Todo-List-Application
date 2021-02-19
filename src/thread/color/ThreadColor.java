package thread.color;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import mediator.TodoMediator;

import java.time.LocalTime;

public class ThreadColor extends TimerTask {
	private TodoMediator mediator;
	private int colorStatus = 1;
	
	public ThreadColor(TodoMediator mediator) {
		this.mediator = mediator;
	}
	
	public void checkingHour() {
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("HH");  

	    int hour = Integer.parseInt(dateFormat.format(date));
	       
//	    System.out.println("Current Hour : " + hour); 
	    if((hour >= 18 || hour < 6) && colorStatus == 1) {
	    	colorStatus = 0;
	       	turnToDark();
	     }else if((hour >= 6 && hour < 18) && colorStatus == 0) {
	    	colorStatus = 1;
	    	turnToLight();
	     }
	}
	
	public void turnToDark() {
		mediator.getColorState().onDark();
	}
	
	public void turnToLight() {
		mediator.getColorState().onLight();
	}
	
	public void run() {
	       checkingHour();
	}
}
