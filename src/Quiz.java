//package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

import org.json.* ;

	public class Quiz extends Chatbot{
		int nb;
		int score;
		private Scanner scanIn;
		
		Quiz(){
			super("quiz");
			this.score=0;
			if(Chatbot.cmnd.length()==5){
			this.nb=1;
			
			}
			else{
				String[] words = Chatbot.cmnd.split(" ");
				this.nb=Integer.parseInt(words[1]);
			}
			
		}
		
		
		
			public void quest_answ(JSONObject re ) throws JSONException{
				scanIn = new Scanner(System.in);
				System.out.println(re.getString("question"));
				JSONArray wrong_responses = re.getJSONArray("incorrect_answers");
				int taille=wrong_responses.length();
				Random r = new Random();
				String corr_answ=re.getString("correct_answer");
				int corr_ind = r.nextInt(taille)+1;
				int i=1;
				int j=0;
				while(i<taille+2){
					if(i==corr_ind){
						 System.out.println(i+" _ "+corr_answ);	
						 i++;
					}
					else{
						
						 System.out.println(i+" _ "+wrong_responses.getString(j));
						 i++;
						 j++;
						
					}
					
				}
				System.out.print("["+Chatbot.arg+"]");
				 String Answ= scanIn.nextLine();
				 while(Integer.parseInt(Answ)<1 | Integer.parseInt(Answ)>taille+1 ){
					 System.out.println("insert a choice between 1 and "+(taille+1));
					 Answ= scanIn.nextLine();					 
				 }
				 if(Integer.parseInt(Answ)==corr_ind){
					 this.score++;
					 System.out.println(this.description()+"Bonne réponse!");
				 }
				 else{
					 System.out.println(this.description()+"Mauvaise réponse! La bonne réponse était: "+corr_answ+  "!");
					 
				 }
			}
	
		   public  String questions_answers(String urlToRead) throws Exception {
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


				JSONObject jsonObj = new JSONObject(response.toString());
		 		JSONArray myresponse = jsonObj.getJSONArray("results");
		 		 int taille=myresponse.length();
		 		JSONObject re = null;
		 		 for(int j=0;j<taille;j++){
		 			 re = myresponse.getJSONObject(j);
		 			System.out.print("Question "+(j+1)+" : ");
		 			 quest_answ(re);
		 		 }
		 		 return this.description()+"Score final: "+ 100*this.score/taille+"% de bonnes réponses ("+this.score+"/"+taille+") !";
		 		 
			   
			
		   }
		
		public String http_send(){
			
			
			
			return null;
		}
		
		
		@Override
		public String reponse() throws Exception {	
			return this.questions_answers("https://opentdb.com/api.php?amount="+this.nb); 
			}
					
	
	}
