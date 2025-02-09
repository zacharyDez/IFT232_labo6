package labo6.session.profiles;

import labo6.User;
import labo6.bots.ChatBot;
import labo6.database.Picture;
import labo6.database.PictureList;
import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.Session;

public class CasualProfile extends Profiler {

    public CasualProfile(Session s) {
        super(s);
    }

    @Override
    public TextList getSuitableMessages(){
        TextList l = super.getSuitableMessages();
        l.keep(TextMessage.TextKey.isSeductive, false);
        return l;
    }

    @Override
    public PictureList getSuitablePictures(){
        PictureList l = super.getSuitablePictures();
        l.keep(Picture.PictureKey.isSeductive, false);
        return l;
    }

    @Override
    public ChatBot createChatBot(Session s, User p, String n){
        Picture pic = getSuitablePictures().random();
        return ChatBot.createSlowmoChatBot(s, p, n, pic, pic.getGender());
    }

}
