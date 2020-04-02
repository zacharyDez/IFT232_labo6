package labo6.bots.behavior;

import labo6.bots.ChatBot;

public class CheckUserBehaviorDontCare extends CheckUserBehavior {

    public CheckUserBehaviorDontCare(ChatBot b) {
        super(b);
    }

    @Override
    public boolean checkForWakeUp() {
        return true;
    }
}
