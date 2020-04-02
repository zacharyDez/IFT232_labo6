package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.bots.behavior.CheckUserBehaviorRepeat;
import labo6.bots.behavior.WaitBehaviorSlowmo;
import labo6.database.Picture;
import labo6.session.Session;

public class SlowmoChatBot extends ChatBot {

    public SlowmoChatBot(Session s, User p, String n, Picture pic, Ressources.Gender g) {
        super(s, p, n, pic, g);
        check = new CheckUserBehaviorRepeat(this);
        wait = new WaitBehaviorSlowmo(this);
    }

}
