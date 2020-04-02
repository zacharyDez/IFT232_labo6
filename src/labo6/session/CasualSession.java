package labo6.session;

import labo6.Labo6Main;
import labo6.User;
import labo6.session.profiles.CasualProfile;

public class CasualSession extends Session {

    public CasualSession(Labo6Main l, User u) {
        super(l, u);
    }

    @Override
    public void createProfiler(){
        profiler = new CasualProfile();
    }
}
