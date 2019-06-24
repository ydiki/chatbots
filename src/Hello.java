//package src;


public class Hello extends Chatbot {
		
		
		Hello(){		
			super("hello");
			
		}
		@Override
		public String reponse() throws NomInvalide {
			if (Chatbot.arg.equals("")){
				throw new NomInvalide();
				}
			else{
				return this.description() +"salut " +Chatbot.arg+"!"; 
			}
		}

		
		
}
