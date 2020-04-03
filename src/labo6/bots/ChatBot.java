package labo6.bots;

import labo6.Ressources;
import labo6.Ressources.Gender;
import labo6.User;
import labo6.bots.behavior.*;
import labo6.database.Picture;
import labo6.session.Session;

public class ChatBot extends User {

    //L'utilisateur avec lequel le robot est en communication.
    protected User peer;
    protected String oldText = "";
    protected Session session;
    protected CheckUserBehavior check;
    protected WaitBehavior wait;


    public ChatBot(Session s, User p, String n, Picture pic, Gender g) {
        super(n, pic, g);
        session = s;
        peer = p;
        setCheck(new CheckUserBehaviorQuestion(this));
        setWait(new WaitBehaviorPatient(this));
    }

    public static ChatBot createImpatientChatBot(Session s, User p, String n, Picture pic, Gender g) {
        ChatBot bot = new ChatBot(s, p, n, pic, g);
        bot.setCheck(new CheckUserBehaviorDontCare(bot));
        bot.setWait(new WaitBehaviorImpatient(bot));
        return bot;
    }

    public static ChatBot createPatientChatBot(Session s, User p, String n, Picture pic, Gender g) {
        ChatBot bot = new ChatBot(s, p, n, pic, g);
        bot.setCheck(new CheckUserBehaviorQuestion(bot));
        bot.setWait(new WaitBehaviorPatient(bot));
        return bot;
    }

    public static ChatBot createSlowmoChatBot(Session s, User p, String n, Picture pic, Gender g) {
        ChatBot bot = new ChatBot(s, p, n, pic, g);
        bot.setCheck(new CheckUserBehaviorRepeat(bot));
        bot.setWait(new WaitBehaviorSlowmo(bot));
        return bot;
    }

    public static ChatBot createTrollChatBot(Session s, User p, String n, Picture pic, Gender gender) {
        ChatBot bot = createImpatientChatBot(s, p, n, pic, gender);
        return bot;
    }

    private void setWait(WaitBehavior waitBehavior) {
        wait = waitBehavior;
    }

    private void setCheck(CheckUserBehavior checkUserBehavior) {
        check = checkUserBehavior;
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    public void appendMessage(String msg) {
        getUI().appendMessage(msg);
    }

    public User getPeer() {
        return peer;
    }

    public boolean wakeUp() {
        boolean res = false;
        if (!peer.getText().equals(oldText) && check.checkForWakeUp()) {
            res = true;
        }
        oldText = peer.getText();
        return res;
    }

    public void waitForUser() {
        wait.waitForUser();
    }

    public Session getSession() {
        return session;
    }
}
