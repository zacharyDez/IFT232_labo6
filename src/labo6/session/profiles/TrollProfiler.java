package labo6.session.profiles;

import labo6.database.TextList;
import labo6.database.TextMessage;
import labo6.session.Session;

public class TrollProfiler extends Profiler {

    public TrollProfiler(Session s) {
        super(s);
    }

    @Override
    public TextList getSuitableMessages() {
        TextList l = super.getSuitableMessages();
        l.keep(TextMessage.TextKey.isSeductive, false);

        return l;
    }
}
