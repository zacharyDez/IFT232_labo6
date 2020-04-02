package labo6.bots.behavior;

import labo6.bots.ChatBot;

public abstract class CheckUserBehavior {
    protected ChatBot bot;
    public CheckUserBehavior(ChatBot b){
        bot = b;
    }

    public abstract boolean checkForWakeUp();

}
