package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.bots.behavior.CheckUserBehavior;
import labo6.bots.behavior.CheckUserBehaviorDontCare;
import labo6.bots.behavior.WaitBehaviorImpatient;
import labo6.database.Picture;
import labo6.session.Session;


public class ImpatientChatBot extends ChatBot  {
    public ImpatientChatBot(Session s, User p, String n, Picture pic, Ressources.Gender g) {
        super(s, p, n, pic, g);
        check = new CheckUserBehaviorDontCare(this);
        wait = new WaitBehaviorImpatient(this);
    }

}
