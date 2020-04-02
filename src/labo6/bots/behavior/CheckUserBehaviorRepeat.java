package labo6.bots.behavior;

import labo6.bots.ChatBot;

public class CheckUserBehaviorRepeat extends CheckUserBehavior {

    private String lastLine = "";

    public CheckUserBehaviorRepeat(ChatBot b) {
        super(b);
    }

    @Override
    public boolean checkForWakeUp() {
        boolean res = bot.getPeer().getLastLine().equals(lastLine);
        lastLine = bot.getPeer().getLastLine();

        return res;
    }
}
