package labo6.session.profiles;

import labo6.Ressources;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.database.*;
import labo6.session.Session;

public abstract class Profiler {

    public ChatBot createChatBot(Session s, User p, String n, Picture pic, Ressources.Gender g){
        return ChatBot.createPatientChatBot(s, p, n, pic, g);
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

}
