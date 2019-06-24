//package src;     
import java.util.Scanner;

import java.util.*;

public class Test{
	
	private static Scanner scanIn;

	Test(){};
	
	public static void test_dealer(String[] args) throws Exception {
		
			HashMap<String,Class> gestionnaire = new HashMap<String, Class>();
			gestionnaire.put("@hello",Hello.class);
			gestionnaire.put("@time",Time.class);
			gestionnaire.put("@icndb",Icndb.class);
			gestionnaire.put("@quiz",Quiz.class);
			gestionnaire.put("Sys",Sys.class);
			
			String x = "["+args[1]+"]";
			boolean a=true;
			scanIn = new Scanner(System.in);
			while(a){
		       String sWhatever;
		       System.out.println(x);
		       sWhatever = scanIn.nextLine();
		       String[] words = sWhatever.split(" "); 
		       Set<String> cles = gestionnaire.keySet();
		       Iterator<String> it = cles.iterator();
		       if(sWhatever.substring(0,1).equals("@")){
		      if(gestionnaire.containsKey(words[0])){	   
		       while (it.hasNext()){
		    	   
		    	   if(words[0].equals(it.next())){
		    		  Chatbot.arg=args[1];
		    		  Chatbot.cmnd=sWhatever;
		    		  Object A=gestionnaire.get(words[0]).newInstance() ;
		    		  System.out.println(((Chatbot) A).reponse());
		    		
		    	   }}}
		    		 
		       else{
				       Sys S=new Sys(sWhatever);
				       System.out.println(S.reponse());
		       }
		     }
		    	   	
		       

		       if(sWhatever.equals("++")){
		    	   a=false;
		       }
		       
		      
	
			}		                  

}
}
