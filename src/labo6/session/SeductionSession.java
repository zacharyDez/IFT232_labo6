package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.session.profiles.SeductiveProfile;

public class SeductionSession extends  Session {
    public SeductionSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    public void createProfiler(){
        profiler = new SeductiveProfile(this);
    }
}
