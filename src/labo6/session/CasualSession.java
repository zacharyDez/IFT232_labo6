package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.bots.ImpatientChatBot;
import labo6.bots.SlowmoChatBot;
import labo6.database.*;

public class CasualSession extends Session {

    public CasualSession(Labo6Main l, User u) {
        super(l, u);
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
    public ChatBot createChatBot(User p, String n, Picture pic, Ressources.Gender g){
        return new SlowmoChatBot(this, p, n, pic, g);
    }
}
