package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.bots.PatientChatBot;
import labo6.database.*;

/*
 * Cette classe repr�sente une session d'un utilisateur humain
 * avec un ou plusieurs robots.
 * La session se termine lorsqu'on d�tecte que l'utilisateur humain
 * s'est d�connect� (change de pays ou de genre, via les boutons "PAYS" et "GENRE").
 */


public class Session {

    private User human;
    private ChatBot robot;
    private Labo6Main ui;
    private boolean ended;
    private Thread sleeper;

    public static final String NORMAL_SESSION = "normal";
    private static final String SEDUCTION_SESSION = "seduction";
    private static final String CASUAL_SESSION = "casual";

    public Session(Labo6Main l, User u) {
        ui = l;
        human = u;
        ended = false;
        sleeper = Thread.currentThread();
    }

    public static Session createSession(String type, Labo6Main ui, User humanUser) {
        Session session;

        if (type.equals(NORMAL_SESSION)) {
            session = new Session(ui, humanUser);
        } else if (type.equals(SEDUCTION_SESSION)) {
            session = new SeductionSession(ui, humanUser);
        } else if (type.equals(CASUAL_SESSION)) {
            session = new CasualSession(ui, humanUser);
        } else {
            throw new IllegalArgumentException("Wrong session type: " + type);
        }

        return session;
    }

    public ChatBot createChatBot(User p, String n, Picture pic, Gender g){
        return new PatientChatBot(this, p, n, pic, g);
    }


    public String generateAnswer() {
        TextList l = getSuitableMessages();
        // keep modify la liste initiale
        return l.random().getMessage();
    }

    public String generateGreeting() {
        TextList l = getSuitableMessages();
        // keep modifie l original
        l.keep(TextMessage.TextKey.isGreeting, true);
        return l.random().getMessage();
    }

    public PictureList getSuitablePictures() {
        return PictureDatabase.getAllPictures();
    }

    public TextList getSuitableMessages() {
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

    /*
     * Appel� par le bouton SUIVANT
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
