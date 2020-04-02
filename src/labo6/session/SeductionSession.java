package labo6.session;

import labo6.Labo6Main;
import labo6.Ressources;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.bots.ImpatientChatBot;
import labo6.bots.PatientChatBot;
import labo6.database.*;
import labo6.database.TextMessage.TextKey;
import labo6.database.Picture.PictureKey;

public class SeductionSession extends  Session {
    public SeductionSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    protected TextList getSuitableMessages(){
        TextList l = super.getSuitableMessages();
        l.keep(TextKey.isSeductive, true);
        return l;
    }

    @Override
    protected PictureList getSuitablePictures(){
        PictureList l = super.getSuitablePictures();
        l.keep(PictureKey.isSeductive, true);
        return l;
    }

    @Override
    protected ChatBot createChatBot(User human, String name, Picture pic, Ressources.Gender gen) {
        return new ImpatientChatBot(human, name, pic, gen);
    }
}
