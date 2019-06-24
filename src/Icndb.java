//package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.* ;

	public class Icndb extends Chatbot{
		int nb;
		
		Icndb(){
			super("icndb");
			if(Chatbot.cmnd.length()==6){
			this.nb=1;
			}
			else{
				String[] words = Chatbot.cmnd.split(" ");
				this.nb=Integer.parseInt(words[1]);
			}
			
		}
		
		
	
		   public  String getHTML(String urlToRead) throws Exception {
		    //connect avec url
			   URL obj = new URL(urlToRead);
			   HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			   
			   //read mn url avec format json un nombre de joks 
			   BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
			   	String inputLine;
			   	
		 		StringBuffer response = new StringBuffer();
		 		inputLine = in.readLine();	
		 		response.append(inputLine);
				in .close();

		 	    
		 		JSONObject myresponse = new JSONObject(response.toString());;
		 		 
		 		JSONObject re = myresponse.getJSONObject("value");
		 		return re.getString("joke");
			   
			   //return 
		   }
		
		public String http_send(){
			
			
			
			return null;
		}
		
		
		@Override
		public String reponse() throws Exception {	
				
						String re="";
						
						for(int i = 1; i <=this.nb ; i++){
							
							re=re+this.description()+ this.getHTML("http://api.icndb.com/jokes/random")+"\n"; 
						}
				return re; 
	
		}
					
	
	}
