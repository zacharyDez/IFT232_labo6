package labo6.bots.behavior;

import labo6.bots.ChatBot;

public class WaitBehaviorSlowmo extends WaitBehavior {

    public WaitBehaviorSlowmo(ChatBot b) {
        super(b);
    }

    @Override
    public void waitForUser() {
        bot.sleep(2000);
    }
}
