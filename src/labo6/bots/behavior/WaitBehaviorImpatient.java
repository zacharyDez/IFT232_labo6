package labo6.bots.behavior;

import labo6.bots.ChatBot;

public class WaitBehaviorImpatient extends WaitBehavior {


    public WaitBehaviorImpatient(ChatBot b) {
        super(b);
    }

    @Override
    public void waitForUser() {
        bot.sleep(1000);
        bot.appendMessage(bot.getSession().getProfiler().getSuitableMessages().random().getMessage());
    }
}
