package labo6.bots.behavior;

import labo6.bots.ChatBot;

public abstract class WaitBehavior {
    protected ChatBot bot;

    public WaitBehavior(ChatBot b){
        bot=b;
    }

    public abstract void waitForUser();
}
