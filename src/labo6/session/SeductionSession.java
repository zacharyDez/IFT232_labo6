package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.database.*;
import labo6.database.TextMessage.TextKey;
import labo6.database.Picture.PictureKey;

public class SeductionSession extends  Session {
    public SeductionSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    public TextList getSuitableMessages(){
        TextList l = super.getSuitableMessages();
        l.keep(TextKey.isSeductive, true);
        return l;
    }

    @Override
    public PictureList getSuitablePictures(){
        PictureList l = super.getSuitablePictures();
        l.keep(PictureKey.isSeductive, true);
        return l;
    }
}
