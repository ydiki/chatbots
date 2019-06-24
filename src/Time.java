//package src;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time extends Chatbot {

	Time(){		
		super("Time");
	}
	@Override
		public String reponse() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		DateFormat dateFormat0 = new SimpleDateFormat("EEEEEEE");
		DateFormat dateFormat1 = new SimpleDateFormat("MMMMMMM");
		DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		
		return this.description() + "Nous sommes "+dateFormat0.format(date)+" "+ dateFormat.format(date)+" "+dateFormat1.format(date)+" et il est "+dateFormat2.format(date); 
			
}
}
