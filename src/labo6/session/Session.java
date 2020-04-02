package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.bots.PatientChatBot;
import labo6.database.*;
import labo6.database.PictureDatabase;
import labo6.database.PictureList;

/*
 * Cette classe représente une session d'un utilisateur humain
 * avec un ou plusieurs robots.
 * La session se termine lorsqu'on détecte que l'utilisateur humain
 * s'est déconnecté (change de pays ou de genre, via les boutons "PAYS" et "GENRE").
 */

public class Session {

	private User human;
	private ChatBot robot;
	private Labo6Main ui;
	private boolean ended;
	private Thread sleeper;
	public static final String NORMAL_SESSION = "normal";
	public static final String SEDUCTION_SESSION = "seduction";
	public static final String CASUAL_SESSION = "casual";

	public Session(Labo6Main l, User u) {
		ui = l;
		human = u;
		ended = false;
		sleeper = Thread.currentThread();
	}

	public static Session createSession(String type, Labo6Main ui, User humanUser){
		if (type.equals(NORMAL_SESSION)){
			return new Session(ui,humanUser);
		} else if(type.equals(SEDUCTION_SESSION)){
			return new SeductionSession(ui, humanUser);
		} else if(type.equals(CASUAL_SESSION)){
			return new CasualSession(ui, humanUser);
		}
		else
		{
			throw new IllegalArgumentException ("Wrong session type: "+type);
		}
	}

	private String generateAnswer(){
		return getSuitableMessages().random().getMessage();
	}

	private String generateGreeting(){
		TextList l = getSuitableMessages();
		// keep modifie l original
		l.keep(TextMessage.TextKey.isGreeting, true);
		return l.random().getMessage();
	}

	protected PictureList getSuitablePictures(){
		return PictureDatabase.getAllPictures();
	}

	public TextList getSuitableMessages(){
		return TextDatabase.getAllMessages();
	}

	public void start() {

		robot = createChatBot(human, "Other", getSuitablePictures().random(), Gender.random());
		ui.initBackGround(robot);
		
		robot.appendMessage(generateGreeting());

		while (!hasEnded()) {

			robot.waitForUser();

			if (robot.wakeUp()) {

				robot.appendMessage(generateAnswer());

			}

		}

	}



	// C'est la Factory Method. Permet de choisir le type de ChatBot. Session est le créateur. SeductionSession et CasualSession sont créateurs concrets
	protected ChatBot createChatBot(User human, String name, Picture pic, Gender gen) {
		return new PatientChatBot(this, human, name, pic, gen);
	}


	/*
	 * Appelé par le bouton SUIVANT
	 */
	public void changeChatBot() {
		robot = createChatBot(human, "Other", PictureDatabase.getAllPictures().random(), Gender.random());
		ui.initBackGround(robot);
	}
	

	public synchronized void end() {
		ended = true;
		sleeper.interrupt();
	}

	private synchronized boolean hasEnded() {
		return ended;
	}	
	
	

}
