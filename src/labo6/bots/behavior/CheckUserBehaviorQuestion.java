package labo6.bots.behavior;

import labo6.bots.ChatBot;

public class CheckUserBehaviorQuestion extends CheckUserBehavior {

    public CheckUserBehaviorQuestion(ChatBot b) {
        super(b);
    }

    @Override
    public boolean checkForWakeUp() {
        return bot.getPeer().getText().endsWith("?");
    }
}
