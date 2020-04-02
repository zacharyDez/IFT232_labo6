package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.database.*;

public class CasualSession extends Session {

    public CasualSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    protected TextList getSuitableMessages(){
        TextList l = super.getSuitableMessages();
        l.keep(TextMessage.TextKey.isSeductive, false);
        return l;
    }

    @Override
    protected PictureList getSuitablePictures(){
        PictureList l = super.getSuitablePictures();
        l.keep(Picture.PictureKey.isSeductive, false);
        return l;
    }
}
