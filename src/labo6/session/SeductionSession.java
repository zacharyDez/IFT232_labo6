package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.database.*;

public class SeductionSession extends  Session {
    public SeductionSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    public TextList getSuitableMessages(){
        TextList l = super.getSuitableMessages();
        l.keep(TextMessage.TextKey.isSeductive, true);
        return l;
    }

    @Override
    public PictureList getSuitablePictures(){
        PictureList l = super.getSuitablePictures();
        l.keep(Picture.PictureKey.isSeductive, true);
        return l;
    }
}
