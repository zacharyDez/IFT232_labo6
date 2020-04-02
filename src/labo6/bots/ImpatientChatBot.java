package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;
import labo6.session.Session;


public class ImpatientChatBot extends ChatBot  {
    public ImpatientChatBot(Session s, User p, String n, Picture pic, Ressources.Gender g) {
        super(s, p, n, pic, g);
    }

    @Override
    public boolean checkForWakeUp() {
        return !peer.getText().isEmpty();
    }

    @Override
    public void waitForUser() {
        sleep(1000);
        appendMessage(session.getSuitableMessages().random().getMessage());
    }

}
