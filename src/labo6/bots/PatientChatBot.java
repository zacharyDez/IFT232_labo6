package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;
import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.Session;

public class PatientChatBot extends ChatBot {

    public PatientChatBot(Session s, User p, String n, Picture pic, Ressources.Gender g) {
        super(s, p, n, pic, g);
    }

    @Override
    public boolean checkForWakeUp() {
        return peer.getText().endsWith("?");
    }

    @Override
    public void waitForUser() {
        sleep(3000);
        TextList l = session.getSuitableMessages();
        l.keep(TextMessage.TextKey.isQuestion, true);
        appendMessage(l.random().getMessage());
    }
}
