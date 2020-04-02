package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;

public class ImpatientChatBot extends ChatBot  {
    public ImpatientChatBot(User p, String n, Picture pic, Ressources.Gender g) {
        super(p, n, pic, g);
    }

    @Override
    public boolean checkForWakeUp() {
        return !peer.getText().isEmpty();
    }
}
