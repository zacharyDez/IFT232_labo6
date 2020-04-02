package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.bots.behavior.CheckUserBehaviorQuestion;
import labo6.bots.behavior.WaitBehaviorPatient;
import labo6.database.Picture;
import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.Session;

public class PatientChatBot extends ChatBot {

    public PatientChatBot(Session s, User p, String n, Picture pic, Ressources.Gender g) {
        super(s, p, n, pic, g);
        check = new CheckUserBehaviorQuestion(this);
        wait = new WaitBehaviorPatient(this);
    }

}
