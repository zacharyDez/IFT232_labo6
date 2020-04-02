package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;

public class SlowmoChatBot extends ChatBot {


    public SlowmoChatBot(User p, String n, Picture pic, Ressources.Gender g) {
        super(p, n, pic, g);
    }

    @Override
    public boolean wakeUp(String message){
        String[] messages = message.split("\n");
        if(messages.length == 2 && messages[0]==messages[1]){
            return true;
        }
        return false;
    }
}
