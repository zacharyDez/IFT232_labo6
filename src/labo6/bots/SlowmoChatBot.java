package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;
import labo6.session.Session;

public class SlowmoChatBot extends ChatBot {

    private String lastLine="";

    public SlowmoChatBot(Session s, User p, String n, Picture pic, Ressources.Gender g) {
        super(s, p, n, pic, g);
    }

    @Override
    public boolean checkForWakeUp() {
        boolean res = peer.getLastLine().equals(lastLine);
        lastLine=peer.getLastLine();

        return res;
    }

    @Override
    public void waitForUser() {
        sleep(2000);
    }

}
