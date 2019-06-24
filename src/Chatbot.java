//package src;


public abstract class Chatbot {
	
	String name;
	static String cmnd;
	static String arg;
	
	
	public Chatbot(String name){
		this.name=name;
		
	}
	
	public String description(){
		
		return "["+this.name+"] :";
		
	}
	public abstract String reponse() throws Exception;
	
}
