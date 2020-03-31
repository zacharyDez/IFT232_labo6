package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.database.TextDatabase;
import labo6.database.TextList;
import labo6.database.TextMessage;

public class CasualSession extends Session {

    public CasualSession(Labo6Main l, User u) {
        super(l, u);
    }
    @Override
    public String generateGreeting(){
        TextList l = TextDatabase.getAllMessages();
        // keep modifie l original
        l.keep(TextMessage.TextKey.isSeductive, false);
        l.keep(TextMessage.TextKey.isGreeting, true);
        return l.random().getMessage();
    }

    @Override
    public String generateAnswer(){
        TextList l = TextDatabase.getAllMessages();
        // keep modify la liste initiale
        l.keep(TextMessage.TextKey.isSeductive, false);
        return l.random().getMessage();
    }
}
