//package src;

public class Sys extends Chatbot {

	String name_chat;
	
	Sys(String name){		
		super("Sys");
		this.name_chat=name;
	}
	
	
	@Override
	public String reponse() {
			if(this.name_chat.startsWith("@")){
			return this.description() +"Je ne connais pas le chatbot "+this.name_chat; 
		
			}else {
				return "";
			}
	}
}
