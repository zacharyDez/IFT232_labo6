package labo6.bots.behavior;

import labo6.bots.ChatBot;
import labo6.database.TextList;
import labo6.database.TextMessage;

public class WaitBehaviorPatient extends WaitBehavior{

    public WaitBehaviorPatient(ChatBot b) {
        super(b);
    }

    @Override
    public void waitForUser() {
        bot.sleep(1000);
        bot.appendMessage(bot.getSession().getProfiler().getSuitableMessages().random().getMessage());
    }
}
