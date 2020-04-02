package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;

public class PatientChatBot extends ChatBot {

    public PatientChatBot(User p, String n, Picture pic, Ressources.Gender g) {
        super(p, n, pic, g);
    }

    @Override
    public boolean wakeUp(String message){
        int lastIdx = message.length()-1;
        return message.indexOf("?")==lastIdx;
    }
}
