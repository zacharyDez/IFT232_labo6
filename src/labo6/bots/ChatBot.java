package labo6.bots;

import labo6.Ressources.Gender;
import labo6.User;
import labo6.database.Picture;
import labo6.session.Session;


public abstract class ChatBot extends User {

	//L'utilisateur avec lequel le robot est en communication.
	protected User peer;
	protected String oldText="";
	protected Session session;

	public ChatBot(Session s, User p, String n, Picture pic, Gender g) {
		super(n, pic, g);
		peer = p;
		session = s;
	}

	public void sleep(int time) {
		try {

			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
	public void appendMessage(String msg){
		getUI().appendMessage(msg);
	}

	public User getPeer(){
		return peer;
	}

	public boolean wakeUp(){
		boolean res=false;
		if(!peer.getText().equals(oldText))
		{
			res = checkForWakeUp();
		}
		oldText = peer.getText();
		return res;
	}

	public abstract boolean checkForWakeUp();

	public abstract void waitForUser();

}
