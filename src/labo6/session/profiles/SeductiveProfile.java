package labo6.session.profiles;

import labo6.Ressources;
import labo6.User;
import labo6.bots.ChatBot;
import labo6.database.Picture;
import labo6.database.PictureList;
import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.Session;

public class SeductiveProfile extends Profiler {

    public SeductiveProfile(Session s) {
        super(s);
    }

    @Override
    public TextList getSuitableMessages() {
        TextList l = super.getSuitableMessages();
        l.keep(TextMessage.TextKey.isSeductive, true);

        return l;
    }

    @Override
    public PictureList getSuitablePictures() {
        PictureList l = super.getSuitablePictures();
        l.keep(Picture.PictureKey.isSeductive, true);

        Ressources.Gender gender = session.getHuman().getGender();

        if(gender.value != Ressources.Gender.unknown.value){
            // deuxieme signature de la methode gender
            l.keep(gender, false);
        } else{
            // si gender est unknown, afficher seulement des unknowns
            l.keep(gender, true);
        }

        return l;
    }

    @Override
    public ChatBot createChatBot(Session s, User p, String n) {
        Picture pic = getSuitablePictures().random();
        return ChatBot.createImpatientChatBot(s, p, n, pic, pic.getGender());
    }


}