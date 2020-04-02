package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.database.*;
import labo6.session.profiles.NormalProfile;
import labo6.session.profiles.Profiler;

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
    private static final String SEDUCTION_SESSION = "seduction";
    private static final String CASUAL_SESSION = "casual";

    Profiler profiler;

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

    public void start() {

        // sets profile accordingly
        createProfiler();
        robot = profiler.createChatBot(this, human, "Other", profiler.getSuitablePictures().random(), Gender.random());

        ui.initBackGround(robot);

        robot.appendMessage(profiler.generateGreeting());
        while (!hasEnded()) {

            robot.waitForUser();

            if (robot.wakeUp()) {

                robot.appendMessage(profiler.generateAnswer());
            }

        }

    }

    public void createProfiler() {
        profiler = new NormalProfile();
    }

    /*
     * Appelé par le bouton SUIVANT
     */
    public void changeChatBot() {
        robot = profiler.createChatBot(this, human, "Other", PictureDatabase.getAllPictures().random(), Gender.random());
        ui.initBackGround(robot);
    }


    public synchronized void end() {
        ended = true;
        sleeper.interrupt();
    }

    private synchronized boolean hasEnded() {
        return ended;
    }

    public Profiler getProfiler() {
        return profiler;
    }
}
