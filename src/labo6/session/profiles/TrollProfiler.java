package labo6.session.profiles;

import labo6.User;
import labo6.bots.ChatBot;
import labo6.database.Picture;
import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.Session;

public class TrollProfiler extends Profiler {

    String lastHumanReply = "";
    int numRepliesWithoutAnswer = 0;
    public TrollProfiler(Session s) {
        super(s);
    }

    @Override
    public TextList getSuitableMessages() {
        TextList l = super.getSuitableMessages(false);

        if(session.getChatBot().getGender().value == session.getHuman().getGender().value){
            l.keep(TextMessage.TextKey.isSeductive, true);
        } else{
            l.keep(TextMessage.TextKey.isSeductive, false);
        }

        lastHumanReply = session.getHuman().getLastLine();
        if(!lastHumanReply.isEmpty()){
            l.keep(TextMessage.TextKey.isOffensive, true);
        } else if(numRepliesWithoutAnswer > 2){
            l.keep(TextMessage.TextKey.isPassiveAggressive, true);
        }

        return l;
    }

    @Override
    public ChatBot createChatBot(Session s, User p, String n) {
        Picture pic = getSuitablePictures().random();
        return ChatBot.createTrollChatBot(s, p, n, pic, pic.getGender());
    }

    @Override
    public String generateGreeting() {
        TextList l = getSuitableMessages();
        // keep modifie l original

        l.keep(TextMessage.TextKey.isGreeting, true);
        l.keep(TextMessage.TextKey.isOffensive, true);
        TextList b = l;
        return l.random().getMessage();
    }

}
